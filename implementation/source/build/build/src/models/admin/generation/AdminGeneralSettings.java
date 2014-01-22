package models.admin.generation;

/**
 *
 * @author Chase Kragenbrink
 */
public class AdminGeneralSettings {
   public static enum TIME_PATTERN {MWF, TH, MW, MF, MTWH, MTWF, WF};
   
   public void setEndTime(int hour) {
      System.out.println("In AdminGeneralSettings.setEndTime.");
   }
   
   public void setStartTime(int hour) {
      System.out.println("In AdminGeneralSettings.setStartTime.");
   }
   
   public void updateTimePattern(TIME_PATTERN index, boolean available) {
      System.out.println("In AdminGeneralSettings.updateTimePattern.");
   }
   
   public void addConstraint(String constraint) {
      System.out.println("In AdminGeneralSettings.addConstraint.");
   }
}
