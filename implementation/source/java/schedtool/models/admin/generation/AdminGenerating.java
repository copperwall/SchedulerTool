package models.admin.generation;
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
		Schedule generatedSchedule = new Schedule();
		//Course testCourse = new Course();
		Instructor testInstructor = new Instructor();
		//ArrayList<Day> testdays = new ArrayList<Day>();
		//Section testSection = new Section(testCourse, 0, testInstructor, null, testdays);
		//generatedSchedule.setOneSection(testSection);
		System.out.println("AdminGenerating.GENERATING!!!");
	}
}
