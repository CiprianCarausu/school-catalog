package model;

public class Profesor {
    private String lastName;
    private String firstName;
    private String email;
    private String Title;
    private int phoneNumber;
    private int yearOfEmployment;
    private boolean active;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTitle(Titles title) {
        title = title;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setYearOfEmployment(int yearOfEmployment) {
        this.yearOfEmployment = yearOfEmployment;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
