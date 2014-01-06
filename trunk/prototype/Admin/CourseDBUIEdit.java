import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CourseDBUIEdit implements ActionListener{
	JFrame frame = new JFrame("ManageCourses");
	String mTitle;
	String mPrefix;
	int mCourseNo;
	int mUnits;
	boolean mHasLab;
	int mLabLength;
	String mLabProx;
	
	JTextField labLengthText;
	JTextField labProxText;

	public CourseDBUIEdit(String title, String prefix, int courseNo, int units, String hasLab, int labLength, String labProx) {
		mTitle = title;
		mPrefix = prefix;
		mCourseNo = courseNo;
		mUnits = units;
		mHasLab = hasLab.equals("Yes");
		mLabLength = labLength;
		mLabProx = labProx;
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
		
		label = new JLabel("Edit Course");
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
		check.setSelected(mHasLab);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 1;
		c.gridy = 5;
		c.insets = new Insets(0, 0, 0, 0);
		pane.add(check, c);
		
		textField = new JTextField(mTitle, 20);
		c.ipady = 0;
		textField.setMaximumSize(textField.getPreferredSize());
		c.gridy = 1;
		pane.add(textField, c);
		
		textField = new JTextField(mPrefix, 3);
		c.ipady = 0;
		textField.setMaximumSize(textField.getPreferredSize());
		c.gridy = 2;
		pane.add(textField, c);
		
		textField = new JTextField(((Integer)mCourseNo).toString(), 3);
		c.ipady = 0;
		textField.setMaximumSize(textField.getPreferredSize());
		c.gridy = 3;
		pane.add(textField, c);
		
		textField = new JTextField(((Integer)mUnits).toString(), 3);
		c.ipady = 0;
		textField.setMaximumSize(textField.getPreferredSize());
		c.gridy = 4;
		pane.add(textField, c);
		
		labProxText = new JTextField(mLabProx, 20);
		
		if(!mHasLab) {
			labLengthText = new JTextField("-", 3);

			labLengthText.setEnabled(false);
			labProxText.setEnabled(false);
		}
		else {
			labLengthText = new JTextField(((Integer)mLabLength).toString(), 3);
			labProxText = new JTextField(mLabProx, 20);
		}

		c.ipady = 0;
		labLengthText.setMaximumSize(labLengthText.getPreferredSize());
		c.gridy = 6;
		pane.add(labLengthText, c);

		labProxText.setMaximumSize(labProxText.getPreferredSize());
		c.gridy = 7;
		pane.add(labProxText, c);
		
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