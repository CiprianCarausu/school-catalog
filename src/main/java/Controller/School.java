package Controller;


import IO.CSVReader;
import IO.CSVWriter;
import Model.*;

import java.io.IOException;
import java.util.*;

public class School {
    Map<Integer, Group> groups = new HashMap<>();
    Map<Integer, Student> students = new HashMap<>();
    Map<Integer, Message> messages = new HashMap<>();
    Map<String, Teacher> teachers = new HashMap<>();
    Map<String, Location> locations = new HashMap<>();


    public void startEverythingUp(){
        loadGroups();
        loadStudents();
        loadMessages();
        connectStudentWithGroup();
        connectMessagesWithGroup();
        connectMessagesWithStudent();
        System.out.println("Connected Message, Students and Groups!");
    }

    public int countEveryStudent(){
        int numberOfStudents = 0;
        for(Group group : groups.values()){
            numberOfStudents += group.countStudents();
        }
        return numberOfStudents;
    }

    public void connectMessagesWithGroup(){
        Collection<Message> values = messages.values();
        for(Message message: values){
            groups.get(message.getGroupId()).addMessage(message);
        }
    }

    public void connectStudentWithGroup(){
        Collection<Student> values = students.values();
        for(Student student: values){
            groups.get(student.getGroupId()).addStudent(student);
        }
    }

    public void connectMessagesWithStudent(){
        Collection<Student> values = students.values();
        for(Student student: values){
            for(String id : student.getMessageIds()){
                int messageId = Integer.parseInt(id);
                student.addMessage(messages.get(messageId));
            }
        }
    }

    public void loadGroups() {
        List<String> group = new CSVReader().readFile("Group");
        for(String line: group){
            Group tempGroup = new Group();
            tempGroup.loadDataFromCSVString(line);
            groups.put(tempGroup.getIdGroup(), tempGroup);
        }
    }

    public void loadStudents(){
        List<String> group = new CSVReader().readFile("Student");
        for(String line: group){
            Student tempStudent = new Student();
            tempStudent.loadDataFromCSVString(line);
            students.put(tempStudent.getstudentNumber(), tempStudent);
        }
    }

    public void loadMessages(){
        List<String> group = new CSVReader().readFile("Message");
        for(String line: group){
            Message tempMessage = new Message();
            tempMessage.loadDataFromCSVString(line);
            messages.put(tempMessage.getGroupId(), tempMessage);
        }
    }

    public void loadTeachers(){
        List<String> group = new CSVReader().readFile("Teacher");
        for(String line: group){
            Teacher tempTeacher = new Teacher();
            tempTeacher.loadDataFromCSVString(line);
            teachers.put(tempTeacher.getLastName(), tempTeacher);
        }
    }

    public void loadLocations(){
        List<String> group = new CSVReader().readFile("Location");
        for(String line: group){
            Location tempLocation = new Location();
            tempLocation.loadDataFromCSVString(line);
            locations.put(tempLocation.getName(), tempLocation);
        }
    }

    public void saveAllMessagesAGroup(){
        for(Group group : groups.values()){
            group.saveMessagesOnTimeOrder();
        }
    }

    public int teachersHiredPast2000() {
        int numberOfTeachers = 0;
        for(Teacher teacher: teachers.values()){
            if(teacher.hiredPast2000()){
                numberOfTeachers++;
            }
        }
        return numberOfTeachers;
    }

    public void saveLocationsAvailable() {
        List<Location> availables = new ArrayList<>();
        for(Location loc : locations.values()){
            if(loc.isAvailable()){
                availables.add(loc);
            }
        }
        try {
            new CSVWriter().writeAvailableLocations(availables);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something when wrong while creating the writer!");
        }
    }

    public void groupTeachersByStatus(){
        for(Teacher teacher: teachers.values()){
            teacher.addMeToGroupedTeachers();
        }
    }
    }

  /*  public static int readGroup() {
        List<String> group = new CSVReader().readFile("Group");
        group.remove(0);
        int count = 0;
        for (String line : group) {
            count++;
        }
        return count;
    }*/

