package models.admin.analytics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for an Analytics table row. It implements the following test plan:
 *
 *     Phase 1: Unit test the constructor.
 *
 *     Phase 2: Unit test getting instructor name.
 *
 *     Phase 3: Unit test getting instructor quality.
 * 
 * @author Alex Kavanaughs
 *
 */
public class AnalyticsRowTest {
    String testName = "TestName";
    Integer testQuality = new Integer(20);
    AnalyticsRow row;

    /**
     * Set up the row.
     */
    @Before
    public void setUp() {        
        this.row = new AnalyticsRow(this.testName, this.testQuality);
    }
    
    /**
     * Unit test the getName method. 
     *                                                                                                                                                      <pre>
     *  Test
     *  Case    Input            Output             Remarks
     * ====================================================================
     *   1   {'TestName', 20}   {'TestName', 20}    Simple getter test.
     *
     */
    @Test
    public void testGetName() {        
        assertEquals(this.testName, this.row.getName());
    }

    /**
     * Unit test the getQuality method. 
     *                                                                                                                                                      <pre>
     *  Test
     *  Case    Input            Output             Remarks
     * ====================================================================
     *   1   {'TestName', 20}   {'TestName', 20}    Simple getter test.
     *
     */
    @Test
    public void testGetQuality() {
        assertEquals(this.testQuality, this.row.getQuality());
    }

}
