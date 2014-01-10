import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.*;
import javax.swing.border.*;

public class LocationDBUI extends JPanel implements ActionListener {
   AdminMainView parent;
   
   public LocationDBUI (AdminMainView parent) {
      this.parent = parent;
      this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      create();
   }
   
   private void create(){
      createJTable();
      createButtons();
      this.setVisible(true);
   }
   
   private void createJTable() {
      String columnNames[] = { "Building", "Room", "Capacity", "Equipment"};
      Object[][] data = {
         {14, "257", "30", "Yes"},
         {14, "301", "35", "Yes"},
         {14, "303", "60", "Yes"},
         {14, "201", "60", "No"},
         {14, "302", "30", "Yes"},
         {14, "230", "25", "No"}
      };
      
      DefaultTableModel model = new DefaultTableModel(100, columnNames.length) ;
      model.setDataVector(data, columnNames);
      
      JTable table = new JTable(model){
            public boolean isCellEditable(int rowIndex, int colIndex) {
            return false; //Disallow the editing of any cell
         }
      };
      
      JScrollPane scrollPane = new JScrollPane(table);
      
      table.setFillsViewportHeight(true);
      table.setGridColor(Color.BLACK);
      
      TableColumn column = null;
      table.setDefaultRenderer(Object.class, new TableCellRenderer(){
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
            return c;
         }
      });
      
      //SET COLUMN DEAFULT WIDTHS -- SO EVERYTHING FITS NICELY
      for (int i = 0; i < columnNames.length; i++) {
         column = table.getColumnModel().getColumn(i);
         if(i != 1)
            column.setPreferredWidth(175);
         else
            column.setPreferredWidth(200);
      }
      
      scrollPane.setBorder(new CompoundBorder(new EmptyBorder(20, 20, 20, 20),
       BorderFactory.createLineBorder(Color.BLACK)));
      
      this.add(scrollPane);
   }

   private void createButtons() {
      JPanel buttonPanel = new JPanel();
      JButton add = new JButton("Add");
      JButton edit = new JButton("Edit");
      JButton delete = new JButton("Delete");

      add.addActionListener(this);
      edit.addActionListener(this);

      buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

      buttonPanel.add(add);
      buttonPanel.add(edit);
      buttonPanel.add(delete);
      
      this.add(buttonPanel);
   }

   public void actionPerformed(ActionEvent e) {
      String ac = e.getActionCommand();

      if (ac.equals("Add")) {
         new LocationDBUIAdd();
      }
      else if (ac.equals("Edit")) {
         new LocationDBUIEdit();
      }
   }
}
