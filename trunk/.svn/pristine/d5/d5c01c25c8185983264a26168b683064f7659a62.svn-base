import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.*;
import javax.swing.border.*;

public class LoadSchedule extends JPanel {
   private AdminMainView parent;
    public LoadSchedule(AdminMainView parent) {
      this.parent = parent;
      create();
   }
   
   private void create(){
      setLayout(new BorderLayout());
      createLabel();
      createJTable();
      createSouthPanel();
   }
   
   private void createSouthPanel() {
      JPanel southPanel = new JPanel();
      
      JButton loadButton = new JButton("Load");
      JButton cancelButton = new JButton("Canel");
      southPanel.add(loadButton);
      southPanel.add(cancelButton);
      southPanel.setBorder(new EmptyBorder(0, 0, 50, 0));
      add(southPanel, BorderLayout.SOUTH);
   }
      
   private void createLabel() {
      JLabel existingLabel = new JLabel("Existing Schedules");
      existingLabel.setForeground(Color.BLACK);
      existingLabel.setFont(new Font("Arial", Font.PLAIN, 24));
      existingLabel.setHorizontalAlignment(SwingConstants.LEFT);
      
      add(existingLabel, BorderLayout.NORTH);
   }
      
   private void createJTable() {
      String columnNames[] = {"Schedule Name"};
      DefaultTableModel model = new DefaultTableModel(100, columnNames.length) ;
      model.setColumnIdentifiers(columnNames);

      JTable table = new JTable(model){
         public boolean isCellEditable(int rowIndex, int colIndex) {
            return true; //Allow the editing of any cell
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


      scrollPane.setBorder(new CompoundBorder(new EmptyBorder(20, 75, 20, 75),
       BorderFactory.createLineBorder(Color.BLACK)));

      add(scrollPane,  BorderLayout.CENTER);
      
   }
      
      
}
