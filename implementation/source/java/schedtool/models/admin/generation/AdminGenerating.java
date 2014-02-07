package models.admin.generation;
import java.util.Vector;

import models.data.databases.*;
/**
 * Model to be called when user wants to generate.
 * @author Jarred Stelfox
 * @version 1
 */
public class AdminGenerating {
	/**
	 * Main algorithm behind the generation.
	 * @return a schedule.
	 */
	public void generate() {
		String[] prefixes = {"CPE","CSC","MATH","AERO","BIO","EE","ME","CHEM"};
		int numToAddToTable = 50;
		
		for(int i = 0; i < numToAddToTable; i++)
		{
			Schedule generatedSchedule = new Schedule();
			//Course testCourse = new Course();
			//testCourse.setCourseNum((int) Math.random() * 500);
			//testCourse.setPrefix(prefixes[(int) Math.random() * prefixes.length]);
			//testCourse.setUnits(4);
			//testCourse.hasLab(false);
			Instructor testInstructor = new Instructor();
			testInstructor.firstName = "Gene";
			testInstructor.lastName = "Fisher";
			testInstructor.username = "gfisher";
			Location testLocation = new Location(""+((int)Math.random() * 100), ""+((int)Math.random() * 200), (int)Math.random() * 50, new String[1]);
			//ArrayList<Day> testdays = new ArrayList<Day>();
			//testDays.add(new Day());
			Section testSection = new Section(/*testCourse*/null, 0, testInstructor, testLocation, /*testdays*/null);
			generatedSchedule.setOneSection(testSection);
		}
		//add schedule(collection of sections) to main table... how?
		System.out.println("AdminGenerating.GENERATING!!!");
	}
}
