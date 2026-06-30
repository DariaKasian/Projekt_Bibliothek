package Bibliothek;
import java.time.LocalDate;


public class Buch {
    private static int naechsteId = 1;
    private int id;
    private String titel;
    private Status status;
    private Kategorie kategorie;
    private LocalDate ausleihe_datum;
    private LocalDate ruckgabe_datum;

    public Buch (String titel, Status status, Kategorie kategorie) {

        this.id = naechsteId;
        naechsteId++;
        this.titel = titel;
        this.status = status;
        this.kategorie = kategorie;
        this.ausleihe_datum = LocalDate.now();
        this.ruckgabe_datum = ausleihe_datum.plusDays(30);

    }

    public int getId() {
        return id;
    }
    public String getTitel() {
        return titel;
    }
    public Status  getStatus() {
        return status;
    }
    public Kategorie getKategorie() {
        return kategorie;
    }
    public LocalDate getAusleihe_datum() {
        return ausleihe_datum;
    }
    public LocalDate getRuckgabe_datum() {
        return ruckgabe_datum;
    }



    public void setStatus(Status status) {
        this.status = status;
    }
    public void setKategorie(Kategorie kategorie) {
        this.kategorie=kategorie;
    }
    public void setAusleihe_datum(LocalDate ausleihe_datum) {
       this.ausleihe_datum = ausleihe_datum;
    }
    public void setRuckgabe_datum(LocalDate ruckgabe_datum) {
        this.ruckgabe_datum = ruckgabe_datum;
    }

}
