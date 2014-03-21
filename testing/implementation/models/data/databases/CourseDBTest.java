package models.data.databases;

import static org.junit.Assert.*;

import java.util.ArrayList;

import models.data.databases.Course;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for <a href="CourseDB.html">CourseDB</a>. It implements the
 * following test plan:
 <ul>
 <p><li>
 *     Phase 1: Unit test the constructor.
 <p><li>
 *     Phase 2: Unit test getting a course.
 <p><li>
 *     Phase 3: Unit test adding a course.
 <p><li>
 *     Phase 4: Unit test removing a course.
 <p><li>
 *     Phase 5: Unit test editing a course.
 <p><li>
 *     Phase 6: Unit test getting all courses.     
 </ul>
 * @author Katie Keim
 *
 */
public class CourseDBTest {
	CourseDB testDB;
	
	@Before
	public void setUp() {
	}
	
	/**
	 * Unit test the constructor for an CourseDB. Only requires one test because
	 * it will only be instantiated once at the beginning of the program. 
	 <pre>
	 *  Test
     *  Case    Input            Output             Remarks
     * ====================================================================
     *   1      null             Proper init done   Only case
     </pre>
	 */
	@Test
	public void testDBCreation() {
		testDB = new CourseDB();
		assertTrue(true);
	}
	
	/**
	 * Unit test getting a Course from a CourseDB.
	 <pre>
	  *  Test
     *  Case    Input                        Output               Remarks
     * ======================================================================
     *   1   Course {"CPE", 309, 4,        Course object   Should be the same for
             "Software Engineering II",     is returned         all cases
             false, 1, 
             Course.LabProximity.DIRECTLY_AFTER, false}        
     *                               
     *                                                                      
    </pre>
	 */
	@Test
	public void testDBGet() {
		testDBCreation();
		Course testAdd = new Course("CPE", 309, 4, "Software Engineering II", false, 1, Course.LabProximity.DIRECTLY_AFTER, false);
		testDB.addCourse(testAdd);
		
		assertEquals(testAdd, testDB.getCourse("CPE", 309));
		testDB.deleteCourse(testAdd);
	}
	
	/**
	 * Unit test the add method for an CourseDB.
	 <pre>
	  *  Test
     *  Case    Input                      Output             Remarks
     * ====================================================================
     *   1  Course {"CPE", 308, 4,     testDB contains   Adding one course
            "Software Engineering I",   this course    
            false, 0, null, false}
     *                                                                      
    </pre>
	 */
	@Test
	public void testDBAdd() {
		testDBCreation();
		
		Course testAdd = new Course("CPE", 308, 4, "Software Engineering I", false, 0, null, false);
		testDB.addCourse(testAdd);
		assertTrue(testDB.getAllCourses().contains(testAdd));
		testDB.deleteCourse(testAdd);
	}
	
	/**
	 * Unit test the remove method for an CourseDB.
	 <pre>
	 *  Test
     *  Case    Input                      Output             Remarks
     * ====================================================================
        1  Course {"CPE", 309, 4,    testDB doesn't        Delete a course
         "Software Engineering II",   contain Test          
         false, 1,                        Course
         Course.LabProximity.DIRECTLY_AFTER, false}  
     </pre>
	 */
	@Test
	public void testDBRemove() {
		testDBCreation();
		Course testAdd = new Course("CPE", 309, 4, "Software Engineering II", false, 1, Course.LabProximity.DIRECTLY_AFTER, false);
		testDB.addCourse(testAdd);
		testDB.deleteCourse(testAdd);
		
		assert(!testDB.getAllCourses().contains(testAdd));
	}
	
	/**
	 * Unit test the edit method for an CourseDB.
	 <pre>
	  *  Test
     *  Case    Input                      Output             Remarks
     * ====================================================================
     *   1  Course {"CPE", 308, 4,     testDB contains   Editing one course
            "Software Engineering I",   this course    to have a lab and equipment
            false, 0, null, false}
            
            Edit--> Course {"CPE", 308, 4, "Software Engineering I", true, 1, Course.LabProximity.DIRECTLY_AFTER, true}
     *                                                                      
    </pre>
	 */
	@Test
	public void testDBEdit() {
		testDBCreation();
		
		Course testAdd = new Course("CPE", 308, 4, "Software Engineering I", false, 0, null, false);
		testDB.addCourse(testAdd);
		testDB.editCourse(testAdd, "CPE", 308, 4, "Software Engineering I", true, 1, Course.LabProximity.DIRECTLY_AFTER, true);
		Course testEdit = testDB.getCourse("CPE", 308);
		assertTrue(testEdit.getHasLab());
		assertTrue(testEdit.getHasEquipment());
		assertTrue(testEdit.getLabProx().equals(Course.LabProximity.DIRECTLY_AFTER));
		assertTrue(testEdit.getLabHasEquipment());
		assertTrue(testEdit.getLabLength() == 1);
		
		testDB.deleteCourse(testEdit);
	}
	
	/**
	 * Unit test getting all Courses from a CourseDB.
	 <pre>
	  *  Test
     *  Case    Input                        Output               Remarks
     * ======================================================================
     *   1   {"CPE", 309, 4,               all three courses   Should be the same for
             "Software Engineering II",                             all cases
           false, 0, null, false}   
           
          {"CPE", 308, 4, "Software Engineering I", true, 1, Course.LabProximity.DIRECTLY_AFTER, false}
          {"CPE", 310, 12, "Mystery in Software", false, 5, Course.LabProximity.DIFF_DAY, true }
     *                               
     *                                                                      
    </pre>
	 */
	@Test
	public void testDBGetAll() {
		testDBCreation();
		Course testAdd1 = new Course("CPE", 309, 4, "Software Engineering II", false, 0, null, false);
		Course testAdd2 = new Course("CPE", 308, 4, "Software Engineering I", true, 1, Course.LabProximity.DIRECTLY_AFTER, false);
		Course testAdd3 = new Course("CPE", 310, 12, "Mystery in Software", false, 5, Course.LabProximity.DIFF_DAY, true);
		testDB.addCourse(testAdd1);
		testDB.addCourse(testAdd2);
		testDB.addCourse(testAdd3);
		
		ArrayList<Course> courses = testDB.getAllCourses();
		
		assertTrue(courses.contains(testAdd1));
		assertTrue(courses.contains(testAdd2));
		assertTrue(courses.contains(testAdd3));
		
		testDB.deleteCourse(testAdd1);
		testDB.deleteCourse(testAdd2);
		testDB.deleteCourse(testAdd3);
	}
}
