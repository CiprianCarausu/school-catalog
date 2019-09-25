package model;

public class Courses {
    String name;
    String abbreviation;
    String details;
    Teacher teachers;

    public Courses(String name, String abbreviation, String details, Teacher teachers){
        this.name = name;
        this.abbreviation = abbreviation;
        this.details = details;
        this.teachers = teachers;

    }
}
