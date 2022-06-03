package com.company;

public class SpeedRunTime {

    private int minute;
    private int second;
    private int millis;

    public SpeedRunTime(String timeString) {
        this.minute = Integer.parseInt(timeString.substring(0, 2));
        this.second = Integer.parseInt(timeString.substring(3, 5));
        this.millis = Integer.parseInt(timeString.substring(7));
    }

    public int compareTo(SpeedRunTime o) {
        return this.toValue() - o.toValue();
    }

    public int toValue() {
        return minute * 3600 + second * 60 + millis;
    }

    public SpeedRunTime(int minute, int second, int millis) {
        this.minute = minute;
        this.second = second;
        this.millis = millis;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (minute < 10)
            sb.append("0");
        sb.append(minute + "'");
        if (second < 10)
            sb.append("0");
        sb.append(second + "''");
        if (millis < 10)
            sb.append("0");
        sb.append(millis + "");
        return sb.toString();
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMillis() {
        return millis;
    }

    public void setMillis(int millis) {
        this.millis = millis;
    }
}
