package models.admin.generation;
import java.util.ArrayList;
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
	
	private class Course {
	   String prefix; 
	   String num;
	   
	   public Course(String prefix, String num) {
	      this.prefix = prefix;
	      this.num = num;
	   }
	}
	
	private class Instructor {
	   String first;
	   String last;
	   
	   public Instructor(String first, String last) {
	      this.first = first;
	      this.last = last;
	   }
	}
	
	public void generate() {
		String[] days ={"MWF","TR","MTRF","MTWR","MW","MF","WF"};
		
		ArrayList<Instructor> instructors = new ArrayList<Instructor>();
		ArrayList<Course> courses = new ArrayList<Course>();
		courses.add(new Course("CPE", "101"));
		courses.add(new Course("CPE", "102"));
		courses.add(new Course("CPE", "103"));
		courses.add(new Course("CSC", "141"));
		courses.add(new Course("CSC", "225"));
		courses.add(new Course("CPE", "315"));
		courses.add(new Course("CPE", "349"));
		courses.add(new Course("CPE", "307"));
		courses.add(new Course("CPE", "308"));
		courses.add(new Course("CPE", "309"));
		courses.add(new Course("CPE", "453"));

		instructors.add(new Instructor("Paul", "Hatalsky"));
		instructors.add(new Instructor("Clint", "Staley"));
		instructors.add(new Instructor("John", "Seng"));
		instructors.add(new Instructor("Phillip", "Nico"));
		instructors.add(new Instructor("Julie", "Workman"));
		instructors.add(new Instructor("Timothy", "Kearns"));
		instructors.add(new Instructor("Hasmik", "Gharibyan"));
		instructors.add(new Instructor("John", "Dalby"));
		instructors.add(new Instructor("Kurt", "Mammen"));
		instructors.add(new Instructor("Ignatios", "Vakalis"));
		instructors.add(new Instructor("John", "Clements"));
		instructors.add(new Instructor("David", "Janzen"));
		instructors.add(new Instructor("Clark", "Turner"));
		instructors.add(new Instructor("Gene", "Fisher"));
		instructors.add(new Instructor("William", "Buckalew"));
		instructors.add(new Instructor("Christopher", "Lupo"));
		instructors.add(new Instructor("Alexander", "Dekhtyar"));
		instructors.add(new Instructor("Foaad", "Khosmood"));

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
			Location testLocation = new Location(""+(int)(Math.random() * 100), ""+(int)(Math.random() * 200), (int)(Math.random() * 50), true);
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
