package models.data.databases;

/**
 * This class holds all the information for a course, including
 * a prefix (CSC), class number (308), has lab, and number of units.
 * All of the get and set methods are included;
 */
public class Course {

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
   
   private LabProximity labProx;
   
	public enum LabProximity {DIRECTLY_AFTER, DIFF_DAY, SAME_DAY};
   
   public Course(String prefix, int courseNum, boolean hasLab, int units, String title, int labLength, Course.LabProximity labProx) {
      this. prefix = prefix;
      this.courseNum = courseNum;
      this. hasLab = hasLab;
      this.units = units;
      this.title = title;
      this.labLength = labLength;
      this.labProx = labProx;
   }
   
   public void setNewData(boolean hasLab, int units, String title, int labLength, Course.LabProximity labProx) {
      this. hasLab = hasLab;
      this.units = units;
      this.title = title;
      this.labLength = labLength;
      this.labProx = labProx;
   }
	
   /**
    * Returns prefix + course number
    */
   /*@
        requires (* none yet *);
        ensures 
          \result == (prefix + " " + this.courseNum);
   @*/
   public String getCourseID() {
      return prefix + " " + courseNum;
   }
   
   /**
    * Checks if the course number matches a given course number
    */
   /*@
     requires (* none yet *);
     ensures 
       \result == (courseNum == this.courseNum);
    @*/
   public boolean matchCourse(int courseNum, String dept) {
      return this.courseNum == courseNum && this.prefix.equals(dept);
   }
}
