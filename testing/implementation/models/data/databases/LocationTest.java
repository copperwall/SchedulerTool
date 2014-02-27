package models.data.databases;
import static org.junit.Assert.*;

import org.junit.Test;

/****
 *
 * Class LocationTest is the companion testing class for <a href='Location.html'>Location</a>. It implements the following module test plan:
 *
 *
 *    Phase 1: Unit test the constructor
 *    Phase 2: Unit test the access methods get*
 *    Phase 3: Unit test the access methods set*
 */

@Test
public class LocationTest {
   /**
    * Unit test the constructor by building multiple Locations.
    *
    * Test
    * Case  Input                Output            Remarks
    * ========================================================
    * 1     Correct type input   Successful init   Only test
    */

    @Test
    protected void testConstructor() {
      Location location;

      try {
         location = new Location("14", "234B", 40, true);
      }
      catch (Exception e) {
         /* This should never happen */
         assertTrue(false);
      }
    }

   /**
    * Unit test the building access method.
    *
    * Test
    * Case  Input                Output            Remarks
    * =======================================================================
    * 1     String: "14"         None              Asserts result == expected
    */

    @Test(dependsOnMethods = {"testConstructor"})
    protected void testGetBuilding() {
      Location location = new Location("14", "234B", 40, true);

      String result = location.getBuilding();

      assertTrue(result.equals("14"));
    }

   /**
    * Unit test the room access method.
    *
    * Test
    * Case  Input                Output            Remarks
    * =======================================================================
    * 1     String: "234B"       None              Asserts output == expected
    */

    @Test(dependsOnMethods = {"testConstructor"})
    protected void testGetRoom() {
      Location location = new Location("14", "234B", 40, true);

      String result = location.getRoom();

      assertTrue(result.equals("234B"));
    }

   /**
    * Unit test the capacity access method.
    *
    * Test
    * Case  Input                Output            Remarks
    * =======================================================================
    * 1     Integer: 40          None              Asserts output == expected
    */

    @Test(dependsOnMethods = {"testConstructor"})
    protected void testGetCapacity() {
      Location location = new Location("14", "234B", 40, true);

      int result = location.getCapacity();

      assertTrue(result == 40);
    }

   /**
    * Unit test the equipment access method.
    *
    * Test
    * Case  Input                Output            Remarks
    * =======================================================================
    * 1     boolean: true        None              Asserts output == expected
    */

    @Test(dependsOnMethods = {"testConstructor"})
    protected void testGetEquipment() {
      Location location = new Location("14", "234B", 40, true);

      boolean result = location.getEquipment();

      assertTrue(result);
    }

    @Test(dependsOnMethods = {"testConstructor", "testGetBuilding", 
     "testGetRoom", "testGetCapacity", "testGetEquipment"}
    protected void testSetBuilding() {
      Location location = new Location("14", "312", 100, false);

      location.setBuilding("52");

      assertTrue(location.getBuilding().equals("52"));
    }

    @Test(dependsOnMethods = {"testConstructor", "testGetBuilding", 
     "testGetRoom", "testGetCapacity", "testGetEquipment"}
    protected void testSetRoom() {
      Location location = new Location("14", "312", 100, false);

      location.setRoom("250");

      assertTrue(location.getRoom().equals("250"));
    }

    @Test(dependsOnMethods = {"testConstructor", "testGetBuilding", 
     "testGetRoom", "testGetCapacity", "testGetEquipment"}
    protected void testSetCapacity() {
      Location location = new Location("14", "312", 100, false);
      
      location.setCapacity(23);

      assertTrue(location.getCapacity() == 23);
    }

    @Test(dependsOnMethods = {"testConstructor", "testGetBuilding", 
     "testGetRoom", "testGetCapacity", "testGetEquipment"}
    protected void testSetEquipment() {
      Location location = new Location("14", "312", 100, false);
      
      location.setEquipment(false);

      assertFalse(location.getEquipment());
    }
}
