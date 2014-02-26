
package models.admin.generation;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import models.admin.generation.Constraint.InvalidConstraintText;

/**
 * 
 * @author Chase Kragenbrink
 *
 */
public class ConstraintTest {
   
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
   
   @Test
   public void testInvalidXLevelNoCurlyBraces() {
      String ending = "-level courses should not overlap";

      try {
         Constraint c = new Constraint("X8X");
         assertEquals("080" + ending, c.getText());
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
         new Constraint("B{2,3,3}XX");
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
         new Constraint("3XXX");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
   }
   
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
      
      Constraint invalid = new Constraint("3{1,2,3}X");
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