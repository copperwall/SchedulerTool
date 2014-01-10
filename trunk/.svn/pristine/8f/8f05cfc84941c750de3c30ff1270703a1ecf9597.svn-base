import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class AdminMainView implements ActionListener {
   private JPanel adminMainPanel;
   private JPanel contentPanel;

   public static void main(String[] args) {
      new AdminMainView();
   }

   public AdminMainView() {
      adminMainPanel = new JPanel();
      contentPanel = new JPanel(new CardLayout());
      adminMainPanel.setLayout(new BoxLayout(adminMainPanel, BoxLayout.Y_AXIS));
      create();
   }

   private void create(){
      createTitlePanel();
      createMenuBar();
      createJTable();
      createJFrame();
      addAnalyticsUI();
      addInstructorDBUI();
      addCourseDBUI();
      addNewUI();
      addGeneralSettingsUI();
      addInstructorPrefsUI();
      addAvailableCoursesUI();
      addGenerateLoadingUI();
      addLoadSchduleUI();
      addLocationDBUI();
   }
   
   private void addNewUI() {
      NewSchedule temp = new NewSchedule(this);
      temp.setVisible(false);
      contentPanel.add(temp, "NewSchedule");
   }

   private void addGenerateLoadingUI() {
      GenerateLoading temp = new GenerateLoading(this);
      temp.setVisible(false);
      contentPanel.add(temp, "GenerateLoading");
   }

   private void addAnalyticsUI() {
      Analytics temp = new Analytics(this);
      temp.setVisible(false);
      contentPanel.add(temp, "Analytics");
   }

   private void addLoadSchduleUI() {
      LoadSchedule temp = new LoadSchedule(this);
      temp.setVisible(false);
      contentPanel.add(temp, "LoadSchedule");
   }

   private void addInstructorDBUI() {
      InstructorDBUI temp = new InstructorDBUI(this);
      temp.setVisible(false);
      contentPanel.add(temp, "InstructorsPanel");
   }

   private void addCourseDBUI() {
      CourseDBUI temp = new CourseDBUI(this);
      temp.setVisible(false);
      contentPanel.add(temp, "CoursesPanel");
   }

   private void addGeneralSettingsUI() {
      GeneralSettings settings = new GeneralSettings(this);
      settings.setVisible(false);
      contentPanel.add(settings, "GeneralSettings");
   }

   private void addInstructorPrefsUI() {
      AdminInstructorPrefs prefs = new AdminInstructorPrefs(this);
      prefs.setVisible(false);
      contentPanel.add(prefs, "InstructorPreferences");
   }

   private void addAvailableCoursesUI() {
      AdminAvailableCourses courses = new AdminAvailableCourses(this);
      courses.setVisible(false);
      contentPanel.add(courses, "AvailableCourses");
   }

   private void addLocationDBUI() {
      LocationDBUI locationView = new LocationDBUI(this);
      locationView.setVisible(false);
      contentPanel.add(locationView, "LocationsPanel");
   }

   private void createJFrame() {
      JFrame frame = new JFrame("Scheduler");
      frame.setSize(1200, 800);
      frame.setLocation(100, 50);
      frame.setContentPane(adminMainPanel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }

   private void createTitlePanel() {
      JPanel titlePanel = new JPanel();

      JButton schedulerLabel = new JButton("Scheduler");
      schedulerLabel.setBorder(new EmptyBorder(0, 8, 0, 0)); // padding on right
      schedulerLabel.setForeground(Color.WHITE);
      schedulerLabel.setFont(new Font("Arial", Font.PLAIN, 24));
      schedulerLabel.addActionListener(this);
      schedulerLabel.setActionCommand("SchedulePanel");
      schedulerLabel.setOpaque(false);
      schedulerLabel.setContentAreaFilled(false);
      schedulerLabel.setBorderPainted(false);
      schedulerLabel.setHorizontalAlignment(SwingConstants.LEFT);

      JLabel whoAmILabel = new JLabel("ADMINISTRATOR");
      whoAmILabel.setBorder(new EmptyBorder(0, 0, 0, 8)); // padding on left
      whoAmILabel.setForeground(Color.WHITE);
      whoAmILabel.setFont(new Font("Arial", Font.PLAIN, 14));
      whoAmILabel.setHorizontalAlignment(SwingConstants.RIGHT);

      String terms[] = { "Fall 2013", "Winter 2014", "Sping 2014",
            "Summer 2014" };
      JComboBox changeTermComboBox = new JComboBox(terms);
      changeTermComboBox.setPrototypeDisplayValue("Change Term");
      Dimension dim = changeTermComboBox.getPreferredSize();
      changeTermComboBox.setPreferredSize(new Dimension(50, dim.height));

      titlePanel.setLayout(new GridLayout(0, 3));
      titlePanel.setMinimumSize(new Dimension(9999999, 50));
      titlePanel.setMaximumSize(new Dimension(9999999, 50));
      titlePanel.setPreferredSize(new Dimension(999999, 50));
      titlePanel.setBackground(new Color(68, 122, 62));

      titlePanel.add(schedulerLabel);
      titlePanel.add(changeTermComboBox);
      titlePanel.add(whoAmILabel);

      adminMainPanel.add(titlePanel);
   }

   private void createMenuBar() {
      JPanel menuBarWrapper = new JPanel();
      menuBarWrapper.setLayout(new GridLayout(0, 1));
      menuBarWrapper.setMinimumSize(new Dimension(9999999, 30));
      menuBarWrapper.setMaximumSize(new Dimension(9999999, 30));
      menuBarWrapper.setPreferredSize(new Dimension(999999, 30));

      JMenuBar menuBar = new JMenuBar();

      JMenu schedulesMenu = new JMenu("Schedules");
      JMenuItem schedulesMenuItem1 = new JMenuItem("New");
      JMenuItem schedulesMenuItem2 = new JMenuItem("Load Existing");
      JMenuItem schedulesMenuItem3 = new JMenuItem("Current Schedule");
      schedulesMenu.add(schedulesMenuItem1);
      schedulesMenu.add(schedulesMenuItem2);
      schedulesMenu.add(schedulesMenuItem3);
      schedulesMenuItem1.addActionListener(this);
      schedulesMenuItem1.setActionCommand("NewSchedule");
      schedulesMenuItem2.addActionListener(this);
      schedulesMenuItem2.setActionCommand("LoadSchedule");
      schedulesMenuItem3.addActionListener(this);
      schedulesMenuItem3.setActionCommand("SchedulePanel");

      JMenu databasesMenu = new JMenu("Databases");
      JMenuItem databasesMenuItem1 = new JMenuItem("Instructors");
      JMenuItem databasesMenuItem2 = new JMenuItem("Courses");
      JMenuItem databasesMenuItem3 = new JMenuItem("Locations");
      databasesMenuItem1.addActionListener(this);
      databasesMenuItem2.addActionListener(this);
      databasesMenuItem3.addActionListener(this);
      databasesMenu.add(databasesMenuItem1);
      databasesMenu.add(databasesMenuItem2);
      databasesMenu.add(databasesMenuItem3);

      JMenu settingsMenu = new JMenu("Settings");
      JMenuItem settingsMenuItem1 = new JMenuItem("General");
      JMenuItem settingsMenuItem2 = new JMenuItem("Instructor Preferences");
      JMenuItem settingsMenuItem3 = new JMenuItem("Available Courses");
      settingsMenuItem1.setActionCommand("GeneralSettings");
      settingsMenuItem1.addActionListener(this);
      settingsMenuItem2.setActionCommand("InstructorPreferences");
      settingsMenuItem2.addActionListener(this);
      settingsMenuItem3.setActionCommand("AvailableCourses");
      settingsMenuItem3.addActionListener(this);

      settingsMenu.add(settingsMenuItem1);
      settingsMenu.add(settingsMenuItem2);
      settingsMenu.add(settingsMenuItem3);

      JButton analyticsMenu = new JButton("Analytics");
      analyticsMenu.setHorizontalAlignment(SwingConstants.LEFT);
      analyticsMenu.setActionCommand("Analytics");
      analyticsMenu.addActionListener(this);
      analyticsMenu.setOpaque(false);
      analyticsMenu.setContentAreaFilled(false);
      analyticsMenu.setBorderPainted(false);

      JButton publishMenu = new JButton("Publish");
      publishMenu.setHorizontalAlignment(SwingConstants.LEFT);
      publishMenu.setActionCommand("Publish");
      publishMenu.addActionListener(this);
      publishMenu.setOpaque(false);
      publishMenu.setContentAreaFilled(false);
      publishMenu.setBorderPainted(false);

      JButton generateMenu = new JButton("Generate");
      generateMenu.setHorizontalAlignment(SwingConstants.LEFT);
      generateMenu.setActionCommand("Generate");
      generateMenu.addActionListener(this);
      generateMenu.setOpaque(false);
      generateMenu.setContentAreaFilled(false);
      generateMenu.setBorderPainted(false);

      menuBar.add(schedulesMenu);
      menuBar.add(databasesMenu);
      menuBar.add(settingsMenu);
      menuBar.add(analyticsMenu);
      menuBar.add(publishMenu);
      menuBar.add(Box.createHorizontalGlue());
      menuBar.add(generateMenu);

      menuBarWrapper.add(menuBar);
      adminMainPanel.add(menuBarWrapper);
   }

   private void createJTable() {
      String columnNames[] = { "Prefix", "Course No.", "Section No.",
            "Building", "Room", "Days", "Time", "Type", "Units", "WTU",
            "Planned Enrollment" };

      DefaultTableModel model = new DefaultTableModel(100, columnNames.length);
      model.setColumnIdentifiers(columnNames);

      JTable table = new JTable(model) {
         public boolean isCellEditable(int rowIndex, int colIndex) {
            return false; // Disallow the editing of any cell
         }
      };

      JScrollPane scrollPane = new JScrollPane(table);

      table.setFillsViewportHeight(true);
      table.setGridColor(Color.BLACK);

      TableColumn column = null;
      table.setDefaultRenderer(Object.class, new TableCellRenderer() {
         private DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

         @Override
         public Component getTableCellRendererComponent(JTable table,
               Object value, boolean isSelected, boolean hasFocus, int row,
               int column) {
            Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table,
                  value, isSelected, hasFocus, row, column);
            if (row % 2 == 0) {
               c.setBackground(Color.WHITE);
            }
            else {
               c.setBackground(Color.LIGHT_GRAY);
            }
            return c;
         }
      });

      int[] widths = {75, 150, 150, 100, 0, 0, 0, 0, 0, 0, 220};
      for (int index = 0; index < 11; index++) {
         column = table.getColumnModel().getColumn(index);
         
         if (widths[index] != 0) {
            column.setPreferredWidth(widths[index]);
         }
      }

      scrollPane.setBorder(new CompoundBorder(new EmptyBorder(20, 20, 20, 20),
            BorderFactory.createLineBorder(Color.BLACK)));

      contentPanel.add(scrollPane, "SchedulePanel");
      adminMainPanel.add(contentPanel);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      CardLayout cl = (CardLayout) contentPanel.getLayout();
      String ac = e.getActionCommand();
      if (ac.equals("Instructors")) {
         cl.show(contentPanel, "InstructorsPanel");
         adminMainPanel.repaint();
      }
      else if (ac.equals("Courses")) {
         cl.show(contentPanel, "CoursesPanel");
         adminMainPanel.repaint();
      }
      else if (ac.equals("SaveInstructorsDB")) {
         cl.show(contentPanel, "SchedulePanel");
         adminMainPanel.repaint();
      }
      else if (ac.equals("CancelInstructorsDB")) {
         cl.show(contentPanel, "SchedulePanel");
         adminMainPanel.repaint();
      }
      else if (ac.equals("GeneralSettings")) {
         cl.show(contentPanel, "GeneralSettings");
         adminMainPanel.repaint();
      }
      else if (ac.equals("InstructorPreferences")) {
         cl.show(contentPanel, "InstructorPreferences");
         adminMainPanel.repaint();
      }
      else if (ac.equals("AvailableCourses")) {
         cl.show(contentPanel, "AvailableCourses");
         adminMainPanel.repaint();
      }
      else if (ac.equals("Locations")) {
         cl.show(contentPanel, "LocationsPanel");
         adminMainPanel.repaint();
         System.out.println("Should be showing the location panel now");
      }
      else if (ac.equals("Generate")) {
         cl.show(contentPanel, "GenerateLoading");
         adminMainPanel.repaint();
      }
      else if (ac.equals("Analytics")) {
         cl.show(contentPanel, "Analytics");
         adminMainPanel.repaint();
      }
      else if (ac.equals("Publish")) {
         (new PublishDialog()).show();
      }
      else if (ac.equals("LoadSchedule")) {
         cl.show(contentPanel, "LoadSchedule");
         adminMainPanel.repaint();
      }
      else if (ac.equals("SchedulePanel")) {
         cl.show(contentPanel, "SchedulePanel");
         adminMainPanel.repaint();
      }
      else if (ac.equals("NewSchedule")) {
         cl.show(contentPanel, "NewSchedule");
         adminMainPanel.repaint();
      }
   }

}
