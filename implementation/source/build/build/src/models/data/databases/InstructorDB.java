package models.data.databases;

import java.util.Collection;

/**
 * Holds the instructor information for all instructors
 */

public class InstructorDB{
   public Collection<Instructor> instructors;
   
   /**
    * Gets an instructor 
    * @return an Instructor object given their username
    */
   /*@
      requires username != null && username.length() > 2;
      ensures \result.username.equals(username);
    @*/
   public Instructor getInstructor(String username) {
       System.out.println("InstructorDB.getInstructor");
       return new Instructor();
   }

   /**
    * Adds the given instructor to the database.
    */
   /*@
     requires instructor != null;
     ensures instructors.containsAll(\old(instructors)) && 
       instructors.contains(instructor);
     // Ensures that none of the old entries are touched and that instructors
     // contains the newly added instructor
    @*/
   public void addInstructor(Instructor instructor) {
       System.out.println("InstructorDB.addInstructor");
   }
   
   /**
    * Changes the properties of the instructor whose name matches the one in
    * the given instructor to those of the given instructor.
    */
   /*@
     requires instructor != null;
     ensures
     // Ensures that all of the instructors are either from the old set of
     // instructors or it has been edited.
     (\forall Instructor i; instructors.contains(i);
       \old(instructors).contains(i) || i.equals(instructor)) &&
       instructors.contains(instructor);
    @*/
   public void editInstructor(Instructor instructor) {
       System.out.println("InstructorDB.editInstructor");
   }
   
   /**
    * Deletes the instructor whose name matches that of the given instructor
    */
   /*@
      // Ensures that the section that matches courseNum gets removed from
      // the list of courses
      ensures !instructors.contains(instructor);
    @*/
   public void deleteInstructor(Instructor instructor) {
       System.out.println("InstructorDB.deleteInstructor");
   }
   
   public void save() {
       System.out.println("InstructorDB.save");
   }
}
