package models.data.databases;

import java.util.Collection;
import java.util.List;

/**
 * An Instructor has a first and last name, their work time units, 
 * their time preferences, their class preferences, if they're active, 
 * and if their preferences are locked by the administrator.
 */
public abstract class Instructor extends User {
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
   public abstract List<CoursePreference> getAllClassPrefs();
   
   /**
    * Gets the preference for one course.
    * @return the preference for that course
    */
   /*@
      // not implemented yet
    @*/
   public abstract int getOneClassPref(Course course);
   
   /**
    * Sets all course preferences to the given integer preference
    */
   /*@
      requires pref == -1 || pref >= 1 && pref <= 5;
    @*/
   public abstract void setAllClassPrefs(int pref);
   
   /**
    * Sets one course's preference
    */
   /*@
     ensures this.getOneClassPref(course) == prefNum;
    @*/
   public abstract void setOneClassPref(Course course, int prefNum);
}
