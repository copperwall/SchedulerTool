package models.admin.generation;

import static org.junit.Assert.*;
import models.data.databases.Course;
import models.data.databases.Location;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class SectionTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCourse() {
		//Course(String prefix, int courseNum, int units, String title, boolean hasEquipment, int labLength, Course.LabProximity labProx, boolean labHasEquipment) {
		int sectionNum = 1;
		int startTime = 2;
		int endTime = 4;
		String days = "MWF";
		String buildingNum = "" + 14;
		String roomNum = "" + 256;
		int roomCap = 50;
		boolean roomHasEquip = true;
		
		models.data.databases.Course tempCourse = new models.data.databases.Course("CSC", 101, 4, "title", true, 1, Course.LabProximity.DIRECTLY_AFTER, true);
		models.data.databases.Instructor tempInstructor = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		Location tempLocation = new Location(buildingNum, roomNum, roomCap, roomHasEquip);
		Section testSection = new Section(tempCourse, sectionNum, tempInstructor, tempLocation, days, startTime, endTime);
		testSection.setEnrolled(50);
		
		assertEquals(testSection.getCourse(), tempCourse);
	}

	@Test
	public void testSetCourse() {
		int sectionNum = 1;
		int startTime = 2;
		int endTime = 4;
		String days = "MWF";
		String buildingNum = "" + 14;
		String roomNum = "" + 256;
		int roomCap = 50;
		boolean roomHasEquip = true;
		
		models.data.databases.Course tempCourse = new models.data.databases.Course("CSC", 101, 4, "title", true, 1, Course.LabProximity.DIRECTLY_AFTER, true);
		models.data.databases.Course tempCourse2 = new models.data.databases.Course("CSC", 102, 4, "title", true, 1, Course.LabProximity.DIRECTLY_AFTER, true);
		models.data.databases.Instructor tempInstructor = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		Location tempLocation = new Location(buildingNum, roomNum, roomCap, roomHasEquip);
		Section testSection = new Section(tempCourse, sectionNum, tempInstructor, tempLocation, days, startTime, endTime);
		testSection.setCourse(tempCourse2);
		testSection.setEnrolled(50);
		
		assertFalse(testSection.getCourse().equals(tempCourse));
		assertTrue(testSection.getCourse().equals(tempCourse2));
	}

	@Test
	public void testGetCourseNo() {
		int sectionNum = 1;
		int startTime = 2;
		int endTime = 4;
		String days = "MWF";
		String buildingNum = "" + 14;
		String roomNum = "" + 256;
		int roomCap = 50;
		boolean roomHasEquip = true;
		
		models.data.databases.Course tempCourse = new models.data.databases.Course("CSC", 101, 4, "title", true, 1, Course.LabProximity.DIRECTLY_AFTER, true);
		models.data.databases.Instructor tempInstructor = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		Location tempLocation = new Location(buildingNum, roomNum, roomCap, roomHasEquip);
		Section testSection = new Section(tempCourse, sectionNum, tempInstructor, tempLocation, days, startTime, endTime);
		testSection.setEnrolled(50);
		
		assertEquals(testSection.getCourseNo(), "101");
	}

	@Test
	public void testGetSectionNum() {
		int sectionNum = 1;
		int startTime = 2;
		int endTime = 4;
		String days = "MWF";
		String buildingNum = "" + 14;
		String roomNum = "" + 256;
		int roomCap = 50;
		boolean roomHasEquip = true;
		
		models.data.databases.Course tempCourse = new models.data.databases.Course("CSC", 101, 4, "title", true, 1, Course.LabProximity.DIRECTLY_AFTER, true);
		models.data.databases.Instructor tempInstructor = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		Location tempLocation = new Location(buildingNum, roomNum, roomCap, roomHasEquip);
		Section testSection = new Section(tempCourse, sectionNum, tempInstructor, tempLocation, days, startTime, endTime);
		testSection.setEnrolled(50);
		
		assertEquals(testSection.getSectionNum(), 1);
	}

	@Test
	public void testSetSectionNum() {
		int sectionNum = 1;
		int startTime = 2;
		int endTime = 4;
		String days = "MWF";
		String buildingNum = "" + 14;
		String roomNum = "" + 256;
		int roomCap = 50;
		boolean roomHasEquip = true;
		
		models.data.databases.Course tempCourse = new models.data.databases.Course("CSC", 101, 4, "title", true, 1, Course.LabProximity.DIRECTLY_AFTER, true);
		models.data.databases.Instructor tempInstructor = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		Location tempLocation = new Location(buildingNum, roomNum, roomCap, roomHasEquip);
		Section testSection = new Section(tempCourse, sectionNum, tempInstructor, tempLocation, days, startTime, endTime);
		testSection.setEnrolled(50);
		testSection.setSectionNum(5);
		
		assertEquals(testSection.getSectionNum(), 5);
	}

	@Test
	public void testGetInstructor() {
		int sectionNum = 1;
		int startTime = 2;
		int endTime = 4;
		String days = "MWF";
		String buildingNum = "" + 14;
		String roomNum = "" + 256;
		int roomCap = 50;
		boolean roomHasEquip = true;
		
		models.data.databases.Course tempCourse = new models.data.databases.Course("CSC", 101, 4, "title", true, 1, Course.LabProximity.DIRECTLY_AFTER, true);
		models.data.databases.Instructor tempInstructor = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		Location tempLocation = new Location(buildingNum, roomNum, roomCap, roomHasEquip);
		Section testSection = new Section(tempCourse, sectionNum, tempInstructor, tempLocation, days, startTime, endTime);
		testSection.setEnrolled(50);
		
		assertEquals(testSection.getInstructor(), tempInstructor);
	}

	@Test
	public void testSetInstructor() {
		int sectionNum = 1;
		int startTime = 2;
		int endTime = 4;
		String days = "MWF";
		String buildingNum = "" + 14;
		String roomNum = "" + 256;
		int roomCap = 50;
		boolean roomHasEquip = true;
		
		models.data.databases.Course tempCourse = new models.data.databases.Course("CSC", 101, 4, "title", true, 1, Course.LabProximity.DIRECTLY_AFTER, true);
		models.data.databases.Instructor tempInstructor = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		models.data.databases.Instructor mrPresident = new models.data.databases.Instructor("Barak", "Obama", "bobama", 15, true);
		Location tempLocation = new Location(buildingNum, roomNum, roomCap, roomHasEquip);
		Section testSection = new Section(tempCourse, sectionNum, tempInstructor, tempLocation, days, startTime, endTime);
		testSection.setEnrolled(50);
		testSection.setInstructor(mrPresident);
		assertEquals(testSection.getInstructor(), mrPresident);
	}

	@Test
	public void testSetLocation() {
		int sectionNum = 1;
		int startTime = 2;
		int endTime = 4;
		String days = "MWF";
		String buildingNum = "" + 14;
		String roomNum = "" + 256;
		int roomCap = 50;
		boolean roomHasEquip = true;
		
		models.data.databases.Course tempCourse = new models.data.databases.Course("CSC", 101, 4, "title", true, 1, Course.LabProximity.DIRECTLY_AFTER, true);
		models.data.databases.Instructor tempInstructor = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		Location tempLocation = new Location(buildingNum, roomNum, roomCap, roomHasEquip);
		Location tempLocation2 = new Location(buildingNum + 1, roomNum + 1, roomCap - 1, !roomHasEquip);
		Section testSection = new Section(tempCourse, sectionNum, tempInstructor, tempLocation, days, startTime, endTime);
		testSection.setEnrolled(50);
		testSection.setLocation(tempLocation2);
		
		assertEquals(testSection.getLocation(), tempLocation2);
	}

	@Test
	public void testSetLinkedSectionNum() {
		int sectionNum = 1;
		int startTime = 2;
		int endTime = 4;
		String days = "MWF";
		String buildingNum = "" + 14;
		String roomNum = "" + 256;
		int roomCap = 50;
		boolean roomHasEquip = true;
		
		models.data.databases.Course tempCourse = new models.data.databases.Course("CSC", 101, 4, "title", true, 1, Course.LabProximity.DIRECTLY_AFTER, true);
		models.data.databases.Instructor tempInstructor = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		Location tempLocation = new Location(buildingNum, roomNum, roomCap, roomHasEquip);
		Section testSection = new Section(tempCourse, sectionNum, tempInstructor, tempLocation, days, startTime, endTime);
		testSection.setEnrolled(50);
		testSection.setLinkedSectionNum(42);
		
		assertEquals(testSection.getLinkedSectionNum(), 42);
	}

	@Test
	public void testSetDays() {
		int sectionNum = 1;
		int startTime = 2;
		int endTime = 4;
		String days = "MWF";
		String buildingNum = "" + 14;
		String roomNum = "" + 256;
		int roomCap = 50;
		boolean roomHasEquip = true;
		
		models.data.databases.Course tempCourse = new models.data.databases.Course("CSC", 101, 4, "title", true, 1, Course.LabProximity.DIRECTLY_AFTER, true);
		models.data.databases.Instructor tempInstructor = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		Location tempLocation = new Location(buildingNum, roomNum, roomCap, roomHasEquip);
		Section testSection = new Section(tempCourse, sectionNum, tempInstructor, tempLocation, days, startTime, endTime);
		testSection.setEnrolled(50);
		testSection.setDays("TR");
		
		assertEquals(testSection.getDays(), "TR");
	}

	@Test
	public void testSetStartTime() {
		int sectionNum = 1;
		int startTime = 2;
		int endTime = 4;
		String days = "MWF";
		String buildingNum = "" + 14;
		String roomNum = "" + 256;
		int roomCap = 50;
		boolean roomHasEquip = true;
		
		models.data.databases.Course tempCourse = new models.data.databases.Course("CSC", 101, 4, "title", true, 1, Course.LabProximity.DIRECTLY_AFTER, true);
		models.data.databases.Instructor tempInstructor = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		Location tempLocation = new Location(buildingNum, roomNum, roomCap, roomHasEquip);
		Section testSection = new Section(tempCourse, sectionNum, tempInstructor, tempLocation, days, startTime, endTime);
		testSection.setEnrolled(50);
		testSection.setStartTime(6);
		
		assertEquals(testSection.getStartTime(), 6);
	}

	@Test
	public void testSetEndTime() {
		int sectionNum = 1;
		int startTime = 2;
		int endTime = 4;
		String days = "MWF";
		String buildingNum = "" + 14;
		String roomNum = "" + 256;
		int roomCap = 50;
		boolean roomHasEquip = true;
		
		models.data.databases.Course tempCourse = new models.data.databases.Course("CSC", 101, 4, "title", true, 1, Course.LabProximity.DIRECTLY_AFTER, true);
		models.data.databases.Instructor tempInstructor = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		Location tempLocation = new Location(buildingNum, roomNum, roomCap, roomHasEquip);
		Section testSection = new Section(tempCourse, sectionNum, tempInstructor, tempLocation, days, startTime, endTime);
		testSection.setEnrolled(50);
		testSection.setEndTime(8);
		
		assertEquals(testSection.getEndTime(), 8);
	}

	@Test
	public void testSetEnrolled() {
		int sectionNum = 1;
		int startTime = 2;
		int endTime = 4;
		String days = "MWF";
		String buildingNum = "" + 14;
		String roomNum = "" + 256;
		int roomCap = 50;
		boolean roomHasEquip = true;
		
		models.data.databases.Course tempCourse = new models.data.databases.Course("CSC", 101, 4, "title", true, 1, Course.LabProximity.DIRECTLY_AFTER, true);
		models.data.databases.Instructor tempInstructor = new models.data.databases.Instructor("Gene", "Fisher", "gfisher", 15, true);
		Location tempLocation = new Location(buildingNum, roomNum, roomCap, roomHasEquip);
		Section testSection = new Section(tempCourse, sectionNum, tempInstructor, tempLocation, days, startTime, endTime);
		testSection.setEnrolled(50);
		testSection.getTime();
		assertEquals(50, testSection.getEnrolled());
	}

}
