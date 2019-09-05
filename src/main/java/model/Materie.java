import model.Profesor;

public class Materie {
    String nume;
    String prescurtare;
    String detalii;
    Profesor profesori;

    public Materie(String nume, String prescurtare, String detalii, Profesor profesori){
        this.nume = nume;
        this.prescurtare = prescurtare;
        this.detalii = detalii;
        this.profesori = profesori;

    }
}
