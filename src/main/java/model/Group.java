package model;

import java.util.List;

public class Group {
    private int idGroup;
    private int year;
    private List<Student> students;
    private List<Message> messages;

    public Group(int idGroup, int year, List<Student> students, List<Message> messages) {
        this.idGroup = checkForIdGroupRange(idGroup);
        this.year = checkForYearRange(year);
        this.students = students;
        this.messages = messages;
    }


    public int getIdGroup() {
        return idGroup;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }


    private int checkForIdGroupRange(int idGroup) {
        if(idGroup < 1 || idGroup > 10){
            throw new IllegalArgumentException("The group doesn't exist.");
        }else{
            return idGroup;
        }
    }
    private int checkForYearRange(int year) {

        if(year < 1 || year > 6){
            throw new IllegalArgumentException("Year not in range 1-6.");
        }else{
            return year;
        }
    }
}
