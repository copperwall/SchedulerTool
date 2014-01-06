package admin;

import data.Schedule;
import data.View;

/**
 * Models the admin view of the scheduler.
 */
abstract public class AdminView extends View {
   private Admin admin;
   public LocationDB locationDB;

   /**
    * Automatically generates a schedule.
    */
   /*@
   requires locationDB.locations.size() > 0;
    @*/
   public abstract Schedule generate(Admin currentAdmin); // Begin JML Responsibility
	
	/**
    * Opens the general settings page.
    */
   /*@
   requires (* Not really needed? *);
   ensures (* Not really needed? *);
   @*/
   public abstract void settingsGeneral();
   
   /**
    * Autosaves the current schedule and opens a blank schedule.
    */
   /*@
   requires (* Not really needed? *);
   ensures (* Not really needed? *);
   @*/
   public abstract Schedule schedulesNew();
   
   /**
    * Autosaves the current schedule and loads an existing schedule
    */
   /*@
   requires (* Not really needed? *);
   ensures (* Not really needed? *);
   @*/
   public abstract void schedulesLoad(Schedule schedule);
   
   /**
    * Opens the manage instructors database page.
    */
   public abstract void databasesInstructors(); // End JML Responsibility
   
   /**
    * Opens the manage courses database page.
    */
   /*@
   requires (* Not really needed? *);
   ensures (* Not really needed? *);
   @*/
   public abstract void databasesCourses();
   
   /**
    * Opens the manage locations database page.
    */
   /*@
   requires (* Not really needed? *);
   ensures (* Not really needed? *);
   @*/
   public abstract void databasesLocations();
   
   /**
    * Opens the instructor preference settings page.
    */
   /*@
   requires (* Not really needed? *);
   ensures (* Not really needed? *);
   @*/
   public abstract void settingsInstructorPreferences();
   
   /**
    * Opens the available courses settings page.
    */
   /*@
   requires (* Not really needed? *);
   ensures (* Not really needed? *);
   @*/
   public abstract void settingsAvailableCourses();
   
   /**
    * Opens the schedule analytics page.
    */
   /*@
   requires (* Not really needed? *);
   ensures (* Not really needed? *);
   @*/
   public abstract void analytics();
   
   /**
    * Publishes the schedule to the Cal Poly database.
    */
   /*@
   requires (* Not really needed? *);
   ensures (* Not really needed? *);
   @*/
   public abstract void publish();
}
