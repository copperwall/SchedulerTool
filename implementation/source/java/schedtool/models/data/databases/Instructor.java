package models.data.databases;

import java.util.*;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

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
   
   private final SimpleStringProperty name = new SimpleStringProperty("");
   private final SimpleIntegerProperty wtu = new SimpleIntegerProperty();
   private final SimpleStringProperty user = new SimpleStringProperty("");
   private final SimpleBooleanProperty act = new SimpleBooleanProperty();
   
   public Instructor(String name, String username, int wtu, boolean active) {
	   this.name.set(name);
	   this.wtu.set(wtu);
	   this.user.set(username);
	   this.act.set(active);
   }
   
   public String getname() {
       return name.get();
   }
   
   public int getwtu() {
       return wtu.get();
   }
   
   public String getuser() {
	   return user.get();
   }
   
   public boolean getact() {
	   return act.get();
   }
   
   public void setname(String name) {
       this.name.set(name);
   }
   
   public void setwtu(int wtu) {
       this.wtu.set(wtu);
   }
   
   public void setuser(String user) {
       this.user.set(user);
   }
   
   public void setact(boolean act) {
       this.act.set(act);
   }
   // empty constructor for making dummy objects
   public Instructor() {}
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
