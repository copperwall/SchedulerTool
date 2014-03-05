package models.data.databases;

import java.util.Collection;
import java.util.Scanner;
import java.util.Vector;
import java.lang.Boolean;
import java.sql.Clob;
import java.sql.SQLException;

/**
 * A day holds 24 booleans of which an instructor is available
 * to hold a class for that hour. Set and get the availability.
 */
public class Day {
   public Collection<Boolean> hourAvailability;
   
   
   public Day(String longtext) {
       hourAvailability = new Vector<Boolean>();
       
       for (int i = 0; i < longtext.length(); i++) {
           System.out.println(i + ":00 - " + (longtext.charAt(i) != '0'));
           hourAvailability.add(longtext.charAt(i) != '0');
       }
   }
   /**
    * Sets the availability to the new given availability.
    */
   /*
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
