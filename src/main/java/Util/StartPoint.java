package Util;

import Controller.School;
import IO.CSVWriter;

public class StartPoint {
    public static void main(String[] args) {
        School school = new School();
        school.startEverythingUp();

        System.out.println("The total number of students is: " + school.countEveryStudent());

        school.saveAllMessagesAGroup();

        school.loadTeachers();
        System.out.println("The number of teacher who got hired past 2000 is: " + school.teachersHiredPast2000());

        school.invokeResortForStudentsByBirthdate();

        school.loadLocations();
        school.saveLocationsAvailable();
        school.saveSortedStudentsByBirthName();
        school.saveListGroupStudents();
        school.saveSortedLocationCapacity();
    }
}

