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
		   // database connection
		   Connection con = DriverManager.getConnection("jdbc:mysql://polyschedules.db."
		   		+ "9302206.hostedresource.com:3306/polyschedules", "polyschedules", 
		   		"a1RightCorner!");
		   // add statement
		   PreparedStatement pstmt = con.prepareStatement(
                   "INSERT INTO core_polyschedulesuser " +
                   "(`username`, `first_name`, `last_name`, `email`, `max_wtu`, " +
                   "`is_active_instructor`, `is_instructor`, `password`, `is_active`, "
                   + "`last_login`, `is_superuser`, `is_staff`, `date_joined`) "
				   + "VALUES( " +
                   "?, ?, ?, ?, ?, ?, ?, '!', 0, ?, 0, 0, ?)");
		   
		   pstmt.setString(1, instructor.username);
		   pstmt.setString(2, instructor.firstName);
		   pstmt.setString(3, instructor.lastName);
		   pstmt.setString(4, instructor.username + "@calpoly.edu");
		   pstmt.setInt(5, instructor.getWtu());
		   pstmt.setInt(6, instructor.getAct() ? 1 : 0);
		   pstmt.setInt(7, 1);
		   pstmt.setDate(8, new Date(new java.util.Date().getTime()));
		   pstmt.setDate(9, new Date(new java.util.Date().getTime()));
		   pstmt.addBatch();
		   pstmt.executeBatch();
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
	   try {
		   // connection to database
		   Connection con = DriverManager.getConnection("jdbc:mysql://polyschedules.db."
		   		+ "9302206.hostedresource.com:3306/polyschedules", "polyschedules", 
		   		"a1RightCorner!");
		   // wtu update query
		   String queryWTU = "UPDATE core_polyschedulesuser SET max_wtu = ?"
		   		+ " WHERE username = ?";
		   // active status update query
		   String queryActive = "UPDATE core_polyschedulesuser "
		   		+ "SET is_active_instructor = ? WHERE username = ?";
		   // wtu update statement
		   PreparedStatement updateWTU = con.prepareStatement(queryWTU);
		   // active status update statement
		   PreparedStatement updateActive = con.prepareStatement(queryActive);
		   
		   updateWTU.setInt(1, instructor.getWtu());
		   updateWTU.setString(2, instructor.getUser());
		   updateWTU.executeUpdate();
		   updateActive.setInt(1, instructor.getAct() ? 1 : 0);
		   updateActive.setString(2, instructor.getUser());
		   updateActive.executeUpdate();
	   } catch (SQLException exc) {
		   System.out.println("Could not connect to database. " + exc.getMessage());
	   }

	   setChanged();
	   notifyObservers();
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
	   try {
		   // connection to database
		   Connection con = DriverManager.getConnection("jdbc:mysql://polyschedules.db."
		   		+ "9302206.hostedresource.com:3306/polyschedules", "polyschedules",
		   		"a1RightCorner!");
		   // delete query
		   String queryDelete = "DELETE FROM core_polyschedulesuser WHERE username = ?";
		   // delete statement
		   PreparedStatement stmtDelete = con.prepareStatement(queryDelete);
		   
		   stmtDelete.setString(1, instructor.username);
		   stmtDelete.executeUpdate();
		   
		   setChanged();
		   notifyObservers();
	   } catch (SQLException exc) {
		   System.out.println("Could not connect to database. " + exc.getMessage());
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
	   // vector of instructors
	   instructors = new Vector<Instructor>();
	   
	   try {
		   // connection to database
		   Connection con = DriverManager.getConnection("jdbc:mysql://polyschedules.db."
		   		+ "9302206.hostedresource.com:3306/polyschedules", "polyschedules",
		   		"a1RightCorner!");
		   // select statement
		   Statement stmt = con.createStatement();
		   // select query
		   String query = "SELECT * FROM core_polyschedulesuser WHERE is_instructor = 1";
		   // result set from query
		   ResultSet rs = stmt.executeQuery(query);
		   
		   while (rs.next()) {
			   // first name of instructor
			   String firstName = rs.getString("first_name");
			   // last name of instructor
			   String lastName = rs.getString("last_name");
			   // username of instructor
			   String username = rs.getString("username");
			   // instructor active status
			   boolean active = rs.getBoolean("is_active_instructor");
			   // instructor's maximum wtu
			   int wtu = rs.getInt("max_wtu");
			   
			   instructors.add(new Instructor(firstName, lastName, username, wtu, active));
		   }
	   } catch (SQLException exc) {
		   System.out.println("Could not connect to database. " + exc.getMessage());
	   }
	   return instructors;
   }
}
