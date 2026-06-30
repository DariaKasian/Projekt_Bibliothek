package Bibliothek;

import javax.swing.*;
import java.awt.*;

public class BibliothekGUI extends JFrame {

    private Bibliothek bibliothek;

    private JTextField titelField;
    private JComboBox<Kategorie> kategorieBox;
    private JTextArea ausgabeArea;

    public BibliothekGUI(Bibliothek bibliothek) {
        this.bibliothek = bibliothek;

        setTitle("Bibliothek");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        titelField = new JTextField(20);
        kategorieBox = new JComboBox<>(Kategorie.values());

        JButton anzeigenButton = new JButton("Alle Bücher anzeigen ");
        JButton suchenButton = new JButton("Buch suchen");
        JButton hinzufuegenButton = new JButton("Buch hinzufügen");
        JButton loeschenButton = new JButton("Buch löschen");

        ausgabeArea = new JTextArea();
        ausgabeArea.setEditable(false);

        JPanel oben = new JPanel(new GridLayout(3, 2, 10, 10));

        oben.add(new JLabel("Titel:"));
        oben.add(titelField);

        oben.add(new JLabel("Kategorie:"));
        oben.add(kategorieBox);

        oben.add(suchenButton);
        oben.add(anzeigenButton);

        JPanel unten = new JPanel();
        unten.add(hinzufuegenButton);
        unten.add(loeschenButton);

        add(oben, BorderLayout.NORTH);
        add(new JScrollPane(ausgabeArea), BorderLayout.CENTER);
        add(unten, BorderLayout.SOUTH);

        anzeigenButton.addActionListener(e -> alleBuecherAnzeigen());
        suchenButton.addActionListener(e -> buchSuchen());
        hinzufuegenButton.addActionListener(e -> buchHinzufuegen());
        loeschenButton.addActionListener(e -> buchLoeschen());

        setVisible(true);
    }

    private void alleBuecherAnzeigen() {
        ausgabeArea.setText("");

        for (Buch buch : bibliothek.getBucher_List()) {
            ausgabeArea.append(
                    buch.getId() + " | " +
                            buch.getTitel() + " | " +
                            buch.getKategorie() + " | " +
                            buch.getStatus() + " | Rückgabe: " +
                            buch.getRuckgabe_datum() + "\n"
            );
        }
    }

    private void buchSuchen() {
        String titel = titelField.getText().trim();

        if (titel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bitte Titel eingeben.");
            return;
        }

        ausgabeArea.setText("");

        for (Buch buch : bibliothek.getBucher_List()) {
            if (buch.getTitel().toLowerCase().contains(titel.toLowerCase())) {
                ausgabeArea.append(
                        buch.getId() + " | " +
                                buch.getTitel() + " | " +
                                buch.getKategorie() + " | " +
                                buch.getStatus() + "\n"
                );
            }
        }

        if (ausgabeArea.getText().isEmpty()) {
            ausgabeArea.setText("Kein Buch gefunden.");
        }
    }

    private void buchHinzufuegen() {
        String titel = titelField.getText().trim();
        Kategorie kategorie = (Kategorie) kategorieBox.getSelectedItem();

        if (titel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bitte Titel eingeben.");
            return;
        }

        Buch neuesBuch = new Buch(titel, Status.VERFUEGBAR, kategorie);
        bibliothek.buchHinzufuegen(neuesBuch);

        titelField.setText("");
        alleBuecherAnzeigen();

        JOptionPane.showMessageDialog(this, "Buch wurde hinzugefügt.");
    }

    private void buchLoeschen() {
        String titel = titelField.getText().trim();

        if (titel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bitte Titel eingeben.");
            return;
        }

        bibliothek.buchLoschen(titel);

        titelField.setText("");
        alleBuecherAnzeigen();

        JOptionPane.showMessageDialog(this, "Buch wurde gelöscht, wenn der Titel genau gepasst hat.");
    }
}