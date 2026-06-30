import Bibliothek.Bibliothek;
import Bibliothek.BibliothekGUI;
import Bibliothek.Buch;
import Bibliothek.Kategorie;
import Bibliothek.Status;

public class Main {

    public static void main(String[] args) {

        Bibliothek bibliothek = new Bibliothek();

        buecherEintragen(bibliothek);

        new BibliothekGUI(bibliothek);
    }

    public static void buecherEintragen(Bibliothek bibliothek) {

        bibliothek.buchHinzufuegen(

                new Buch("1-Die  kleine Raupe Nimmersatt", Status.VERFUEGBAR, Kategorie.KINDERBUCH),
                new Buch("2-Der Grüffelo", Status.VERFUEGBAR, Kategorie.KINDERBUCH),
                new Buch("3-Pettersson und  Findus", Status.VERFUEGBAR, Kategorie.KINDERBUCH),
                new Buch("4-Die Schule der magischen Tiere", Status.VERFUEGBAR, Kategorie.KINDERBUCH),
                new Buch("5-Das Sams", Status.VERFUEGBAR, Kategorie.KINDERBUCH),
                new Buch("6-Der kleine Drache Kokosnuss", Status.VERFUEGBAR, Kategorie.KINDERBUCH),
                new Buch("7-Emil und die Detektive", Status.VERFUEGBAR, Kategorie.KINDERBUCH),
                new Buch("8-Pippi Langstrumpf", Status.VERFUEGBAR, Kategorie.KINDERBUCH),
                new Buch("9-Jim Knopf und Lukas der Lokomotivführer", Status.VERFUEGBAR, Kategorie.KINDERBUCH),
                new Buch("10-Rico, Oskar und die Tieferschatten", Status.VERFUEGBAR, Kategorie.KINDERBUCH),

                new Buch("1-Der Herr der Ringe", Status.VERFUEGBAR, Kategorie.ROMAN),
                new Buch("2-Harry Potter und der Stein der Weisen", Status.VERFUEGBAR, Kategorie.ROMAN),
                new Buch("3-Stolz und Vorurteil", Status.VERFUEGBAR, Kategorie.ROMAN),
                new Buch("4-Der Alchimist", Status.VERFUEGBAR, Kategorie.ROMAN),
                new Buch("5-Der Vorleser", Status.VERFUEGBAR, Kategorie.ROMAN),
                new Buch("6-Die unendliche Geschichte", Status.VERFUEGBAR, Kategorie.ROMAN),
                new Buch("7-1984", Status.VERFUEGBAR, Kategorie.ROMAN),
                new Buch("8-Der Name der Rose", Status.VERFUEGBAR, Kategorie.ROMAN),
                new Buch("9-Die Säulen der Erde", Status.VERFUEGBAR, Kategorie.ROMAN),
                new Buch("10-Der Medicus", Status.VERFUEGBAR, Kategorie.ROMAN),

                new Buch("1-Geschichte des Alten Ägyptens", Status.VERFUEGBAR, Kategorie.GESCHICHTE),
                new Buch("2-Das Römische Reich", Status.VERFUEGBAR, Kategorie.GESCHICHTE),
                new Buch("3-Die Französische Revolution", Status.VERFUEGBAR, Kategorie.GESCHICHTE),
                new Buch("4-Der Erste Weltkrieg", Status.VERFUEGBAR, Kategorie.GESCHICHTE),
                new Buch("5-Der Zweite Weltkrieg", Status.VERFUEGBAR, Kategorie.GESCHICHTE),
                new Buch("6-Geschichte Deutschlands", Status.VERFUEGBAR, Kategorie.GESCHICHTE),
                new Buch("7-Die Berliner Mauer", Status.VERFUEGBAR, Kategorie.GESCHICHTE),
                new Buch("8-Napoleon Bonaparte", Status.VERFUEGBAR, Kategorie.GESCHICHTE),
                new Buch("9-Das Mittelalter", Status.VERFUEGBAR, Kategorie.GESCHICHTE),
                new Buch("10-Die Geschichte Europas", Status.VERFUEGBAR, Kategorie.GESCHICHTE)

        );
    }
}







