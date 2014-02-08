package models.admin.generation;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AvailableCoursesRow
{
    private SimpleStringProperty prefix;
    private SimpleIntegerProperty courseNumber;
    private SimpleStringProperty courseTitle;
    private SimpleIntegerProperty sections;
    private SimpleIntegerProperty suggested;
    
    public AvailableCoursesRow(String prefix, Integer courseNumber, 
            String courseTitle, Integer sections, Integer suggested)
    {
        this.prefix = new SimpleStringProperty(prefix);
        this.courseNumber = new SimpleIntegerProperty(courseNumber);
        this.courseTitle = new SimpleStringProperty(courseTitle);
        this.sections = new SimpleIntegerProperty(sections);
        this.suggested = new SimpleIntegerProperty(suggested);
    }

    public String getPrefix()
    {
        return prefix.get();
    }

    public Integer getCourseNumber()
    {
        return courseNumber.get();
    }

    public String getCourseTitle()
    {
        return courseTitle.get();
    }

    public String getSections()
    {
        return "" + sections.get();
    }
    
    public void setSections(String sections)
    {
        this.sections = new SimpleIntegerProperty(Integer.parseInt(sections));
    }
    

    public Integer getSuggested()
    {
        return suggested.get();
    }
    
    public void loadSuggested()
    {
        this.sections.set(this.suggested.get());
    }
    
    public String toString()
    {
        return this.getPrefix() + " " + this.getCourseNumber() + " - Sections: " + this.getSections() + ", Suggested: " + this.getSuggested();
    }
}