package admin;
import data.Day;
import java.util.Collection;

/** 
 * This class holds the admin settings including the start time 
 * and end times of the next generated schedule. For example, the start 
 * time is 7 for 7AM and the end time is 22 for 10PM. There are 4 methods
 * of setting and getting start times and end times.
 */
public abstract class Settings {
   private int startTime;
   private int endTime;
   private Collection<Constraint> constraints;
   private Collection<Day> days;
   private Collection<Boolean> timePatterns;
}
