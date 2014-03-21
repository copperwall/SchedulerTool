package models.data.databases;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * This class holds all the information for a course, including
 * a prefix (CPE), a class number (309), the title of the course, whether it
 * has a lab, the number of units, the lab length (if applicable),
 * and the lab proximity(if applicable).
 * All of the get and set methods are included.
 * @author Katie Keim
 */
public class Course {
   /**
    * The prefix for the data table.
    */
   private final SimpleStringProperty prefix = new SimpleStringProperty("");
 
   /**
    * The course number for the data table.
    */
   private final SimpleIntegerProperty courseNum = new SimpleIntegerProperty();

   /**
    * The boolean for if the course has a lab for the data table.
    */
   private final SimpleBooleanProperty hasLab = new SimpleBooleanProperty();

   /**
    * The number of units for the data table.
    */
   private final SimpleIntegerProperty units = new SimpleIntegerProperty();

   /**
    * The title of the class for the data table.
    */
   private final SimpleStringProperty title = new SimpleStringProperty("");
 
   /**
    * The boolean for if the course has a lab for the data table.
    */
   private final SimpleBooleanProperty hasEquipment = new SimpleBooleanProperty();

   /**
    * The boolean for if the course has a lab for the data table.
    */
   private final SimpleBooleanProperty labHasEquipment = new SimpleBooleanProperty();

   /**
    * The lab length for the data table.
    */
   private final SimpleIntegerProperty labLength = new SimpleIntegerProperty();

   /**
    * An enum value for the proximity of lab and lecture for the data table.
    */
   private final SimpleObjectProperty<LabProximity> labProx = new SimpleObjectProperty<LabProximity>();
   
   /**
    * An enum representing how close the associated lab should be to this class (time-wise).
    * Includes directly after the class, on a different day as the class, or on the same day
    * as the class.
    * @author Katie
    */
   public enum LabProximity {
      DIRECTLY_AFTER, 
      DIFF_DAY, 
      SAME_DAY
   };
   
   /**
    * A constructor for a course WITH a lab.
    * @param prefix the course's department prefix
    * @param courseNum the course's id number
    * @param hasLab whether the course has a lab
    * @param units the number of units of the course
    * @param title the title of the course
    * @param labLength the length of the lab
    * @param labProx the proximity of lab to lecture
    */
   /*@
      requires (prefix != null && title != null);
      ensures 
        this.prefix != null && this.courseNum != null && this.hasLab != null && this.units != null && this.hasEquipment != null
        && this.labLength != null && this.labProx != null && this.labHasEquipment != null;
   @*/
   public Course(String prefix, int courseNum, int units, String title, boolean hasEquipment, int labLength, Course.LabProximity labProx, boolean labHasEquipment) {
      this.prefix.set(prefix);
      this.courseNum.set(courseNum);
      this.hasLab.set(labProx != null);
      this.units.set(units);
      this.title.set(title);
      this.hasEquipment.set(hasEquipment);
      this.labLength.set(labLength);
      this.labProx.set(labProx);
      this.labHasEquipment.set(labHasEquipment);
   }

   /**
    * Gets the course's prefix
    * @return the course's prefix
    */
   /*@
      requires (this.prefix != null);
      ensures 
        \result != null;
   @*/
   public String getPrefix() {
       return prefix.get();
   }
   
   /**
    * Gets the course's prefix for the data table
    * @return the course's prefix for the data table
    */
   /*@
      requires (this.prefix != null);
      ensures 
        \result ! = null;
   @*/
   public SimpleStringProperty prefixProperty() {
	   return prefix;
   }
   
   /**
    * Gets the course's number
    * @return the course's number
    */
   /*@
      requires (this.courseNum != null);
      ensures 
        true;
   @*/
   public int getCourseNum() {
       return courseNum.get();
   }
   
   /**
    * Gets the course's number for the data table
    * @return the course's number for the data table
    */
   /*@
      requires (this.courseNum != null);
      ensures 
        \result != null;
   @*/
   public SimpleIntegerProperty courseNumProperty() {
	   return courseNum;
   }
   
   /**
    * Gets the course's title
    * @return the course's title
    */
   /*@
      requires (this.title != null);
      ensures 
        \result != null;
   @*/
   public String getTitle() {
	   return title.get();
   }
   
   /**
    * Gets the course's title for the data table
    * @return the course's title for the data table
    */
   /*@
      requires (this.title != null);
      ensures 
        \result != null;
   @*/
   public SimpleStringProperty titleProperty() {
	   return title;
   }
   
   /**
    * Gets if the lecture needs equipment
    * @return a boolean value for if the lecture needs equipment
    */
   /*@
      requires (this.hasEquipment != null);
      ensures 
        true;
   @*/
   public boolean getHasEquipment() {
	   return hasEquipment.get();
   }
   
   /**
    * Gets if the lecture needs equipment for the data table
    * @return a boolean value for if the lecture needs equipment
    */
   /*@
      requires (this.hasEquipment != null);
      ensures 
        \result != null;
   @*/
   public SimpleBooleanProperty hasEquipmentProperty() {
	   return hasEquipment;
   }
   
   /**
    * Gets the course's number of units
    * @return the course's number of units
    */
   /*@
      requires (this.units != null);
      ensures 
        \result > 0;
   @*/
   public int getUnits() {
       return units.get();
   }
   
   /**
    * Gets the course's number of units for the data table
    * @return the course's number of units for the data table
    */
   /*@
      requires (this.units != null);
      ensures 
        \result != null;
   @*/
   public SimpleIntegerProperty unitsProperty() {
	   return units;
   }
   
   /**
    * Gets if the course has a lab
    * @return a boolean value for if the course has a lab
    */
   /*@
      requires (hasLab != null);
      ensures 
        \result true;
   @*/
   public boolean getHasLab() {
	   return hasLab.get();
   }
   
   /**
    * Gets if the course has a lab for the data table
    * @return a boolean value for if the course has a lab for the data table
    */
   /*@
      requires (hasLab != null);
      ensures 
        \result != null;
   @*/
   public SimpleBooleanProperty hasLabProperty() {
	   return hasLab;
   }
   
   /**
    * Gets if the lab needs equipment
    * @return a boolean value for if the lab needs equipment
    */
   /*@
   requires (labHasEquipment != null);
   ensures 
     true;
@  */
   public boolean getLabHasEquipment() {
	   return labHasEquipment.get();
   }
   
   /**
    * Gets if the lab needs equipment for the data table
    * @return a boolean value for if the lab needs equipment
    */
   /*@
      requires (labHasEquipment != null);
      ensures 
        \result != null;
   @*/
   public SimpleBooleanProperty labHasEquipmentProperty() {
	   return labHasEquipment;
   }
   
   /**
    * Gets the length of this course's lab
    * @return the length of the course's lab
    */
   /*@
      requires (labLength != null);
      ensures 
        \result != null;
   @*/
   public int getLabLength() {
       return labLength.get();
   }
   
   /**
    * Gets the length of this course's lab for the data table
    * @return the length of the course's lab for the data table
    */ 
   /*@
      requires (labLength != null);
      ensures 
        \result != null;
   @*/
   public SimpleIntegerProperty labLengthProperty() {
	   return labLength;
   }
   
   /**
    * Gets the proximity of the course's lab to the lecture
    * @return the proximity of the course's lab to the lecture
    */
   /*@
      requires (labProx != null);
      ensures 
        \result.getClass().equals(LabProximity.class);
   @*/
   public LabProximity getLabProx() {
	   return labProx.get();
   }
   
   /**
    * Gets the proximity of the course's lab to the lecture for the data table
    * @return the proximity of the course's lab to the lecture for the data table
    */
   /*@
      requires (labProx != null);
      ensures 
        \result != null;
   @*/
   public SimpleObjectProperty<LabProximity> labProxProperty() {
	   return labProx;
   }
   
   /**
    * Sets the course's prefix
    * @param prefix the course's new prefix
    */
   /*@
      requires (prefix != null && this.prefix != null);
      ensures 
        \result == (this.prefix.get() == prefix);
   @*/
   public void setPrefix(String prefix) {
      this.prefix.set(prefix);
   }
   
   /**
    * Sets the course's number
    * @param courseNum the new course number
    */
   /*@
      requires (this.courseNum != null);
      ensures 
        \result == (this.courseNum.get() == courseNum);
   @*/
   public void setCourseNum(int courseNum) {
      this.courseNum.set(courseNum);
   }
   
   /**
    * Sets the course's units
    * @param units the new number of units 
    */
   /*@
      requires (units > 0 && this.units != null);
      ensures 
        \result == (this.units.get() == units);
   @*/
   public void setUnits(int units) {
      this.units.set(units);
   }
   
   /**
    * Sets the course's title
    * @param title the new title
    */
   /*@
      requires (title != null && this.title != null);
      ensures 
        \result == (this.titleString.get() == labProx);
   @*/
   public void setTitle(String title) {
       this.title.set(title);
   }
   
   /**
    * Sets if the course has a lab
    * @param hasLab the new value of whether the course has a lab
    */
   /*@
      requires this.hasLab != null;
      ensures 
        \result == (this.hasLab.get() == hasLab);
   @*/
   public void setHasLab(boolean hasLab) {
      this.hasLab.set(hasLab);
   }
   
   /**
    * Sets the lab length
    * @param labLength the new lab length
    */
   /*@
      requires labLength >= 0 && this.labLength != null;
      ensures 
        \result == (this.labLength.get() == labLength);
   @*/
   public void setLabLength(int labLength) {
      this.labLength.set(labLength);
   }
   
   /**
    * Sets the proximity of the lab to the lecture
    * @param labProx
    */
   /*@
      requires this.labProx != null;
      ensures 
        \result == (this.labProx.get() == labProx);
   @*/
   public void setLabProx(LabProximity labProx) {
      this.labProx.set(labProx);
   }
	
   /**
    * Returns the course's prefix and course number
    * @return the course's full String id
    */
   /*@
        requires this.prefix != null && this.prefix = null;
        ensures 
          \result == (coursePrefix + " " + this.courseNo);
   @*/
   public String getCourseID() {
      return prefix.get() + " " + courseNum.get();
   }
   
   /**
    * Checks if the given course number matches this course's number
    * and the given  department prefix matches this course's prefix
    * @param courseNum the number of the course to match
    * @param dept the department prefix to match
    */
   /*@
     requires dept != null && this.courseNum != null && this.prefix != null;
     ensures 
       \result == (courseNum == this.courseNum.get() &&
                   dept.equals(this.prefix.get()));
    @*/
   public boolean matchCourse(int courseNum, String dept) {
      return this.courseNum.get() == courseNum && this.prefix.get().equals(dept);
   }
   
   public boolean equals()
   {
	   return true;
   }
}
