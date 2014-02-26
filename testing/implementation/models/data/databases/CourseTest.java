package models.data.databases;
import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for <a href="CourseDB.html">Course</a>. It implements the
 * following test plan:
 *                                                                        <ul>
 *                                                                      <p><li>
 *     Phase 1: Unit test the constructor.
 *                                                                      <p><li>
 *     Phase 2: Unit test getting the course prefix
 *                                                                      <p><li>
 *     Phase 3: Unit test getting the course number
 *         
 <p><li>
 *     Phase 4: Unit test getting the course title
 *
 <p><li>
 *     Phase 5: Unit test getting the course units
 *
 </ul>
 * @author Katie Keim
 */
public class CourseTest {
	@Before
	public void setUp()
	{
	}
	
	/**
	 * Unit test the constructor for an Course. There are two kinds of courses,
	 * so it only needs two tests.
	 <pre>
	  *  Test
     *  Case    Input                    Output             Remarks
     * ====================================================================
     *   1      {"Test Name", "tname"    Proper init done   with a lab
     *           10, false}
     *   2      { }                      Proper init done   without a lab                                 
    </pre>
	 */
	@Test
	public void testConstructor()
	{
		Course test = new Course("CPE", 309, 4, "Software Engineering I", 1, Course.LabProximity.DIRECTLY_AFTER);
		
		assertTrue(test != null);
      
      Course test = new Course("Test", "Name", "tname", 10, false);
		
		assertTrue(test != null);
	}
	
	/**
	 * Unit test getting an course's user name
	 * 																			<pre>
	 *  Test
     *  Case    Input                    Output             Remarks
     * ====================================================================
     *   1      {"Test Name", "tname"    "tname"            Only case
     *           10, false}
     *                                                                         </pre>
	 */
	@Test
	public void testGetPrefix() {
		Course test = new Course("Test", "Name", "tname", 10, false);
		
		assertTrue(test.getUser().equals("tname"));
	}
	
	/**
	 * Unit test getting an course's work time units.
	 * 																			<pre>
	 *  Test
     *  Case    Input                    Output             Remarks
     * ====================================================================
     *   1      {"Test Name", "tname"    10                 Only case
     *           10, false}
     *                                                                         </pre>
	 */
	@Test
	public void testGetCourseNum() {
		Course test = new Course("Test", "Name", "tname", 10, false);
		
		assertTrue(test.getWtu() == 10);
	}
	
	/**
	 * Unit test for checking if an course is active.
	 * 																			<pre>
	 *  Test
     *  Case    Input                    Output             Remarks
     * ====================================================================
     *   1      {"Test Name", "tname"    false              Inactive course
     *           10, false}
     *           
     *   2      {"Eikichi Onizuka",
     *           "eonizuka", 5, true}    true               Active course
     *                                                                         </pre>
	 */
	@Test
	public void testGetTitle() {
		Course test = new Course("Test", "Name", "tname", 10, false);
		
		assertTrue(test.getAct() == false);
		
		test = new Course("Eikichi", "Onizuka", "eonizuka", 10, true);
		assertTrue(test.getAct() == true);
	}
	
	/**
	 * Unit test getting course preferences.
	 * 																			<pre>
	 *  Test
     *  Case    Input                    Output               Remarks
     * ======================================================================
     *   1      {"Test Name", "tname"    all default course   gets all course
     *           10, false}              prefs                preferences
     *                                                                         </pre>
	 */
	@Test
	public void testGetUnits() {
		Course test = new Course("Test", "Name", "tname", 10, false);
		
		assertTrue(new Vector<CoursePreference>().containsAll(test.getAllClassPrefs()));
	}
}
