package Model;

import Util.DateTimeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Student implements Comparable{
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;
    private String phoneNumber;
    private int groupId;
    private int studentNumber;
    private List<String> messagesIds;
    private List<Message> messages = new ArrayList<>();

    public Student(String firstName, String lastName, String email, Date birthDate, String phoneNumber, int group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = checkEmail(email);
        this.birthDate = birthDate;
        this.phoneNumber = checkPhone(phoneNumber);
        this.groupId = checkGroup(group);
    }

    public Student() {
    }

    public void loadDataFromCSVString(String line) {
        String[] columns = line.split(",");
        this.studentNumber = Integer.parseInt(columns[0]);
        this.firstName = columns[1];
        this.lastName = columns[2];
        this.email = columns[3];
        this.birthDate = DateTimeConverter.stringToDate(columns[4]);
        this.phoneNumber = columns[5];
        this.groupId = Integer.parseInt(columns[6]);
        this.messagesIds = Arrays.asList(columns[7].split("/"));
    }

    public String checkPhone(String phoneNumber) {
        if (phoneNumber != "^/d(?:-/d{3}){3}/d$") {
            System.out.println("Error! Please enter a vaild phone number!");
        }
        return phoneNumber;
    }

    public int getstudentNumber() {
        return studentNumber;
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

    public int getGroupId() { return groupId;}

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

    public void setGroupId(int groupId) { this.groupId = groupId;}

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

    public List<String> getMessageIds() {
        return messagesIds;
    }

    public void addMessage(Message message){
        messages.add(message);
    }

    /*public void loadDataFromCSVString(String line) {
        String[] columns = line.split(",");
        this.firstName = columns[0];
        this.birthDate = DateTimeConverter.stringToDateAndTime(columns[3]);
    }*/
    public String toCSVFileSave() {
        return firstName + "," + lastName + "," + email + "," + birthDate + "," + phoneNumber+ "," + groupId+"\n";
    }


    @Override
    public int compareTo(Object o) {
Student other = (Student) o;
        return birthDate.compareTo(other.birthDate);
    }
}