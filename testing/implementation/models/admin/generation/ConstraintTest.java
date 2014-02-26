
package models.admin.generation;

import static org.junit.Assert.*;

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
         Constraint c = new Constraint("X{X,3,2}X");
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
         new Constraint("3XXX");
         assertTrue(false);
      }
      catch (InvalidConstraintText e) {
         assertTrue(true);
      }
   }
}