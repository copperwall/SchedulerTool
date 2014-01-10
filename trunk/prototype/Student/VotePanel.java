import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class VotePanel extends javax.swing.JPanel {
   private StudentMainView parent;
    public VotePanel(StudentMainView parent) {
      this.parent = parent;
      Box vbox = Box.createVerticalBox();
      JLabel label1 = new JLabel("Use the following form to vote for four courses you wish to be enrolled in for this term. Your votes will provide valuable input used during schedule generation.");
      vbox.add(label1);
      String dept[] = { "CPE", "CSC", "AERO"};
      String course[] = { "101", "102", "103"};
      JLabel labelspace = new JLabel(" ");
      vbox.add(labelspace);
      JLabel label2 = new JLabel("The voting window for this term will close on Nov. 1, 2013");
      vbox.add(label2);
      JLabel label3 = new JLabel("Vote #1");
      vbox.add(label3);
      Box hbox1 = Box.createHorizontalBox();
      JComboBox dept1 = new JComboBox(dept);
      JComboBox course1 = new JComboBox(course);
      hbox1.add(dept1);
      hbox1.add(course1);
      vbox.add(hbox1);
      
      JLabel label4 = new JLabel("Vote #2");
      vbox.add(label4);
      Box hbox2 = Box.createHorizontalBox();
      JComboBox dept2 = new JComboBox(dept);
      JComboBox course2 = new JComboBox(course);
      hbox2.add(dept2);
      hbox2.add(course2);
      vbox.add(hbox2);
      
      
      JLabel label5 = new JLabel("Vote #3");
      vbox.add(label5);
      Box hbox3 = Box.createHorizontalBox();
      JComboBox dept3 = new JComboBox(dept);
      JComboBox course3 = new JComboBox(course);
      hbox3.add(dept3);
      hbox3.add(course3);
      vbox.add(hbox3);
      
      
      JLabel label6 = new JLabel("Vote #4");
      vbox.add(label6);
      Box hbox4 = Box.createHorizontalBox();
      JComboBox dept4 = new JComboBox(dept);
      JComboBox course4 = new JComboBox(course);
      hbox4.add(dept4);
      hbox4.add(course4);
      vbox.add(hbox4);
      
      
      JButton submit = new JButton("Submit");
      JButton cancel = new JButton("Cancel");
      vbox.add(submit);
      vbox.add(cancel);
      add(vbox);
   }
}