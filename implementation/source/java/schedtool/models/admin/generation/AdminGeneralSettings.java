package models.admin.generation;

import java.util.ArrayList;
import java.util.Observable;

import models.data.databases.Day;

/**
 *
 * @author Chase Kragenbrink
 */
public class AdminGeneralSettings extends Observable {
   public static enum TIME_PATTERN {MWF, TH, MW, MF, MTWH, MTWF, WF};
   public static String[] TIME_PATTERN_STRINGS = {"MWF", "TH", "MW", "MF", "MTWH", "MTWF", "WF"};
   public int startTime;
   public int endTime;
   private ArrayList<Constraint> constraints;
   private TimePrefRow[] prefRows;
   
   //private ArrayList<Day> days;
   private boolean[] timePatterns;
   
   /**
    * A String dump of all of the current settings.
    */
   @Override 
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Settings:\n");
      builder.append("  Available time patterns: {");
      int countAvailable = 0;
      for (int index = 0; index < TIME_PATTERN.values().length; index++) {
         if (timePatterns[index]) {
            builder.append((countAvailable == 0 ? "" : ", ") + TIME_PATTERN_STRINGS[index]);
            countAvailable++;
         }
      }
      
      if (countAvailable == 0) 
         builder.append(" none ");
      builder.append("}\n");
      
      builder.append("  Start time: " + startTime);
      builder.append("  End time: " + endTime);
      
      builder.append("\n  Constraints: {");
      countAvailable = 0;
      for (Constraint c : constraints) {
         builder.append((countAvailable == 0 ? "" : ", ")+ "[" + c.text + "]");
         countAvailable++;
      }
      if (constraints.size() == 0) {
         builder.append("none");
      }
      builder.append("}\n\n");
      return builder.toString();
   }
   
   public AdminGeneralSettings() {
      timePatterns = new boolean[7];
      constraints = new ArrayList<Constraint>();
      prefRows = new TimePrefRow[16];
      
      setStartTime(7);
      setEndTime(10);
   }
   
   /**
    * Sets the end time used to create a schedule
    * @param hour hour integer of when to end the schedule.
    */
   /*@
      requires 
         hour >= 7 && hour <= 10;
   @*/
   public void setEndTime(int hour) {
      this.endTime = hour;
   }
   
   /**
    * Sets the start time used to create a schedule
    * @param hour integer of when to start the schedule.
    */
   /*@
      requires 
         hour >= 7 && hour <= 10;
   @*/
   public void setStartTime(int hour) {
      this.startTime = hour;
   }
   
   /**
    * This method is for the controller to update the given time pattern (MW, MWF, MTWF, etc.)
    * @param index time pattern in which to update.
    * @param available if this time pattern is to be used.
    */
   public void updateTimePattern(TIME_PATTERN index, boolean available) {
      timePatterns[index.ordinal()] = available;
      System.out.print(this.toString());
   }
   
   /**
    * 
    * @param constraintText the constraint to add. It's not being parsed yet into actual data.
    */
   public void addConstraint(String constraintText) {
      Constraint constraint = new Constraint();
      constraint.text = constraintText;
      
      constraints.add(constraint);
      setChanged();
      notifyObservers(constraints);
      
   }
   
   /**
    * This method is for the controller
    * @return the blocked out times (this is for the controller) for one row (Mon, Tues, ..., Fri).
    */
   public TimePrefRow[] getBlockedOutTimes() {
      return prefRows;
   }
   
   /**
    * 
    * @return an ArrayList of Constraint objects. Currently the constraints only have text to them.
    */
   public ArrayList<Constraint> getConstraints() {
      return constraints;
   }

  
}
