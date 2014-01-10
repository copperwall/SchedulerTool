import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.*;
import javax.swing.border.*;
import java.io.File;
import java.net.URL;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class GenerateLoading extends JPanel implements ActionListener{
   private AdminMainView parent;
   public GenerateLoading(AdminMainView parent) {
      this.parent = parent;
      try {
         create();
      } catch (java.net.MalformedURLException e) {
         System.out.println("MalformedURLException");
      }
   }
    private void create() throws java.net.MalformedURLException {
      Icon gif = new ImageIcon("throbber_100x100.gif");
      JPanel wrapper = new JPanel();
      
      JLabel icon = new JLabel(gif);
      JLabel label = new JLabel("<html>Please wait, generating schedule <br /> This may take a while...</html>");
      
      icon.setVerticalAlignment(JLabel.CENTER);
      icon.setHorizontalAlignment(JLabel.CENTER);
      label.setHorizontalAlignment(JLabel.CENTER);
      label.setVerticalAlignment(JLabel.CENTER);

      wrapper.add(label);
      wrapper.add(icon);

      Box centerBox = new Box(BoxLayout.Y_AXIS);
      centerBox.setAlignmentX(JComponent.CENTER_ALIGNMENT);
      centerBox.add(Box.createVerticalGlue());
      centerBox.add(wrapper);
      centerBox.add(Box.createVerticalGlue());
      
      setLayout(new BorderLayout());
      add(centerBox, BorderLayout.CENTER);
   }
   
   public void actionPerformed(ActionEvent e) {
   }
}  