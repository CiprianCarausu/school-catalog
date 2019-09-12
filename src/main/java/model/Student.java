package model;
/*
        Nume - text, obligatoriu *
        Prenume - text, obligatoriu *
        Email - text, obligatoriu, validare format si unicitate
        Data_nasterii - data, obligatoriu *
        Telefon - text, validare format
        Grupa - numeric, intre 1 si 10. Reprezinta grupa din care face parte studentul
*/
import java.util.Date;

public class Student {
    //Student - Olimpia, Ariana, Simona

    private String firstName;
    private String lastName;
    private String eMail;
    private Date birthDate;
    private String phoneNumber;
    private int group;

    public Student(String firstName, String lastName, String eMail, Date birthDate, String phoneNumber, int group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = checkEmail(eMail);
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
        return eMail;
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
            this.eMail = eMail;
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

    public String checkEmail(String eMail) {
        if (eMail != "[_a-zA-Z1-9]+(\\.[A-Za-z0-9]*)*@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]*)*") {
            System.out.println("ERROR. Invalid e-mail adress!");
        }
        return eMail;

    }

    public int checkGroup(int group) {
        if (group < 1 && group > 10) {
            System.out.println("Error: Invalid Group");
        }
        return group;

    }
}