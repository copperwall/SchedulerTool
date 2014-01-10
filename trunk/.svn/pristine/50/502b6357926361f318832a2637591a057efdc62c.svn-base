import java.awt.Color;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class GeneralSettings extends JPanel {
   AdminMainView parent;
   
   private JButton jButton1;
   private JCheckBox jCheckBox1;
   private JCheckBox jCheckBox2;
   private JCheckBox jCheckBox3;
   private JCheckBox jCheckBox4;
   private JCheckBox jCheckBox6;
   private JCheckBox jCheckBox7;
   private JCheckBox jCheckBox8;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JLabel jLabel3;
   private JLabel jLabel4;
   private JLabel jLabel5;
   private JLabel jLabel6;
   private JLabel jLabel7;
   private JLabel jLabel8;
   private JLabel jLabel9;
   private JLabel jLabel10;
   private JPanel jPanel1;
   private JPanel jPanel2;
   private JScrollPane jScrollPane1;
   private JScrollPane jScrollPane2;
   private JSlider jSlider1;
   private JSlider jSlider2;
   private JTable jTable1;
   private JTable jTable2;
   private JTextField jTextField1;

   public GeneralSettings(AdminMainView adminMainView) {
      this.parent = adminMainView;
      create();
   }

   public void create() {
      // methods to build the UI
      initComponents();
      this.setVisible(true);
   }

   private void initComponents() {

      jPanel1 = new JPanel();
      jLabel1 = new JLabel();
      jSlider1 = new JSlider();
      jSlider2 = new JSlider();
      jLabel2 = new JLabel();
      jLabel3 = new JLabel();
      jLabel4 = new JLabel();
      jScrollPane1 = new JScrollPane();
      jTable1 = new JTable();
      jTextField1 = new JTextField();
      jButton1 = new JButton();
      jPanel2 = new JPanel();
      jScrollPane2 = new JScrollPane();
      jTable2 = new JTable() {
         @Override
         public boolean isCellEditable(int row, int column) {
            return false;
         }
         
         
      };
      jLabel5 = new JLabel();
      jLabel6 = new JLabel();
      jLabel7 = new JLabel();
      jLabel8 = new JLabel();
      jLabel9 = new JLabel();
      jLabel10 = new JLabel();
      jCheckBox1 = new JCheckBox();
      jCheckBox2 = new JCheckBox();
      jCheckBox3 = new JCheckBox();
      jCheckBox4 = new JCheckBox();
      jCheckBox6 = new JCheckBox();
      jCheckBox7 = new JCheckBox();
      jCheckBox8 = new JCheckBox();

      // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
      jLabel1.setText("General Settings");

      jLabel2.setText("Start time:");

      jLabel3.setText("End time:");

      jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
      jLabel4.setText("Current Constraints");
      
      jButton1.setText("Add constraint");
      
      jLabel7.setText("Add constraint:");
      jLabel8.setText("Ex: \"305, 309\" - 305 and 309 should not overlap");

      jLabel9.setText("Ex: \"5XX\" - 500-level courses should not overlap");

      jLabel10.setText("Ex: \"3{6,7,8}X\" - 360s, 370s, 380s should not overlap");
      
      Cell[][] constraintTable = new Cell[3][];  

         constraintTable[0] = new Cell[]{new Cell("305 and 309 may not overlap", null)};
         constraintTable[1] = new Cell[]{new Cell("400-level classes may not overlap", null)};
         constraintTable[2] = new Cell[]{new Cell("360s and 370s may not overlap", null)};

      DefaultTableModel model1 = new DefaultTableModel(3, 1) ;
      model1.setDataVector(constraintTable, new String[] { "Constraint"});


      jTable1.setModel(model1);
      jScrollPane1.setViewportView(jTable1);

      GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
             .addContainerGap()
             .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(jLabel1)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                         .addComponent(jLabel2)
                         .addGap(28, 28, 28)
                         .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                         .addComponent(jLabel3)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                 .addComponent(jLabel4)
                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addComponent(jLabel7)
                 .addGroup(jPanel1Layout.createSequentialGroup()
                     .addGap(10, 10, 10)
                     .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jLabel8)
                         .addComponent(jLabel9)
                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                             .addGroup(jPanel1Layout.createSequentialGroup()
                                 .addComponent(jTextField1)
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                 .addComponent(jButton1))
                             .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)))))
             .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
     );
     jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
             .addContainerGap()
             .addComponent(jLabel1)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
             .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                 .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
             .addGap(18, 18, 18)
             .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addComponent(jLabel3))
             .addGap(28, 28, 28)
             .addComponent(jLabel4)
             .addGap(18, 18, 18)
             .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
             .addGap(18, 18, 18)
             .addComponent(jLabel7)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addComponent(jLabel8)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addComponent(jLabel9)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addComponent(jLabel10)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
             .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                 .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addComponent(jButton1))
             .addContainerGap(114, Short.MAX_VALUE))
     );
      Cell[][] timeTable = new Cell[16][];  
      Color c = Color.RED;
      
      for (int time = 7; time <= 22; time++) {
         String t = time < 12 ? time + ":00AM" : time == 12 ? "12:00PM" : (time - 12) + ":00PM";
         timeTable[time - 7] = new Cell[]{new Cell(t, c), new Cell(c), new Cell(c), new Cell(c),new Cell(c),new Cell(c),new Cell(c)};
      }
      
      DefaultTableModel model = new DefaultTableModel(16, 7) ;
      model.setDataVector(timeTable, new String[] { "Time", "Mon.", "Tues.", "Wed.", "Thurs.", "Fri.", "Sat." });
      
      jTable2.setModel(model);
      
      jTable2.setFillsViewportHeight(true);
      jTable2.setGridColor(Color.BLACK);
      
      jTable2.setDefaultRenderer(Object.class, new TableCellRenderer(){
         private DefaultTableCellRenderer DEFAULT_RENDERER =  new DefaultTableCellRenderer();
         
         @Override
         public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Cell cell = (Cell)value;
            
            
            if (hasFocus && cell.isColorable() && !cell.backgroundIsSet()) {
               c.setBackground(Color.RED);
               cell.backgroundColor = Color.RED;
            }
            else if (hasFocus && cell.backgroundIsSet()) {
               Color color = row % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY;
               c.setBackground(color);
               cell.backgroundColor = color;
            }
            else if (cell.backgroundIsSet())
               c.setBackground(cell.backgroundColor);
            else {
               c.setBackground(row % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
            }
            return c;
         }
      });
      
      
      jScrollPane2.setViewportView(jTable2);

      jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
      jLabel5.setText("Blocked out times");

      jLabel6.setText("Available Time Patterns");

      jCheckBox1.setText("MWF");
     /* jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jCheckBox1ActionPerformed(evt);
         }
      });*/

      jCheckBox2.setText("MF");

      jCheckBox3.setText("WF");

      jCheckBox4.setText("MTWF");

      jCheckBox6.setText("MW");

      jCheckBox7.setText("TH");

      jCheckBox8.setText("MTWH");

      GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
             .addGap(0, 0, Short.MAX_VALUE)
             .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addComponent(jLabel6)
                 .addComponent(jLabel5)
                 .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(jPanel2Layout.createSequentialGroup()
                                 .addComponent(jCheckBox1)
                                 .addGap(18, 18, 18)
                                 .addComponent(jCheckBox7))
                             .addGroup(jPanel2Layout.createSequentialGroup()
                                 .addComponent(jCheckBox2)
                                 .addGap(18, 18, 18)
                                 .addComponent(jCheckBox8)))
                         .addGap(18, 18, 18)
                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(jCheckBox4)
                             .addGroup(jPanel2Layout.createSequentialGroup()
                                 .addComponent(jCheckBox6)
                                 .addGap(18, 18, 18)
                                 .addComponent(jCheckBox3))))))
             .addGap(19, 19, 19))
     );
     jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
             .addContainerGap()
             .addComponent(jLabel5)
             .addGap(17, 17, 17)
             .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
             .addGap(18, 18, 18)
             .addComponent(jLabel6)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
             .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                 .addComponent(jCheckBox1)
                 .addComponent(jCheckBox6)
                 .addComponent(jCheckBox7)
                 .addComponent(jCheckBox3))
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                 .addComponent(jCheckBox2)
                 .addComponent(jCheckBox8)
                 .addComponent(jCheckBox4))
             .addContainerGap(82, Short.MAX_VALUE))
     );

     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
     setLayout(layout);
     layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
             .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
     );
     layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
     );

      // pack();
   }// </editor-fold>
}
