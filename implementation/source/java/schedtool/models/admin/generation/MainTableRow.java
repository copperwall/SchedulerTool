package models.admin.generation;

import models.data.databases.Course;
import models.data.databases.Location;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MainTableRow
{
    private SimpleStringProperty prefix;
    private SimpleIntegerProperty courseNumber;
    private SimpleIntegerProperty sectionNumber;
    private SimpleStringProperty intructorName;
    private SimpleStringProperty buildingNumber;
    private SimpleStringProperty roomNumber;
    private SimpleStringProperty days;
    private SimpleStringProperty time;
    private SimpleStringProperty type;
    private SimpleIntegerProperty units;
    private SimpleIntegerProperty workTimeUnits;
    private SimpleIntegerProperty plannedEnrollment;
    
    public MainTableRow(Section section)
    {
    	Course course = section.getCourse();
    	Location loc = section.getLocation();
    	
    	
        this.prefix = new SimpleStringProperty(course.getPrefix());
        this.courseNumber = new SimpleIntegerProperty(course.getCourseNum());
        this.sectionNumber = new SimpleIntegerProperty(section.getSectionNum());
        this.intructorName = new SimpleStringProperty(section.getInstructor().lastName + ", " + section.getInstructor().firstName);
        this.buildingNumber = new SimpleStringProperty(loc.getBuilding());
        this.roomNumber = new SimpleStringProperty(loc.getRoom());
        this.days = new SimpleStringProperty(section.getDays());
        this.time = new SimpleStringProperty(section.getTime());
        if(section.getLinkedSectionNum() != 0)
        {
        	this.type = new SimpleStringProperty("Lab");
        }
        else
        {
        	this.type = new SimpleStringProperty("Lec");
        }
        this.units = new SimpleIntegerProperty(course.getUnits());
        this.workTimeUnits = new SimpleIntegerProperty(5);
        this.plannedEnrollment = new SimpleIntegerProperty(0);
    }
    
    public String getPrefix()
    {
        return prefix.get();
    }
    
    public SimpleStringProperty prefixProperty()
    {
        return prefix;
    }

    public Integer getCourseNumber()
    {
        return courseNumber.get();
    }
    
    public SimpleStringProperty courseNumberProperty()
    {
        return new SimpleStringProperty("" + courseNumber.get());
    }
    
    public Integer getSectionNumber()
    {
        return sectionNumber.get();
    }
    
    public SimpleIntegerProperty sectionNumberProperty()
    {
        return sectionNumber;
    }
    
    public String getRoomNumber()
    {
        return roomNumber.get();
    }
    
    public SimpleStringProperty roomNumberProperty()
    {
        return roomNumber;
    }
    
    public String getIntructorName()
    {
        return intructorName.get();
    }
    
    public SimpleStringProperty intructorNameProperty()
    {
        return intructorName;
    }
    
    public String getBuildingNumber()
    {
        return buildingNumber.get();
    }
    
    public SimpleStringProperty buildingNumberProperty()
    {
        return buildingNumber;
    }
    
    public SimpleStringProperty daysProperty()
    {
        return days;
    }
    
    public String getDays()
    {
        return days.get();
    }
    
    public String getTime()
    {
        return time.get();
    }
    
    public SimpleStringProperty timeProperty()
    {
        return time;
    }
    
    public String getType()
    {
        return type.get();
    }
    
    public SimpleStringProperty typeProperty()
    {
        return type;
    }
    
    public SimpleStringProperty workTimeUnitsProperty()
    {
        return new SimpleStringProperty("" + workTimeUnits.get());
    }
    
    public void setWorkTimeUnits(Integer workTimeUnits)
    {
        this.workTimeUnits = new SimpleIntegerProperty(workTimeUnits);
    }
    
    public Integer getUnits()
    {
        return units.get();
    }
    
    public SimpleIntegerProperty unitsProperty()
    {
        return units;
    }

    public Integer getPlannedEnrollment()
    {
        return plannedEnrollment.get();
    }
    
    public SimpleIntegerProperty plannedEnrollmentProperty()
    {
        return plannedEnrollment;
    }
    
    
}