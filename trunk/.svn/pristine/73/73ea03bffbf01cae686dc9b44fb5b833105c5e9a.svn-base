package data;

import java.util.Collection;

/**
 * Contains all Courses. Add/edit/delete course
 * are available.
 */
public abstract class CourseDB {
   public Collection<Course> courses;
   
   /**
    * Returns the course whose course number matches courseNum.
    */
   /*@
     requires courseNum > 0;
     ensures \old(courses).equals(courses);
     // Ensures courses hasn't changed since calling this method.
    @*/
   public abstract Course getCourse(int courseNum);
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
   public abstract void addCourse(Course course);
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
   public abstract void editCourse(Course course);
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
   public abstract void deleteCourse(int courseNum);
}
