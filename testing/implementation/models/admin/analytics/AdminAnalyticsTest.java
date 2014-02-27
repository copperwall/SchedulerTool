package models.admin.analytics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controllers.admin.analytics.AdminAnalyticsController;

/**
 * Test class for the Analytics model. It implements the following test plan:
 *
 *     Phase 1: Unit test the constructor.
 *
 *     Phase 2: Unit test the calculate methods.
 *
 *     Phase 3: Unit test getting individual analytics.
 *     
 *     Phase 4: Unit test getting overall analytics.
 * 
 * @author Alex Kavanaughs
 *
 */
public class AdminAnalyticsTest {
    AdminAnalytics model;

    /**
     * Instantiate the model and calculate analytics.
     */
    @Before
    public void setUp() {
        this.model = new AdminAnalytics();
        this.model.calculate();
    }

    /**
     * Unit test the getIndividualAnalytics and calculateIndividual methods
     *                                                                                                                                                      <pre>
     *  Test
     *  Case    Input            Output             Remarks
     * ====================================================================
     *   1      none          A non-empty         Once actual data is pulled,
     *                        analytics list.     the test can check for more
     *                                            in-depth stuff.
     */
    @Test
    public void testGetIndividualAnalytics() {
        assertFalse(this.model.getIndividualAnalytics().isEmpty());
    }

    /**
     * Unit test the getOverallAnalytics and calculateOverall methods
     *                                                                                                                                                      <pre>
     *  Test
     *  Case    Input            Output             Remarks
     * ====================================================================
     *   1      none          A non-empty         Once actual data is pulled,
     *                        analytics list.     the test can check for more
     *                                            in-depth stuff.
     */
    @Test
    public void testGetOverallAnalytics() {
        assertFalse(this.model.getOverallAnalytics().isEmpty());
    }

}
