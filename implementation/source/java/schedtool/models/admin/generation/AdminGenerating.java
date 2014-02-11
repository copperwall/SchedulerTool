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
	private Schedule generatedSchedule;
	public AdminGenerating()
	{
		generatedSchedule = new Schedule();
	}
	public void generate() {
		String[] prefixes = {"CPE","CSC","MATH","AERO","BIO","EE","ME","CHEM"};
		String[] days ={"MWF","TR","MTRF","MTWR","MW","MF","WF"};
		int numToAddToTable = 50;
		for(int i = 0; i < numToAddToTable; i++)
		{
			Course testCourse = new Course(prefixes[(int) (Math.random() * prefixes.length)], (int) (Math.random() * 500), false, 4, "");
			Instructor testInstructor = new Instructor();
			testInstructor.firstName = "Gene";
			testInstructor.lastName = "Fisher";
			testInstructor.username = "gfisher";
			Location testLocation = new Location(""+(int)(Math.random() * 100), ""+(int)(Math.random() * 200), (int)(Math.random() * 50), new String[1]);
			Section testSection = new Section(testCourse, 0, testInstructor, testLocation, days[(int)(Math.random()*days.length)],(int) (Math.random() * 12), (int) (Math.random() * 12));
			generatedSchedule.setOneSection(testSection);
		}
		//add schedule(collection of sections) to main table... how?
		System.out.println("AdminGenerating.GENERATING!!!");
	}
	
	public Schedule getSchedule() {
		return generatedSchedule;
	}
}
