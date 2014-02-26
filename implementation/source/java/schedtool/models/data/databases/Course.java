package models.data.databases;

import java.util.*;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;


/**
 * This class holds all the information for a course, including
 * a prefix (CSC), a class number (309), the title of the course, whether it
 * has a lab, the number of units, the lab length (if applicable),
 * and the lab proximity(if applicable).
 * All of the get and set methods are included.
 * @author Katie Keim
 */
public class Course {
   /**
    * The department prefix for a course.
    */
   public String coursePrefix;
   
   /**
    * The prefix for the data table.
    */
   private final SimpleStringProperty prefix = new SimpleStringProperty("");
   
   /**
    * The identifying course number.
    */
   public int courseNo;
   
   /**
    * The course number for the data table.
    */
   private final SimpleIntegerProperty courseNum = new SimpleIntegerProperty();
   
   /**
    * A boolean identifying if this course has a lab associated with it.
    */
   private boolean hasALab;
   
   /**
    * The boolean for if the course has a lab for the data table.
    */
   private final SimpleBooleanProperty hasLab = new SimpleBooleanProperty();
   
   /**
    * The number of units that this course.
    */
   private int numUnits;
   
   /**
    * The number of units for the data table.
    */
   private final SimpleIntegerProperty units = new SimpleIntegerProperty();
   
   /**
    * The title of the class as given by school catalog.
    */
   private String titleString;
   
   /**
    * The title of the class for the data table.
    */
   private final SimpleStringProperty title = new SimpleStringProperty("");
   
   /**
    * The length of the lab, if hasLab is true, in minutes.
    */
   private int aLabLength;
   
   /**
    * The lab length for the data table.
    */
   private final SimpleIntegerProperty labLength = new SimpleIntegerProperty();
   
   /**
    * An enum value representing how close the lab is to the lecture.
    */
   private LabProximity aLabProx;

   /**
    * An enum value for the proximity of lab and lecture for the data table.
    */
   private final SimpleObjectProperty<LabProximity> labProx = new SimpleObjectProperty<>();
   
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
   public Course(String prefix, int courseNum, boolean hasLab, int units, String title, int labLength, Course.LabProximity labProx) {
      this.prefix.set(prefix);
      this.courseNum.set(courseNum);
      this.hasLab.set(hasLab);
      this.units.set(units);
      this.title.set(title);
      this.labLength.set(labLength);
      this.labProx.set(labProx);
      
      this.coursePrefix = prefix;
      this.courseNo = courseNum;
      this.hasALab = hasLab;
      this.numUnits = units;
      this.titleString = title;
      this.aLabLength = labLength;
      this.aLabProx = labProx;
   }
   
   /**
    * A constructor for a course WITHOUT a lab.
    * @param prefix the course's department prefix
    * @param courseNum the course's id number
    * @param hasLab whether the course has a lab
    * @param units the number of units of the course
    * @param title the title of the course
    */
   public Course(String prefix, int courseNum, boolean hasLab, int units, String title) {
	   this.prefix.set(prefix);
      this.courseNum.set(courseNum);
      this.hasLab.set(hasLab);
      this.units.set(units);
      this.title.set(title);
      this.labLength.set(0);
      this.labProx.set(null);
      
      this.coursePrefix = prefix;
      this.courseNo = courseNum;
      this.hasALab = hasLab;
      this.numUnits = units;
      this.titleString = title;
      this.aLabLength = 0;
      this.aLabProx = null;
   }

   /**
    * Sets new data for editing a course. Please note that the course number
    * and department prefix cannot be changed.
    * @param hasLab
    * @param units
    * @param title
    * @param labLength
    * @param labProx
    */
   public void setNewData(boolean hasLab, int units, String title, int labLength, Course.LabProximity labProx) {
      this.hasLab.set(hasLab);
      this.units.set(units);
      this.title.set(title);
      this.labLength.set(labLength);
      this.labProx.set(labProx);

      this.hasALab = hasLab;
      this.numUnits = units;
      this.titleString = title;
      this.aLabLength = labLength;
      this.aLabProx = labProx;
   }
   
   /**
    * Gets the course's prefix
    * @return the course's prefix
    */
   public String getPrefix() {
       return coursePrefix;
   }
   
   /**
    * Gets the course's prefix for the data table
    * @return the course's prefix for the data table
    */
   public SimpleStringProperty prefixProperty() {
	   return prefix;
   }
   
   /**
    * Gets the course's number
    * @return the course's number
    */
   public int getCourseNum() {
       return courseNo;
   }
   
   /**
    * Gets the course's number for the data table
    * @return the course's number for the data table
    */
   public SimpleIntegerProperty courseNumProperty() {
	   return courseNum;
   }
   
   /**
    * Gets the course's title
    * @return the course's title
    */
   public String getTitle() {
	   return titleString;
   }
   
   /**
    * Gets the course's title for the data table
    * @return the course's title for the data table
    */
   public SimpleStringProperty titleProperty() {
	   return title;
   }
   
   /**
    * Gets the course's number of units
    * @return the course's number of units
    */
   public int getUnits() {
       return numUnits;
   }
   
   /**
    * Gets the course's number of units for the data table
    * @return the course's number of units for the data table
    */
   public SimpleIntegerProperty unitsProperty() {
	   return units;
   }
   
   /**
    * Gets if the course has a lab
    * @return a boolean value for if the course has a lab
    */
   public boolean getHasLab() {
	   return hasALab;
   }
   
   /**
    * Gets if the course has a lab for the data table
    * @return a boolean value for if the course has a lab for the data table
    */
   public SimpleBooleanProperty hasLabProperty() {
	   return hasLab;
   }
   
   /**
    * Gets the length of this course's lab
    * @return the length of the course's lab
    */
   public int getLabLength() {
       return aLabLength;
   }
   
   /**
    * Gets the length of this course's lab for the data table
    * @return the length of the course's lab for the data table
    */ 
   public SimpleIntegerProperty labLengthProperty() {
	   return labLength;
   }
   
   /**
    * Gets the proximity of the course's lab to the lecture
    * @return the proximity of the course's lab to the lecture
    */
   public LabProximity getLabProx() {
	   return aLabProx;
   }
   
   /**
    * Gets the proximity of the course's lab to the lecture for the data table
    * @return the proximity of the course's lab to the lecture for the data table
    */
   public SimpleObjectProperty labProxProperty() {
	   return labProx;
   }
   
   /**
    * Sets the course's prefix
    * @param prefix the course's new prefix
    */
   public void setPrefix(String prefix) {
      this.prefix.set(prefix);
      coursePrefix = prefix;
   }
   
   /**
    * Sets the course's number
    * @param courseNum the new course number
    */
   public void setCourseNum(int courseNum) {
	   courseNo = courseNum;
      this.courseNum.set(courseNum);
   }
   
   /**
    * Sets the course's units
    * @param units the new number of units 
    */
   public void setUnits(int units) {
	   numUnits = units;
      this.units.set(units);
   }
   
   /**
    * Sets the course's title
    * @param title the new title
    */
   public void setTitle(String title) {
	   titleString = title;
       this.title.set(title);
   }
   
   /**
    * Sets if the course has a lab
    * @param hasLab the new value of whether the course has a lab
    */
   public void setHasLab(boolean hasLab) {
	   hasALab = hasLab;
      this.hasLab.set(hasLab);
   }
   
   /**
    * Sets the lab length
    * @param labLength the new lab length
    */
   public void setLabLength(int labLength) {
	   aLabLength = labLength;
      this.labLength.set(labLength);
   }
   
   /**
    * Sets the proximity of the lab to the lecture
    * @param labProx
    */
   public void setLabProx(LabProximity labProx) {
      aLabProx = labProx;
      this.labProx.set(labProx);
   }
	
   /**
    * Returns prefix + course number
    * @return the course's full String id
    */
   /*@
        requires (* none yet *);
        ensures 
          \result == (prefix + " " + this.courseNum);
   @*/
   public String getCourseID() {
      return coursePrefix + " " + courseNo;
   }
   
   /**
    * Checks if the course number matches a given course number
    * @param courseNum the number of the course to match
    * @param dept the department prefix to match
    */
   /*@
     requires (* none yet *);
     ensures 
       \result == (courseNum == this.courseNum);
    @*/
   public boolean matchCourse(int courseNum, String dept) {
      return this.courseNo == courseNum && this.coursePrefix.equals(dept);
   }
}
