import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.*;
import javax.swing.border.*;

public class LocationDBUIAdd implements ActionListener {
   JFrame frame = new JFrame("Add Location");
   JPanel panel = new JPanel();

   public LocationDBUIAdd () {
      panel.setLayout(new GridBagLayout());
      create();
   }
   
   private void create(){
      createForms();
      createButtons(); // Done

      frame.add(panel);
      frame.pack();
      frame.setVisible(true);
   }

   private void createForms() {
      JPanel formPanel = new JPanel();
      JPanel formPanel2 = new JPanel();

      JTextField building = new JTextField(15);
      JTextField capacity = new JTextField(15);
      JTextField room = new JTextField(8);
      JCheckBox equipment = new JCheckBox();

      formPanel.add(new JLabel("Building"));
      formPanel.add(building);
      formPanel.add(new JLabel("Capacity"));
      formPanel.add(capacity);
      formPanel2.add(new JLabel("Room"));
      formPanel2.add(room);
      formPanel2.add(Box.createHorizontalGlue());
      formPanel2.add(new JLabel("Equipment"));
      formPanel2.add(equipment);

      panel.add(formPanel);
      panel.add(formPanel2);
   }

   private void createButtons() {
      JPanel buttonPanel = new JPanel();
      JButton confirm = new JButton("Confirm");
      JButton cancel = new JButton("Cancel");

      confirm.addActionListener(this);
      cancel.addActionListener(this);

      buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

      buttonPanel.add(confirm);
      buttonPanel.add(cancel);
      
      panel.add(buttonPanel);
   }

   public void actionPerformed(ActionEvent e) {
      frame.dispose();
   }
}
