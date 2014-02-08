package models.data.databases;

import java.util.*;

/**
 * Contains all Courses. Add/edit/delete course
 * are available.
 * @author Katie Keim
 */
public class CourseDB extends Observable{
   public Vector<Course> courses;
   
   /**
     * CourseDB constructor
     */
   public CourseDB() {
      courses = new Vector<Course>();
      
      setChanged();
	  notifyObservers();
   }
   
   /**
    * Returns the course whose course number matches courseNum.
    */
   /*@
     requires courseNum > 0 && dept != null && dept.length() > 0;
     ensures \old(courses).equals(courses);
     // Ensures courses hasn't changed since calling this method.
    @*/
   public Course getCourse(int courseNum, String dept) {
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
    */
   /*@
     requires course != null;
     ensures courses.containsAll(\old(courses)) && 
       courses.contains(course);
     // Ensures that none of the old entries are touched and that courses
     // contains the course to be added
    @*/
   public void addCourse(String prefix, int courseNum, boolean hasLab, int units, String title, int labLength, Course.LabProximity labProx) {
      courses.add(new Course(prefix, courseNum, hasLab, units, title, labLength, labProx));
      
      setChanged();
	  notifyObservers();
   }
   /**
    * Edits the course whose course number matches course's course number
    * and changes the other properties to match.
    */
   /*@
     requires course != null;
     ensures
     // Ensures that all of the courses are either from the old set of
     // courses, an edited course, or a new course that was added.
     (\forall Course c; courses.contains(c);
       \old(courses).contains(c) || c.equals(course)) &&
     courses.contains(course);
    @*/
   public void editCourse(String prefix, int courseNum, boolean hasLab, int units, String title, int labLength, Course.LabProximity labProx) {
      Course curCourse = null;
      
      for (Course course : courses) {
         if (course.matchCourse(courseNum, prefix)) {
            curCourse = course;
         }
      }
      
      if (curCourse != null) {
    	  curCourse.setNewData(hasLab, units, title, labLength, labProx);
      }
      
      setChanged();
	  notifyObservers();
   }
   /**
    * Deletes the course whose course num matches courseNum.
    */
   /*@
     requires (* none yet *);
     ensures
     // Ensures that the course that matches courseNum gets removed from
     // the list of courses
     (\forall Course c; c.matchCourseNum(courseNum);
       !courses.contains(c));
    @*/
   public void deleteCourse(Course course) {
      courses.remove(course);
      
      setChanged();
	  notifyObservers();
   }
   
   public Vector<Course> getAllCourses() {
      return courses;
   }

	public void addCourse(String prefix, int courseNum, boolean hasLab, int units, String title) {
		courses.add(new Course(prefix, courseNum, hasLab, units, title));
	      
       setChanged();
	   notifyObservers();
	}
	
	public void editCourse(String prefix, int courseNum, boolean hasLab, int units, String title) {
		 Course curCourse = null;
	      
	      for (Course course : courses) {
	         if (course.matchCourse(courseNum, prefix)) {
	            curCourse = course;
	         }
	      }
	      
	      if (curCourse != null) {
	    	  curCourse.setNewData(hasLab, units, title, 0, null);
	      }    
	      
       setChanged();
	   notifyObservers();
	}
}
