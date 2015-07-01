// O. Bittel
// 27.5.2011
package aufgabe11TelefonBuch;

import javax.swing.*;

public class TelefonBuchGUI extends JFrame {

    private TelefonBuch telBuch;

    public TelefonBuchGUI() {
        // TelefonBuch anlegen:
        telBuch = new TelefonBuch();
        TelefonBuchEinfuegenPanel p = new TelefonBuchEinfuegenPanel(telBuch);
        TelefonBuchSuchenLoeschenPanel s = new TelefonBuchSuchenLoeschenPanel(telBuch);
               TelefonBuchMenuBar m = new TelefonBuchMenuBar(telBuch);

     
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(17, 17, 17, 17));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
                this.setJMenuBar(m);

        mainPanel.add(p);
                mainPanel.add(s);



        // ...
        this.setContentPane(mainPanel);

        // Sonstige Eigenschaften des Hauptfenster setzen:
        this.setTitle("Telefonbuch");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TelefonBuchGUI();
    }
}
