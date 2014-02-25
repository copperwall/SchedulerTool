package models.data.databases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Observable;
import java.util.Vector;

/**
 * Holds the instructor information for all instructors
 * @author Calvin Elizan (celizan)
 */

public class InstructorDB extends Observable{
   /** vector containing all of the instructors **/
   public Vector<Instructor> instructors;
   
   /**
    * Instantiates an InstructorDB
    */
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
	   
	   try {
		   Connection con = DriverManager.getConnection("jdbc:mysql://polyschedules.db.9302206.hostedresource.com:3306/polyschedules", "polyschedules", "a1RightCorner!");
		   PreparedStatement pstmt = con.prepareStatement(
                   "INSERT INTO core_polyschedulesuser " +
                   "(`username`, `first_name`, `last_name`, `email`, `max_wtu`, " +
                   "`is_active_instructor`, `is_instructor`, `password`, `last_login`,"
                   + "`is_superuser`, `is_staff`, `is_active`)" +
				   "VALUES( " +
                   "?, ?, ?, ?, ?, ?, ?, 'temp', ?, 0, 0, ?, ?)");
		   pstmt.setString(1, instructor.username);
		   pstmt.setString(2, instructor.firstName);
		   pstmt.setString(3, instructor.lastName);
		   pstmt.setString(4, instructor.username + "@calpoly.edu");
		   pstmt.setInt(5, instructor.getWtu());
		   pstmt.setInt(6, instructor.getAct() ? 1 : 0);
		   pstmt.setInt(7, 1);
		   pstmt.setDate(8, new Date((new java.util.Date()).getTime()));
		   pstmt.setInt(9, instructor.getAct() ? 1 : 0);
		   pstmt.setDate(10, new Date((new java.util.Date()).getTime()));
		   pstmt.addBatch();
		   int [] updateCounts = pstmt.executeBatch();
		   con.commit();
	   } catch (SQLException exc) {
		   System.out.println("Could not connect to database. " + exc.getMessage());
	   }
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
	   // reference to the instructor that needs to be edited
	   Instructor instructorToEdit = null;
	   
	   // find instructor that needs to be edited
	   for(Instructor item : instructors) {
		   if (item.getUser().compareTo(instructor.getUser()) == 0) {
			   instructorToEdit = item;
			   break;
		   }
	   }
	   // edit the instructor or add it in if it isn't in the list
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
	   /* reference to the instructor that matches the given instructor */
	   Instructor instructorToDelete = null;
	   
	   // finds the instructor whose name matches the given one
	   for(Instructor item : instructors) {
		   if (item.getUser().compareTo(instructor.getUser()) == 0) {
			   instructorToDelete = item;
			   break;
		   }
	   }
	   // if the instructor was found, update
	   if (instructorToDelete != null) {
		   instructors.remove(instructorToDelete);
		   setChanged();
		   notifyObservers();
	   }
   }
   
   /**
    * Gets a vector of instructors that represents all of the ones in the database
    * @return a Vector with all of the instructors
    */
   /*@
      ensures 
      // All instructors in the database are in the result
      \result.containsAll(instructors);
    @*/
   public Vector<Instructor> getAllInstructors() {
	   instructors = new Vector<Instructor>();
	   
	   try {
		   Connection con = DriverManager.getConnection("jdbc:mysql://polyschedules.db.9302206.hostedresource.com:3306/polyschedules", "polyschedules", "a1RightCorner!");
		   Statement stmt = con.createStatement();
		   String query = "SELECT * FROM core_polyschedulesuser WHERE is_instructor = 1";
		   ResultSet rs = stmt.executeQuery(query);
		   while (rs.next()) {
			   String firstName = rs.getString("first_name");
			   String lastName = rs.getString("last_name");
			   String username = rs.getString("username");
			   boolean active = rs.getBoolean("is_active_instructor");
			   int wtu = rs.getInt("max_wtu");
			   instructors.add(new Instructor(firstName, lastName, username, wtu, active));
		   }
	   } catch (SQLException exc) {
		   System.out.println("Could not connect to database. " + exc.getMessage());
	   }
	   return instructors;
   }
}
