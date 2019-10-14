package Model;

import Util.DateTimeConverter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Message implements Comparable {
    private List<Student> students = new ArrayList<>();
    private Date dateTime;
    private String message;
    private int groupId;

    public Message() {
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public int getGroupId() {
        return groupId;
    }

    private boolean messageHasContent(String text) {
        String EMPTY_STRING = "";
        return (text != null) && (!text.trim().equals(EMPTY_STRING));
    }

    private boolean groupValidation(int group) {
        return (group >= 1) && (group <= 10);
    }

    private void validate() throws Exception {
        List<String> errors = new ArrayList<>();
         /*if (!messageHasContent(Student.get(firstName))) {
            errors.add("Student must have content.");
         }
         if (!groupValidation(group)) {
             errors.add("Student must have group from 1 to 10.");
         }*/

        if (dateTime == null) {
            errors.add("DateTime cannot be null.");
        }
        if (!messageHasContent(message)) {
            errors.add("Message must have content.");
        }

        if (!errors.isEmpty()) {
            Exception ex = new Exception("Errors found in constructing a Message.");
            for (String error : errors) {
                ex.addSuppressed(new Exception(error));
            }
            throw ex;
        }

    }

    public void loadDataFromCSVString(String line) {
        String[] columns = line.split(",");
        this.groupId = Integer.parseInt(columns[3]);
        this.dateTime = DateTimeConverter.stringToDateAndTime(columns[1]);
        this.message = columns[2];
    }

    @Override
    public int compareTo(Object o) {
        Message other = (Message) o;
        return dateTime.compareTo(other.dateTime);
    }

    public String singeGroupFileSave() {
        return dateTime + "," + message + "\n";
    }
}
