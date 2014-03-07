package models.admin.generation;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * A row in the Available Courses table.
 * 
 * @author Alex Kavanaugh
 * 
 */
public class AvailableCoursesRow {
    private SimpleStringProperty prefix;
    private SimpleIntegerProperty courseNumber;
    private SimpleStringProperty courseTitle;
    private SimpleIntegerProperty sections;
    private SimpleIntegerProperty suggested;

    /**
     * Constructs a new Available Courses row.
     * TODO: Instead of passing in the values individually, pass in a Course
     * 
     * @param prefix
     *     The course prefix.
     * @param courseNumber
     *     The course number.
     * @param courseTitle
     *     The course title.
     * @param sections
     *     The section count for this course.
     * @param suggested
     *     The suggested section count for this course.
     */
    /*
     * @ ensures // AvailableCoursesRow has all fields defined
     * this.prefix.equals(prefix) &&
     * this.courseNumber.equals(courseNumber) &&
     * this.courseTitle.equals(courseTitle) &&
     * this.sections.equals(sections) &&
     * this.suggested.equals(suggested);
     * @
     */
    public AvailableCoursesRow(String prefix, Integer courseNumber,
            String courseTitle, Integer sections, Integer suggested) {
        this.prefix = new SimpleStringProperty(prefix);
        this.courseNumber = new SimpleIntegerProperty(courseNumber);
        this.courseTitle = new SimpleStringProperty(courseTitle);
        this.sections = new SimpleIntegerProperty(sections);
        this.suggested = new SimpleIntegerProperty(suggested);
    }

    /**
     * Returns the prefix.
     * 
     * @return Returns the prefix.
     */
    /*
     * @ ensures // the item returned is the same as the class item
     * \result.equals(prefix.get());
     * 
     * @
     */
    public String getPrefix() {
        return prefix.get();
    }

    /**
     * Returns the prefix property.
     * 
     * @return Returns the prefix property.
     */
    /*
     * @ ensures // the item returned is the same as the class item
     * \result.equals(prefix);
     * 
     * @
     */
    public SimpleStringProperty prefixProperty() {
        return prefix;
    }

    /**
     * Returns the courseNumber.
     * 
     * @return Returns the courseNumber.
     */
    /*
     * @ ensures // the item returned is the same as the class item
     * \result.equals(courseNumber.get());
     * 
     * @
     */
    public Integer getCourseNumber() {
        return courseNumber.get();
    }

    /**
     * Returns the courseNumber property.
     * 
     * @return Returns the courseNumber property.
     */
    /*
     * @ ensures // the item returned is the same as the class item
     * \result.equals(courseNumber);
     * 
     * @
     */
    public SimpleStringProperty courseNumberProperty() {
        return new SimpleStringProperty("" + courseNumber.get());
    }

    /**
     * Returns the courseTitle.
     * 
     * @return Returns the courseTitle.
     */
    /*
     * @ ensures // the item returned is the same as the class item
     * \result.equals(courseTitle.get());
     * 
     * @
     */
    public String getCourseTitle() {
        return courseTitle.get();
    }

    /**
     * Returns the courseTitle property.
     * 
     * @return Returns the courseTitle property.
     */
    /*
     * @ ensures // the item returned is the same as the class item
     * \result.equals(courseTitle);
     * 
     * @
     */
    public SimpleStringProperty courseTitleProperty() {
        return courseTitle;
    }

    /**
     * Returns the sections.
     * 
     * @return Returns the sections.
     */
    /*
     * @ ensures // the item returned is the same as the class item
     * \result.equals(sections.get());
     * 
     * @
     */
    public Integer getSections() {
        return sections.get();
    }

    /**
     * Returns the sections property.
     * 
     * @return Returns the sections property.
     */
    /*
     * @ ensures // the item returned is the same as the class item
     * \result.equals(sections);
     * 
     * @
     */
    public SimpleStringProperty sectionsProperty() {
        return new SimpleStringProperty("" + sections.get());
    }

    /**
     * Sets the sections property.
     * 
     * @param sections
     *    The section count to set.
     */
    /*
     * @ ensures // value was set 
     * this.sections.equals(new SimpleIntegerProperty(sections));
     * 
     * @
     */
    public void setSections(Integer sections) {
        this.sections = new SimpleIntegerProperty(sections);
    }

    /**
     * Returns the suggested sections.
     * 
     * @return Returns the suggested sections.
     */
    /*
     * @ ensures // the item returned is the same as the class item
     * \result.equals(suggested.get());
     * 
     * @
     */
    public Integer getSuggested() {
        return suggested.get();
    }

    /**
     * Returns the suggested sections property.
     * 
     * @return Returns the suggested sections property.
     */
    /*
     * @ ensures // the item returned is the same as the class item
     * \result.equals(suggested);
     * 
     * @
     */
    public SimpleIntegerProperty suggestedProperty() {
        return suggested;
    }

    /**
     * Sets the section count to the suggested section count.
     */
    /*
     * @ ensures // value was set 
     * this.sections.equals(this.suggested.get());
     * 
     * @
     */
    public void loadSuggested() {
        this.sections.set(this.suggested.get());
    }
}
