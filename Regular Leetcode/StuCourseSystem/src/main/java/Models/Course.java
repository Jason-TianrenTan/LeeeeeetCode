package Models;

public class Course {

    private int course_id;
    private String course_name;
    private String startTime, endTime, day;

    public Course(int course_id, String course_name, String startTime, String endTime, String day) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return this.course_name + ", " + this.startTime + " - " + this.endTime + ", " + this.day;
    }
}
