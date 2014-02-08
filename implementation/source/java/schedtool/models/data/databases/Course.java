package models.data.databases;

import java.util.*;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;


/**
 * This class holds all the information for a course, including
 * a prefix (CSC), class number (308), has lab, and number of units.
 * All of the get and set methods are included;
 */
public class Course {

   /**
    * The department prefix for a course.
    */
   public String coursePrefix;
   
   /**
    * The identifying course number.
    */
   public int courseNo;
   
   /**
    * A boolean identifying if this course has a lab associated with it.
    */
   private boolean hasALab;
   
   /**
    * The number of units that this course.
    */
   private int numUnits;
   
   /**
    * The name of the class as given by school catalog.
    */
   private String titleString;
   
   /**
    * The length of the lab, if hasLab is true, in minutes.
    */
   private int aLabLength;
   
   private LabProximity aLabProx;

   private final SimpleIntegerProperty courseNum = new SimpleIntegerProperty();
   private final SimpleStringProperty prefix = new SimpleStringProperty("");
   private final SimpleStringProperty title = new SimpleStringProperty("");
   private final SimpleBooleanProperty hasLab = new SimpleBooleanProperty();
   private final SimpleIntegerProperty labLength = new SimpleIntegerProperty();
   private final SimpleIntegerProperty units = new SimpleIntegerProperty();
   private final SimpleObjectProperty<LabProximity> labProx = new SimpleObjectProperty<>();
   
	public enum LabProximity {DIRECTLY_AFTER, DIFF_DAY, SAME_DAY};
   
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
   
   public String getPrefix() {
       return coursePrefix;
   }
   
   public SimpleStringProperty prefixProperty() {
	   return prefix;
   }
   
   public int getCourseNum() {
       return courseNo;
   }
   
   public SimpleIntegerProperty courseNumProperty() {
	   return courseNum;
   }
   
   public String getTitle() {
	   return titleString;
   }
   
   public SimpleStringProperty titleProperty() {
	   return title;
   }
   
   public int getUnits() {
       return numUnits;
   }
   
   public SimpleIntegerProperty unitsProperty() {
	   return units;
   }
   
   public boolean getHasLab() {
	   return hasALab;
   }
   
   public SimpleBooleanProperty hasLabProperty() {
	   return hasLab;
   }
   
   public int getLabLength() {
       return aLabLength;
   }
   
   public SimpleIntegerProperty labLengthProperty() {
	   return labLength;
   }
   
   public LabProximity getLabProx() {
	   return aLabProx;
   }
   
   public SimpleObjectProperty labProxProperty() {
	   return labProx;
   }
   
   public void setPrefix(String prefix) {
      this.prefix.set(prefix);
      coursePrefix = prefix;
   }
   
   public void setCourseNum(int courseNum) {
	   courseNo = courseNum;
      this.courseNum.set(courseNum);
   }
   
   public void setUnits(int units) {
	   numUnits = units;
      this.units.set(units);
   }
   
   public void setTitle(String title) {
	   titleString = title;
       this.title.set(title);
   }
   
   public void setHasLab(boolean hasLab) {
	   hasALab = hasLab;
      this.hasLab.set(hasLab);
   }
   
   public void setLabLength(int labLength) {
	   aLabLength = labLength;
      this.labLength.set(labLength);
   }
   
   public void setLabProx(LabProximity labProx) {
      aLabProx = labProx;
      this.labProx.set(labProx);
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
      return coursePrefix + " " + courseNo;
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
      return this.courseNo == courseNum && this.coursePrefix.equals(dept);
   }
}
