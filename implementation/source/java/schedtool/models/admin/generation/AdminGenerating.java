package models.admin.generation;
import java.util.Vector;

import javafx.scene.layout.AnchorPane;
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
		String[] days ={"MWF","TR","MTRF","MTWR","MW","MF","WF"};
		int numToAddToTable = 50;
		Schedule generatedSchedule = new Schedule();
		for(int i = 0; i < numToAddToTable; i++)
		{
			Course testCourse = new Course(prefixes[(int) (Math.random() * prefixes.length)], (int) (Math.random() * 500), false, 4, "");
			Instructor testInstructor = new Instructor();
			testInstructor.firstName = "Gene";
			testInstructor.lastName = "Fisher";
			testInstructor.username = "gfisher";
			Location testLocation = new Location(""+(int)(Math.random() * 100), ""+(int)(Math.random() * 200), (int)(Math.random() * 50), new String[1]);
			Section testSection = new Section(testCourse, 0, testInstructor, testLocation, days[(int)Math.random()*days.length]);
			generatedSchedule.setOneSection(testSection);
		}
		//add schedule(collection of sections) to main table... how?
		for(Section sec : generatedSchedule.getAllSections())
		{
			System.out.println(sec.getCourse().coursePrefix +" "+ sec.getCourse().courseNo +" "+ sec.getInstructor().firstName +sec.getInstructor().lastName +" "+ sec.getLocation().getBuilding() + " "+ sec.getLocation().getRoom() +" "+sec.getLocation().getCapacity());
		}
		System.out.println("AdminGenerating.GENERATING!!!");
	}
}
