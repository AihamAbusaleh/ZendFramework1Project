// O. Bittel
// 2.3.2012
package aufgabe11TelefonBuch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class TelefonBuchEinfuegenPanel
        extends JPanel implements ActionListener {

    private TelefonBuch telBuch;
    private JTextField tfEinfuegenName;
    // private JTextArea ausgabeArea;

    private JTextField tfEinfuegenZusatz;
    private JTextField tfEinfuegenTelNr;
    private JButton buttonEinfuegen;

    public TelefonBuchEinfuegenPanel(TelefonBuch tb) {
        telBuch = tb;

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1));
        panel1.add(new JLabel("Name"));
        panel1.add(new JLabel("Zusatz"));
        panel1.add(new JLabel("TelefonNummer"));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 1));
        tfEinfuegenName = new JTextField("", 20);
        panel2.add(tfEinfuegenName);
        tfEinfuegenZusatz = new JTextField("", 20);
        panel2.add(tfEinfuegenZusatz);
        tfEinfuegenTelNr = new JTextField("", 20);
        panel2.add(tfEinfuegenTelNr);

        Border border = BorderFactory.createTitledBorder("Einfügen");
        this.setBorder(border);
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.add(panel1);
        this.add(panel2);
        buttonEinfuegen = new JButton("Einfügen");
        this.add(buttonEinfuegen);
        buttonEinfuegen.addActionListener(this);

//        JPanel ausgabePanel = new JPanel();
//        Border border1 = BorderFactory.createTitledBorder("Ausgabe");
//        ausgabePanel.setBorder(border1);
//        ausgabePanel.setLayout(new BorderLayout());
//
//        ausgabeArea = new JTextArea();
//        ausgabeArea.setPreferredSize(new Dimension(400, 250));
//        ausgabePanel.add(ausgabeArea, BorderLayout.CENTER);
//        ausgabeArea.setEnabled(false);
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        // this.add(suchePanel);
//        //this.add(allpanel);
//
//        this.add(ausgabePanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // ...
        Object source = e.getSource();
        String name = tfEinfuegenName.getText();
        String zusatz = tfEinfuegenZusatz.getText();
        String tel = tfEinfuegenTelNr.getText();
        boolean einfuegen;
        try {
            Integer.parseInt(tel);
            einfuegen = telBuch.insert(name, zusatz, tel);

      //  String alle = name + " " + zusatz + " " + tel;
            if (source == buttonEinfuegen) {

                if (!einfuegen) {
                    JOptionPane.showMessageDialog(this, name + " " + zusatz + " existiert bereits", "Einfügen fehlgeschlagen", JOptionPane.ERROR_MESSAGE);

                }
            }
        } catch (NumberFormatException x) {
            JOptionPane.showMessageDialog(this, "Bitte richtige Telefonnummer eingeben !");

        }
//        ausgabeArea.append(alle + "\n");
//        ausgabeArea.setCaretPosition(ausgabeArea.getDocument().getLength());

    }
}
