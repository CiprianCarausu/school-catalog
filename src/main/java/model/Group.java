package model;

public class Group {
    private int IdGroup;     //- numeric,obligatoriu intre 1 si 10.
    private int Year;        //obligatoriu intre 1 si 6. Reprezinta anul din care face parte grupa.

    //Studenti - lista de studenti
    //Mesaje //- lista de mesaje asociate grupei

    public Group(int idGroup, int year) {
        IdGroup = idGroup;
        Year = year;
    }

    public int getIdGroup() {
        return IdGroup;
    }

    public void setIdGroup(int idGroup) {
        IdGroup = idGroup;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }
}
