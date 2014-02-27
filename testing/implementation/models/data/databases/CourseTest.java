package models.data.databases;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for <a href="Course.html">Course</a>. It implements the
 * following test plan:
 <ul>
 <p><li>
 *     Phase 1: Unit test the constructor.
 <p><li>
 *     Phase 2: Unit test getting the course prefix
 <p><li>
 *     Phase 3: Unit test getting the course number 
 <p><li>
 *     Phase 4: Unit test getting the course title
 <p><li>
 *     Phase 5: Unit test getting the course units
 </ul>
 * @author Katie Keim
 */
public class CourseTest {
	@Before
	public void setUp()
	{
	}
	
	/**
	 * Unit test the constructor for an Course.
	 <pre>
	  *  Test
     *  Case    Input                    Output             Remarks
     * ====================================================================
     *   1      {"CPE", 309, 4,          Proper init done    Construct a Course
     *   "Software Engineering II", 1, 
     *   Course.LabProximity.DIRECTLY_AFTER}                               
    </pre>
	 */
	@Test
	public void testConstructor()
	{
		Course test = new Course("CPE", 309, 4, "Software Engineering II", false, 1, Course.LabProximity.DIRECTLY_AFTER, false);
		assertTrue(test != null);
	}
	
	/**
	 * Unit test getting an course's prefix
	 <pre>
	 *  Test
     *  Case    Input                    Output             Remarks
     * ====================================================================
     *   1      {"CPE", 309, 4,           "CPE"           Getting a course prefix
     *   "Software Engineering II", 1, 
     *   Course.LabProximity.DIRECTLY_AFTER}
     </pre>
	 */
	@Test
	public void testGetPrefix() {
		Course test = new Course("CPE", 309, 4, "Software Engineering II", false, 1, Course.LabProximity.DIRECTLY_AFTER, false);
		assertEquals(test.getPrefix(), "CPE");
	}
	
	/**
	 * Unit test getting an course's id number.
	 <pre>
	 *  Test
     *  Case    Input                    Output             Remarks
     * ====================================================================
     *   1 {""CPE", 309, 4,                309             Get Course Number
     *   "Software Engineering II", 1, 
     *   Course.LabProximity.DIRECTLY_AFTER}
     </pre>
	 */
	@Test
	public void testGetCourseNum() {
		Course test = new Course("CPE", 309, 4, "Software Engineering II", false, 1, Course.LabProximity.DIRECTLY_AFTER, false);
		assertEquals(test.getCourseNum(), 309);
	}
	
	/**
	 * Unit test for getting a course title
	 <pre>
	 *  Test
     *  Case    Input                    Output             Remarks
     * ====================================================================
     *   1 {"CPE", 309, 4,         "Software Engineering II"   Getting a course title
     *   "Software Engineering II", 1, 
     *   Course.LabProximity.DIRECTLY_AFTER}
     </pre>
	 */
	@Test
	public void testGetTitle() {
		Course test = new Course("CPE", 309, 4, "Software Engineering II", false, 1, Course.LabProximity.DIRECTLY_AFTER, false);
		assertEquals(test.getTitle(), "Software Engineering II");
	}
	
	/**
	 * Unit test getting course preferences.
	 <pre>
	 *  Test
     *  Case    Input                    Output               Remarks
     * ======================================================================
     *   1      {"CPE", 309, 4,           4                Getting a course's units
     *   "Software Engineering II", 1, 
     *   Course.LabProximity.DIRECTLY_AFTER}
     </pre>
	 */
	@Test
	public void testGetUnits() {
		Course test = new Course("CPE", 309, 4, "Software Engineering II", false, 1, Course.LabProximity.DIRECTLY_AFTER, false);
		assertEquals(test.getUnits(), 4);
	}
}