package model;
import java.util.Date;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;
    private String phoneNumber;
    private int group;

    public Student(String firstName, String lastName, String email, Date birthDate, String phoneNumber, int group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = checkEmail(email);
        this.birthDate = birthDate;
        this.phoneNumber = checkPhone(phoneNumber);
        this.group = checkGroup(group);
    }

    public String checkPhone(String phoneNumber) {
        if (phoneNumber != "^/d(?:-/d{3}){3}/d$") {
            System.out.println("Error! Please enter a vaild phone number!");
        }
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public int getGroup() {
        return group;
    }
    public void setFirstName(String firstName) {
        if (firstName != null && !"".equals(firstName)) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null && !"".equals(lastName)) {
            this.lastName = lastName;

        }
    }

    public void setEmail(String eMail) {
        if (eMail != null && !"".equals((eMail))) {
            this.email = eMail;
        }
    }

    public void setBirthDate(Date birthDate) {
        if (birthDate != null && "".equals(birthDate)) {
            this.birthDate = birthDate;
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String checkEmail(String email) {
        if (email != "[_a-zA-Z1-9]+(\\.[A-Za-z0-9]*)*@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]*)*") {
            System.out.println("ERROR. Invalid e-mail adress!");
        }
        return email;
    }

    public int checkGroup(int group) {
        if (group < 1 && group > 10) {
            System.out.println("Error: Invalid Group");
        }
        return group;
    }
}