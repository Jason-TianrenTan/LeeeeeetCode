package Controller;

import DBUtils.DBConnection;
import Models.Course;
import Models.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBController {


    public void disconnect() throws SQLException{
        DBConnection.disconnect();
    }

    public boolean addStudent(String name) {
        try {
            DBConnection.execUpdate("INSERT INTO students (student_name) VALUES\n" +
                    "(\"" + name + "\")");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            return false;
        }
    }

    public boolean addCourse(String course_name, String day, String startTime, String endTime) {
        try {
            DBConnection.execUpdate("INSERT INTO courses VALUES\n" +
                    "(DEFAULT, \"" + course_name + "\", \"" + startTime + "\", \"" + endTime + "\", \"" + day + "\")");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            return false;
        }
    }

    public List<Student> getStudents() {
        try {
            ResultSet resultSet = DBConnection.execQuery("SELECT * FROM students");
            return generateStudentList(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            return null;
        }
    }

    public List<Course> getCourses() {
        try {
            ResultSet resultSet = DBConnection.execQuery("SELECT course_id, course_name,\n" +
                    "\tdate_format(course_start_time,'%H:%i') as start_time, \n" +
                    "\tdate_format(course_end_time,'%H:%i') as end_time,\n" +
                    "    course_day\n" +
                    "FROM student_course.courses;");
            return generateCourseList(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            return null;
        }
    }

    public List<Course> getCourses(int stuID) {
        try {
            ResultSet resultSet = DBConnection.execQuery("SELECT c.course_id, course_name,\n" +
                    "\tdate_format(course_start_time,'%H:%i') as start_time, \n" +
                    "    date_format(course_end_time,'%H:%i') as end_time,\n" +
                    "    course_day\n" +
                    "FROM courses c JOIN student_course_enrollment enrolls ON c.course_id = enrolls.course_id\n" +
                    "\tJOIN students s ON enrolls.student_id = s.student_id\n" +
                    "WHERE s.student_id = " + stuID + "\n" +
                    "ORDER BY course_start_time");
            return generateCourseList(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            return null;
        }
    }

    public List<Course> getCourses(int stuID, String day) {
        try {
            ResultSet resultSet = DBConnection.execQuery("SELECT enrolls.course_id, course_name, date_format(course_start_time,'%H:%i') as start_time,\n" +
                    " date_format(course_end_time,'%H:%i') as end_time, course_day\n" +
                    "FROM courses c \n" +
                    "\tJOIN student_course_enrollment enrolls \n" +
                    "\t\tON c.course_id = enrolls.course_id\n" +
                    "    JOIN students stu\n" +
                    "\t\tON enrolls.student_id = stu.student_id\n" +
                    "WHERE stu.student_id = " + stuID + " AND course_day = \'" + day +"\'\n" +
                    "ORDER BY course_start_time");
            return generateCourseList(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            return null;
        }
    }

    public List<Student> getStudents(int courseID) {
        try {
            ResultSet resultSet = DBConnection.execQuery("SELECT s.student_id, s.student_name\n" +
                    "FROM courses c JOIN student_course_enrollment enrolls ON c.course_id = enrolls.course_id\n" +
                    "\tJOIN students s ON enrolls.student_id = s.student_id\n" +
                    "WHERE c.course_id = " + courseID);
            return generateStudentList(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            return null;
        }
    }

    public boolean enrollStudentIntoCourse(int stuID, int courseID) {
        try {
            DBConnection.execUpdate("INSERT INTO student_course_enrollment VALUES\n" +
                    "(" + stuID + ", " + courseID + ")");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            return false;
        }
    }

    private List<Student> generateStudentList(ResultSet resultSet) throws SQLException {
        List<Student> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new Student(resultSet.getInt("student_id"), resultSet.getString("student_name")));
        }
        return list;
    }

    private List<Course> generateCourseList(ResultSet resultSet) throws SQLException {
        List<Course> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new Course(
                    resultSet.getInt("course_id"),
                    resultSet.getString("course_name"),
                    resultSet.getString("start_time"),
                    resultSet.getString("end_time"),
                    resultSet.getString("course_day")));
        }
        return list;
    }

    public void connectDB() {
        try {
            DBConnection.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
