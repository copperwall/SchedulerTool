package models.data.databases;

import java.util.Vector;

/**
 * Save data for the location db view.
 * 
 * @author Chris Opperwall
 *
 */
public class LocationDB {
   private Vector<Location> locations;

   public LocationDB() {
      locations = new Vector<Location>();
   }
	
   /* Get, Add, Edit, Delete */

   public Location getLocation(int id) {
      return locations.get(id);
   }

   public void addLocation(Location location) {
      locations.add(location);
   }

   public void editLocation(Location location) {
      locations.set(location.getId(), location);
   }

   public void deleteLocation(Location location) {
      location.remove(location);
   }

   public Vector<Location> getAllLocations() {
      return locations;
   }
}
