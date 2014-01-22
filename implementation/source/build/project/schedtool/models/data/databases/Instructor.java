package models.data.databases;

import java.util.*;

/**
 * An Instructor has a first and last name, their work time units, 
 * their time preferences, their class preferences, if they're active, 
 * and if their preferences are locked by the administrator.
 */
public class Instructor extends User {
   private int workTimeUnits;
   private Collection<Day> timePrefs;
   public List<CoursePreference> coursePrefs;
   private boolean active;
   private boolean prefsLocked;
   
   /**
    * Gets the instructor's course preferences. 
    * @return a List of CoursePreferences
    */
   /*@
      ensures \result.containsAll(coursePrefs);
    @*/
   public List<CoursePreference> getAllClassPrefs() {
       System.out.println("Instructor.getAllClassPrefs()");
       return new ArrayList<CoursePreference>();
   }
   
   /**
    * Gets the preference for one course.
    * @return the preference for that course
    */
   /*@
      // not implemented yet
    @*/
   public int getOneClassPref(Course course) {
       System.out.println("Instructor.getOneClassPref()");
       return 0;
   }
   
   /**
    * Sets all course preferences to the given integer preference
    */
   /*@
      requires pref == -1 || pref >= 1 && pref <= 5;
    @*/
   public void setAllClassPrefs(int pref) {
       System.out.println("Instructor.setAllClassPrefs()");
   }
   
   /**
    * Sets one course's preference
    */
   /*@
     ensures this.getOneClassPref(course) == prefNum;
    @*/
   public void setOneClassPref(Course course, int prefNum) {
       System.out.println("Instructor.setOneClassPref()");
   }
}
