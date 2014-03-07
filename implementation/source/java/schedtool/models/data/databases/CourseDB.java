package models.data.databases;

import java.util.*;

/**
 * A database class which maintains a list of all Courses. 
 * The user can add, edit, or delete a course.
 * It is Observable for a data table.
 * @author Katie Keim
 */
public class CourseDB extends Observable{
   /** The list of courses to maintain. */
   public Vector<Course> courses;
   
   /**
     * CourseDB constructor.
     */
   
   /*@
      requires ( *nothing* );
      ensures (courses != null);
   @*/
   public CourseDB() {
      courses = new Vector<Course>();
      
      setChanged();
	  notifyObservers();
   }
   
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
      System.out.println("Got a course.");
      
      for (Course course : courses) {
         if (course.matchCourse(courseNum, dept)) {
            return course;
         }
      }
      
      return null;
   }
   
   /**
    * Adds course to the course database.
    * @param prefix the course's department prefix
    * @param courseNum the course's id number
    * @param hasLab whether the course has a lab
    * @param units the number of units of the course
    * @param title the title of the course
    * @param labLength the length of the lab
    * @param labProx the proximity of lab to lecture
    */
   /*@
     requires courses != null && prefix != null && title != null;
     ensures courses.containsAll(\old(courses)) && 
       courses.contains(course);
     // Ensures that none of the old entries are touched and that courses
     // contains the course to be added
    @*/
   public void addCourse(String prefix, int courseNum, int units, String title, boolean hasEquip, int labLength, Course.LabProximity labProx, boolean labHasEquip) {
      Course course = new Course(prefix, courseNum, units,  title, hasEquip, labLength, labProx, labHasEquip);
	  courses.add(course);
      
      setChanged();
	  notifyObservers();
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
      courses.add(course);
      
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
      int index = courses.indexOf(oldCourse);
      Course course = new Course(prefix, courseNum, units, title, hasEquip, labLength, labProx, labHasEquip);

      if (index > 0 && index < courses.size()) {
    	  courses.setElementAt(course, index);
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
      courses.remove(course);
      
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
   public Vector<Course> getAllCourses() {
      return courses;
   }
}
