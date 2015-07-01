// O. Bittel
// 27.5.2011
package aufgabe11TelefonBuch;

import javax.swing.*;
import java.io.*;
import java.awt.event.*;

public class TelefonBuchMenuBar extends JMenuBar implements ActionListener {

    private TelefonBuch telBuch;
    private JMenuItem open, speichern, beenden;
    private JMenu menu;

    public TelefonBuchMenuBar(TelefonBuch tb) {
        JMenuBar menuBar;

        telBuch = tb;
        menuBar = new JMenuBar();

        menu = new JMenu("Datei");

        menuBar.add(menu);

        open = new JMenuItem("Telefonbuch öffnen ..");
        speichern = new JMenuItem("Telefonbuch speichern unter ..");
        beenden = new JMenuItem("Telefonbuch beenden ..");

        open.addActionListener(this);
        menu.add(open);
        speichern.addActionListener(this);
        menu.add(speichern);
        menu.addSeparator();
        beenden.addActionListener(this);
        menu.add(beenden);
        menuBar.add(menu);
        this.add(menuBar);
        // return menuBar;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = (e.getSource());

        if (source == beenden) {
            int end = JOptionPane.showConfirmDialog(beenden, "Datei schließen ?", "Confirm Dialog", JOptionPane.YES_NO_OPTION);

            if (end == JOptionPane.YES_OPTION) {
                System.exit(0);

            }
        } else if (source == speichern) {
            JFileChooser fc = new JFileChooser();
            int datei = fc.showSaveDialog(this.getParent());
            if (datei == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile(); // nur ein file
//                File[] files = fc.getSelectedFiles();
//                if (files.length > 0) {
                telBuch.save(file);
//                }
            }

        } else {
            JFileChooser fc = new JFileChooser();
            int datei = fc.showOpenDialog(this.getParent());
            if (datei == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
//          
                telBuch.read(file);

            }

        }
    }
}
