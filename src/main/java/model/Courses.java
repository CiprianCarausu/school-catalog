package model;

public class Courses {
    String nume;
    String prescurtare;
    String detalii;
    Profesor profesori;

    public Courses(String nume, String prescurtare, String detalii, Profesor profesori){
        this.nume = nume;
        this.prescurtare = prescurtare;
        this.detalii = detalii;
        this.profesori = profesori;

    }
}
