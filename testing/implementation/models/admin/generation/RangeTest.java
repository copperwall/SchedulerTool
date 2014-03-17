package models.admin.generation;
import static org.junit.Assert.*;
import models.admin.generation.Range.RangeOutOfBoundsException;
import models.admin.generation.Range.StartAfterEndException;

import org.junit.Test;

public class RangeTest {
   
   /**
    * Unit tests for Range.java. 
    *                              <pre>
    *  Test
    *  Case    Input         Output  Remarks
    * ================================================================
    *   1      (300, 309)    None    Valid Range
    *   2      (99, 300)     None    Start off by one (lower bound)
    *   3      (0, 300)      None    Start way off    (lower bound)
    *   4      (1000, 300)   None    Start off by one (upper bound)
    *   5      (5000, 300)   None    Start way off    (upper bound)
    *   6      (300, 99)     None    End off by one   (lower bound)
    *   7      (300, 0)      None    End way off      (lower bound)
    *   8      (300, 1000)   None    End off by one   (upper bound)
    *   9      (300, 5000)   None    End way off      (upper bound)
    *   10     (400, 300)    None    Start greater than end
    *                 </pre>
    */
   @Test
   public void testConstructor() throws RangeOutOfBoundsException, StartAfterEndException {
      Range r = new Range(300, 309);
      assertTrue(r.start == 300 && r.end == 309);
      
      try {
         r = new Range(99, 300);
         assertTrue(false);
      }
      catch (RangeOutOfBoundsException e) {
         assertTrue(true);
      }
      
      try {
         r = new Range(0, 300);
         assertTrue(false);
      }
      catch (RangeOutOfBoundsException e) {
         assertTrue(true);
      }
      
      try {
         r = new Range(1000, 300);
         assertTrue(false);
      }
      catch (RangeOutOfBoundsException e) {
         assertTrue(true);
      }
      
      try {
         r = new Range(5000, 300);
         assertTrue(false);
      }
      catch (RangeOutOfBoundsException e) {
         assertTrue(true);
      }
      
      try {
         r = new Range(300, 99);
         assertTrue(false);
      }
      catch (RangeOutOfBoundsException e) {
         assertTrue(true);
      }
      
      try {
         r = new Range(300, 0);
         assertTrue(false);
      }
      catch (RangeOutOfBoundsException e) {
         assertTrue(true);
      }
      
      try {
         r = new Range(300, 1000);
         assertTrue(false);
      }
      catch (RangeOutOfBoundsException e) {
         assertTrue(true);
      }
      
      try {
         r = new Range(300, 5000);
         assertTrue(false);
      }
      catch (RangeOutOfBoundsException e) {
         assertTrue(true);
      }
      
      try {
         r = new Range(400, 300);
         assertTrue(false);
      }
      catch (StartAfterEndException e) {
         assertTrue(true);
      }
   }
}
