
package models.admin.generation;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import models.admin.generation.Constraint.InvalidConstraintText;
import models.admin.generation.Range.RangeOutOfBoundsException;
import models.admin.generation.Range.StartAfterEndException;
/**
 * Test class for Constraint.java. It implements the following test plan:
 *                                                                        <ul>
 *                                                                      <p><li>
 *     Phase 1: Test valid simple lists of courses
 *                                                                      </p></li>
 *                                                                      <p><li>
 *     Phase 2: Test invalid simple lists of courses
 *                                                                      </p></li>
 *                                                                      <p><li>
 *     Phase 3: Test valid courses constraints with X in it, such as 3XX
 *                                                                      </p></li>
 *                                                                      <p><li>
 *     Phase 4: Test invalid courses constraints with X in it, such as 3XF
 *                                                                      </p></li>
 *                                                                      <p><li>
 *     Phase 5: Test valid courses with curly brace list, such as 3{2,1,3}X
 *                                                                      </p></li>
 *                                                                      <p><li>
 *     Phase 6: Test invalid courses with curly brace list, such as 3{B,1,2}X
 *                                                                      </p></li>
 *                                                                      <p><li>
 *     Phase 7: Test getConstraints() method which each type of constraint
 *                                                                      </p></li>
 *                                                                        </ul>
 * @author Chase Kragenbrink
 *
 */
public class ConstraintTest {
   
   /**
    * Unit test for simple valid constraint lists
    *                                                          <pre>
    *  Test
     *  Case    Input                    Output               Remarks
     * ==========================================================================
     *   1      "305, 309, 306"        Constraint.text =      Valid list of constraints
     *                                 305, 306, and 309 
     *                                 should not overlap
     *                                 
     *   2      "305, 309"             Constraint.text =      Valid list of constraints
     *                                 305 and 309 should 
     *                                 not overlap              </pre>
    * @throws StartAfterEndException 
    * @throws RangeOutOfBoundsException 
    */
   @Test
   public void testValidList() throws RangeOutOfBoundsException, StartAfterEndException {
      try {
         Constraint c = new Constraint("305, 309, 306");
         assertEquals("305, 306, and 309 should not overlap", c.getText());
      }
      catch (InvalidConstraintText e) {
         assertTrue(false);
      }
      
      try {
         Constraint c = new Constraint("305, 309");
         assertEquals("305 and 309 should not overlap", c.getText());
      }
      catch (InvalidConstraintText e) {
         assertTrue(false);
      }
   }
   
   /**
    * Unit test for simple invalid constraint lists
    *                                                          <pre>
    *  Test
     *  Case    Input                    Output             Remarks
     * ==========================================================================
     *   1      "305"                  Exception thrown     Constraint must have more 
     *                                                      than one entry
     *
     *   2      "305,309"              Exception thrown     Constraint list must have
     *                                                      a space after the commas
     *                                                   
     *   3      "305, 309, 305,        Exception thrown     No duplicates allowed
     *           207, 308, 410"                        
     *   
     *   4      ""                     Exception thrown     Cannot be an empty list
     *   
     *   5      "       "              Exception thrown     Cannot be an empty list
     *   
     *   6      "305, 309,"            Exception thrown     No extra commas allowed
     *   
     *   7      "305, 309, 309"        Exception thrown     No duplicates allowed
     *   
     *   8      "305, "                Exception thrown     No extra commas allowed
     *   
     *   9      "305, , 309"           Exception thrown     Must be list of integers
     *   
     *   10     "305, ,309 305"        Exception thrown     Must be a list of valid 
     *                                                      integers
     *   
     *   11     "305, 305"             Exception thrown     No duplicates
     *   
     *   12     "asdf, 334"            Exception thrown     Must be valid integers
     *   
     *   13     "asdfaobvhwoie"        Exception thrown     Must be valid integers
     *                                                                         </pre>
    * @throws StartAfterEndException 
    * @throws RangeOutOfBoundsException 
    */
   @Test
   public void testInvalidList() throws RangeOutOfBoundsException, StartAfterEndException {
      try {
         new Constraint("305");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("305,309");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }

      try {
         new Constraint("305, 309, 305, 207, 308, 410");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("      ");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("305, 309,");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("305, 309, 309");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("305, ");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("305, , 309");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("305, , 309");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("305, ,309 305");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("305, 305");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("asdf, 334");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("asdfaobvhwoie");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
   }
   
   /**
    * Unit tests for valid constrains in the form of "NXX"
    *                                                          <pre>
    *  Test
    *  Case    Input                    Output                                Remarks
    * ===============================================================================
    *   1      "3XX"  Constraint.text = 300-level courses should not overlap 
    *
    *   2      "38X"  Constraint.text = 380-level courses should not overlap
    *                                                        </pre>
    * @throws StartAfterEndException 
    * @throws RangeOutOfBoundsException 
    */
   @Test
   public void testValidXLevelNoCurlyBraces() throws RangeOutOfBoundsException, StartAfterEndException {
      String ending = "-level courses should not overlap";
      
      try {
         Constraint c = new Constraint("3XX");
         assertEquals("300" + ending, c.getText());
      }
      catch (InvalidConstraintText e) {
         assertTrue(false);
      }
      
      try {
         Constraint c = new Constraint("38X");
         assertEquals("380" + ending, c.getText());
      }
      catch (InvalidConstraintText e) {
         assertTrue(false);
      }
   }
   
   /**
    * Unit tests for invalid constraints in the form "NXX"
    *                                                          <pre>
    *  Test
    *  Case    Input               Output           Remarks
    * =============================================================================
    *   1      "X8X"               Exception thrown  First character must be 
    *                                                  an integer
    *                                               
    *
    *   2      "BXX"               Exception thrown  First character must be 
    *                                                  an integer
    *                                                  
    *   3      "2BX"               Exception thrown  Cannot contain other characters
    *                                               than X or integers
    *                                               
    *   4      "3XXX"              Exception thrown  Thousand-level courses not 
    *                                               supported.
    *                                                                         </pre>
    * @throws StartAfterEndException 
    * @throws RangeOutOfBoundsException 
    */
   @Test
   public void testInvalidXLevelNoCurlyBraces() throws RangeOutOfBoundsException, StartAfterEndException {
      try {
         new Constraint("X8X");
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("BXX");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("2BX");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("3XXX");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
   }
   
   /**
    * Unit tests for valid constraints in the form of "N{N,N,N}X"
    *                                                          <pre>
    *  Test
    *  Case    Input               Output           Remarks
    * =============================================================================
    *   1      "3{1,2,3}X"     Constraint.txt =         
    *                          "310s, 320s, and 330s should not overlap"                       
    *
    *   2      "3{3,1}X"       Constraint.txt = "330s and 310s should not overlap"                                      
    *                                               
    *   3      "3{1}X"         Constraint.txt = "310s should not overlap"
    *                                              
    *                                                                         </pre>
    * @throws StartAfterEndException 
    * @throws RangeOutOfBoundsException 
    */
   @Test
   public void testValidXLevelCurlyBraces() throws RangeOutOfBoundsException, StartAfterEndException {
      String ending = " should not overlap";
      
      try {
         Constraint c = new Constraint("3{1,2,3}X");
         assertEquals("310s, 320s, and 330s" + ending, c.getText());
      }
      catch (InvalidConstraintText e) {
         assertTrue(false);
      }
      
      try {
         Constraint c = new Constraint("3{3,1}X");
         assertEquals("330s and 310s" + ending, c.getText());
      }
      catch (InvalidConstraintText e) {
         assertTrue(false);
      }
      
      try {
         Constraint c = new Constraint("3{1}X");
         assertEquals("310s" + ending, c.getText());
      }
      catch (InvalidConstraintText e) {
         assertTrue(false);
      }
   }
   
   /**
    * Unit tests for invalid constraints in the form of "N{N,N,N}X"
    *                                                          <pre>
    *  Test
    *  Case    Input               Output           Remarks
    * =============================================================================
    *   1      "X{X,3,2}X"         Exception thrown  1st char must be an integer                                 
    *
    *   2      "3{1,1,2}X"         Exception thrown  No duplicates                                      
    *                                               
    *   3      "B{2,3,3}X"         Exception thrown  1st char must be an integer
    *   
    *   4      "3{2,3,4}XX"        Exception thrown  Thousand-level courses not 
    *                                               supported
    *                                               
    *   5      "2X{1,2,3}"         Exception thrown  Ones place not valid for
    *                                               curly brace list
    *                                               
    *   6      "3{F,2,3}X"         Exception thrown  All values in curly braces 
    *                                               must be integers
    *                                               
    *   7      "3{1,2 ,3}X"        Exception thrown  No spaces in curly brace list
    *   
    *   8      "3{X,X}X"           Exception thrown  Curly brace values must be ints
    *                                                                         </pre>
    * @throws StartAfterEndException 
    * @throws RangeOutOfBoundsException 
    */
   @Test
   public void testInvalidXLevelCurlyBraces() throws RangeOutOfBoundsException, StartAfterEndException {
      try {
         new Constraint("X{X,3,2}X");
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("3{1,1,2}X");
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("B{2,3,3}X");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("3{2,3,3}XX");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("2X{1,2,3}");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("3{F,2,3}X");
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("3{1,2 ,3}X");
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      try {
         new Constraint("3{X,X}X");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
   }
   /**
    * Unit tests for invalid constraints in the form of "N{N,N,N}X"
    * 
    *  Test
    *  Case    Input              Output            Remarks
    * =============================================================================
    *   1      "305, 309, 306"    none              List of 305, 309, 306                                 
    *
    *   2      "305, 309"         none              List of 305 and 309                                     
    *                                               
    *   3      "38X"              none              List from 380 to 389
    *   
    *   4      "3{1,2,3}X"        none              List from 310 to 339
    *   
    *   5      "300, 301"         Exception thrown   Sets ranges and notOverlapArr 
    *                                               to null which then getConstraints()
    *                                               will throw InvalidConstraintText
    *                                               
    *                                                                         </pre>
    * @throws InvalidConstraintText
    * @throws StartAfterEndException 
    * @throws RangeOutOfBoundsException 
    */
   @Test
   public void testGetConstraints() throws InvalidConstraintText, RangeOutOfBoundsException, StartAfterEndException {
      ArrayList<Integer> returnList;
      ArrayList<Integer> expected = new ArrayList<Integer>();
      
      Constraint simpleList = new Constraint("305, 309, 306");
      expected.add(305);
      expected.add(306);
      expected.add(309);
      returnList = simpleList.getConstraints();
      assertTrue(listsEqual(expected, returnList)); 
      expected.clear();
      
      Constraint listOfTwo = new Constraint("305, 309");
      expected.add(305);
      expected.add(309);
      returnList = listOfTwo.getConstraints();
      assertTrue(listsEqual(expected, returnList));
      expected.clear();
      
      Constraint xNoCurlyBraces = new Constraint("38X");
      for (int c = 380; c <= 389; c++) {
         expected.add(c);  
      }
      returnList = xNoCurlyBraces.getConstraints();
      assertTrue(listsEqual(expected, returnList));
      expected.clear();
      
      Constraint xCurlyBraces = new Constraint("3{1,2,3}X");
      for (int c = 310; c <= 339; c++) {
         expected.add(c);  
      }
      returnList = xCurlyBraces.getConstraints();
      assertTrue(listsEqual(expected, returnList));
      expected.clear();
      
      Constraint invalid = new Constraint("300, 301");
      invalid.ranges = null;
      invalid.notOverlapArr = null;
      try {
         returnList = invalid.getConstraints();
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
      
      expected.clear();
   }
   
   private boolean listsEqual(ArrayList<Integer> expected, ArrayList<Integer> returnList) {
      if (returnList.size() != expected.size())
         return false;
      
      for (int index = 0; index < expected.size(); index++) {
         if (!expected.get(index).equals(returnList.get(index)))
            return false;
      }
      return true;
   }
}