package models.admin.generation;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Chase Kragenbrink
 */
public class AdminGeneralSettings extends Observable {
   public static enum TIME_PATTERN {MWF, TH, MW, MF, MTWH, MTWF, WF};
   public int startTime;
   public int endTime;
   private ArrayList<Constraint> constraints;
   //private ArrayList<Day> days;
   private boolean[] timePatterns;
   
   public AdminGeneralSettings() {
      timePatterns = new boolean[7];
      constraints = new ArrayList<Constraint>();
   }
   
   public void setEndTime(int hour) {
      System.out.println("In AdminGeneralSettings.setEndTime.");
      this.endTime = hour;
   }
   
   public void setStartTime(int hour) {
      System.out.println("In AdminGeneralSettings.setStartTime.");
      this.startTime = hour;
   }
   
   public void updateTimePattern(TIME_PATTERN index, boolean available) {
      System.out.println("In AdminGeneralSettings.updateTimePattern.");
      timePatterns[index.ordinal()] = available;
   }
   
   public void addConstraint(String constraintText) {
      System.out.println("In AdminGeneralSettings.addConstraint.");
      
      Constraint constraint = new Constraint();
      constraint.text = constraintText;
      
      constraints.add(constraint);
      
      notifyObservers(constraints);
      
   }
   
   public ArrayList<Constraint> getConstraints() {
      return constraints;
   }
}
