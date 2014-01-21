import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class InstructorDBUIAdd implements ActionListener {
	JFrame frame = new JFrame("ManageInstructors");
	
	public void show() {
		// methods to build the UI
		createAndShow();
	}
	
	private void createAndShow() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		addComponentsToPane(frame.getContentPane());
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private void addComponentsToPane(Container pane) {
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JLabel label;
		JCheckBox check;
		JTextField textField;
		JButton button;
		
		label = new JLabel("Add Instructor");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.ipady = 40;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,20,0,20);
		pane.add(label, c);
		
		label = new JLabel("Cal Poly User ID");
		c.ipady = 0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.EAST;
		c.anchor = GridBagConstraints.EAST;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 0, 10);
		pane.add(label, c);
		
		label = new JLabel("WTU");
		c.gridy = 2;
		c.insets = new Insets(0, 0, 0, 10);
		pane.add(label, c);
		
		label = new JLabel("Active");
		c.gridy = 3;
		c.insets = new Insets(0, 0, 0, 10);
		pane.add(label, c);
		
		check = new JCheckBox("");
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 1;
		c.gridy = 3;
		c.insets = new Insets(0, 0, 0, 0);
		pane.add(check, c);
		
		textField = new JTextField(20);
		c.ipady = 0;
		textField.setMaximumSize(textField.getPreferredSize());
		c.gridy = 1;
		pane.add(textField, c);
		
		textField = new JTextField(10);
		textField.setMaximumSize(textField.getPreferredSize());
		c.gridy = 2;
		pane.add(textField, c);
		
		button = new JButton("Submit");
		button.addActionListener(new InstructorDBUIAdd());
		c.gridy = 4;
		c.gridx = 1;
		c.fill = GridBagConstraints.EAST;
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(0, 0, 20, 0);
		pane.add(button, c);
		
		button = new JButton("Cancel");
		button.addActionListener(new InstructorDBUIAdd());
		c.gridx = 2;
		pane.add(button, c);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		Window buttonFrame = SwingUtilities.windowForComponent(button);
		if (button.getActionCommand().equals("Submit")) {
			buttonFrame.dispose();
		} else {
			buttonFrame.dispose();
		}
	}
}