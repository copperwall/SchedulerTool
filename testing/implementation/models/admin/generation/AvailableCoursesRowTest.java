package models.admin.generation;

import static org.junit.Assert.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import models.admin.analytics.AnalyticsRow;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for an Available Courses table row. It implements the following test plan:
 *
 *     Phase 1: Unit test the constructor.
 *
 *     Phase 2: Unit test getting prefix and prefix property.
 *
 *     Phase 3: Unit test getting courseNumber and courseNumberProperty.
 *     
 *     Phase 4: Unit test getting courseTitle and courseTitleProperty.
 *     
 *     Phase 5: Unit test getting sections and sectionsProperty.
 *     
 *     Phase 6: Unit test setting sections
 *     
 *     Phase 7: Unit test getting suggested and suggestedProperty.
 *     
 *     Phase 8: Unit test loading suggested sections into sections.
 * 
 * @author Alex Kavanaughs
 *
 */
public class AvailableCoursesRowTest {
    String testPrefix = "CPE";
    Integer testCourseNumber = new Integer(101);
    String testCourseTitle = "Introduction to Computing I";
    Integer testSections = new Integer(0);
    Integer testSuggested = new Integer(8);
    AvailableCoursesRow row;

    /**
     * Set up the row.
     * 
     *  Test
     *  Case    Input            Output             Remarks
     * ====================================================================
     *  All  {'CPE', 101,         {'CPE', 101,      Same data for all.
     *       'Introduction to     'Introduction to 
     *       Computing I', 0, 8}  Computing I', 0, 8}    
     *
     */
    @Before
    public void setUp() {
        this.row = new AvailableCoursesRow(this.testPrefix, this.testCourseNumber,
                this.testCourseTitle, this.testSections, this.testSuggested);
    }

    /**
     * Unit test the getPrefix and prefixProperty methods.
     */
    @Test
    public void testGetPrefix() {
        assertEquals(this.testPrefix, this.row.getPrefix());
        assertEquals(this.testPrefix, this.row.prefixProperty().get());
    }

    /**
     * Unit test the getCourseNumber and courseNumberProperty methods.
     */
    @Test
    public void testGetCourseNumber() {
        assertEquals(this.testCourseNumber, this.row.getCourseNumber());
        assertEquals("" +  this.testCourseNumber, this.row.courseNumberProperty().get());
    }

    /**
     * Unit test the getCourseTitle and courseTitleProperty methods.
     */
    @Test
    public void testGetCourseTitle() {
        assertEquals(this.testCourseTitle, this.row.getCourseTitle());
        assertEquals(this.testCourseTitle, this.row.courseTitleProperty().get());
    }

    /** 
     * Unit test getting sections and sectionsProperty.
     */
    @Test
    public void testGetSections() {
        assertEquals(this.testSections, this.row.getSections());
        assertEquals("" + this.testSections, this.row.sectionsProperty().get());
    }

    /** 
     * Unit test setting sections.
     */
    @Test
    public void testSetSections() {
        this.row.setSections(5);
        assertEquals(new Integer(5), this.row.getSections());
    }

    /**
     * Unit test getting suggested and suggestedProperty.
     */
    @Test
    public void testGetSuggested() {
        assertEquals(this.testSuggested, this.row.getSuggested());
        assertEquals(new Integer(this.testSuggested), new Integer(this.row.suggestedProperty().get()));
    }

    @Test
    public void testLoadSuggested() {
        this.row.loadSuggested();
        assertEquals(new Integer(this.testSuggested), this.row.getSections());
    }

}
