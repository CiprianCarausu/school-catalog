package Model;

import java.util.List;

public class Group implements Comparable<Group>  {
    private int groupId;
    private int year;
    private List<Student> students;
    private List<Message> messages;

    public Group(int groupId, int year, List<Student> students, List<Message> messages) {
        this.groupId = checkForIdGroupRange(groupId);
        this.year = checkForYearRange(year);
        this.students = students;
        this.messages = messages;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getYear() {
        return year;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void addStudent(Student tempStudent) {
        students.add(tempStudent);
    }

    public int getStudentsCount() {
        return students.size();
    }

    @Override
    public int compareTo(Group o) {
        return this.groupId - o.groupId;
    }

    @Override
    public boolean equals(Object o)
    {
        return false;
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
}

