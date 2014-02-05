package models.data.databases;

import java.util.Collection;
import java.util.Observable;
import java.util.Vector;

/**
 * Holds the instructor information for all instructors
 */

public class InstructorDB extends Observable{
   public Vector<Instructor> instructors;
   
   public InstructorDB() {
	   instructors = new Vector<Instructor>();
   }
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
	   instructors.add(instructor);
	   setChanged();
	   notifyObservers();
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
	   Instructor instructorToEdit = null;
	   for(Instructor item : instructors) {
		   if (item.getUser().compareTo(instructor.getUser()) == 0) {
			   instructorToEdit = item;
			   break;
		   }
	   }
	   if (instructorToEdit != null) {
		   instructorToEdit.setWtu(instructor.getWtu());
		   instructorToEdit.setAct(instructor.getAct());
		   setChanged();
		   notifyObservers();
	   } else {
		   this.addInstructor(instructor);
	   }
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
	   Instructor instructorToDelete = null;
	   for(Instructor item : instructors) {
		   if (item.getUser().compareTo(instructor.getUser()) == 0) {
			   instructorToDelete = item;
			   break;
		   }
	   }
	   if (instructorToDelete != null) {
		   instructors.remove(instructorToDelete);
		   setChanged();
		   notifyObservers();
	   } else {
		   this.addInstructor(instructor);
	   }
   }
   
   public void save() {
       System.out.println("InstructorDB.save");
   }
   
   public Vector<Instructor> getAllInstructors() {
	   return instructors;
   }
}
