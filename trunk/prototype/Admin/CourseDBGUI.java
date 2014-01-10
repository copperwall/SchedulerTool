/* Team Right Corner */
import javax.swing.*;

public class CourseDBGUI {
   private static void createAndShowGUI() {
      JFrame frame = new JFrame("CourseDBGUI");

      //Add label.
      JLabel label = new JLabel("Course Database");
      frame.getContentPane().add(label);

      //Display the window.
      frame.pack();
      frame.setVisible(true);
   }
    
   public static void main(String[] args) {
      //Schedule a job for the event-dispatching thread:
      //creating and showing this application's GUI.
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
         createAndShowGUI();
      }
      });
   }
}