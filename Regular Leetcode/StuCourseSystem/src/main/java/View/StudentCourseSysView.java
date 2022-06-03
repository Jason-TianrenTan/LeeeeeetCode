package View;

import Controller.DBController;
import DBUtils.DBConnection;
import Models.Course;
import Models.Student;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;

public class StudentCourseSysView {

    private static final String getHelp() {
        return "-getstudents\t            Query all student name and id list\n" +
                "-getstudents <course_id>    Query student list in course with specific id\n" +
                "-getcourses                 Query all course list\n" +
                "-getcourses <stu_id>        Query all courses for student with specific id\n" +
                "-getcourses <stu_id> <day>  Query all courses for student with specific id on specific day\n" +
                "-addstudent                 Enroll student into program\n" +
                "-addcourse                  Introduce new course into program\n" +
                "-enroll <stu_id><course_id> Enroll student into course" +
                "-exit                       Exit system";
    }
    
    private boolean checkValidDay(String day) {
        List<String> days = new ArrayList<>(Arrays.asList("MON, TUE, WES, THU, FRI, SAT, SUN".split(", ")));
        return days.stream().anyMatch(str -> str.equals(day));
    }

    private boolean checkValidTime(String time) {
        DateTimeFormatter strictTimeFormatter = DateTimeFormatter.ofPattern("HH:mm")
                .withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalTime.parse(time, strictTimeFormatter);
        } catch (DateTimeParseException | NullPointerException e) {
            return false;
        }
        return true;
    }

    private boolean compareTimes(String start, String end) {
        try {
            SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
            Date startTime = parser.parse(start), endTime = parser.parse(end);
            return startTime.before(endTime);
        } catch (Exception e) {
            return false;
        }
    }

    DBController controller;

    public StudentCourseSysView() {
        controller = new DBController();
        System.out.println("Connecting to database...");
        controller.connectDB();
    }

    private <T> void printList(List<T> list) {
        System.out.println("------------------------------------------------------------");
        for (T item : list)
            System.out.println(item);
        System.out.println("------------------------------------------------------------");
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please input your query:");
            String query = scanner.nextLine();

            //Add student
            if (query.equals("-addstudent")) {
                System.out.println("Please input student name: ");
                String stu_name = scanner.nextLine();
                if (controller.addStudent(stu_name))
                    System.out.println("Student successfully added");
                else System.out.println("Student failed to add");
            }

            //Add course
            else if (query.equals("-addcourse")) {
                String course_name = "null", day = "null", startTime = "null", endTime = "null";
                System.out.println("Please input course name: ");
                course_name = scanner.nextLine();

                boolean validDay = false;
                while (!validDay) {
                    System.out.println("Please input course day(MON, TUE...) : ");
                    day = scanner.nextLine();
                    validDay = checkValidDay(day);
                }

                boolean validStartTime = false;
                while (!validStartTime) {
                    System.out.println("Please input course start time(HH:mm) : ");
                    startTime = scanner.nextLine();
                    validStartTime = checkValidTime(startTime);
                }

                boolean validEndTime = false;
                while (!validEndTime) {
                    System.out.println("Please input course end time(HH:mm) : ");
                    endTime = scanner.nextLine();
                    validEndTime = checkValidTime(endTime) && compareTimes(startTime, endTime);
                }

                if (controller.addCourse(course_name, day, startTime, endTime))
                    System.out.println("Course successfully added");
                else System.out.println("Course failed to add");
            }

            //Query students
            else if (query.startsWith("-getstudents")) {
                String[] parts = query.split(" ");
                //All students
                if (parts.length == 1) {
                    List<Student> students = controller.getStudents();
                    if (students != null && students.size() > 0) {
                        System.out.println("Student list:");
                        printList(students);
                    } else System.out.println("List is empty or null");
                }
                //Course ID students
                else if (parts.length == 2) {
                    if (StringUtils.isNumeric(parts[1])) {
                        List<Student> students = controller.getStudents(Integer.parseInt(parts[1]));
                        if (students != null && students.size() > 0) {
                            System.out.println("Student list for Course No." + parts[1]);
                            printList(students);
                        } else System.out.println("List is empty or null");
                    } else System.out.println("Unrecognized argument \'" + parts[1] + "\', please try again");
                } else System.out.println("Bad argument, please try again");
            }

            //Query courses
            else if (query.startsWith("-getcourses")) {
                String[] parts = query.split(" ");
                //All courses
                if (parts.length == 1) {
                    List<Course> courses = controller.getCourses();
                    if (courses != null && courses.size() > 0) {
                        System.out.println("Course list:");
                        printList(courses);
                    } else System.out.println("List is empty or null");
                }
                //Student ID courses
                else if (parts.length == 2) {
                    if (StringUtils.isNumeric(parts[1])) {
                        List<Course> courses = controller.getCourses(Integer.parseInt(parts[1]));
                        if (courses != null && courses.size() > 0) {
                            System.out.println("Course list for Student No." + parts[1]);
                            printList(courses);
                        } else System.out.println("List is empty or null");
                    } else System.out.println("Unrecognized argument \'" + parts[1] + "\', please try again");
                } else if (parts.length == 3) {
                    if (StringUtils.isNumeric(parts[1]) && checkValidDay(parts[2])) {
                        List<Course> courses = controller.getCourses(Integer.parseInt(parts[1]), parts[2]);
                        if (courses != null && courses.size() > 0) {
                            System.out.println("Course list for Student No." + parts[1] + " on " + parts[2]);
                            printList(courses);
                        } else System.out.println("List is empty or null");
                    }
                }
                else System.out.println("Bad argument, please try again");
            }

            //Enroll student into class
            else if (query.startsWith("-enroll")) {
                String[] parts = query.split(" ");
                if (parts.length != 3)
                    System.out.println("Bad argument, please try again");
                else {
                    String stuID = parts[1], courseID = parts[2];
                    if (StringUtils.isNumeric(stuID) && StringUtils.isNumeric(courseID)) {
                        if (controller.enrollStudentIntoCourse(Integer.parseInt(stuID), 
                                Integer.parseInt(courseID))) 
                            System.out.println("Enroll success.");
                        else System.out.println("Enrollment failed.");
                    } else System.out.println("Unrecognized time arguments, please try again");
                }
            }

            //Help
            else if (query.equals("-help")) {
                System.out.println(getHelp());
            }

            //Exit
            else if (query.equals("-exit")) {
                try {
                    controller.disconnect();
                    System.exit(0);
                } catch (SQLException e) {
                    System.out.println("Error when trying to shutdown DB: ");
                    System.out.println(e.getMessage());
                    System.out.println(e.getSQLState());
                }
            }
            else System.out.println("Unrecognized command \'" + query + "\', please try again");
        }
    }
}
