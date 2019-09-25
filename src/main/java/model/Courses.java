package model;

public class Courses {
    String name;
    String abbreviation;
    String details;
    Profesor teachers;

    public Courses(String name, String abbreviation, String details, Profesor teachers){
        this.name = name;
        this.abbreviation = abbreviation;
        this.details = details;
        this.teachers = teachers;

    }
}
