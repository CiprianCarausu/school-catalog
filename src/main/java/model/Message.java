package model;/*
   Mesaj
Student - obligatoriu, Studentul care a transmis mesajul
Timp - data si timpul, obligatoriu. Timpul exact la care a fost transmis cu precizie cat mai mare (e.g. milisecunde). Precizia este necesara pentru ordonare cronologica.
Text - text, obligatoriu. textul mesajului
Grupa - obligatoriu, grupa unde a fost transmis mesajul
Eve, Geta, Andrei
        */

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Message{
    private String student;
    private LocalDateTime dateTime ;
    private String message;
    private int group;

    public Message(String student, LocalDateTime dateTime, String message, int group) {
        this.student = student;
        this.dateTime = dateTime;
        this.message = message;
        this.group = group;
        validate();
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    private boolean messageHasContent(String text) {
        String EMPTY_STRING = "";
        return (text != null) && (!text.trim().equals(EMPTY_STRING));
    }

    private boolean groupValidation(int group){
        return (group >= 1) && ( group <= 10);
    }
    private void validate() throws Exception {
        List<String> errors = new ArrayList<>();
        if (!messageHasContent(student)) {
            errors.add("Student must have content.");
        }
        if (!groupValidation(group)) {
            errors.add("Student must have group from 1 to 10.");
        }

        if (dateTime == null){
            errors.add("DateTime cannot be null.");
        }
        if (!messageHasContent(message)) {
            errors.add("Message must have content.");
        }

        if  (!errors.isEmpty()) {
            Exception ex = new Exception("Errors found in constructing a Message.");
            for (String error : errors) {
                ex.addSuppressed(new Exception(error));
            }
            throw ex;
        }
    }

}
