package Bibliothek;

public class Benutzer {

    private String name_B;
    private String familiename_B;
    private String geburstdatum_B;
    private static int naechsteId = 1;
    private int id_B;


    public Benutzer(String name_B, String familiename_B, String geburstdatum_B) {
        this.name_B = name_B;
        this.familiename_B = familiename_B;
        this.geburstdatum_B = geburstdatum_B;
        this.id_B = naechsteId;
        naechsteId++;
    }

    public String getName_B() {
        return name_B;
    }

    public String getFamiliename_B() {
        return familiename_B;
    }

    public String getGeburstdatum_B() {
        return geburstdatum_B;
    }

    public int getId_B() {
        return id_B;
    }


    public void setName_B(String name_B) {
        this.name_B = name_B;
    }

    public void setFamiliename_B(String familiename_B) {
        this.familiename_B = familiename_B;
    }

    public void setGeburstdatum_B(String geburstdatum_B) {
        this.geburstdatum_B = geburstdatum_B;
    }

    public void setId_B(int id_B) {
        this.id_B = id_B;
    }



    public void zeigen_PersonlicheInf() {
        System.out.println("Name - " + name_B + "\nFamiliename - " + familiename_B + "\nGeburstdatum - " + geburstdatum_B);

    }
}