package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teacher{
    private String lastName;
    private String firstName;

    private String email;
    private Title title;
    private String phoneNumber;
    private int yearOfEmployment;
    private boolean active;
    private static Map<Title, List<Teacher>> groupedByTeachers = new HashMap<>();


    public Teacher(String strTeachers) {
    }
    public Teacher(){}

    public void loadDataFromCSVString(String line){
        String[] columns = line.split(",");
        this.lastName = columns[0];
        this.firstName = columns[1];
        setEmail(columns[2]);
        setTitle(Title.valueOf(columns[3]));
        setPhoneNumber(columns[4]);
        setYearOfEmployment(Integer.parseInt(columns[5]));
    }

    public void addMeToGroupedTeachers(){
        groupedByTeachers.computeIfAbsent(title, k -> new ArrayList<>());
        groupedByTeachers.get(title).add(this);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
        String emailRegex = "[_a-zA-Z1-9]+(\\.[A-Za-z0-9]*)*@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]*)*";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);

        if (matcher.find() == false)
            System.out.println("The email address you entered is invalid!");

    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        String phoneNumberRegex = "^(\\+\\d{1,2}\\s?)?1?\\-?\\.?\\s?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";
        Pattern phoneNumberPat = Pattern.compile(phoneNumberRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = phoneNumberPat.matcher(phoneNumber);

        if (matcher.find() == false)
            System.out.println("The phone number you entered is invalid!");
    }

    public void setYearOfEmployment(int yearOfEmployment) {
        this.yearOfEmployment = yearOfEmployment;
        if(yearOfEmployment < 1970){
            System.out.println("The mentioned year is below 1970.");
        }
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getLastName(){
        return lastName;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", Title='" + title + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", yearOfEmployment=" + yearOfEmployment +
                ", active=" + active +
                '}';
    }

    public boolean hiredPast2000() {
        return yearOfEmployment > 2000;
    }
}