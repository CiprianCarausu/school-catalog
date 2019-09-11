package model;

import java.util.List;

public class Group {
    private int idGroup;     //- numeric,obligatoriu intre 1 si 10.
    private int year;        //obligatoriu intre 1 si 6. Reprezinta anul din care face parte grupa.
    private List<Student> students; //studenti - lista de studenti
    private List<Message> messages; //mesaje //- lista de mesaje asociate grupei

    public Group(int idGroup, int year, List<Student> students, List<Message> messages) {
        checkForIdGroupRange();
        checkForYearRange();
        this.idGroup = idGroup;
        this.year = year;
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


    private void checkForIdGroupRange() {
        if(this.idGroup < 1 || this.idGroup > 10){
            throw new IllegalArgumentException("The group doesn't exist.");
        }

    }
    private void checkForYearRange() {

        if(year < 1 || year > 6){
            throw new IllegalArgumentException("Year not in range 1-6.");
        }
    }


}
