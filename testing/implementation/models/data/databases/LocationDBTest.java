package models.data.databases;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Vector;

import models.data.databases.Location;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/****
 *
 * Class LocationDBTest is the companiontesting class for <a href='LocationDB.html'>LocationDB</a>. It implements the following module test plan:
 *
 *    Phase 1: Unit test the constructor
 *    Phase 2: Unit test the smaller field validation methods
 *    Phase 3: Unit test the higher level add, remove, and edit methods
 */

public class LocationDBTest {
   
   /**
    * Unit test the constructor by creating a single instance of LocationDB.
    * 
    * Test
    * Case  Input          Output            Remarks
    * ==============================================================
    * 1     None           Successful init   Only case
    */

   @Test
   public void testConstructor() {
      LocationDB db;

      try {
         db = new LocationDB();
      }
      catch (Exception e) {
         /* This should not happen */
         assertTrue(false);
      }
   }

   /**
    * Unit test the building validation method.
    * 
    * Test
    * Case  Input          Output            Remarks
    * ==============================================================
    * 1     "14"           "14"              Valid Case
    * 2     "1....."       Exception         Invalid input
    * @throws SecurityException 
    * @throws NoSuchMethodException 
    * @throws InvocationTargetException 
    * @throws IllegalAccessException 
    */

   @Test
   public void testValidateBuilding() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
      LocationDB db = new LocationDB();

      // Reflection time
      Method method = LocationDB.class.getDeclaredMethod("validateBuilding", String.class);

      try {
         method.setAccessible(true);
         Object o = method.invoke(db, "13");
      }
      catch (RuntimeException e) {
         /* Failure*/
         assertTrue(false);
      }

      try {
         Object o = method.invoke(db, "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
      }
      catch (RuntimeException e) {
         /* Success */
         assertTrue(true);
      }
   }

   /**
    * Unit test the room validation method.
    * 
    * Test
    * Case  Input          Output            Remarks
    * ==============================================================
    * 1     "123"           No Exception      Valid Case
    * 2     "1020304"       Exception         Invalid input
    * @throws InvocationTargetException 
    * @throws IllegalAccessException 
    * @throws SecurityException 
    * @throws NoSuchMethodException 
    */

   @Test
   public void testValidateRoom() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
      LocationDB db = new LocationDB();

      Method method = LocationDB.class.getDeclaredMethod("validateRoom", String.class);

      try {
         method.setAccessible(true);
         Object o = method.invoke(db, "123");
      }
      catch (RuntimeException e) {
         /* Failure */
         assertTrue(false);
      }

      try {
         Object o = method.invoke(db, "1020304");
      }
      catch (RuntimeException e) {
         assertTrue(true);
      }
   }

   /**
    * Unit test the capacity validation method.
    * 
    * Test
    * Case  Input          Output            Remarks
    * ==============================================================
    * 1     "40"           No Exception      Valid Case
    * 2     "abcd"         Exception         Invalid input
    * @throws SecurityException 
    * @throws NoSuchMethodException 
    * @throws InvocationTargetException 
    * @throws IllegalAccessException 
    */

   @Test
   public void testValidateCapacity() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
      LocationDB db = new LocationDB();

      Method method = LocationDB.class.getDeclaredMethod("validateCapacity", String.class);

      try {
         method.setAccessible(true);
         Object o = method.invoke(db, "40");
      }
      catch (RuntimeException e) {
         /* Failure */
         assertTrue(false);
      }

      try {
         method.invoke(db, "abcd");
      }
      catch (RuntimeException e) {
         assertTrue(true);
      }
         
   }

   /**
    * Unit test the equipment validation method.
    * 
    * Test
    * Case  Input          Output            Remarks
    * ==============================================================
    * 1     true           None              Expects no exceptions
    * @throws SecurityException 
    * @throws NoSuchMethodException 
    * @throws InvocationTargetException 
    * @throws IllegalAccessException 
    */

   @Test
   public void testValidateEquipment() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
      LocationDB db = new LocationDB();

      Method method = LocationDB.class.getDeclaredMethod("validateEquipment", boolean.class);

      try {
         method.setAccessible(true);
         Object o = method.invoke(db, true);
      }
      catch (RuntimeException e) {
         /* Failure */
         assertTrue(false);
      }
   }

   @Test
   public void testGetAllLocations() {
      LocationDB db = new LocationDB();
      Vector<Location> location = db.getAllLocations();
      assertTrue(true);
   }

   @Test
   public void testAddLocation() {
      LocationDB db = new LocationDB();
      Vector<Location> locations = db.getAllLocations();

      assertTrue(locations.size() == 0);

      db.addLocation("14", "234", "41", true);

      locations = db.getAllLocations();

      assertTrue(locations.size() == 1);
   }

   @Test
   public void testGetLocation() {
      LocationDB db = new LocationDB();

      db.addLocation("Frank E. Pilling Building", "14", "234", "41", true);
      Location location = db.getLocation(0);

      assertTrue(location.getBuilding().equals("Frank E. Pilling Building"));
      assertTrue(location.getBuildingNumber().equals("14"));
      assertTrue(location.getRoom().equals("234"));
      assertTrue(location.getCapacity() == 41);
      assertTrue(location.getEquipment());
   }

   @Test
   public void testEditLocation() {
      LocationDB db = new LocationDB();
      Vector<Location> locations = db.getAllLocations();

      db.addLocation("Frank E. Pilling Building", "14", "234", "41", true);
      Location location = db.getLocation(0);
      Location two = new Location("Frank E. Pilling Building", "15", "2344", 40, false);

      db.editLocation(location, two);

      location = db.getLocation(0);

      assertTrue(location.getBuilding().equals("Frank E. Pilling Building"));
      assertTrue(location.getBuildingName().equals("15"));
      assertTrue(location.getRoom().equals("2344"));
      assertTrue(location.getCapacity() == 40);
      assertFalse(location.getEquipment());
   }

   @Test
   public void testDeleteLocation() {
      LocationDB db = new LocationDB();

      db.addLocation("Frank E. Pilling Building", "14", "234", "41", true);
      db.deleteLocation(db.getLocation(0));
   }
}
