package model;/*
   Mesaj
Student - obligatoriu, Studentul care a transmis mesajul
Timp - data si timpul, obligatoriu. Timpul exact la care a fost transmis cu precizie cat mai mare (e.g. milisecunde). Precizia este necesara pentru ordonare cronologica.
Text - text, obligatoriu. textul mesajului
Grupa - obligatoriu, grupa unde a fost transmis mesajul

        */

import java.util.Date;

public class Message{
    private Student student = new Student();
    private Date time ;
    private String message = "";
    private Group group = new Group();

    public Message(Date time, String message) {
        this.time = time;
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
