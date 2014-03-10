package models.data.databases;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

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
   private String building_number;
   private String room;
   private int capacity;
   private boolean equipment;
   
   private final SimpleStringProperty buildingProp = new SimpleStringProperty("");
   private final SimpleStringProperty buildingNumProp = new SimpleStringProperty("");
   private final SimpleStringProperty roomProp = new SimpleStringProperty("");
   private final SimpleIntegerProperty capacityProp = new SimpleIntegerProperty();
   private final SimpleBooleanProperty equipmentProp = new SimpleBooleanProperty();

   public Location(String building, String building_number, String room, int capacity, boolean equipment) {
      this.building = building;
      this.building_number = building_number;
      this.room = room;
      this.capacity = capacity;
      this.equipment = equipment;
      
      this.buildingProp.set(building);
      this.buildingNumProp.set(building_number);
      this.roomProp.set(room);
      this.capacityProp.set((Integer)capacity);
      this.equipmentProp.set((Boolean)equipment);
      
   }

   /* Getters and Setters */
   /**
    * Gets the value of <code>building</code> for this Location.
    *
    * @return Building name
    */
    /*@
      ensures \result.equals(this.building);
    @*/ 
   public String getBuilding() {
      return this.building;
   }

   /**
    * Sets the value of <code>building</code> for this Location.
    *
    * @param building New building name for this location.
    */
    /*@
      ensures this.building.equals(building);
    @*/
   public void setBuilding(String building) {
      this.building = building;
   }

   /**
    * Gets the value of <code>building_number</code> for this Location.
    *
    * @return Building Number
    */
    /*@
      ensures \result.equals(this.building_number);
    @*/ 
   public String getBuildingNumber() {
      return this.building_number;
   }

   /**
    * Sets the value of <code>building_number</code> for this Location.
    *
    * @param building_number New building number for this location.
    */
    /*@
      ensures this.building.equals(building_number);
    @*/
   public void setBuildingNumber(String building_number) {
      this.building_number = building_number;
   }

   /**
    * Gets the value of <code>room</code> for this Location.
    *
    * @return Room number 
    */
    /*@
      ensures \result.equals(this.room);
    @*/
   public String getRoom() {
      return this.room;
   }

   /**
    * Sets the value of <code>room</code> for this Location.
    *
    * @return Building name
    */
    /*@
      ensures this.room.equals(room);
    @*/
   public void setRoom(String room) {
      this.room = room;
   }
   
   /**
    * Gets the value of <code>capacity</code> for this Location.
    *
    * @return The capacity of the location.
    */
    /*@
      ensures \result == this.capacity;
    @*/
   public int getCapacity() {
      return this.capacity;
   }

   /**
    * Sets the value of <code>capacity</code> for this Location.
    *
    * @param capacity The new capacity value for this location.
    */
    /*@
      ensures this.capacity == capacity;
    @*/
   public void setCapacity(int capacity) {
      this.capacity = capacity;
   }

   /**
    * Gets the value of <code>equipment</code> for this Location.
    *
    * @return array of equipment strings
    */
    /*@
      ensures \result.equals(this.equipment);
    @*/
   public boolean getEquipment() {
      return this.equipment;
   }

   /**
    * Sets the value of <code>building</code> for this to the equipment param.
    *
    * @param equipment The array of equipment names for this location.
    */
    /*@
      ensures this.equipment.equals(equipment);
    @*/
   public void setEquipment(boolean equipment) {
      this.equipment = equipment;
   }
   
   public SimpleStringProperty buildingPropProperty() {
	   return this.buildingProp;
   }
   
   public SimpleStringProperty buildingNumPropProperty() {
	   return this.buildingNumProp;
   }
   
   public SimpleStringProperty roomPropProperty() {
	   return this.roomProp;
   }
   
   public SimpleIntegerProperty capacityPropProperty() {
	   return this.capacityProp;
   }
   
   public SimpleBooleanProperty equipmentPropProperty() {
	   return this.equipmentProp;
   }
}
