import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

public class CourseDBUI extends JPanel implements ActionListener{
	Object currentSelection[];
	JTable courses;
	// **********IMPORTANT**********
	// This is really important because it allows us to make an Action Listener
	// that knows all of the things that the AdminMainView knows, but without
	// creating a new one, which would cause a new JFrame to be shown.
	AdminMainView parent;
	
	/*public static void main(String[] args) {
		JFrame content = new JFrame();
		InstructorDBUI panel = new InstructorDBUI();
		content.add(panel);
		content.setVisible(true);
		content.pack();
	}*/
	
	public CourseDBUI(AdminMainView parent) {
		this.parent = parent;
		create();
	}

	public void create() {
		// methods to build the UI
		createAndShow();
	}
	
	private void createAndShow() {
		addComponentsToPane();
		
		this.setVisible(true);
	}
	
	private void addComponentsToPane() {
		this.setLayout(new BorderLayout());
		JPanel panel;
		JPanel buttonsPanel;
		JLabel label;
		JButton button;
		JScrollPane scrollPane;
		String[] columnTitles = {"Title",
				 "Prefix",
				 "Course No.",
				 "Units",
				 "Has Lab?",
				 "Lab Length",
				 "Lab Proximity"};
		Object[][] data = {
			{"Fundamentals of Computing I", "CPE", new Integer(101), new Integer(4), "Yes", new Integer(1), "DIRECTLY_AFTER"},
			{"Fundamentals of Computing II", "CPE", new Integer(102), new Integer(4), "Yes", new Integer(1), "DIRECTLY_AFTER"},
			{"Fundamentals of Computing III", "CPE", new Integer(103), new Integer(4), "Yes", new Integer(1), "DIRECTLY_AFTER"},
			{"Introduction to Computing", "CSC", new Integer(123), new Integer(4), "Yes", new Integer(1), "DIRECTLY_AFTER"},
			{"Discrete Structures", "CSC", new Integer(141), new Integer(4), "No", "-", "-"},
			{"Introduction to Computer Organization", "CPE", new Integer(225), new Integer(4), "No", "-", "-"},
			{"Individual Software Development", "CPE", new Integer(305), new Integer(4), "No", "-", "-"},
			{"Introduction to Software Engineering", "CPE", new Integer(307), new Integer(4), "Yes", new Integer(1), "DIRECTLY_AFTER"},
			{"Software Engineering I", "CPE", new Integer(308), new Integer(4), "Yes", new Integer(1), "DIRECTLY_AFTER"},
			{"Software Engineering II", "CPE", new Integer(309), new Integer(4), "Yes", new Integer(1), "DIRECTLY_AFTER"},
			{"Design and Analysis of Algorithms", "CPE", new Integer(349), new Integer(4), "Yes", new Integer(1), "DIFF_DAY"},
			{"Systems Programming", "CPE", new Integer(357), new Integer(4), "Yes", new Integer(1), "DIRECTLY_AFTER"},
			{"Interactive Entertainment Engineering", "CPE", new Integer(378), new Integer(4), "Yes", new Integer(1), "DIRECTLY_AFTER"},
			{"Introduction to Operating Systems", "CPE", new Integer(453), new Integer(4), "Yes", new Integer(1), "SAME_DAY"}};
		
		this.setBorder(new EmptyBorder(20,20,30,20));
		
		label = new JLabel("Manage Courses");
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setBorder(new EmptyBorder(0, 0, 10, 0));
		this.add(label, BorderLayout.PAGE_START);
		
		
		DefaultTableModel model = new DefaultTableModel(100, columnTitles.length) ;
      model.setDataVector(data, columnTitles);
      
      courses = new JTable(model){
            public boolean isCellEditable(int rowIndex, int colIndex) {
            return false; //Disallow the editing of any cell
         }
      };
		scrollPane = new JScrollPane(courses);
		this.add(scrollPane, BorderLayout.CENTER);
		
		panel = new JPanel(new BorderLayout());
		button = new JButton("Save");
		// **********IMPORTANT**********
		// Make sure that if you want the button to do something with the main
		// window, you make the action command into something that won't
		// coincide with other people's action commands.
		button.setActionCommand("SaveCoursesDB");
		button.addActionListener(parent);
		panel.add(button, BorderLayout.LINE_START);

		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
		button = new JButton("Add");
		button.addActionListener(new CourseAddListener());
		buttonsPanel.add(button);
		buttonsPanel.add(Box.createRigidArea(new Dimension(5,0)));
	   
		button = new JButton("Edit");
		button.addActionListener(this);
		buttonsPanel.add(button);
		buttonsPanel.add(Box.createRigidArea(new Dimension(5,0)));
		
		button = new JButton("Delete");
		buttonsPanel.add(button);
		buttonsPanel.add(Box.createRigidArea(new Dimension(5,0)));
		
		button = new JButton("Cancel");
		button.setActionCommand("CancelCoursesDB");
		button.addActionListener(parent);
		buttonsPanel.add(button);
		
		panel.add(buttonsPanel, BorderLayout.LINE_END);
		panel.setBorder(new EmptyBorder(15, 0, 0, 0));
		this.add(panel, BorderLayout.PAGE_END);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		JPanel newContent;
		
		if (e.getActionCommand().equals("Edit")) {
			if (courses.getSelectedRow() < 0) {
				return ;
			}
			TableModel dtm = (TableModel)courses.getModel();
			int selectedRow = courses.getSelectedRow();
			System.out.println(selectedRow);
			CourseDBUIEdit dialog;
			
			String title = (String)dtm.getValueAt(selectedRow, 0);
			String prefix = (String)dtm.getValueAt(selectedRow, 1);
			int courseNo = (Integer)dtm.getValueAt(selectedRow, 2);
			int units = (Integer)dtm.getValueAt(selectedRow, 3);
			String hasLab = (String)dtm.getValueAt(selectedRow, 4);
			int labLength = (Integer)dtm.getValueAt(selectedRow, 5);
			String labProx = (String)dtm.getValueAt(selectedRow, 6);

			dialog = new CourseDBUIEdit(title, prefix, courseNo, units, hasLab, labLength, labProx);
			
			dialog.show();
		}
	}
}

class CourseAddListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		(new CourseDBUIAdd()).show();
	}
}
