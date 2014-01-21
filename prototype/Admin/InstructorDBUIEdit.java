import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class InstructorDBUIEdit {
	JFrame frame = new JFrame("ManageInstructors");
	int mWTU;
	String mUserID;
	boolean mActive;
	
	public InstructorDBUIEdit(String userID, int wtu, String active) {
		mUserID = userID;
		mWTU = wtu;
		mActive = active.equals("Yes");
	}
	
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
		
		label = new JLabel("Edit Instructor");
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
		
		textField = new JTextField(mUserID, 20);
		textField.setEnabled(false);
		c.ipady = 0;
		textField.setMaximumSize(textField.getPreferredSize());
		c.gridy = 1;
		pane.add(textField, c);
		
		textField = new JTextField("" + mWTU, 10);
		textField.setMaximumSize(textField.getPreferredSize());
		c.gridy = 2;
		pane.add(textField, c);
		
		button = new JButton("Submit");
		button.addActionListener(new EditListener());
		c.gridy = 4;
		c.gridx = 1;
		c.fill = GridBagConstraints.EAST;
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(0, 0, 20, 0);
		pane.add(button, c);
		
		button = new JButton("Cancel");
		button.addActionListener(new EditListener());
		c.gridx = 2;
		pane.add(button, c);
	}
}

class EditListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		Window buttonFrame = SwingUtilities.windowForComponent(button);
		
		// For now, just close the window.
		if (button.getActionCommand().equals("Submit")) {
			buttonFrame.dispose();
		} else {
			buttonFrame.dispose();
		}
	}
}