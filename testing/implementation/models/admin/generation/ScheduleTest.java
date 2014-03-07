/**
 * 
 */
package models.admin.generation;

import static org.junit.Assert.*;

import java.util.Vector;

import models.admin.generation.Schedule;
import models.admin.generation.Section;
import models.data.databases.Course;
import models.data.databases.Instructor;
import models.data.databases.Location;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jarred
 *
 */
public class ScheduleTest {

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link models.admin.generation.Schedule#getSections()}.
	 */
	@Test
	public void testGetSections() {
		Schedule schedule = new Schedule();
		boolean hasLab = false;
		boolean isLab = false;
		int count = 0;
		models.data.databases.Course testCourse = new models.data.databases.Course("CSC", 101, 4, "title", false, 0, null, false);
		models.data.databases.Instructor testInstructor = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		Location testLocation = new Location(""+14, ""+256, 50, true);
		Section testSection = new Section(testCourse, count++, testInstructor, testLocation, "MWF", 2, 4);
		testSection.setEnrolled(50);
		schedule.setOneSection(testSection);
		assertEquals(schedule.getAllSections().size(),1);
	}

	/**
	 * Test method for {@link models.admin.generation.Schedule#setAllSections(java.util.Vector)}.
	 */
	@Test
	public void testSetAllSections() {
		Schedule schedule = new Schedule();
		Vector<Section>sections = new Vector<Section>();
		boolean hasLab = false;
		boolean isLab = false;
		int count = 0;
		models.data.databases.Course testCourse = new models.data.databases.Course("CSC", 101, 4, "title", false, 0, null, false);
		models.data.databases.Instructor testInstructor = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		Location testLocation = new Location(""+14, ""+256, 50, true);
		Section testSection = new Section(testCourse, count++, testInstructor, testLocation, "MWF", 2, 4);
		testSection.setEnrolled(50);
		sections.add(testSection);
		models.data.databases.Course testCourse2 = new models.data.databases.Course("CSC", 101, 4, "title", false, 0, null, false);
		models.data.databases.Instructor testInstructor2 = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		Location testLocation2 = new Location(""+14, ""+256, 50, true);
		Section testSection2 = new Section(testCourse, count++, testInstructor, testLocation, "MWF", 2, 4);
		testSection2.setEnrolled(50);
		sections.add(testSection2);
		
		schedule.setAllSections(sections);
		assertEquals(schedule.getAllSections().size(),2);
	}

	/**
	 * Test method for {@link models.admin.generation.Schedule#getOneSection(int, models.data.databases.Course)}.
	 */
	@Test
	public void testGetOneSection() {
		Schedule schedule = new Schedule();
		Vector<Section>sections = new Vector<Section>();
		boolean hasLab = false;
		boolean isLab = false;
		int count = 0;
		models.data.databases.Course testCourse = new models.data.databases.Course("CSC", 101, 4, "title", false, 0, null, false);
		models.data.databases.Instructor testInstructor = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		Location testLocation = new Location(""+14, ""+256, 50, true);
		Section testSection = new Section(testCourse, count++, testInstructor, testLocation, "MWF", 2, 4);
		testSection.setEnrolled(50);
		sections.add(testSection);
		models.data.databases.Course testCourse2 = new models.data.databases.Course("CSC", 102, 4, "title", false, 0, null, false);
		models.data.databases.Instructor testInstructor2 = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		Location testLocation2 = new Location(""+14, ""+256, 50, true);
		Section testSection2 = new Section(testCourse, count++, testInstructor, testLocation, "MWF", 2, 4);
		testSection2.setEnrolled(50);
		sections.add(testSection2);
		
		schedule.setAllSections(sections);
		Section sec = schedule.getOneSection(0, testCourse);
		schedule.getSections();
		assertEquals(sec.getCourse(),testCourse);
	}

}
