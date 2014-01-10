import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Analytics extends JPanel {
   
   /*public static void main(String[] args) {
      JFrame content = new JFrame();
      Analytics panel = new Analytics();
      content.getContentPane().add(panel);
      content.setVisible(true);
      content.pack();
   }*/
   
   public Analytics() {
      create();
   }

   // **********IMPORTANT**********
   // This is really important because it allows us to make an Action Listener
   // that knows all of the things that the AdminMainView knows, but without
   // creating a new one, which would cause a new JFrame to be shown.
   AdminMainView parent;
   JTable instructors;
   Object currentSelection[];

   public Analytics(AdminMainView adminMainView) {
      this.parent = adminMainView;
      create();
   }

   public void create() {
      addComponentsToPane();
      this.setVisible(true);
   }

   private void addComponentsToPane() {
      this.setLayout(new BorderLayout());
      JLabel lblAnalytics;
      String[] columnTitles = { "Name", "Quality (%)" };
      Object[][] data = {
            { "Paul Hatalsky", new Integer(80) },
            { "Clint Staley", new Integer(76) },
            { "John Seng", new Integer(90) },
            { "Phillip Nico", new Integer(83) },
            { "Julie Workman", new Integer(93) },
            { "Timothy Kearns", new Integer(67) },
            { "Hasmik Gharibyan", new Integer(80) },
            { "John Dalby", new Integer(99) },
            { "Kurt Mammen", new Integer(92) },
            { "Ignatios Vakalis", new Integer(79) },
            { "John Clements", new Integer(57) },
            { "David Janzen", new Integer(96) },
            { "Clark Turner", new Integer(30) },
            { "Gene Fisher", new Integer(87) },
            { "William Buckalew", new Integer(76) },
            { "Christopher Lupo", new Integer(86) },
            { "Alexander Dekhtyar", new Integer(88) },
            { "Foaad Khosmood", new Integer(84) }
      };

      this.setBorder(new EmptyBorder(20, 20, 30, 20));

      lblAnalytics = new JLabel("Schedule Analytics");
      lblAnalytics.setFont(new Font("Arial", Font.PLAIN, 16));
      lblAnalytics.setBorder(new EmptyBorder(0, 0, 10, 0));
      this.add(lblAnalytics, BorderLayout.PAGE_START);
      
      JPanel overallQuality = new JPanel();
      add(overallQuality, BorderLayout.WEST);
      
      Box verticalBox = Box.createVerticalBox();
      overallQuality.add(verticalBox);
      
      JLabel lblOverallScheduleQuality = new JLabel("Overall Schedule Quality");
      verticalBox.add(lblOverallScheduleQuality);
      lblOverallScheduleQuality.setFont(new Font("Arial", Font.BOLD, 18));
      
      JTextPane txtpnAverageMedian = new JTextPane();
      verticalBox.add(txtpnAverageMedian);
      txtpnAverageMedian.setEditable(false);
      txtpnAverageMedian.setText("Average: 80%\r\nMedian: 84%\r\nMode: 76%, 80%\r\nStd. Dev.: 16%");
      
      JPanel individualQuality = new JPanel();
      add(individualQuality, BorderLayout.EAST);
      
      JLabel lblIndividualScheduleQuality = new JLabel();
      lblIndividualScheduleQuality.setText("Individual Schedule Quality");
      lblIndividualScheduleQuality.setFont(new Font("Arial", Font.BOLD, 18));
      
      DefaultTableModel model = new DefaultTableModel(100, columnTitles.length);
      model.setDataVector(data, columnTitles);

      instructors = new JTable(model) {
         public boolean isCellEditable(int rowIndex, int colIndex) {
            if (colIndex == 3) {
               return true;
            }
            return false; // Disallow the editing of any cell
         }
      };
      
      JScrollPane instructorQuality = new JScrollPane(instructors);
      GroupLayout gl_individualQuality = new GroupLayout(individualQuality);
      gl_individualQuality.setHorizontalGroup(
         gl_individualQuality.createParallelGroup(Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
            .addGroup(gl_individualQuality.createSequentialGroup()
               .addGap(35)
               .addGroup(gl_individualQuality.createParallelGroup(Alignment.LEADING, false)
                  .addComponent(instructorQuality, Alignment.TRAILING)
                  .addComponent(lblIndividualScheduleQuality, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addContainerGap(33, Short.MAX_VALUE))
      );
      gl_individualQuality.setVerticalGroup(
         gl_individualQuality.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_individualQuality.createSequentialGroup()
               .addContainerGap()
               .addComponent(lblIndividualScheduleQuality)
               .addPreferredGap(ComponentPlacement.RELATED)
               .addComponent(instructorQuality, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
      );
      individualQuality.setLayout(gl_individualQuality);
      
      instructors.setDefaultRenderer(Object.class, new TableCellRenderer() {
         private DefaultTableCellRenderer DEFAULT_RENDERER =  new DefaultTableCellRenderer();
         
         @Override
         public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            if (row == 7 || row == 11) {
               c.setBackground(Color.green);
            }
            else if (row == 10 || row == 12) {
               c.setBackground(Color.red);
            }
            else {
               c.setBackground(Color.white);
            }

            return c;
         }
      });
      
   }
}
