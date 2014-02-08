package models.admin.generation;

import java.util.Collection;
import models.data.databases.*;
/**
 * This class has a section number, a Course, an Instructor, a Location, if it's
 * a lab, its corresponding pair to the its lab/lecture and the days of the week
 * the class is held. Get and set methods are included for each variable.
 */
public class Section {
   public int sectionNum;
   public Course course;
   private Instructor instructor;
   private Location location;
   private int linkedSectionNum;
   private String days;
   
   public Section(Course course,int sectionNum, Instructor instructor, Location location, String days)
   {
	   this.course = course;
	   this.sectionNum = sectionNum;
	   this.instructor = instructor;
	   this.location = location;
	   this.days = days;
   }
   
   public Course getCourse()
   {
	   return course;
   }
   
   public void setCourse(Course course)
   {
	   this.course = course;
   }
   
   public String getCourseNo() {
	   return ""+course.getCourseNum();
   }
   
   public int getSectionNum()
   {
	   return sectionNum;
   }
   
   public void setSectionNum(int sectionNum)
   {
	   this.sectionNum = sectionNum;
   }

	public Instructor getInstructor() {
		return instructor;
	}
	
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public int getLinkedSectionNum() {
		return linkedSectionNum;
	}
	
	public void setLinkedSectionNum(int linkedSectionNum) {
		this.linkedSectionNum = linkedSectionNum;
	}
	
	public String getDays() {
		return days;
	}
	
	public void setDays(String days) {
		this.days = days;
	}
   
}   
