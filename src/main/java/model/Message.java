package model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Message{
    private Student student;
    private LocalDateTime dateTime;
    private String message;
    private Group idGroup;

    public Message(Student student, LocalDateTime dateTime, String message, Group group) throws Exception {
        //this.student = student;
        this.dateTime = dateTime;
        this.message = message;
        //this.group = idGroup;
        validate();
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


    private boolean messageHasContent(String text) {
        String EMPTY_STRING = "";
        return (text != null) && (!text.trim().equals(EMPTY_STRING));
    }

    private boolean groupValidation(int group){
        return (group >= 1) && ( group <= 10);
    }
    private void validate() throws Exception {
        List<String> errors = new ArrayList<>();
         /*if (!messageHasContent(Student.get(firstName))) {
            errors.add("Student must have content.");
         }
         if (!groupValidation(group)) {
             errors.add("Student must have group from 1 to 10.");
         }*/

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
