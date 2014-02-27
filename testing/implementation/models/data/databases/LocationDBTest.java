package models.data.databases;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Vector;
import models.data.databases.Location;
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
   protected void testConstructor() {
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
    */

   @Test
   protected void testValidateBuilding() {
      LocationDB db = new LocationDB();
      boolean flag = false;

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
         Object o = method.invoke(db, "1111111111111111111111111111111111111111111111111111111111111111111111");
      }
      catch (RuntimeException e) {
         /* Success */
         flag = true;
      }
      finally {
         assertTrue(flag);
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
    */

   @Test
   protected void testValidateRoom() {
      LocationDB db = new LocationDB();
      boolean flag = false;

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
         /* Success */
         flag = true;
      }
      finally {
         assertTrue(flag);
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
    */

   @Test
   protected void testValidateCapacity() {
      LocationDB db = new LocationDB();
      boolean flag = false;

      Method method = LocationDB.class.getDeclaredMethod("validateCapacity", Integer.class);

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
         flag = true;
      }
      finally {
         assertTrue(flag);
      }
         
   }

   /**
    * Unit test the equipment validation method.
    * 
    * Test
    * Case  Input          Output            Remarks
    * ==============================================================
    * 1     true           None              Expects no exceptions
    */

   @Test
   protected void testValidateEquipment() {
      LocationDB db = new LocationDB();

      Method method = LocationDB.class.getDeclaredMethod("validateEquipment", Boolean.class);

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
   protected void testGetAllLocations() {
      LocationDB db = new LocationDB();
      Vector<Location> location = db.getAllLocations();
      assertTrue(true);
   }

   @Test
   protected void testAddLocation() {
      LocationDB db = new LocationDB();
      Vector<Location> locations = db.getAllLocations();

      assertTrue(locations.size() == 0);

      db.addLocation("14", "234", "41", true);

      locations = db.getAllLocations();

      assertTrue(locations.size() == 1);
   }

   @Test
   protected void testGetLocation() {
      LocationDB db = new LocationDB();

      db.addLocation("14", "234", "41", true);
      Location location = db.getLocation(1);

      assertTrue(location.building.equals("14"));
      assertTrue(location.room.equals("234"));
      assertTrue(location.capacity == 41);
      assertTrue(location.equipment);
   }

   @Test
   protected void testEditLocation() {
      LocationDB db = new LocationDB();
      Vector<Location> locations = db.getAllLocations();

      db.addLocation("14", "234", "41", true);
      Location location = db.getLocation(1);
      Location two = new Location("15", "2344", "40", false);

      db.editLocation(location, two);

      location = db.getLocation(1);

      assertTrue(location.building.equals("15"));
      assertTrue(location.room.equals("2344"));
      assertTrue(location.capacity == 40);
      assertFalse(location.equipment);
   }

   @Test
   protected void testDeleteLocation() {
      LocationDB db = new LocationDB();

      db.addLocation("14", "234", "41", true);
      db.removeLocation(1);
   }
}
