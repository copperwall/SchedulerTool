package models.data.databases;
import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for <a href="InstructorDB.html">Instructor</a>. It implements the
 * following test plan:
 *                                                                        <ul>
 *                                                                      <p><li>
 *     Phase 1: Unit test the constructor.
 *                                                                      <p><li>
 *     Phase 2: Unit test getting class preferences
 *                                                                      <p><li>
 *     Phase 3: Unit test setting class preferences
 *                                                                        </ul>
 * @author Calvin Elizan
 *
 */
public class InstructorTest {
	@Before
	public void setUp()
	{
	}
	
	/**
	 * Unit test the constructor for an Instructor. Only one kind of instructor,
	 * so it only needs one test.
	 * 																			<pre>
	 *  Test
     *  Case    Input                    Output             Remarks
     * ====================================================================
     *   1      {"Test Name", "tname"    Proper init done   Only case
     *           10, false}
     *                                                                         </pre>
	 */
	@Test
	public void testConstructor()
	{
		Instructor test = new Instructor("Test Name", "tname", 10, false);
		
		assertTrue(test != null);
	}
	
	/**
	 * Unit test getting an instructor's user name
	 * 																			<pre>
	 *  Test
     *  Case    Input                    Output             Remarks
     * ====================================================================
     *   1      {"Test Name", "tname"    "tname"            Only case
     *           10, false}
     *                                                                         </pre>
	 */
	@Test
	public void testGetUserID()
	{
		Instructor test = new Instructor("Test Name", "tname", 10, false);
		
		assertTrue(test.getUser().equals("tname"));
	}
	
	/**
	 * Unit test getting an instructor's work time units.
	 * 																			<pre>
	 *  Test
     *  Case    Input                    Output             Remarks
     * ====================================================================
     *   1      {"Test Name", "tname"    10                 Only case
     *           10, false}
     *                                                                         </pre>
	 */
	@Test
	public void testGetWTU()
	{
		Instructor test = new Instructor("Test Name", "tname", 10, false);
		
		assertTrue(test.getWtu() == 10);
	}
	
	/**
	 * Unit test for checking if an instructor is active.
	 * 																			<pre>
	 *  Test
     *  Case    Input                    Output             Remarks
     * ====================================================================
     *   1      {"Test Name", "tname"    false              Inactive instructor
     *           10, false}
     *           
     *   2      {"Eikichi Onizuka",
     *           "eonizuka", 5, true}    true               Active instructor
     *                                                                         </pre>
	 */
	@Test
	public void testGetActive()
	{
		Instructor test = new Instructor("Test Name", "tname", 10, false);
		
		assertTrue(test.getAct() == false);
		
		test = new Instructor("Eikichi Onizuka", "eonizuka", 10, true);
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
	public void testGettingPrefs()
	{
		Instructor test = new Instructor("Test Name", "tname", 10, false);
		
		assertTrue(new Vector<CoursePreference>().containsAll(test.getAllClassPrefs()));
	}
}
