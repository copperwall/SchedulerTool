package models.data.databases;

import java.util.Vector;
import java.lang.NumberFormatException;

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
    /*@
      requires id >= 0;
      ensures  \result instanceof Location
    @*/
   public Location getLocation(int id) {
      return locations.get(id);
   }

   /**
    * Accepts a <code>Location</code> 
    *
    * @param location <code>Location</code> to add to locations vector.
    * @see Location
    */
    /*@
      requires building != null && room != null && capacity != null && equipment != null;
      ensures \old(locations).size() == locations.size() + 1
         && locations.contains(location);
    @*/
   public void addLocation(String building, String room, String capacity, String equipment) {
      /* Resulting building String from validation */
      String building_check = validateBuilding(building);
      /* Resulting room String from validation */
      String room_check = validateRoom(room);
      /* Resulting integer from converting capacity string to int */
      int capacity_check = validateCapacity(capacity);
      /* Resulting String[] after splitting equipment argument */
      String[] equipment_check = validateEquipment(equipment);

      Location location = new Location(building_check, room_check, capacity_check,
       equipment_check);

      locations.add(location);
   }

   /**
    * Accepts a <code>Location</code> parameter to edit in the locations vector.
    *
    * @param location <code>Location</code> to edit.
    * @see Location
    */
    /*@
      requires \old(locations).contains(location);
      ensures  locations.contains(new_location) && !locations.contains(old);
    @*/
   public void editLocation(Location old, Location new_location) {
      locations.set(locations.indexOf(old), new_location);
   }

   /**
    * Accepts a <code>Location</code> parameter to remove from the locations vector.
    *
    * @param location <code>Location</code> to remove from the locations vector.
    * @see Location
    */
    /*@
      requires \old(locations).contains(location);
      ensures  locations.contains(location) == false;
    @*/
   public void deleteLocation(Location location) {
      locations.remove(location);
   }

   /**
    * Returns the private instance vector of all locations.
    *
    * @return Vector of all <code>Locations</code>
    * @see Location
    */
    /*@
      ensures \result.equals(locations);
    @*/
   public Vector<Location> getAllLocations() {
      return locations;
   }

   /* Begin data validation function */
   /**
    * Validates building name argument, returns validated copy
    *
    * @param building String representation of building name
    * @return Validated copy of building name
    */
    /*@
      ensures \result.getClass() == String.class && \result.length <= 70;
    @*/
   private String validateBuilding(String building) {
      if (building.length() > 70) {
         System.err.println("Building name is too big: Greater than 70 chars");
         System.exit(1);
      }

      return building;
   }

   /**
    * Checks string length of <code>room</code>
    *
    * @param room String representation of a room
    * @return Room value
    */
    /*@
      ensures \result.getClass() == String.class && \result.length <= 6;
    @*/
   private String validateRoom(String room) {
      if (room.length() > 6) {
         System.err.println("Room string does not match format: Too large");
         System.exit(1);
      }

      return room;
   }

   /**
    * Checks validity of capacity argument, returns int value if okay.
    *
    * @param capacity The string representation of capacity
    * @return Integer value of capacity
    */
    /*@
      public normal_behavior
         ensures  \result == Integer.getInteger(capacity).intValue();
      also
       public exceptional_behavior
         requires Integer.parseInt(this.capacity).getClass() == Integer.class;
         signals (NumberFormatException) true; 
    @*/
   private int validateCapacity(String capacity) {
      int integer_capacity = -1;
      
      try {
         integer_capacity = Integer.parseInt(capacity);
      }
      catch(NumberFormatException e) {
         System.err.println("Capacity is not an integer value");
         System.exit(1);
      }

      return integer_capacity;
   }

   /**
    * Takes comma-separated equipment string and splits it into an array
    *
    * @param equipment Comma-separated equipment value to be parsed into a string[].
    * @return String[] of equipment
    */
    /*@
      ensures  /result != null && \result.length > 0;
    @*/
   private String[] validateEquipment(String equipment) {
      String[] result = equipment.split(", ");
      
      if (result.length == 0) {
         System.err.println("Equipment string not comma-separated");
         System.exit(1);
      }

      return equipment.split(", ");
   }
}
