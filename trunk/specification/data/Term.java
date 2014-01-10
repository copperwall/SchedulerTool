package data;

import java.util.Collection;
import java.util.Date;

/**
 * Models a Term that has a collection of schedules,
 * student votes for that term, its available courses,
 * a Date for when student votes are locked, a Date
 * for when intstructor preferences are locked, 
 * the year, and 
 */
public abstract class Term {
   Collection<Schedule> schedules;
   Date voteLock;
   Date prefLock;
   Collection<Section> availableSections;
   int year;
   enum Season {FALL, WINTER, SPRING, SUMMER};
   Schedule publishedSchedule;
}
