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
   
   @Override 
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Settings:\n");
      builder.append("  Available time patterns: \n  {");
      int countAvailable = 0;
      for (int index = 0; index < TIME_PATTERN.values().length; index++) {
         if (timePatterns[index]) {
            builder.append((countAvailable == 0 ? " " : ", ") + TIME_PATTERN_STRINGS[index]);
            countAvailable++;
         }
      }
      
      if (countAvailable == 0) 
         builder.append(" none ");
      builder.append(" }\n");
      
      builder.append("  Start time: " + startTime);
      builder.append("  End time: " + startTime);
      
      builder.append("\n  Constraints: \n");
      for (Constraint c : constraints) {
         builder.append("   " + c.text);
      }
      if (constraints.size() == 0) {
         builder.append("   {none}");
      }
      return builder.toString();
   }
   
   public AdminGeneralSettings() {
      timePatterns = new boolean[7];
      constraints = new ArrayList<Constraint>();
      prefRows = new TimePrefRow[16];
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
      setChanged();
      notifyObservers(constraints);
      
   }
   
   public void initTimePrefsTable() {
      for (int index = 0; index < 16; index++) {
         int rawHour = index + 7;
         int hour = rawHour % 13; 
         if (rawHour >= 13) {
            hour++;
         }
         prefRows[index] = new TimePrefRow(hour + ":00" + (rawHour >= 12 ? "PM" : "AM"), new Day());
      }
      
      setChanged();
      notifyObservers(prefRows);
      
   }
   
   public TimePrefRow[] getBlockedOutTimes() {
      return prefRows;
   }
   
   public ArrayList<Constraint> getConstraints() {
      return constraints;
   }

  
}
