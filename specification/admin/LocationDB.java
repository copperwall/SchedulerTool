package admin;

import java.util.Collection;
import data.Location;

/**
 * Contains all of the available locations. 
 * Add/edit/delete location methods are available.
 */
public abstract class LocationDB {
   /**
    * A database of locations
    */
   public Collection<Location> locations;

   /**
    * Adds a location to the database of locations.
    */
   /*@
      // The given location is not null
      requires
         (location != null) &&
      // There is no location in the database of locations the same as the
      // input.
         (! (\exists Location loc_other ;
             locations.contains(loc_other) ;
                 loc_other.getBuildingNum() == location.getBuildingNum()
              && loc_other.getRoomNum() == location.getRoomNum()));

      // A location is in the new locations collection if and only if
      // it has been added to it.
      ensures
         locations.equals(\old(locations).add(location));
   @*/
   public abstract void addLocation(Location location);
   
   /**
    * Edits a given location. Building and room numbers must remain the same. 
    */
   /*@
      requires
         location != null;
      // Ensures that the location is in the database, and the course number and building number remain the same. Other data fields
      // are either old data or new, edited data. 
      ensures
         locations.contains(location) && location.getBuildingNum() == \old(location.getBuildingNum()) && location.getRoomNum() == \old(location.getBuildingNum());
    @*/
   public abstract void editLocation(Location location);
   
   /**
    * Removes a given location.
    */
   /*@
      // Location given is not null
      requires 
         location != null;
      // Ensures that the location specified is removed from the database
      ensures
         !locations.contains(location);
   @*/
   public abstract void deleteLocation(Location location);
}
