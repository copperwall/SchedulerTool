
package models.admin.generation;

import models.admin.generation.Constraint.InvalidConstraintText;

/**
 * 
 * @author Chase Kragenbrink
 *
 */
public class ConstraintTest {
   public ConstraintTest() {
      try {
         Constraint c = new Constraint("Wow");
      }
      catch (InvalidConstraintText e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}