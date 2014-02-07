package models.data.databases;

import java.util.Collection;
import java.lang.Boolean;

/**
 * A day holds 24 booleans of which an instructor is available
 * to hold a class for that hour. Set and get the availability.
 */
public class Day {
   public Collection<Boolean> hourAvailability;
   
   /**
    * Sets the availability to the new given availability.
    */
   /*@
      requires availableHours != null;
      ensures hourAvailability.equals(availableHours);
   @*/
   public void setAvailability(Collection<Boolean> availableHours) {
      
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
   public Collection<Boolean> getAvailability() {
      return null;
   }
}
