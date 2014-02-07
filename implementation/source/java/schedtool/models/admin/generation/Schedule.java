package models.admin.generation;
import models.data.databases.*;
import java.util.*;

/**
 * Models a schedule as a collection of sections.
 *
 */
public class Schedule {
   public ArrayList<Section> sections;

   /**
    * Sets the schedule to the given set of sections.
    */
   /*@
     requires newSections != null;
     ensures
       // Makes sure that the set of sections given by newSections overwrites
       // the old set of sections.
       sections.containsAll(newSections) && newSections.containsAll(sections);
    @*/
   public void setAllSections(ArrayList<Section> newSections)
   {
   }
   /**
    * This returns all of the sections in the schedule.
    */
   /*@
     requires (* Not really needed? *);
     ensures
       // Ensures that none of the sections are changed and that all the
       // sections are included in the return value.
       \forall Section sec; \old(sections).contains(sec) || sections.contains(sec);
         \result.contains(sec) && sections.contains(sec) &&
          \old(sections).contains(sec);
    @*/
   public ArrayList<Section> getAllSections() {
	   return sections;
   }
   
   /**
    * Sets the section in "sections" that matches the given section to the
    * given section. If a match doesn't exist, the given section is added to
    * the schedule.
    */
   /*@
     requires value != null;
     ensures
       // Ensures that all of the sections are either from the old set of
       // sections, an edited section, or a new section that was added.
       (\forall Section sec; sections.contains(sec);
         \old(sections).contains(sec) || sec.equals(value)) &&
       sections.contains(value);
    @*/
   public void setOneSection(Section value) {
	   
   }
   
   /**
    * Returns the section matching the given course id.
    */
   /*@
     requires (* Not really needed *);
     ensures
       // Ensures that none of the sections are touched and the result is
       // either null or matches the given parameters.
       (sections.equals(\old(sections))) &&
       ((\result == null) ||
       (\result.sectionNum == sectionNum &&
       \result.course.equals(course)));
    @*/
   public  Section getOneSection(int sectionNum, Course course) {
	   return sections.get(0);
   }
}
