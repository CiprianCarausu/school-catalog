package Util;

import Controller.School;
import IO.CSVWriter;

public class StartPoint {
    public static void main(String[] args) {
        School school = new School();
        school.startEverythingUp();

        System.out.println("\n\nExercise 4");
        System.out.println("The total number of students is: " + school.countEveryStudent());

        System.out.println("\n\nExercise 5");
        school.saveAllMessagesAGroup();

        System.out.println("\n\nExercise 6");
        school.loadTeachers();
        System.out.println("The number of teacher who got hired past 2000 is: " + school.teachersHiredPast2000());

        System.out.println("\n\nExercise 7");

        school.invokeResortForStudentsByBirthdate();

        System.out.println("Exercise ");
        school.loadLocations();
        school.saveLocationsAvailable();
        school.saveSortedStudentsByBirthName();
    }
}