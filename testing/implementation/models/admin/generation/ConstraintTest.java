
package models.admin.generation;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import models.admin.generation.Constraint.InvalidConstraintText;
/**
 * Test class for <a href="Constraint.html">Instructor</a>. It implements the
 * following test plan:
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
     *  Case    Input                    Output             Remarks
     * ==========================================================================
     *   1      "305, 309, 306"        none             Valid list of constraints
     *
     *           
     *   2      "305, 309"             none             Valid list of constraints
     *                                                                         </pre>
    */
   @Test
   public void testValidList() {
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
     *   1      "305"                  none             Constraint must have more 
     *                                                   than one entry
     *
     *   2      "305,309"              none             Constraint list must have
     *                                                   a space after the commas
     *                                                   
     *   3      "305, 309, 305,        none             No duplicates allowed
     *           207, 308, 410"                        
     *   
     *   4      ""                     none             Cannot be an empty list
     *   
     *   5      "       "              none             Cannot be an empty list
     *   
     *   6      "305, 309,"            none             No extra commas allowed
     *   
     *   7      "305, 309, 309"        none             No duplicates allowed
     *   
     *   8      "305, "                none             No extra commas allowed
     *   
     *   9      "305, , 309"           none             Must be list of integers
     *   
     *   10     "305, ,309 305"        none             Must be a list of valid 
     *                                                  integers
     *   
     *   11     "305, 305"             none             No duplicates
     *   
     *   12     "asdf, 334"            none             Must be valid integers
     *   
     *   13     "asdfaobvhwoie"        none             Must be valid integers
     *                                                                         </pre>
    */
   @Test
   public void testInvalidList() {
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
    *  Case    Input                    Output             Remarks
    * ==========================================================================
    *   1      "3XX"                  none             300-level courses should 
    *                                                  not overlap
    *
    *   2      "38X"                  none             380-level courses should
    *                                                  not overlap
    *                                                        </pre>
    */
   @Test
   public void testValidXLevelNoCurlyBraces() {
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
    *   1      "X8X"               none             First character must be 
    *                                                  an integer
    *                                               
    *
    *   2      "BXX"               none             First character must be 
    *                                                  an integer
    *                                                  
    *   3      "2BX"               none             Cannot contain other characters
    *                                               than X or integers
    *                                               
    *   4      "3XXX"              none             Thousand-level courses not 
    *                                               supported.
    *                                                                         </pre>
    */
   @Test
   public void testInvalidXLevelNoCurlyBraces() {
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
    *   1      "3{1,2,3}X"         none             310s, 320s, and 330s should not
    *                                               overlap                                 
    *
    *   2      "3{3,1}X"           none             330s and 310s should not overlap                                      
    *                                               
    *   3      "3{1}X"             none             310s should not overlap
    *                                              
    *                                                                         </pre>
    */
   @Test
   public void testValidXLevelCurlyBraces() {
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
    *   1      "X{X,3,2}X"         none             1st char must be an integer                                 
    *
    *   2      "3{1,1,2}X"         none             No duplicates                                      
    *                                               
    *   3      "B{2,3,3}X"         none             1st char must be an integer
    *   
    *   4      "3{2,3,4}XX"        none             Thousand-level courses not 
    *                                               supported
    *                                               
    *   5      "2X{1,2,3}"         none             Ones place not valid for
    *                                               curly brace list
    *                                               
    *   6      "3{F,2,3}X"         none             All values in curly braces 
    *                                               must be integers
    *                                               
    *   7      "3{1,2 ,3}X"        none             No spaces in curly brace list
    *   
    *   8      "3{X,X}X"           none             Curly brace values must be ints
    *                                                                         </pre>
    */
   @Test
   public void testInvalidXLevelCurlyBraces() {
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
    *   5      "300, 301"         none              Sets ranges and notOverlapArr 
    *                                               to null which then getConstraints()
    *                                               will throw InvalidConstraintText
    *                                               
    *                                                                         </pre>
    * @throws InvalidConstraintText
    */
   @Test
   public void testGetConstraints() throws InvalidConstraintText {
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