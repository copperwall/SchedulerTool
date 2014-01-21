import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

public class InstructorDBUI extends JPanel implements ActionListener{
	Object currentSelection[];
	JTable instructors;
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
	
	public InstructorDBUI(AdminMainView parent) {
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
		String[] columnTitles = {"First Name",
				 "Last Name",
				 "Cal Poly User ID",
				 "WTU",
				 "Active"};
		Object[][] data = {
			{"John", "Clements", "clements", new Integer(12), "Yes"},
			{"Clint", "Staley", "cstaley", new Integer(20), "No"},
			{"Clark", "Turner", "csturner", new Integer(12), "Yes"},
			{"David", "Janzen", "djanzen", new Integer(8), "Yes"},
			{"Gene", "Fisher", "gfisher", new Integer(12), "Yes"},
			{"Hasmik", "Gharibyan", "hghariby", new Integer(12), "Yes"},
			{"Ignatios", "Vakalis", "ivakalis", new Integer(12), "No"},
			{"John", "Dalbey", "jdalbey", new Integer(8), "No"},
			{"John", "Seng", "jseng", new Integer(12), "Yes"},
			{"Julie", "Workman", "jworkman", new Integer(12), "Yes"},
			{"Kurt", "Mammen", "kmammen", new Integer(12), "Yes"},
			{"Paul", "Hatalsky", "phatalsk", new Integer(12), "Yes"},
			{"Phillip", "Nico", "pnico", new Integer(14), "Yes"},
			{"Timothy", "Kearns", "tkearns", new Integer(10), "No"}
         };
		
		this.setBorder(new EmptyBorder(20,20,30,20));
		
		label = new JLabel("Manage Instructors");
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setBorder(new EmptyBorder(0, 0, 10, 0));
		this.add(label, BorderLayout.PAGE_START);
		
		
		DefaultTableModel model = new DefaultTableModel(100, columnTitles.length) ;
      model.setDataVector(data, columnTitles);
      
      instructors = new JTable(model){
            public boolean isCellEditable(int rowIndex, int colIndex) {
            return false; //Disallow the editing of any cell
         }
      };
		scrollPane = new JScrollPane(instructors);
		this.add(scrollPane, BorderLayout.CENTER);
		
		panel = new JPanel(new BorderLayout());
		button = new JButton("Save");
		// **********IMPORTANT**********
		// Make sure that if you want the button to do something with the main
		// window, you make the action command into something that won't
		// coincide with other people's action commands.
		button.setActionCommand("SaveInstructorsDB");
		button.addActionListener(parent);
		panel.add(button, BorderLayout.LINE_START);

		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
		button = new JButton("Add");
		button.addActionListener(new AddListener());
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
		button.setActionCommand("CancelInstructorsDB");
		button.addActionListener(parent);
		buttonsPanel.add(button);
		
		panel.add(buttonsPanel, BorderLayout.LINE_END);
		panel.setBorder(new EmptyBorder(15, 0, 0, 0));
		this.add(panel, BorderLayout.PAGE_END);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		JPanel newContent;
		
		if (e.getActionCommand().equals("Edit")) {
			if (instructors.getSelectedRow() < 0) {
				return ;
			}
			TableModel dtm = (TableModel)instructors.getModel();
			int selectedRow = instructors.getSelectedRow();
			System.out.println(selectedRow);
			InstructorDBUIEdit dialog;
			int wtu = (Integer)dtm.getValueAt(selectedRow, 3);
			String userID = (String)dtm.getValueAt(selectedRow, 2);
			String active = (String)dtm.getValueAt(selectedRow, 4);
			dialog = new InstructorDBUIEdit(userID, wtu, active);
			
			dialog.show();
		}
	}
}

class AddListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		(new InstructorDBUIAdd()).show();
	}
}
