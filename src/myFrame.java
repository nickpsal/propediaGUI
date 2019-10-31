package propediaGUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class myFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JFrame frame;
	private JLabel label;
	private JLabel label2;
	private JTextField inputfield;
	private JButton btn;
	
	public myFrame() {
		Font font = new Font("Verdana", Font.PLAIN, 18);
		Font font2 = new Font("Verdana", Font.PLAIN, 14);
		panel = new JPanel();
		frame = new JFrame();
		label = new JLabel("ΠΟΙΑ ΠΡΟΠΕΔΙΑ ΘΕΣ ΝΑ ΥΠΟΛΟΓΙΣΕΙΣ");
		label2 = new JLabel("",SwingConstants.CENTER);
		inputfield = new JTextField(20);
		btn = new JButton("ΥΠΟΛΟΓΙΣΜΟΣ");
		
		panel.add(label);
		panel.add(inputfield);
		panel.add(btn);
		
		label.setFont(font2);
		inputfield.setFont(font2);
		btn.setFont(font2);
		
		label2.setFont(font);
		
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		frame.getContentPane().add(label2, BorderLayout.CENTER);
		
		ButtonListener listener = new ButtonListener();
		btn.addActionListener(listener);
		
		frame.pack();
		frame.setVisible(true);
		frame.setSize(750, 550);
		frame.setTitle("ΠΡΟΓΡΑΜΜΑ ΕΚΤΥΠΩΣΗΣ ΠΡΟΠΕΔΙΑΣ");
	}
	
	class ButtonListener implements ActionListener{
                @Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btn)) {
				label2.setText("<HTML>");
				if(!inputfield.getText().equals("")) {
					int number = Integer.parseInt(inputfield.getText());
					if (number == 0) {
						JOptionPane.showMessageDialog(frame, "ΔΕΝ ΜΠΟΡΕΙΤΕ ΝΑ ΒΡΕΊΤΕ ΤΗΝ ΠΡΟΠΕΔΙΑ ΤΟΥ ΜΗΔΕΝΟΣ" ,
								"ΠΡΟΣΟΧΗ", JOptionPane.INFORMATION_MESSAGE);	
					}else {
						number = Math.abs(number);
						label2.setText(label2.getText() + "<p>Η ΠΡΟΠΕΔΙΑ ΤΟΥ " + number + " είναι </p>");
						for(int i = 1; i<=12; i++) {
							label2.setText(label2.getText() + "<p>" + number + " * " +  i + " = " + number*i + "</p>");
						}
						label2.setText(label2.getText() + "</HTML");
					}
				}else {
					JOptionPane.showMessageDialog(frame, "ΔΕΝ ΠΛΗΚΤΡΟΛΟΓΗΣΑΤΕ ΚΑΠΟΙΟ ΝΟΥΜΕΡΟ" ,
							"ΠΡΟΣΟΧΗ", JOptionPane.INFORMATION_MESSAGE);	
				}
			}
		}
	}
}
