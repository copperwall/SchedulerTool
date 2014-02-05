package models.data.databases;

import java.util.Vector;

/**
 * Class LocationDB contains a list of locations for the Term.
 * 
 * It contains methods to get, add, edit, delete, and getAll from the 
 * instance Vector <code>locations</code>.
 * 
 * @author Chris Opperwall (copperwa@calpoly.edu)
 */
public class LocationDB {
   /* A collection of locations for the current term */
   private Vector<Location> locations;

   public LocationDB() {
      locations = new Vector<Location>();
   }
	
   /**
    * Accepts a location's id as a parameter and returns the location at that index.
    *
    * @return Location at index <code>id</code>.
    * @see Location
    */
   public Location getLocation(int id) {
      return locations.get(id);
   }

   /**
    * Accepts a <code>Location</code> 
    *
    * @param location <code>Location</code> to add to locations vector.
    * @see Location
    */
   public void addLocation(Location location) {
      locations.add(location);
   }

   /**
    * Accepts a <code>Location</cod> parameter to edit in the locations vector.
    *
    * @param location <code>Location</code> to edit.
    * @see Location
    */
   public void editLocation(Location location) {
      locations.set(locations.indexOf(location), location);
   }

   /**
    * Accepts a <code>Location</code> parameter to remove from the locations vector.
    *
    * @param location <code>Location</code> to remove from the locations vector.
    * @see Location
    */
   public void deleteLocation(Location location) {
      locations.remove(location);
   }

   /**
    * Returns the private instance vector of all locations.
    *
    * @return Vector of all <code>Locations</code>
    * @see Location
    */
   public Vector<Location> getAllLocations() {
      return locations;
   }
}
