package models.data.databases;

/**
 * A Location has a building, room, capacity, and list of equipment.
 * 
 * Each section must have a location.
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
   public String getBuilding() {
      return this.building;
   }

   public void setBuilding(String building) {
      this.building = building;
   }

   public String getRoom() {
      return this.room;
   }

   public void setRoom(String room) {
      this.room = room;
   }
   
   public int getCapacity() {
      return this.capacity;
   }

   public void setCapacity(int capacity) {
      this.capacity = capacity;
   }

   public String[] getEquipment() {
      return this.equipment;
   }

   public void setEquipment(String[] equipment) {
      this.equipment = equipment;
   }
}
