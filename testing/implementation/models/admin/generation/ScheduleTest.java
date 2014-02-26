/**
 * 
 */
package models.admin.generation;

import static org.junit.Assert.*;
import models.admin.generation.Schedule;
import models.admin.generation.Section;
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
		models.data.databases.Course testCourse = new models.data.databases.Course("CSC", 101, hasLab, 4, "");
		models.data.databases.Instructor testInstructor = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		Location testLocation = new Location(""+14, ""+256, 50, new String[1]);
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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link models.admin.generation.Schedule#getAllSections()}.
	 */
	@Test
	public void testGetAllSections() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link models.admin.generation.Schedule#setOneSection(models.admin.generation.Section)}.
	 */
	@Test
	public void testSetOneSection() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link models.admin.generation.Schedule#getOneSection(int, models.data.databases.Course)}.
	 */
	@Test
	public void testGetOneSection() {
		fail("Not yet implemented");
	}

}
