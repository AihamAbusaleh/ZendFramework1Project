package blatt11;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Taschenrechner extends JFrame implements ActionListener,
		ItemListener {

	JCheckBox helles;

	JRadioButton deg;
	JRadioButton rad;

	JTextField x;
	JTextField y;
	JTextField z;

	JButton plus;
	JButton mal;
	JButton minus;
	JButton div;
	JButton sin;
	JButton cos;
	JButton pow;
	JButton log2;
	JButton clear;

	public Taschenrechner() {
		setTitle("Taschenrechner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel o1 = new JLabel("Operand x");
		JLabel o2 = new JLabel("Operand y");
		JLabel o3 = new JLabel("Resultat");

		x = new JTextField("0", 15);
		y = new JTextField("0", 15);
		z = new JTextField("0", 15);

		z.setEditable(false);

		plus = new JButton("+");
		mal = new JButton("*");
		minus = new JButton("-");
		div = new JButton("/");
		sin = new JButton("sin");
		cos = new JButton("cos");
		pow = new JButton("x^y");
		log2 = new JButton("log2");
		clear = new JButton("Clear");

		plus.addActionListener(this);
		mal.addActionListener(this);
		minus.addActionListener(this);
		div.addActionListener(this);
		sin.addActionListener(this);
		cos.addActionListener(this);
		pow.addActionListener(this);
		log2.addActionListener(this);
		clear.addActionListener(this);

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 10));
		p1.add(o1);
		p1.add(x);

		p1.add(o2);
		p1.add(y);

		p1.add(o3);
		p1.add(z);

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(2, 10));
		p2.add(plus);
		p2.add(mal);
		p2.add(minus);
		p2.add(div);
		p2.add(sin);
		p2.add(cos);
		p2.add(pow);
		p2.add(log2);

		JPanel p3 = new JPanel();
		p3.add(clear);

		// --------------------------------------------------
		deg = new JRadioButton("Deg");
		deg.setSelected(true);

		rad = new JRadioButton("Rad");
		rad.setSelected(false);

		rad.addActionListener(this);
		deg.addActionListener(this);

		ButtonGroup group = new ButtonGroup();
		group.add(deg);
		group.add(rad);

		JPanel raddegPanel = new JPanel();
		raddegPanel.add(deg);
		raddegPanel.add(rad);

		// this.add(deg);
		// this.add(rad);
		// this.add(helles);

		// ---------------------------------------------------------------------------
		helles = new JCheckBox("Helles Display");
		helles.setSelected(true);

		helles.addItemListener(this);
		pack();
		setVisible(true);
		raddegPanel.add(helles);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(p1);
		panel.add(raddegPanel);
		panel.add(p2);
		panel.add(p3);
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		setContentPane(panel);
		pack();
		setResizable(false);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();

		String s1 = x.getText();
		String s2 = y.getText();

		double op1 = Double.parseDouble(s1);
		double op2 = Double.parseDouble(s2);

		if (source == plus)
			z.setText("" + (op1 + op2));

		if (source == mal)
			z.setText("" + (op1 * op2));

		if (source == minus)
			z.setText("" + (op1 - op2));

		if (source == div)
			z.setText("" + (op1 / op2));

		if (source == pow)
			z.setText("" + Math.pow(op1, op2));

		if (source == cos) {
			z.setText("" + Math.cos(op1));
			y.setText("0");
		}

		if (source == sin) {
			z.setText("" + Math.sin(op1));
			y.setText("0");
		}

		if (source == log2) {
			z.setText("" + (Math.log(op1) / Math.log(2)));
			y.setText("0");
		}

		if (source == rad && source == sin)
			z.setText("" + (Math.toRadians(Math.sin(op1))));

		if (source == rad && source == cos)
			z.setText("" + (Math.toRadians(Math.cos(op1))));

		if (source == rad && source == sin)
			z.setText("" + (Math.toDegrees(Math.sin(op1))));

		if (source == rad && source == cos)
			z.setText("" + (Math.toDegrees(Math.cos(op1))));

		if (source == clear) {
			x.setText("0");
			y.setText("0");
			z.setText("0");
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		Object source = e.getItemSelectable();

		if (source == helles) {
			x.setBackground(Color.WHITE);
			y.setBackground(Color.WHITE);
			z.setBackground(Color.WHITE);

			x.setForeground(Color.BLACK);
			y.setForeground(Color.BLACK);
			z.setForeground(Color.BLACK);

		}
		if (e.getStateChange() == ItemEvent.DESELECTED) {
			x.setBackground(Color.BLACK);
			y.setBackground(Color.BLACK);
			z.setBackground(Color.BLACK);

			x.setForeground(Color.YELLOW);
			y.setForeground(Color.YELLOW);
			z.setForeground(Color.YELLOW);

		}

	}

	public static void main(String[] args) {

		JFrame myApp = new Taschenrechner();
		myApp.setVisible(true);
	}
}
