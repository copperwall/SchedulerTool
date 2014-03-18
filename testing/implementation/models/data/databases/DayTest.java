package models.data.databases;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for <a href="Day.html">Day</a>. It implements the
 * following test plan:
 *                                                                        <ul>
 *                                                                      <p><li>
 *     Phase 1: Unit test the constructor.
 *                                                                      <p><li>
 *     Phase 2: Unit test getting availability
 *                                                                      <p><li>
 *     Phase 3: Unit test setting availability
 *                                                                        </ul>
 * @author Calvin Elizan
 *
 */
public class DayTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testConstructor() {
	    Day test = new Day("111100001111000011110000");
	    
	    assertTrue(test != null);
	    
	    try {
	        test = new Day("0000");
	        assertTrue(false);
	    }
	    catch (StringIndexOutOfBoundsException exc) {
	        assertTrue(true);
	    }
	}
	
	@Test
	public void testGettingAvailability() {
	    Day test = new Day("111100001111000011110000");
	    
	    ArrayList<Boolean> result = test.getAvailability();
	    ArrayList<Boolean> expected = new ArrayList<Boolean>();
	    
	    assertTrue(result.size() == 24);
	    for (int i = 0; i < 4; i++) {
	        expected.add(true);
	    }
	    for (int i = 0; i < 4; i++) {
            expected.add(false);
        }
	    for (int i = 0; i < 4; i++) {
            expected.add(true);
        }
	    for (int i = 0; i < 4; i++) {
            expected.add(false);
        }
        for (int i = 0; i < 4; i++) {
            expected.add(true);
        }
        for (int i = 0; i < 4; i++) {
            expected.add(false);
        }
	    
	    for (int i = 0; i < 24; i++) {
	        assertTrue(expected.get(i).equals(result.get(i)));
	    }
	}

}
