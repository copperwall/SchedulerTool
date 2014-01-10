import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CourseDBUIAdd implements ActionListener {
	JFrame frame = new JFrame("ManageInstructors");
	JTextField labLengthText;
	JTextField labProxText;
	
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
		
		label = new JLabel("Add Course");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.ipady = 40;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,20,0,20);
		pane.add(label, c);
		
		label = new JLabel("Title");
		c.ipady = 0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.EAST;
		c.anchor = GridBagConstraints.EAST;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 0, 10);
		pane.add(label, c);
		
		label = new JLabel("Prefix");
		c.ipady = 0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.EAST;
		c.anchor = GridBagConstraints.EAST;
		c.gridy = 2;
		c.insets = new Insets(0, 0, 0, 10);
		pane.add(label, c);
		
		label = new JLabel("Course No.");
		c.ipady = 0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.EAST;
		c.anchor = GridBagConstraints.EAST;
		c.gridy = 3;
		c.insets = new Insets(0, 0, 0, 10);
		pane.add(label, c);
		
		label = new JLabel("Units");
		c.ipady = 0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.EAST;
		c.anchor = GridBagConstraints.EAST;
		c.gridy = 4;
		c.insets = new Insets(0, 0, 0, 10);
		pane.add(label, c);

		label = new JLabel("hasLab");
		c.gridy = 5;
		c.insets = new Insets(0, 0, 0, 10);
		pane.add(label, c);
		
		label = new JLabel("Lab Length (hrs)");
		c.ipady = 0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.EAST;
		c.anchor = GridBagConstraints.EAST;
		c.gridy = 6;
		c.insets = new Insets(0, 0, 0, 10);
		pane.add(label, c);
		
		label = new JLabel("Lab Proximity");
		c.ipady = 0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.EAST;
		c.anchor = GridBagConstraints.EAST;
		c.gridy = 7;
		c.insets = new Insets(0, 0, 0, 10);
		pane.add(label, c);
		
		check = new JCheckBox("");
		check.addActionListener(this);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 1;
		c.gridy = 5;
		c.insets = new Insets(0, 0, 0, 0);
		pane.add(check, c);
		
		textField = new JTextField(20);
		c.ipady = 0;
		textField.setMaximumSize(textField.getPreferredSize());
		c.gridy = 1;
		pane.add(textField, c);
		
		textField = new JTextField(3);
		c.ipady = 0;
		textField.setMaximumSize(textField.getPreferredSize());
		c.gridy = 2;
		pane.add(textField, c);
		
		textField = new JTextField(3);
		c.ipady = 0;
		textField.setMaximumSize(textField.getPreferredSize());
		c.gridy = 3;
		pane.add(textField, c);
		
		textField = new JTextField(3);
		c.ipady = 0;
		textField.setMaximumSize(textField.getPreferredSize());
		c.gridy = 4;
		pane.add(textField, c);
		
		labLengthText = new JTextField(3);
		c.ipady = 0;
		labLengthText.setMaximumSize(labLengthText.getPreferredSize());
		c.gridy = 6;
		pane.add(labLengthText, c);
		
		labProxText = new JTextField(20);
		labProxText.setMaximumSize(labProxText.getPreferredSize());
		c.gridy = 7;
		pane.add(labProxText, c);
		
		labLengthText.setEnabled(false);
		labProxText.setEnabled(false);
		
		button = new JButton("Submit");
		button.addActionListener(this);
		c.gridy = 8;
		c.gridx = 1;
		c.fill = GridBagConstraints.EAST;
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(0, 0, 20, 0);
		pane.add(button, c);
		
		button = new JButton("Cancel");
		button.addActionListener(this);
		c.gridx = 2;
		pane.add(button, c);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		JButton button;
		Window buttonFrame;
		JCheckBox check;
		
		if (source instanceof JButton) {
			button = (JButton)(source);
			buttonFrame = SwingUtilities.windowForComponent(button);
			if (button.getActionCommand().equals("Submit")) {
				buttonFrame.dispose();
			} else {
				buttonFrame.dispose();
			}
		}
		else if (source instanceof JCheckBox) {
			check = (JCheckBox)(source);
			if (check.isSelected()) {
				labLengthText.setEnabled(true);
				labProxText.setEnabled(true);
			}
			else {
				labLengthText.setEnabled(false);
				labProxText.setEnabled(false);
			}
		}
	}
}