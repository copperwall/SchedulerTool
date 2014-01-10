import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

public class AdminAvailableCourses extends JPanel implements ActionListener {
   
   /*public static void main(String[] args) {
      JFrame content = new JFrame();
      AdminAvailableCourses panel = new AdminAvailableCourses();
      content.getContentPane().add(panel);
      content.setVisible(true);
      content.pack();
   }*/
   
   public AdminAvailableCourses() {
      create();
   }

   // **********IMPORTANT**********
   // This is really important because it allows us to make an Action Listener
   // that knows all of the things that the AdminMainView knows, but without
   // creating a new one, which would cause a new JFrame to be shown.
   AdminMainView parent;
   Object currentSelection[];
   JTable courses;
   private JButton button_1;
   private JButton button_2;

   public AdminAvailableCourses(AdminMainView adminMainView) {
      this.parent = adminMainView;
      create();
   }

   public void create() {
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
      String[] columnTitles = { "Prefix", "Course No", "Course Title",
            "Sections", "Suggested Sections" };
      Object[][] data = {
            { "CPE", new Integer(101), "Introduction to Computing I",
                  new Integer(6), new Integer(8) },
            { "CPE", new Integer(102), "Introduction to Computing II",
                  new Integer(6), new Integer(4) },
            { "CPE", new Integer(103), "Introduction to Computing III",
                  new Integer(6), new Integer(5) },
            { "CSC", new Integer(141), "Discrete Structures", new Integer(2),
                  new Integer(1) },
            { "CSC", new Integer(225), "Introduction to Computer Organization",
                  new Integer(4), new Integer(3) },
            { "CPE", new Integer(315), "Computer Architecture", new Integer(2),
                  new Integer(2) },
            { "CPE", new Integer(349), "Design and Analysis of Algorithms",
                  new Integer(2), new Integer(2) },
            { "CPE", new Integer(307), "Introduction to Software Engineering",
                  new Integer(4), new Integer(5) },
            { "CPE", new Integer(308), "Software Engineering I",
                  new Integer(4), new Integer(10) },
            { "CPE", new Integer(309), "Software Engineering II",
                  new Integer(3), new Integer(3) },
            { "CPE", new Integer(453), "Introduction to Operating Systems",
                  new Integer(4), new Integer(4) } };

      this.setBorder(new EmptyBorder(20, 20, 30, 20));

      label = new JLabel("Available Courses");
      label.setFont(new Font("Arial", Font.PLAIN, 16));
      label.setBorder(new EmptyBorder(0, 0, 10, 0));
      this.add(label, BorderLayout.PAGE_START);

      DefaultTableModel model = new DefaultTableModel(100, columnTitles.length);
      model.setDataVector(data, columnTitles);

      courses = new JTable(model) {
         public boolean isCellEditable(int rowIndex, int colIndex) {
            if (colIndex == 3) {
               return true;
            }
            return false; // Disallow the editing of any cell
         }
      };
      scrollPane = new JScrollPane(courses);
      this.add(scrollPane, BorderLayout.CENTER);

      panel = new JPanel(new BorderLayout());
      button = new JButton("Save");
      button.setEnabled(false);
      
      // **********IMPORTANT**********
      // Make sure that if you want the button to do something with the main
      // window, you make the action command into something that won't
      // coincide with other people's action commands.
      button.setActionCommand("SaveAvailableCourses");
      button.addActionListener(parent);
      panel.add(button, BorderLayout.LINE_START);

      buttonsPanel = new JPanel();
      buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));

      button_2 = new JButton("Load From:");
      button_2.setEnabled(false);
      buttonsPanel.add(button_2);
      
      JComboBox comboBox = new JComboBox();
      comboBox.setModel(new DefaultComboBoxModel(new String[] {"Winter 2013", "Spring 2013", "Fall 2013"}));
      buttonsPanel.add(comboBox);
      buttonsPanel.add(Box.createRigidArea(new Dimension(5, 0)));

      button = new JButton("Load Suggested");
      button.addActionListener(this);
      buttonsPanel.add(button);
      buttonsPanel.add(Box.createRigidArea(new Dimension(5, 0)));

      button_1 = new JButton("Cancel");
      button_1.setEnabled(false);
      button_1.setActionCommand("CancelAvailableCourses");
      button_1.addActionListener(parent);
      buttonsPanel.add(button_1);

      panel.add(buttonsPanel, BorderLayout.LINE_END);
      panel.setBorder(new EmptyBorder(15, 0, 0, 0));
      this.add(panel, BorderLayout.PAGE_END);
      
      courses.setDefaultRenderer(Object.class, new TableCellRenderer() {
         private DefaultTableCellRenderer DEFAULT_RENDERER =  new DefaultTableCellRenderer();
         
         @Override
         public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (row%2 == 0){
               c.setBackground(Color.WHITE);
            }
            else {
               c.setBackground(Color.LIGHT_GRAY);
            }
            
            if (column == 4) {
               c.setBackground(Color.LIGHT_GRAY);
            }

            return c;
         }
      });
   }

   public void actionPerformed(ActionEvent e) {
      JPanel newContent;

      if (e.getActionCommand().equals("Load Suggested")) {
         if (courses.getSelectedRow() < 0) {
            return;
         }
         
         TableModel dtm = (TableModel) courses.getModel();
         
         for (int row = 0; row < dtm.getRowCount(); row++) {
            Integer suggestedInt = (Integer) dtm.getValueAt(row,  4);
            dtm.setValueAt(suggestedInt, row, 3);
         }
      }
   }
}
