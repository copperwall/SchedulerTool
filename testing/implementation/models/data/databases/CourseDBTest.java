package models.data.databases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for <a href="CourseDB.html">Course</a>. It implements the
 * following test plan:
 *                                                                        <ul>
 *                                                                      <p><li>
 *     Phase 1: Unit test the constructor.
 *                                                                      <p><li>
 *     Phase 2: Unit test getting a course.
 *                                                                      <p><li>
 *     Phase 3: Unit test adding a course
 *                                                                      <p><li>
 *     Phase 4: Unit test removing a course
 *                                                                      <p><li>
 *     Phase 5: Unit test editing a course with inputs that mimic the ones
 *              given by each of the GUIs that call editCourse()
 *                                                                      <p><li>
 *     Phase 6: Stress test by scheduling and deleting 100 items.
 *                                                                        </ul>
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
	 * 																			<pre>
	 *  Test
     *  Case    Input            Output             Remarks
     * ====================================================================
     *   1      null             Proper init done   Only case
     *                                                                         </pre>
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
     *   1   {"CPE", 309, true, 4,        Course object   Should be the same for
             "Software Engineering I",     is returned         all cases
     1, Course.LabProximity.DIRECTLY_AFTER}        
     *                               
     *                                                                      
    </pre>
	 */
	@Test
	public void testDBGet() {
		testDBCreation();
		Course testAdd = new Course("CPE", 309, true, 4, "Software Engineering I", 1, Course.LabProximity.DIRECTLY_AFTER);
		testDB.addCourse(testAdd);
		
		assertEquals(testAdd, testDB.getCourse("CPE", 309));
	}
	
	/**
	 * Unit test the add method for an CourseDB.
	 <pre>
	  *  Test
     *  Case    Input                      Output             Remarks
     * ====================================================================
     *   1  {"CPE", 309, true, 4,        testDB has one   Adding one course
             "Software Engineering I",     course          
     1, Course.LabProximity.DIRECTLY_AFTER}    
     *                                                                      
    </pre>
	 */
	@Test
	public void testDBAdd() {
		testDBCreation();
		Course testAdd = new Course("CPE", 309, true, 4, "Software Engineering I", 1, Course.LabProximity.DIRECTLY_AFTER);
		testDB.addCourse(testAdd);
		
		assertTrue(testDB.getAllCourses().contains(testAdd));
	}
	
	/**
	 * Unit test the remove method for an CourseDB.
	 * 																		    <pre>
	 *  Test
     *  Case    Input                      Output             Remarks
     * ====================================================================
        1  {"CPE", 309, true, 4,          testDB doesn't   Delete a course
             "Software Engineering I",     contain Test          
     1, Course.LabProximity.DIRECTLY_AFTER}  Course
     *                                                                         </pre>
	 */
	@Test
	public void testDBRemove() {
		testDBCreation();
		Course testAdd = new Course("CPE", 309, true, 4, "Software Engineering I", 1, Course.LabProximity.DIRECTLY_AFTER);
		testDB.addCourse(testAdd);
		testDB.deleteCourse(new Course("CPE", 309, true, 4, "Software Engineering I", 1, Course.LabProximity.DIRECTLY_AFTER));
		
		assert(!testDB.getAllCourses().contains(testAdd));
	}
}
