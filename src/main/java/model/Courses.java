package model;

public class Courses {

    private String name;
    private String shortcut;
    private String details;
    private String teachers;

    public Courses(String nume, String shortcut, String details, String teachers){
        this.name = name;
        this.shortcut = shortcut;
        this.details = details;
        this.teachers = teachers;

    }

    public String getName() {
        return name;
    }

    public String getShortcut() {
        return shortcut;
    }

    public String getDetails() {
        return details;
    }
}
