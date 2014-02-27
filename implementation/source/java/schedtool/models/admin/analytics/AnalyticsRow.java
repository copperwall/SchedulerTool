package models.admin.analytics;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * A row in the Analytics table.
 * 
 * @author Alex Kavanaugh
 *
 */
public class AnalyticsRow {
    private SimpleStringProperty name;
    private SimpleIntegerProperty quality;

    public AnalyticsRow(String name, Integer quality) {
        this.name = new SimpleStringProperty(name);
        this.quality = new SimpleIntegerProperty(quality);
    }

    /**
     * Returns the name of the instructor.
     * 
     * @return Returns the instructor's name.
     */
    /*
     * @ ensures // the name returned is the name of the instructor
     * \result.equals(name);
     * 
     * @
     */
    public String getName() {
        return name.get();
    }

    /**
     * Returns the instructor's schedule quality.
     * 
     * @return Returns the instructor's schedule quality.
     */
    /*
     * @ ensures // the quality returned is the instructor's quality
     * \result.equals(quality);
     * 
     * @
     */
    public Integer getQuality() {
        return quality.get();
    }
}
