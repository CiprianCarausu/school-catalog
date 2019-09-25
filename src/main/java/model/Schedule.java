package model;

import java.util.Date;

public class Schedule {
    private Group idGroup;
    private Teacher profesor;
    private Location location;
    private Date date;
    private String startTime;
    private String endTime;
    private String courseDetails;
    private Courses courses;

    public Schedule(Group idGroup, Teacher profesor, Location location, Date date, String startTime, String endTime, String courseDetails, Courses courses) {
        this.idGroup = idGroup;
        this.profesor = profesor;
        this.location = location;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.courseDetails = courseDetails;
        this.courses = courses;
    }

    public Group getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Group idGroup) {
        this.idGroup = idGroup;
    }

    public Teacher getProfesor() {
        return profesor;
    }

    public void setProfesor(Teacher profesor) {
        this.profesor = profesor;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(String courseDetails) {
        this.courseDetails = courseDetails;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "idGroup=" + idGroup +
                ", profesor=" + profesor +
                ", location=" + location +
                ", date=" + date +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", courseDetails='" + courseDetails + '\'' +
                ", courses=" + courses +
                '}';
    }
}
