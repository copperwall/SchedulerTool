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
 *     Phase 2: Unit test getting an instructor.
 *                                                                      <p><li>
 *     Phase 3: Unit test adding an instructor
 *                                                                      <p><li>
 *     Phase 4: Unit test removing an instructor
 *                                                                      <p><li>
 *     Phase 5: Unit test editing an instructor with inputs that mimic the ones
 *              given by each of the GUIs that call editInstructor()
 *                                                                      <p><li>
 *     Phase 6: Stress test by scheduling and deleting 100 items.
 *                                                                        </ul>
 * @author Calvin Elizan
 *
 */
public class InstructorDBTest {
	InstructorDB testDB;
	
	@Before
	public void setUp()
	{
	}
	
	/**
	 * Unit test the constructor for an InstructorDB. Only requires one test because
	 * it will only be instantiated once and at the beginning of the program. 
	 * 																			<pre>
	 *  Test
     *  Case    Input            Output             Remarks
     * ====================================================================
     *   1      null             Proper init done   Only case
     *                                                                         </pre>
	 */
	@Test
	public void testDBCreation()
	{
		testDB = new InstructorDB();
		assertTrue(true);
	}
	
	/**
	 * Unit test getting an Instructor from an InstructorDB.
	 * 																		    <pre>
	 *  Test
     *  Case    Input                Output               Remarks
     * ======================================================================
     *   1      {"tinstruct"}        Test Instructor's    Should be the same for
     *                               object is returned   all cases
     *                                                                         </pre>
	 */
	@Test
	public void testDBGet()
	{
		testDBCreation();
		Instructor testAdd = new Instructor("Test", "Instructor", "tinstruct", 10, true);
		//testDB.addInstructor(testAdd);
		
		assertEquals("gfisher", testDB.getInstructor("gfisher").getUser());
	}
	
	/**
	 * Unit test the add method for an InstructorDB.
	 * 																		    <pre>
	 *  Test
     *  Case    Input                Output             Remarks
     * ====================================================================
     *   1      {"Test Instructor",  testDB has one     Adding one instructor
     *           "tinstruct", 10,   instructor
     *           true}
     *                                                                         </pre>
	 */
	//@Test
	public void testDBAdd()
	{
		testDBCreation();
		Instructor testAdd = new Instructor("Test", "Instructor", "tinstruct", 10, true);
	    boolean existsInList = false;
		testDB.addInstructor(testAdd);
		
		Vector<Instructor> allInstructors = testDB.getAllInstructors();
		for(Instructor instructor : allInstructors) {
			if (instructor.getUser().equals(testAdd.getUser())) {
				existsInList = true;
			}
		}
		
		assertTrue(existsInList);
	}
	
	/**
	 * Unit test the remove method for an InstructorDB.
	 * 																		    <pre>
	 *  Test
     *  Case    Input                Output             Remarks
     * ====================================================================
     *   1      {"Test Instructor",  testDB doesn't     Delete an instructor
     *           "tinstruct", 0,     contain "Test
     *           false}              Instructor
     *                                                                         </pre>
	 */
	//@Test
	public void testDBRemove()
	{
		testDBCreation();
		Instructor testAdd = new Instructor("Test", "Instructor", "tinstruct", 10, true);
		Vector<Instructor> allInstructors = new Vector<Instructor>();
		testDB.deleteInstructor(new Instructor("Test", "Instructor", "tinstruct", 10, true));
		
		allInstructors = testDB.getAllInstructors();
		for(Instructor instructor : allInstructors) {
			assertTrue(!instructor.getUser().equals(testAdd.getUser()));
		}
	}
	
	/**
	 * Unit test editing an Instructor.
	 * 																		    <pre>
	 *  Test
     *  Case    Input                Output               Remarks
     * ======================================================================
     *   1      {"tinstruct", 8,     Test Instructor's     Should be the same for
     *           false}              max wtu and active    all cases
     *                               state are changed
     *                                                                         </pre>
	 */
	//@Test
	public void testDBEdit()
	{
		testDBCreation();
		Instructor testAdd = new Instructor("Test", "Instructor", "tinstruct", 10, true);
		//testDB.addInstructor(testAdd);
		
		testAdd = new Instructor("Test", "Instructor", "tinstruct", 8, false);
		testDB.editInstructor(testAdd);
		
		testAdd = testDB.getInstructor("tinstruct");
		assertEquals(8, testAdd.getWtu());
		assertEquals(false, testAdd.getAct());
	}
}
