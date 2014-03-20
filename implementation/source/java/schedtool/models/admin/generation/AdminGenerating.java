package models.admin.generation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import controllers.admin.analytics.pickinessComparator;
import javafx.scene.layout.AnchorPane;
import models.data.databases.*;
/**
 * Model to be called when user wants to generate.
 * @author Jarred Stelfox
 * @version 1
 */
public class AdminGenerating {
	
	private Schedule generatedSchedule = new Schedule();
	
	public void generate()
	{
		generatedSchedule.clear();
		//generatedSchedule
		System.out.println("AdminGenerating.GENERATING!!!??????????");
		InstructorDB instructordb = new InstructorDB();
		Vector<Instructor> instructors = removeInactiveInstructors(instructordb.getAllInstructors());
		Collections.sort(instructors, new pickinessComparator());
		for(Instructor instructor: instructors)
		{
			Course course = getTopAvailableCourseThatNeedsSections(instructor);
			int hours = getCourseLength(course);
			ArrayList<Day> timePrefs = instructor.getTimePrefs();
			int startTime = startTime(timePrefs);
			Location location = getLocationAtTime(startTime, startTime + 1);
			Section section = new Section(course,
					generatedSchedule.getSectionCount(course), instructor, location, "MWF", startTime, startTime + 1);
			generatedSchedule.setOneSection(section);
		}
	}
		
	public Location getLocationAtTime(int startTime, int endTime)
	{
		LocationDB locationdb = new LocationDB();
		Vector<Location> allLocs = locationdb.getAllLocations();
		Location location = null;
		Vector<Section> sections = generatedSchedule.getAllSections();
		for(Section section : sections)
		{
			if(overlap(startTime, endTime, section.getStartTime()) || overlap(startTime, endTime, section.getEndTime())
					|| overlap(section.getStartTime(), section.getEndTime(), startTime) || overlap(section.getStartTime(), section.getEndTime(), endTime))
			{
				allLocs.remove(section.getLocation());
			}
		}
		if(allLocs.size() > 0)
		{
			location = allLocs.get(0);
		}
		return location;
	}
	
	public boolean overlap(int startTime, int endTime, int checkTime)
	{
		return checkTime > startTime && checkTime < endTime;
	}
	
	public int startTime(ArrayList<Day> timePrefs)
	{
		ArrayList<Boolean> monday = timePrefs.get(0).getAvailability();
		ArrayList<Boolean> wednesday = timePrefs.get(2).getAvailability();
		ArrayList<Boolean> friday = timePrefs.get(4).getAvailability();
		for(int i = 0; i < monday.size(); i++)
		{
			if(monday.get(i) && wednesday.get(i) && friday.get(i))
			{
				return i;
			}
		}
		return -1;
	}
	
	public int getCourseLength(Course course)
	{
		int toReturn = -1;
		int units = course.getUnits();
		if(course.getHasLab())
		{
			toReturn = units - 1;
		}
		else
		{
			toReturn = units;
		}
		toReturn = 3;
		return toReturn;
	}
	
	public Course getTopAvailableCourseThatNeedsSections(Instructor instructor)
	{
		List<CoursePreference> prefsList = instructor.getAllClassPrefs();
		Course toReturn = null;
		Vector<AvailableCoursesRow> availCourses = AdminAvailableCourses.getAvailableCourses();
		for(CoursePreference coursePref : prefsList)
		{
			int courseIndexInAvailCourses = availCourses.indexOf(coursePref.course);
			if(courseIndexInAvailCourses >= 0 && availCourses.get(courseIndexInAvailCourses).getSections() < generatedSchedule.getSectionCount(coursePref.course))
			{
				return coursePref.course;
			}
		}
		return null;
	}
	
	public Vector<Instructor> removeInactiveInstructors(Vector<Instructor> instructors)
	{
		for(int i = 0; i < instructors.size(); i++)
		{
			if(!instructors.get(i).getAct())
			{
				instructors.remove(i);
			}
		}
		return instructors;
	}
	
	public Schedule getSchedule() {
		return generatedSchedule;
	}
}
