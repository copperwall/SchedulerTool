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
		int numToAddToTable = 500;
		for(int i = 0; i < numToAddToTable; i++)
		{
			boolean hasLab = Math.random() < 0.5;
			boolean isLab = Math.random() < 0.5;
			Course testCourse = new Course(prefixes[(int) (Math.random() * prefixes.length)], (int) (Math.random() * 500), hasLab, (int)(Math.random()*4)+1, "");
			if(hasLab)
				testCourse.setLabProx(Course.LabProximity.values()[(int)(Math.random()*Course.LabProximity.values().length)]);
			Instructor testInstructor = new Instructor();
			testInstructor.firstName = "Gene";
			testInstructor.lastName = "Fisher";
			testInstructor.username = "gfisher";
			Location testLocation = new Location(""+(int)(Math.random() * 100), ""+(int)(Math.random() * 200), (int)(Math.random() * 50), new String[1]);
			Section testSection = new Section(testCourse, (int)(Math.random()*150) + 1, testInstructor, testLocation, days[(int)(Math.random()*days.length)],(int) (Math.random() * 11) + 1, (int) (Math.random() * 11) + 1);
			testSection.setEnrolled((int)(Math.random()*150));
			if(isLab)
				testSection.setLinkedSectionNum((int)(Math.random()*20));
			generatedSchedule.setOneSection(testSection);
		}
		System.out.println("AdminGenerating.GENERATING!!!");
	}
	
	public Schedule getSchedule() {
		return generatedSchedule;
	}
}
