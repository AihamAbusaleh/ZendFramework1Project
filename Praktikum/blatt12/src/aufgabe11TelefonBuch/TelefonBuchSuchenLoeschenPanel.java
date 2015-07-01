// O. Bittel
// 27.5.2011
package aufgabe11TelefonBuch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.List;

public class TelefonBuchSuchenLoeschenPanel
        extends JPanel implements ActionListener {

    // ...    
    private JTextField nameSuchen, zusatz;
    private JButton anwenden;
    private JComboBox auswahl;
    private TelefonBuch telbuch;
    private String[] auswahlListe = {"Exakte-Suche", "Prefix-Suche", "Löschen"};
    private JTextArea ausgabeArea;

    public TelefonBuchSuchenLoeschenPanel(TelefonBuch tb) {
        // ...
        telbuch = tb;

        Border border = BorderFactory.createTitledBorder("Suchen/Löschen");
        this.setBorder(border);
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        JPanel allpanel = new JPanel();
        //   allpanel.setLayout(new GridLayout(2, 1));

//        JPanel panel1 = new JPanel();
//        panel1.setLayout(new GridLayout(2, 1));
//        panel1.add(new JLabel("Name"));
//        panel1.add(new JLabel("Zusatz"));
//
//        JPanel panel2 = new JPanel();
//        panel2.setLayout(new GridLayout(2, 1));
//        nameSuchen = new JTextField("", 20);
//        panel2.add(nameSuchen);
//        zusatz = new JTextField("", 20);
//        panel2.add(zusatz);
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Name"));
        panel1.add(new JLabel("Zusatz"));
        panel1.setLayout(new GridLayout(2, 1));

        JPanel panel2 = new JPanel();
        nameSuchen = new JTextField("", 20);
        panel2.add(nameSuchen);
        zusatz = new JTextField("", 20);
        panel2.add(zusatz);
        panel2.setLayout(new GridLayout(2, 1));

        allpanel.add(panel1);
        allpanel.add(panel2);

        auswahl = new JComboBox(auswahlListe);
        auswahl.setSelectedIndex(1);
        allpanel.add(auswahl);

        anwenden = new JButton("Anwenden");
        allpanel.add(anwenden);
        anwenden.addActionListener(this);

        JPanel ausgabePanel = new JPanel();
        Border border1 = BorderFactory.createTitledBorder("Ausgabe");
        ausgabePanel.setBorder(border1);
        ausgabePanel.setLayout(new BorderLayout());

        ausgabeArea = new JTextArea();
        ausgabeArea.setPreferredSize(new Dimension(400, 250));
        JScrollPane scroll = new JScrollPane(ausgabeArea);
        ausgabePanel.add(scroll, BorderLayout.CENTER);
        ausgabeArea.setEditable(false);
        //ausgabeArea.setEnabled(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // this.add(suchePanel);
           //     ausgabePanel.add(scroll);

        this.add(allpanel);

        this.add(ausgabePanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // ...
        Object zusuchend = auswahl.getSelectedItem();
        StringBuilder gefunden = new StringBuilder("");

        if (zusuchend.equals(auswahlListe[0])) {
            String a = telbuch.exactSearch(nameSuchen.getText(), zusatz.getText());
            if (!a.equals("")) {
                gefunden.append(nameSuchen.getText());
                gefunden.append(" ");

                gefunden.append(zusatz.getText());
            } else {

                //JOptionPane.showMessageDialog(this, nameSuchen + " " + zusatz + " nicht gefunden !", "Suche fehlgeschalgen", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(this, "Name nicht gefunden !");
            }
        }
        if (zusuchend.equals(auswahlListe[1])) {
            //  zusatz.setEditable(false);
            List<String> listeVonPrefixs = telbuch.prefixSearch(nameSuchen.getText());
            for (String s : listeVonPrefixs) {
                gefunden.append(s).append("\n");

            }

        }


        if (zusuchend.equals(auswahlListe[2])) {
            boolean gelöscht = telbuch.remove(nameSuchen.getText(), zusatz.getText());
            if (gelöscht) {
                //    JOptionPane.showMessageDialog(this, nameSuchen + " " + zusatz + " wurde gelöscht", "Löschen war erfolgreich", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(this, "Name wurde gelöscht !");

            }

        }

        ausgabeArea.setText(gefunden.toString());

    }
}
