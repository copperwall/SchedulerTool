package models.admin.generation;

import java.util.Vector;
import java.util.Observable;

/**
 * Saves and loads data in Admin Available Courses
 * 
 * @author Alex Kavanaugh
 *
 */
public class AdminAvailableCourses extends Observable {
    
    private static Vector<AvailableCoursesRow> availableCourses;
    
    public AdminAvailableCourses() {
        availableCourses = new Vector<AvailableCoursesRow>();
        
        AvailableCoursesRow row = new AvailableCoursesRow("CPE", 101, "Introduction to Computing I", 0, 8);
        availableCourses.add(row);
        row = new AvailableCoursesRow("CPE", 102, "Introduction to Computing II", 0, 4);
        availableCourses.add(row);
        row = new AvailableCoursesRow("CPE", 103, "Introduction to Computing III", 0, 6);
        availableCourses.add(row);
    }
    
    public static Vector<AvailableCoursesRow> getAvailableCourses() {
        return availableCourses;
    }
    
    public void loadFromTerm(String term) {
        System.out.println("In AdminAvailableCourses:loadFromTerm()");
    }
    
    public void loadSuggested() {
        for (AvailableCoursesRow row : availableCourses)
        {
            row.loadSuggested();
        }
        setChanged();
        notifyObservers();
    }
}