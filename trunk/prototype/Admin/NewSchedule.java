import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.*;
import javax.swing.border.*;

public class NewSchedule extends JPanel {
   private AdminMainView parent;
    public NewSchedule(AdminMainView parent) {
      this.parent = parent;
      create();
   }
   
   private void create(){
      setLayout(new BorderLayout());
      createLabel();
      JTextField text = new JTextField();
      text.setPreferredSize(new Dimension(80,20));
      text.setMinimumSize(new Dimension(80,20));
      add(text);
      createSouthPanel();
   }
   
   private void createSouthPanel() {
      JPanel southPanel = new JPanel();
      
      JButton loadButton = new JButton("Create");
      JButton cancelButton = new JButton("Canel");
      southPanel.add(loadButton);
      southPanel.add(cancelButton);
      southPanel.setBorder(new EmptyBorder(0, 0, 50, 0));
      add(southPanel, BorderLayout.SOUTH);
   }
      
   private void createLabel() {
      JLabel existingLabel = new JLabel("New Schedule Name");
      existingLabel.setForeground(Color.BLACK);
      existingLabel.setFont(new Font("Arial", Font.PLAIN, 24));
      existingLabel.setHorizontalAlignment(SwingConstants.LEFT);
      
      add(existingLabel, BorderLayout.NORTH);
   }
}
