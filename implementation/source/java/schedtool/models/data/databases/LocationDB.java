package models.data.databases;

import java.util.Vector;
import java.util.Observable;
import java.lang.NumberFormatException;
import java.lang.RuntimeException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class LocationDB contains a list of locations for the Term.
 * 
 * It contains methods to get, add, edit, delete, and getAll from the 
 * instance Vector <code>locations</code>.
 * 
 * @author Chris Opperwall (copperwa@calpoly.edu)
 */
public class LocationDB extends Observable {
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
   public void addLocation(String building, String building_number, String room, String capacity, boolean equipment) {
      /* Resulting building String from validation */
      String building_check = validateBuilding(building);
      /* Resulting building_number String from validation */
      String building_number_check = validateBuildingNumber(building_number);
      /* Resulting room String from validation */
      String room_check = validateRoom(room);
      /* Resulting integer from converting capacity string to int */
      int capacity_check = validateCapacity(capacity);
      /* Resulting boolean */
      boolean equipment_check = validateEquipment(equipment);

      try {
         // Get Connection
    	  Connection con = DriverManager.getConnection("jdbc:mysql://polyschedules.db."
    			     + "9302206.hostedresource.com:3306/polyschedules", "polyschedules", "a1RightCorner!");
         // Just need to do shit now
    	  
    	 System.out.println("Do we get here?");
         PreparedStatement pstmt = con.prepareStatement("INSERT INTO schedules_location "
                 + "(`building`, `building_number`, `room_number`, `has_equipment`, `capacity`) "
                 + "VALUES( "
                 + "?, ?, ?, ?, ?)");
         
         pstmt.setString(1, building_check);
         pstmt.setString(2, building_number_check);
         pstmt.setString(3, room_check);
         pstmt.setInt(4, (equipment_check ? 1 : 0));
         pstmt.setInt(5, capacity_check);
         pstmt.addBatch();
         pstmt.executeBatch();
         
      }
      catch (SQLException e) {
         System.err.println("LocationDB Add:\n"
            + e.getMessage());
      }
            
      setChanged();
      notifyObservers();
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
      try {
         // Get Connection
         Connection con = DriverManager.getConnection(
            "jdbc:mysql://polyschedules.db."
               + "9302206.hostedresource.com:3306/polyschedules",
            "polyschedules", "a1RightCorner!");
         // Just need to do shit now
         
         String query = "UPDATE schedules_location SET building = '"
        		 + new_location.getBuilding() + "', building_number = '"
        		 + new_location.getBuildingNumber() + "', room_number = '"
        		 + new_location.getRoom() + "', capacity = " + new_location.getCapacity()
        		 + ", has_equipment = " + (new_location.getEquipment() ? 1 : 0)
        		 + " WHERE id = " + findLocationQuery(old);
         
         Statement stmt = con.createStatement();
         stmt.executeUpdate(query);
      }
      catch (SQLException e) {
         System.err.println("LocationDB Edit:\n"
            + e.getMessage());
      }
      
      setChanged();
      notifyObservers();
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
      
      
      try {
         // Get Connection
         Connection con = DriverManager.getConnection(
            "jdbc:mysql://polyschedules.db."
               + "9302206.hostedresource.com:3306/polyschedules",
            "polyschedules", "a1RightCorner!");
         // Just need to do shit now
         int locationId = findLocationQuery(location);
         
         String query = "DELETE FROM schedules_location WHERE id = " + locationId;
         
         Statement stmt = con.createStatement();
         stmt.executeUpdate(query);
      }
      catch (SQLException e) {
         System.err.println("LocationDB Delete:\n"
            + e.getMessage());
      }
      
      setChanged();
      notifyObservers();
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
	   Location location;
	   locations = new Vector<Location>();
	   
	   try {
		   Connection con = DriverManager.getConnection("jdbc:mysql://polyschedules.db."
		     + "9302206.hostedresource.com:3306/polyschedules", "polyschedules", "a1RightCorner!");
		   
		   Statement stmt = con.createStatement();
		   
		   String query = "SELECT * FROM schedules_location ORDER BY building_number";
		   ResultSet rs = stmt.executeQuery(query);
		   
		   while (rs.next()) {
			   String building = rs.getString("building");
			   String building_number = rs.getString("building_number");
			   String room = rs.getString("room_number");
			   Boolean equipment = rs.getInt("has_equipment") == 1;
			   int capacity = rs.getInt("capacity");
			   
			   location = new Location(building, building_number, room, capacity, equipment);
			   locations.add(location);
		   }
	   }
	   catch (SQLException e) {
	         System.err.println("LocationDB Add:\n" + e.getMessage());
	   }
	   
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
      if (building.length() > 60) {
         throw new RuntimeException("Building name is too big: Greater than 70 chars");
      }

      return building;
   }
   
   private String validateBuildingNumber(String building_number) {
      if (building_number.length() > 6) {
         throw new RuntimeException("Building number is too big: Greater than 6 chars");
      }

      return building_number;
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
         throw new RuntimeException("Room string does not match format: Too large");
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
         throw new RuntimeException("Capacity is not an integer value");
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
   private boolean validateEquipment(boolean equipment) {
      return equipment;
   }
   
   private int findLocationQuery(Location location) {
	   try {
		   Connection con = DriverManager.getConnection(
                   "jdbc:mysql://polyschedules.db."
                           + "9302206.hostedresource.com:3306/polyschedules",
                   "polyschedules", "a1RightCorner!");
		   
		   Statement stmt = con.createStatement();
		   String query = "SELECT DISTINCT id FROM schedules_location WHERE building = '"
		    + location.getBuilding() + "' AND building_number = '" + location.getBuildingNumber()
		    + "' AND room_number = '" + location.getRoom() + "' AND capacity = "
		    + location.getCapacity() + " AND has_equipment = " + (location.getEquipment() ? 1 : 0);
		   
		   ResultSet rs = stmt.executeQuery(query);
		   if (rs.next())
			   return rs.getInt("id");
		   return -1;
	   }
	   catch (SQLException e) {
		   System.err.println("FindLocationQuery: " + e.getMessage());
	   }
	   
	   return -1;
   }
}
