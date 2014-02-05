package models.data.databases;

/****
 * Class Location is the object representation of a room or lab to schedule course 
 * sections in. Class Location provides methods for getting and setting the building
 * name, room number, student capacity, and list of equipment. The four fields
 * are private and must be accessed through the getter and setter methods. There
 * can only be only section in a location at a particular time interval.
 * 
 * @author Chris Opperwall (copperwa@calpoly.edu)
 */

public class Location {
   private String building;
   private String room;
   private int capacity;
   private String[] equipment;

   public Location(String building, String room, int capacity, String[] equipment) {
      this.building = building;
      this.room = room;
      this.capacity = capacity;
      this.equipment = equipment;
      
   }

   /* Getters and Setters */
   /**
    * Gets the value of <code>building</code> for this Location.
    *
    * @return Building name
    */
   public String getBuilding() {
      return this.building;
   }

   /**
    * Sets the value of <code>building</code> for this Location.
    *
    * @param building New building name for this location.
    */
   public void setBuilding(String building) {
      this.building = building;
   }

   /**
    * Gets the value of <code>room</code> for this Location.
    *
    * @return Room number 
    */
   public String getRoom() {
      return this.room;
   }

   /**
    * Sets the value of <code>room</code> for this Location.
    *
    * @return Building name
    */
   public void setRoom(String room) {
      this.room = room;
   }
   
   /**
    * Gets the value of <code>capacity</code> for this Location.
    *
    * @return The capacity of the location.
    */
   public int getCapacity() {
      return this.capacity;
   }

   /**
    * Sets the value of <code>capacity</code> for this Location.
    *
    * @param capacity The new capacity value for this location.
    */
   public void setCapacity(int capacity) {
      this.capacity = capacity;
   }

   /**
    * Gets the value of <code>equipment</code> for this Location.
    *
    * @return array of equipment strings
    */
   public String[] getEquipment() {
      return this.equipment;
   }

   /**
    * Sets the value of <code>building</code> for this to the equipment param.
    *
    * @param equipment The array of equipment names for this location.
    */
   public void setEquipment(String[] equipment) {
      this.equipment = equipment;
   }
}
