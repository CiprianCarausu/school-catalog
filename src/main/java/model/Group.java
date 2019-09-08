package model;

public class Group {
    private int idGroup;     //- numeric,obligatoriu intre 1 si 10.
    private int year;        //obligatoriu intre 1 si 6. Reprezinta anul din care face parte grupa.
    Student student;        //studenti - lista de studenti
    Message message;        //mesaje //- lista de mesaje asociate grupei

    public Group(int idGroup, int year, Student student, Message message) {

        if(idGroup < 1 || idGroup > 10){
            throw new IllegalArgumentException("The group is doesn't exist.");
        }
        if(year < 1 || year > 6){
            throw new IllegalArgumentException("Year not in range 1-6.");
        }

        this.idGroup = idGroup;
        this.year = year;
        this.student = student;
        this.message = message;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public int getYear() {
        return year;
    }

}
