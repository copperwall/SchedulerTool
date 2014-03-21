package models.admin.generation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import java.util.Vector;

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
    }
    
    public static Vector<AvailableCoursesRow> getAvailableCourses() {
    	if (availableCourses.size() == 0) {
	    	try {
	    		Connection con = DriverManager.getConnection("jdbc:mysql://polyschedules.db."
	   			     + "9302206.hostedresource.com:3306/polyschedules", "polyschedules", "a1RightCorner!");
	    		
	    		Statement stmt = con.createStatement();
	    		String query = "select prefix, number, title, count(course_id) as num_votes "
	    				+ "from votes_vote join schedules_course "
	    				+ "on schedules_course.id = course_id group by course_id";
	    		
	    		ResultSet rs = stmt.executeQuery(query);
	    		
	    		while (rs.next()) {
	    			availableCourses.add(new AvailableCoursesRow(rs.getString("prefix"), rs.getInt("number"), rs.getString("title"), 0, rs.getInt("num_votes")));
	    		}
	    	}
	    	catch (SQLException e) {
	    		System.err.println(e);
	    	}
	    	return availableCourses;
    	}
    	else
    		return availableCourses;
    }
    
    public void loadFromTerm(String term) {
        System.out.println("In AdminAvailableCourses:loadFromTerm()");
    }
    
    /* Needs to update database otherwise will be doubled */
    public void loadSuggested() {
        for (AvailableCoursesRow row : availableCourses)
        {
            row.loadSuggested();
        }
        setChanged();
        notifyObservers();
    }
}