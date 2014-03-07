package models.data.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import java.util.ArrayList;

/**
 * A database class which maintains a list of all Courses. 
 * The user can add, edit, or delete a course.
 * It is Observable for a data table.
 * @author Katie Keim
 */
public class CourseDB extends Observable{  
   /**
    * Returns the course whose course number matches the courseNum and dept prefix.
    * @param courseNum the number of the course to match
    * @param dept the department prefix of the course to match
    * @return the course matching the dept prefix and course number
    */
   /*@
     requires courses != null && dept != null;
     ensures \old(courses).equals(courses);
    @*/
   public Course getCourse(String dept, int courseNum) {
	   ArrayList<Course> courses = getAllCourses();
	   Course correctCourse = null;
	   
	   for (Course course : courses)
	   {
	       if (course.getPrefix().equals(dept) && courseNum == course.getCourseNum()) {
	    	   correctCourse = course;
	       }    	  
       }
               
       return correctCourse; 
   }
   
   /**
    * Adds course to the course database.
    * @param course the new course to be added
    */
   /*@
     requires courses != null && course != null;
     ensures courses.containsAll(\old(courses)) && 
       courses.contains(course);
     // Ensures that none of the old entries are touched and that courses
     // contains the course to be added
    @*/
   public void addCourse(Course course) {
	   try {
           // connection to database
           Connection con = DriverManager.getConnection(
                   "jdbc:mysql://polyschedules.db."
                           + "9302206.hostedresource.com:3306/polyschedules",
                   "polyschedules", "a1RightCorner!");
        // add statement
           PreparedStatement pstmt = con
                   .prepareStatement("INSERT INTO schedules_course"
                           + "(`prefix`, `number`, `title`, `units`, `requires_equipment`, "
                           + "`has_lab`, `lab_requires_equipment`, `lab_length`, `lab_time_proximity`)"
                           + "VALUES( "
                           + course.getPrefix() + ", " 
                           + course.getCourseNum() + ", " 
                           + course.getTitle() + ", " 
                           + course.getUnits() + ", " 
                           + (course.getHasEquipment() ? 1 : 0) + ", "
                           + (course.getHasLab() ? 1 : 0) + ", "
                           + (course.getLabHasEquipment() ? 1 : 0) + ", "
                           + course.getLabLength() + ", "
                           + course.getLabProx() + ")");
           pstmt.addBatch();
           pstmt.executeBatch();
       }
       catch (SQLException exc) {
           System.err
                   .println("CourseDB Add: Could not add to database.\n\t"
                           + exc.getMessage());
       }

      setChanged();
	  notifyObservers();
   }

   /**
    * Edits the course whose course number matches course's course number
    * and changes the other properties to match.
    * @param prefix the course's department prefix to match
    * @param courseNum the course's id number to match
    * @param hasLab whether the course has a lab
    * @param units the number of units of the course
    * @param title the title of the course
    * @param labLength the length of the lab
    * @param labProx the proximity of lab to lecture
    */
   /*@
     requires courses != null && oldCourse != null && prefix != null && title != null && courses.contains(oldCourse);
     ensures
     // Ensures that all of the courses are either from the old set of
     // courses, an edited course, or a new course that was added.
     (\forall Course c; courses.contains(c);
       \old(courses).contains(c) || c.equals(course)) &&
     courses.contains(course);
    @*/
   public void editCourse(Course oldCourse, String prefix, int courseNum, int units, String title, boolean hasEquip, int labLength, Course.LabProximity labProx, boolean labHasEquip) {
      try {
	      // connection to database
	      Connection con = DriverManager.getConnection(
	              "jdbc:mysql://polyschedules.db."
	                      + "9302206.hostedresource.com:3306/polyschedules",
	              "polyschedules", "a1RightCorner!");
	      
	      PreparedStatement pstmt = con.prepareStatement(
	      "UPDATE schedules_course" +
	      " SET prefix = '" + prefix + "', " +
	      " SET number = " + courseNum + ", " +
	      " SET units = " + units + ", " +
	      " SET title = '" + title + "', " +
	      " SET has_lab = " + (labProx != null ? 1 : 0) + ", " +
	      " SET requires_equipment = " + (hasEquip ? 1 : 0) + ", " +
	      " SET lab_length = " + labLength + ", " +
	      " SET lab_proximity = " + labProx + ", " +
	      " SET lab_requires_equipment = " + (labHasEquip ? 1 : 0) + ", " +
	      "WHERE `prefix` = " + oldCourse.getPrefix() + " AND `number` = " + oldCourse.getCourseNum());
	      
	      pstmt.addBatch();
	      pstmt.executeBatch();
      }
      catch (SQLException exc) {
           System.err.println("CourseDB Add: Could not add to database.\n\t" + exc.getMessage());
	  }

      setChanged();
	  notifyObservers();
   }
   /**
    * Deletes the given course.
    * @param course the course to delete
    */
   /*@
     requires courses != null && course != null && courses.contains(course);
     ensures
     // Ensures that the course that matches course gets removed from
     // the list of courses
       !courses.contains(course));
    @*/
   public void deleteCourse(Course course) {
      try {
	      // connection to database
	      Connection con = DriverManager.getConnection(
	              "jdbc:mysql://polyschedules.db."
	                      + "9302206.hostedresource.com:3306/polyschedules",
	              "polyschedules", "a1RightCorner!");
	      
	      PreparedStatement pstmt = con.prepareStatement(
	      "DELETE FROM schedules_course " +
	      "WHERE `prefix` = " + course.getPrefix() + " AND `number` = " + course.getCourseNum());
	      
	      pstmt.addBatch();
	      pstmt.executeBatch();
      }
      catch (SQLException exc) {
           System.err.println("CourseDB Add: Could not add to database.\n\t" + exc.getMessage());
	  }
      
      setChanged();
	  notifyObservers();
   }
   
   /**
    * Gets the list of courses for the data table.
    * @return the list of courses for the data table.
    */
   /*@
    * requires courses != null; 
    * ensures \return != null;
   @*/
   public ArrayList<Course> getAllCourses() {
	  Course course;
	  ArrayList<Course> courses = new ArrayList<Course>();
	   
      try {
	     // connection to database
         Connection con = DriverManager.getConnection(
                   "jdbc:mysql://polyschedules.db."
                           + "9302206.hostedresource.com:3306/polyschedules",
                   "polyschedules", "a1RightCorner!");
           // select statement
           Statement stmt = con.createStatement();
           // select query
           String query = "SELECT * FROM schedules_course";
           // result set from query
           ResultSet rs = stmt.executeQuery(query);

           while (rs.next()) {
               String prefix = rs.getString("prefix");
               int number = rs.getInt("number");
               String title = rs.getString("title");
               int units = rs.getInt("units");
               boolean hasEquip = rs.getBoolean("requires_equipment");
               boolean hasLab = rs.getBoolean("has_lab");
               boolean labHasEquip = rs.getBoolean("lab_requires_equipment");
               double labLength = rs.getDouble("lab_length");
               Course.LabProximity labProx = Course.LabProximity.values()[rs.getInt("lab_time_proximity")];

        	  if (hasLab) {
                 course = new Course(prefix, number, units, title, hasEquip, (int)labLength, labProx, labHasEquip);
        	  }
        	  else {
        		 course = new Course(prefix, number, units, title, hasEquip, 0, null, false);
        	  }
        	  
        	  courses.add(course);
           }
	  }
	  catch (SQLException exc) {
	       System.err.println("CourseDB Add: Could not add to database.\n\t" + exc.getMessage());
	  } 
	   
      return courses;
   }
}
