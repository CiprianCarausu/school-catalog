package model;

/*
Materie
	Denumire - text, obligatoriu
	Prescurtare - text, obligatoriu. Denumirea scurta a materiei
	Detalii - text, obligatoriu, maxim 100 caractere. Detalii despre continutul cursului / seminarului
	Profesori - lista de profesori care pot preda materia curenta

	Courses
    - fara modificatori de acces pe variabile
    - lipsesc gettere si settere pt fielduri
    - inconsistenta la Profesor, e declarata variabila ‘profesori’ asociata unui singur profesor


 */

public class Courses {

    private String name;
    private String shortcut;
    private String details;
    private String teachers;//get teachers list from Profesor's getter

    public Courses(String name, String shortcut, String details, String teachers){


        this.name = name;
        this.shortcut = shortcut;
        this.details = checks(details);
        this.teachers = teachers;

    }

    public String getName() {
        return name;
    }

    public String getShortcut() {
        return shortcut;
    }

    public String getDetails() {
        return details;
    }

    public String checks(String details){

        if(details.length() >100){
            System.out.println("ERROR. Too many details!!!");
        }
        return details;
    }
}
