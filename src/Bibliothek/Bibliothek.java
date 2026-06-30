package Bibliothek;

import java.util.ArrayList;
import java.util.Scanner;

public class Bibliothek {

    private ArrayList<Benutzer> benutzer_List;
    private ArrayList<Buch> bucher_List;
    private ArrayList<Buch> korb_List;

    public Bibliothek() {
        benutzer_List = new ArrayList<>();
        bucher_List = new ArrayList<>();
        korb_List = new ArrayList<>();
    }


    public Kategorie buch_Kategorie_zeigen(Scanner sc) {
        System.out.println("1 -> Kinderbuch");
        System.out.println("2 -> Roman");
        System.out.println("3 -> Geschichte");
        System.out.println("4 -> Alle Kategorien");

        String wahl = sc.nextLine();

        switch (wahl) {
            case "1":
                return Kategorie.KINDERBUCH;
            case "2":
                return Kategorie.ROMAN;
            case "3":
                return Kategorie.GESCHICHTE;
            case "4":
                return Kategorie.ALLE_KATEGORIE;
            default:
                System.out.println("Falsche Eingabe.");
                return null;
        }
    }

    public void buecherNachKategorieZeigen(Kategorie kategorie) {
        if (kategorie == null) {
            return;
        }

        for (int i = 0; i < bucher_List.size(); i++) {
            Buch buch = bucher_List.get(i);

            if (kategorie == Kategorie.ALLE_KATEGORIE ||
                    buch.getKategorie().equals(kategorie)) {
                System.out.println(buch.getTitel());
            }
        }
    }

    public void buchAuswaehlenUndInKorbLegen(Scanner sc) {
        if (bucher_List.isEmpty()) {
            System.out.println("Keine Bücher vorhanden.");
            return;
        }

        System.out.println("Wähle ein Buch:");

        for (int i = 0; i < bucher_List.size(); i++) {
            Buch buch = bucher_List.get(i);
            System.out.println((i + 1) + " -> " + buch.getTitel());
        }

        String eingabe = sc.nextLine();
        int nummer = Integer.parseInt(eingabe);

        if (nummer < 1 || nummer > bucher_List.size()) {
            System.out.println("Falsche Nummer.");
            return;
        }

        Buch gewaehltesBuch = bucher_List.get(nummer - 1);
        korb_List.add(gewaehltesBuch);

        System.out.println("Buch wurde in den Korb gelegt: " + gewaehltesBuch.getTitel());
    }

    public void buchHinzufuegen(Buch... buecher) {
        for (Buch buch : buecher) {
            bucher_List.add(buch);
        }
    }

    public void benutzerHinzufuegen(Benutzer benutzer) {
        benutzer_List.add(benutzer);
    }

    public void buchLoschen(String titel) {
        for (int i = 0; i < bucher_List.size(); i++) {
            Buch buch = bucher_List.get(i);

            if (buch.getTitel().equals(titel)) {
                bucher_List.remove(i);
                System.out.println("Buch wurde gelöscht.");
                return;
            }
        }

        System.out.println("Buch wurde nicht gefunden.");
    }

    public boolean ueberprueft(Benutzer benutzer) {
        for (int i = 0; i < benutzer_List.size(); i++) {
            Benutzer gespeicherterBenutzer = benutzer_List.get(i);

            if (gespeicherterBenutzer.getName_B().equals(benutzer.getName_B()) &&
                    gespeicherterBenutzer.getFamiliename_B().equals(benutzer.getFamiliename_B()) &&
                    gespeicherterBenutzer.getGeburstdatum_B().equals(benutzer.getGeburstdatum_B())) {
                return true;
            }
        }

        return false;
    }

    public void korb_hinzufuegen(Scanner sc) {
        System.out.println("Mach deine Wahl von dem Buch:");
        String gewaehltesBuch = sc.nextLine();

        for (int i = 0; i < bucher_List.size(); i++) {
            Buch buch = bucher_List.get(i);

            if (buch.getTitel().equals(gewaehltesBuch)) {
                korb_List.add(buch);
                System.out.println("Buch wurde zum Korb hinzugefügt.");
                return;
            }
        }

        System.out.println("Kein Buch mit diesem Namen gefunden.");
    }

    public void korbZeigen() {
        if (korb_List.isEmpty()) {
            System.out.println("Korb ist leer.");
            return;
        }

        for (int i = 0; i < korb_List.size(); i++) {
            Buch buch = korb_List.get(i);
            System.out.println(buch.getTitel());
        }
    }

    public void alleBuecherZeigen() {
        if (bucher_List.isEmpty()) {
            System.out.println("Keine Bücher vorhanden.");
            return;
        }

        for (int i = 0; i < bucher_List.size(); i++) {
            Buch buch = bucher_List.get(i);
            System.out.println(buch.getTitel());
        }
    }


    public ArrayList<Buch> getBucher_List() {
        return bucher_List;
    }

    public ArrayList<Buch> getKorb_List() {
        return korb_List;
    }

}

