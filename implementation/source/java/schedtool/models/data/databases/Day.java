package models.data.databases;

import java.util.ArrayList;
import java.lang.Boolean;

/**
 * A day holds 24 booleans of which an instructor is available
 * to hold a class for that hour. Set and get the availability.
 */
public class Day {
   public ArrayList<Boolean> hourAvailability;
   public String text;
   
   public Day(String longtext) {
      this.text = longtext;
       hourAvailability = new ArrayList<Boolean>();
       if (longtext != null) {
           for (int i = 0; i < 24; i++) {
               hourAvailability.add(longtext.charAt(i) != '0');
           }
       }
   }
   /**
    * Sets the availability to the new given availability.
    */
   /*
      requires availableHours != null;
      ensures hourAvailability.equals(availableHours);
   @*/
   public void setAvailability(ArrayList<Boolean> availableHours) {
      this.hourAvailability = availableHours;
   }

   /**
    * Returns this day's availability
    */
   /*@
      requires hourAvailability != null;
      ensures 
         \result != null &&
         \result.equals(hourAvailability);
   @*/
   public ArrayList<Boolean> getAvailability() {
      return hourAvailability;
   }
}
