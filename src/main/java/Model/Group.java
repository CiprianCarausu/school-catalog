package Model;

import IO.CSVWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group implements Comparable {
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

    public Group() {
    }

    public void loadDataFromCSVString(String line) {
        String[] columns = line.split(",");
        this.idGroup = Integer.parseInt(columns[0]);
        this.year = Integer.parseInt(columns[1]);
        this.students = new ArrayList<>();
        this.messages = new ArrayList<>();
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
        if (idGroup < 1 || idGroup > 10) {
            throw new IllegalArgumentException("The group doesn't exist.");
        } else {
            return idGroup;
        }
    }

    private int checkForYearRange(int year) {

        if (year < 1 || year > 6) {
            throw new IllegalArgumentException("Year not in range 1-6.");
        } else {
            return year;
        }
    }

    public void addStudent(Student tempStudent) {
        students.add(tempStudent);
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public int countStudents() {
        return students.size();
    }

    public void saveMessagesOnTimeOrder() {
        Collections.sort(messages);
        try {
            new CSVWriter().writeMessagesToFile(idGroup, messages);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong while creating a csv filewriter file!");
        }
}


    public String toCSVFileSave() {
        String text = "";
        for (Student student:students ) {
            text += idGroup + "," + year + "," + student.getFirstName() ;
        }
        return text;
    }

    @Override
    public int compareTo(Object o) {
        Group other = (Group) o;
        if (idGroup > ((Group) o).getIdGroup()) {
            return 1;
        } else {
            return 0;
        }
    }
}

