package data;

import java.util.Collection;

/**
 * This class has a section number, a Course, an Instructor, a Location, if it's
 * a lab, its corresponding pair to the its lab/lecture and the days of the week
 * the class is held. Get and set methods are included for each variable.
 */
public abstract class Section {
   public int sectionNum;
   public Course course;
   private Instructor instructor;
   private Location location;
   private int linkedSectionNum;
   private Collection<Day> days;
}
