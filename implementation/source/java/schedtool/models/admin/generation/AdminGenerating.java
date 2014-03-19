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
	
	private Schedule generatedSchedule;

	public void generate() {
		String[] days ={"MWF","TR","MTRF","MTWR","MW","MF","WF"};

		int numToAddToTable = 150;
		for(int i = 0; i < numToAddToTable; i++)
		{
			boolean hasLab = Math.random() < 0.5;
			boolean isLab = Math.random() < 0.5;
			int courseRand = (int)(Math.random() * courses.size());
			models.data.databases.Course testCourse = new models.data.databases.Course(courses.get(courseRand).prefix, Integer.valueOf(courses.get(courseRand).num), 4, "", false, 0, null, false);
			if(hasLab)
				testCourse.setLabProx(models.data.databases.Course.LabProximity.values()[(int)(Math.random()*models.data.databases.Course.LabProximity.values().length)]);
			Instructor instructor = instructors.get((int)(Math.random() * instructors.size()));
			models.data.databases.Instructor testInstructor = new models.data.databases.Instructor();
			testInstructor.firstName = instructor.first;
			testInstructor.lastName = instructor.last;
			testInstructor.username = "gfisher";
			Location testLocation = new Location(""+(int)(Math.random() * 100), ""+(int)(Math.random() * 100), ""+(int)(Math.random() * 200), (int)(Math.random() * 50), true);
			Section testSection = new Section(testCourse, (int)(Math.random()*150) + 1, testInstructor, testLocation, days[(int)(Math.random()*days.length)],(int) (Math.random() * 11) + 1, (int) (Math.random() * 11) + 1);
			testSection.setEnrolled((int)(Math.random()*150));
			if(isLab)
				testSection.setLinkedSectionNum((int)(Math.random()*20));
			generatedSchedule.setOneSection(testSection);
		}
		System.out.println("AdminGenerating.GENERATING!!!");
	}
	
	public void generating2()
	{
		//generatedSchedule
		InstructorDB instructordb = new InstructorDB();
		Vector<Instructor> instructors = removeInactiveInstructors(instructordb.getAllInstructors());
		Collections.sort(instructors, new pickinessComparator());
		for(Instructor instructor: instructors)
		{
			Course course = getTopAvailableCourseThatNeedsSections(instructor);
			int hours = getCourseLength(course);
		}
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
