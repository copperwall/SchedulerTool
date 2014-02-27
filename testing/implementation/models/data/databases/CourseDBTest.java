package models.data.databases;

import static org.junit.Assert.*;
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
     *   1   {"CPE", 309, 4,        Course object   Should be the same for
             "Software Engineering II",     is returned         all cases
     1, Course.LabProximity.DIRECTLY_AFTER}        
     *                               
     *                                                                      
    </pre>
	 */
	@Test
	public void testDBGet() {
		testDBCreation();
		Course testAdd = new Course("CPE", 309, 4, "Software Engineering II", 1, Course.LabProximity.DIRECTLY_AFTER);
		testDB.addCourse(testAdd);
		
		assertEquals(testAdd, testDB.getCourse("CPE", 309));
	}
	
	/**
	 * Unit test the add method for an CourseDB.
	 <pre>
	  *  Test
     *  Case    Input                      Output             Remarks
     * ====================================================================
     *   1  {"CPE", 309, 4,            testDB contains   Adding one course
             "Software Engineering II",  this course     by all the course
     1, Course.LabProximity.DIRECTLY_AFTER}             parameters with a lab
         2  Course {"CPE", 308, 4,     testDB contains   Adding one course by a
            "Software Engineering I",   this course    Course Object without a lab
            0, null}
     *                                                                      
    </pre>
	 */
	@Test
	public void testDBAdd() {
		testDBCreation();
		
		testDB.addCourse("CPE", 309, 4, "Software Engineering II", 1, Course.LabProximity.DIRECTLY_AFTER);	
		assertTrue(testDB.getAllCourses().contains(testDB.getCourse("CPE", 309)));
		
		Course testAdd = new Course("CPE", 308, 4, "Software Engineering I", 0, null);
		testDB.addCourse(testAdd);
		assertTrue(testDB.getAllCourses().contains(testAdd));
	}
	
	/**
	 * Unit test the remove method for an CourseDB.
	 <pre>
	 *  Test
     *  Case    Input                      Output             Remarks
     * ====================================================================
        1  {"CPE", 309, 4,          testDB doesn't        Delete a course
        "Software Engineering II",   contain Test          
     1, Course.LabProximity.DIRECTLY_AFTER}  Course
     </pre>
	 */
	@Test
	public void testDBRemove() {
		testDBCreation();
		Course testAdd = new Course("CPE", 309, 4, "Software Engineering II", 1, Course.LabProximity.DIRECTLY_AFTER);
		testDB.addCourse(testAdd);
		testDB.deleteCourse(testAdd);
		
		assert(!testDB.getAllCourses().contains(testAdd));
	}
}
