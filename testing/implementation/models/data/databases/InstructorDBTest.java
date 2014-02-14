package models.data.databases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for <a href="InstructorDB.html">Instructor</a>.
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
	@Test
	public void testDBAdd()
	{
		testDBCreation();
		Instructor testAdd = new Instructor("Test Instructor", "tinstruct", 10, true);
		testDB.addInstructor(testAdd);
		
		assertTrue(testDB.getAllInstructors().contains(testAdd));
	}
}
