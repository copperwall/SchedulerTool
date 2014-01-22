package models.data.databases;

import java.util.Collection;
import java.lang.Boolean;

/**
 * A day holds 24 booleans of which an instructor is available
 * to hold a class for that hour. Set and get the availability.
 */
public abstract class Day {
   public Collection<Boolean> halfHourAvailability;
   
   /**
    * Sets the availability to the new given availability.
    */
   /*@
      requires availableHalfHours != null;
      ensures halfHourAvailability.equals(availableHalfHours);
   @*/
   public abstract void setAvailability(Collection<Boolean> availableHalfHours);

   /**
    * Returns this day's availability
    */
   /*@
      requires halfHourAvailability != null;
      ensures 
         \result != null &&
         \result.equals(halfHourAvailability);
   @*/
   public abstract Collection<Boolean> getAvailability();
}
