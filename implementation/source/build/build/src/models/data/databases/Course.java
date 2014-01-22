package models.data.databases;

/**
 * This class holds all the information for a course, including
 * a prefix (CSC), class number (308), has lab, and number of units.
 * All of the get and set methods are included;
 */
public abstract class Course {

   /**
    * The department prefix for a course.
    */
   public String prefix;
   
   /**
    * The identifying course number.
    */
   public int courseNum;
   
   /**
    * A boolean identifying if this course has a lab associated with it.
    */
   private boolean hasLab;
   
   /**
    * The number of units that this course.
    */
   private int units;
   
   /**
    * The name of the class as given by school catalog.
    */
   private String title;
   
   /**
    * The length of the lab, if hasLab is true, in minutes.
    */
   private int labLength;
   
	private enum labProximity {DIRECTLY_AFTER, DIFF_DAY, SAME_DAY};
	
   /**
    * Returns prefix + course number
    */
   /*@
        requires (* none yet *);
        ensures 
          \result == (prefix + " " + this.courseNum);
   @*/
   public abstract String getCourseID();
   
   
   /**
    * Checks if the course number matches a given course number
    */
   /*@
     requires (* none yet *);
     ensures 
       \result == (courseNum == this.courseNum);
    @*/
   public abstract boolean matchCourseNum(int courseNum);
}
