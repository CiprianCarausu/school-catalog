package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Message implements Comparable<Message> {
    private int groupId;
    private Date dateTime;
    private String content;
    private List<Student> students;

    public Message(int groupId, Date dateTime, String content, List<Student> students) {
        this.groupId = groupId;
        this.dateTime = dateTime;
        this.content = content;
        this.students = students;
    }

    public int getGroupId() {
        return groupId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getContent() {
        return content;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    private void validate() throws Exception {
        List<String> errors = new ArrayList<>();

        if (dateTime == null) {
            errors.add("DateTime cannot be null.");
        }
        if (!contentNotEmpty()) {
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

    private boolean contentNotEmpty() {
        String EMPTY_STRING = "";

        return content != null && !content.trim().equals(EMPTY_STRING);
    }

    @Override
    public int compareTo(Message o) {
        return dateTime.compareTo(o.dateTime);
    }
}
