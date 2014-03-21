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
   private int startTime;
   private int endTime;
   private int enrolled;
   
   public Section(Course course,int sectionNum, Instructor instructor, Location location, String days, int startTime, int endTime)
   {
	   this.course = course;
	   this.sectionNum = sectionNum;
	   this.instructor = instructor;
	   this.location = location;
	   this.days = days;
	   this.startTime = startTime;
	   this.endTime = endTime;
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
	
	public int getStartTime() {
		return startTime;
	}
	
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
	public int getEndTime() {
		return endTime;
	}
	
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
	public int getEnrolled() {
		return enrolled;
	}
	
	public void setEnrolled(int enrolled) {
		this.enrolled = enrolled;
	}
	
	public String getTime() {
		String time = "AM";
		if(endTime >= 12)
			time = "PM";
		if(startTime > 12)
			startTime = startTime % 12;
		if(endTime > 12)
			endTime = endTime % 12;
		return startTime + "-" + endTime + time;
	}   
}   
