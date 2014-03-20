package models.data.databases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Vector;

/**
 * Holds the instructor information for all instructors
 * 
 * @author Calvin Elizan (celizan)
 */

public class InstructorDB extends Observable {
    /** vector containing all of the instructors **/
    public Vector<Instructor> instructors;

    /**
     * Instantiates an InstructorDB
     */
    public InstructorDB() {
        instructors = new Vector<Instructor>();
    }

    /**
     * Gets an instructor
     * 
     * @return an Instructor object given their username
     */
    /*
     * @ requires username != null && username.length() > 2; ensures
     * \result.username.equals(username);
     * 
     * @
     */
    public Instructor getInstructor(String username) {
        Instructor result = null;
        try {
            // connection to database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://polyschedules.db."
                            + "9302206.hostedresource.com:3306/polyschedules",
                    "polyschedules", "a1RightCorner!");
            // select statement
            Statement stmt = con.createStatement();
            // select query
            String query = "SELECT * FROM core_polyschedulesuser"
                    + " LEFT JOIN "
                	+ "(core_polyschedulesuser_course_preferences,"
                	+ " preferences_coursepreference, schedules_course"
                	+ " ) "
                	+ "ON "
                 	+ "(core_polyschedulesuser_course_preferences.polyschedulesuser_id=core_polyschedulesuser.id"
                 	+ " AND preferences_coursepreference.id=core_polyschedulesuser_course_preferences.coursepreference_id"
                 	+ " AND preferences_coursepreference.course_id=schedules_course.id"
                 	+ ") WHERE username = '" + username + "'";
            // result set from query
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // first name of instructor
                String firstName = rs.getString("first_name");
                // last name of instructor
                String lastName = rs.getString("last_name");
                // instructor active status
                boolean active = rs.getBoolean("is_active_instructor");
                // instructor's maximum wtu
                int wtu = rs.getInt("max_wtu");
                // course preferences
                Vector<CoursePreference> cPrefs = new Vector<CoursePreference>();
                // temp course pref
                CoursePreference cPref = new CoursePreference();

                result = new Instructor(firstName, lastName, username, wtu,
                        active);
                
                // add first course pref
                cPref.course = new Course(rs.getString("prefix"), rs.getInt("number"),
                        rs.getInt("units"), rs.getString("title"), 
                        rs.getBoolean("requires_equipment"), 
                        rs.getInt("lab_length"), Course.LabProximity.values()[rs.getInt("lab_time_proximity")], 
                        rs.getBoolean("lab_requires_equipment"));
                cPref.preference = rs.getInt("preference");
                cPrefs.add(cPref);
                
                // add rest
                while (rs.next()) {
                    cPref = new CoursePreference();
                    cPref.course = new Course(rs.getString("prefix"), rs.getInt("number"),
                            rs.getInt("units"), rs.getString("title"), 
                            rs.getBoolean("requires_equipment"), 
                            rs.getInt("lab_length"), Course.LabProximity.values()[rs.getInt("lab_time_proximity")], 
                            rs.getBoolean("lab_requires_equipment"));
                    cPref.preference = rs.getInt("preference");
                    cPrefs.add(cPref);
                }
                
                result.coursePrefs = cPrefs;
            }
            
            // time preference query
            query = "SELECT * FROM core_polyschedulesuser"
                    + " LEFT JOIN "
                    + "(core_polyschedulesuser_time_preference,"
                    + " preferences_timepreference,"
                    + " schedules_week)"
                    + "ON "
                    + "("
                    + " core_polyschedulesuser_time_preference.polyschedulesuser_id=core_polyschedulesuser.id "
                    + " AND preferences_timepreference.id=core_polyschedulesuser_time_preference.timepreference_id"
                    + " AND schedules_week.id=preferences_timepreference.availability_id"
                    + ") WHERE username = '" + username + "'";
            rs = stmt.executeQuery(query);
            rs.next();
            ArrayList<Day> timeprefs = new ArrayList<Day>();
                timeprefs.add(new Day(rs.getString("monday")));
                timeprefs.add(new Day(rs.getString("tuesday")));
                timeprefs.add(new Day(rs.getString("wednesday")));
                timeprefs.add(new Day(rs.getString("thursday")));
                timeprefs.add(new Day(rs.getString("friday")));
                timeprefs.add(new Day(rs.getString("saturday")));
                timeprefs.add(new Day(rs.getString("sunday")));
            result.timePrefs = timeprefs;
        }
        catch (SQLException exc) {
            System.err
                    .println("InstructorDB Get: Could not connect to database.\n\t"
                            + exc.getMessage());
        }
        return result;
    }

    /**
     * Adds the given instructor to the database.
     */
    /*
     * @ requires instructor != null; ensures
     * instructors.containsAll(\old(instructors)) &&
     * instructors.contains(instructor); // Ensures that none of the old entries
     * are touched and that instructors // contains the newly added instructor
     * 
     * @
     */
    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);

        try {
            // database connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://polyschedules.db."
                            + "9302206.hostedresource.com:3306/polyschedules",
                    "polyschedules", "a1RightCorner!");
            // add statement
            PreparedStatement pstmt = con
                    .prepareStatement("INSERT INTO core_polyschedulesuser "
                            + "(`username`, `first_name`, `last_name`, `email`, `max_wtu`, "
                            + "`is_active_instructor`, `is_instructor`, `password`, `is_active`, "
                            + "`last_login`, `is_superuser`, `is_staff`, `date_joined`) "
                            + "VALUES( "
                            + "?, ?, ?, ?, ?, ?, ?, '!', 1, ?, 0, 0, ?)");

            pstmt.setString(1, instructor.username);
            pstmt.setString(2, instructor.firstName);
            pstmt.setString(3, instructor.lastName);
            pstmt.setString(4, instructor.username + "@calpoly.edu");
            pstmt.setInt(5, instructor.getWtu());
            pstmt.setBoolean(6, instructor.getAct());
            pstmt.setInt(7, 1);
            pstmt.setDate(8, new Date(0));
            pstmt.setDate(9, new Date(new java.util.Date().getTime()));
            pstmt.addBatch();
            pstmt.executeBatch();
        }
        catch (SQLException exc) {
            System.err
                    .println("InstructorDB Add: Could not connect to database.\n\t"
                            + exc.getMessage());
        }
        setChanged();
        notifyObservers();
    }

    /**
     * Changes the properties of the instructor whose name matches the one in
     * the given instructor to those of the given instructor.
     */
    /*
     * @ requires instructor != null; ensures // Ensures that all of the
     * instructors are either from the old set of // instructors or it has been
     * edited. (\forall Instructor i; instructors.contains(i);
     * \old(instructors).contains(i) || i.equals(instructor)) &&
     * instructors.contains(instructor);
     * 
     * @
     */
    public void editInstructor(Instructor instructor) {

        try {
            // connection to database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://polyschedules.db."
                            + "9302206.hostedresource.com:3306/polyschedules",
                    "polyschedules", "a1RightCorner!");
            // wtu update query
            String queryWTU = "UPDATE core_polyschedulesuser SET max_wtu = ?"
                    + " WHERE username = ?";
            // active status update query
            String queryActive = "UPDATE core_polyschedulesuser "
                    + "SET is_active_instructor = ? WHERE username = ?";
            // wtu update statement
            PreparedStatement updateWTU = con.prepareStatement(queryWTU);
            // active status update statement
            PreparedStatement updateActive = con.prepareStatement(queryActive);

            updateWTU.setInt(1, instructor.getWtu());
            updateWTU.setString(2, instructor.getUser());
            updateWTU.executeUpdate();
            updateActive.setBoolean(1, instructor.getAct());
            updateActive.setString(2, instructor.getUser());
            updateActive.executeUpdate();
        }
        catch (SQLException exc) {
            System.err
                    .println("InstructorDB Edit: Could not connect to database.\n\t"
                            + exc.getMessage());
        }

        setChanged();
        notifyObservers();
    }

    /**
     * Deletes the instructor whose name matches that of the given instructor
     */
    /*
     * @ // Ensures that the section that matches courseNum gets removed from //
     * the list of courses ensures !instructors.contains(instructor);
     * 
     * @
     */
    public void deleteInstructor(Instructor instructor) {
        try {
            // connection to database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://polyschedules.db."
                            + "9302206.hostedresource.com:3306/polyschedules",
                    "polyschedules", "a1RightCorner!");
            // find user id
            String queryFindId = "SELECT id FROM core_polyschedulesuser WHERE username = ?";
            // delete query
            String queryDelete = "DELETE FROM core_polyschedulesuser WHERE username = ?";
            // find user's course preferences in index table
            String queryFindCPrefs = "SELECT coursepreference_id FROM core_polyschedulesuser_course_preferences WHERE polyschedulesuser_id = ?";
            // delete user's actual course preferences
            String queryDeleteCPrefs = "DELETE FROM preferences_coursepreference WHERE id = ?";
            // delete user's course preference indices
            String queryDeleteCPIndex = "DELETE FROM core_polyschedulesuser_course_preferences WHERE polyschedulesuser_id = ?";
            // find user's time preferences in index table
            String queryFindTPrefs = "SELECT timepreference_id FROM core_polyschedulesuser_time_preference WHERE polyschedulesuser_id = ?";
            // find user's availability indices
            String queryFindWeeks = "SELECT availability_id FROM preferences_timepreference WHERE id = ?";
            // delete user's actual time preferences
            String queryDeleteTPrefs = "DELETE FROM preferences_timepreference WHERE id = ?";
            // delete user's availability prefs
            String queryDeleteWeeks = "DELETE FROM schedules_week WHERE id = ?";
            // delete user's course preference indices
            String queryDeleteTPIndex = "DELETE FROM core_polyschedulesuser_time_preference WHERE polyschedulesuser_id = ?";
            // find user id statement
            PreparedStatement stmtId = con.prepareStatement(queryFindId);
            // delete statement
            PreparedStatement stmtDelete = con.prepareStatement(queryDelete);
            // find user's course preferences statement
            PreparedStatement stmtFindCP = con.prepareStatement(queryFindCPrefs);
            // delete user's actual course preferences
            PreparedStatement stmtDeleteCPrefs = con.prepareStatement(queryDeleteCPrefs);
            // delete index of user course preferences
            PreparedStatement stmtDeleteCPIndex = con.prepareStatement(queryDeleteCPIndex);
            // statement object for finding  time prefs
            PreparedStatement stmtFindTimePref = con.prepareStatement(queryFindTPrefs);
            // statement for deleting time prefs
            PreparedStatement stmtDeleteTimePref = con.prepareStatement(queryDeleteWeeks);
            // statement for deleting week index
            PreparedStatement stmtDeleteWeekIndex = con.prepareStatement(queryDeleteTPrefs);
            // statement for deleting time pref index
            PreparedStatement stmtDeleteTPIndex = con.prepareStatement(queryDeleteTPIndex);
            // user id in database
            int userId;
            // coursepref id in database
            int coursePrefId;
            // timepref id in database
            int timePrefId;
            // week id in database
            int weekId;

            stmtId.setString(1, instructor.username);
            ResultSet rs = stmtId.executeQuery();
            rs.next();
            userId = rs.getInt("id");
            stmtFindCP.setInt(1, userId);
            rs = stmtFindCP.executeQuery();
            removeFromSchedule(userId);
            removeTermLocks(userId);
            // deletes course preferences
            while (rs.next())
            {
                ResultSet rsCP;
                coursePrefId = rs.getInt("coursepreference_id");
                stmtDeleteCPrefs.setInt(1, coursePrefId);
                stmtDeleteCPrefs.execute();
            }
            stmtDeleteCPIndex.setInt(1, userId);
            stmtDeleteCPIndex.execute();
            // deletes time preferences
            stmtFindTimePref.setInt(1, userId);
            while (rs.next()) {
                ResultSet rsTP;
                timePrefId = rs.getInt("timepreference_id");
                stmtFindTimePref = con.prepareStatement(queryFindWeeks);
                rsTP = stmtFindTimePref.executeQuery();
                while (rsTP.next()) {
                    weekId = rsTP.getInt("availability_id");
                    stmtDeleteTimePref.setInt(1, weekId);
                    stmtDeleteTimePref.execute();
                }
                stmtDeleteWeekIndex.setInt(1, timePrefId);
                stmtDeleteWeekIndex.execute();
            }
            stmtDeleteTPIndex.setInt(1, userId);
            stmtDeleteTPIndex.execute();
            
            stmtDelete.setString(1, instructor.username);
            stmtDelete.executeUpdate();

            setChanged();
            notifyObservers();
        }
        catch (SQLException exc) {
            System.err
                    .println("InstructorDB Delete: Could not connect to database.\n\t"
                            + exc.getMessage());
        }
    }
    
    /**
     * Removes the given instructor id from the schedule
     * @param userId instructor's id in the database
     */
    private void removeFromSchedule(int userId) throws SQLException
    {
        // connection to database
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://polyschedules.db."
                        + "9302206.hostedresource.com:3306/polyschedules",
                "polyschedules", "a1RightCorner!");
        // find user id
        String queryEditSections = "UPDATE schedules_section  SET instructor_id = null"
                + " WHERE instructor_id = ?";
        PreparedStatement stmtEditSections = con.prepareStatement(queryEditSections);
        
        stmtEditSections.setInt(1, userId);
        stmtEditSections.execute();
    }
    
    /**
     * Remove an instructor's term locks
     * @param userId the id of the instructor in the database
     */
    private void removeTermLocks(int userId) throws SQLException
    {
        // connection to database
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://polyschedules.db."
                        + "9302206.hostedresource.com:3306/polyschedules",
                "polyschedules", "a1RightCorner!");
        // find user id
        String queryFindId = "SELECT termpreferencelock_id  FROM core_polyschedulesuser_preference_locks WHERE polyschedulesuser_id = ?";
        // delete query
        String queryDelete = "DELETE FROM preferences_timepreferencelock WHERE id = ?";
        // delete cross table entries
        String queryDeleteCross = "DELETE FROM core_polyschedulesuser_preference_locks WHERE polyschedulesuser_id = ?";
        PreparedStatement stmtFindId = con.prepareStatement(queryFindId);
        PreparedStatement stmtDelete = con.prepareStatement(queryDelete);
        PreparedStatement stmtDeleteCross = con.prepareStatement(queryDeleteCross);
        
        ResultSet rsFindId;
        
        int prefLockId;
        
        stmtFindId.setInt(1, userId);
        rsFindId = stmtFindId.executeQuery();
        
        while (rsFindId.next())
        {
            prefLockId = rsFindId.getInt("termpreferencelock_id");
            stmtDelete.setInt(1, prefLockId);
            stmtDelete.execute();
        }

        stmtDeleteCross.setInt(1, userId);
        stmtDeleteCross.execute();
    }

    /**
     * Gets a vector of instructors that represents all of the ones in the
     * database
     * 
     * @return a Vector with all of the instructors
     */
    /*
     * @ ensures // All instructors in the database are in the result
     * \result.containsAll(instructors);
     * 
     * @
     */
    public Vector<Instructor> getAllInstructors() {
        // vector of instructors
        instructors = new Vector<Instructor>();

        try {
            // connection to database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://polyschedules.db."
                            + "9302206.hostedresource.com:3306/polyschedules",
                    "polyschedules", "a1RightCorner!");
            // select statement
            Statement stmt = con.createStatement();
            // select query
            String query = "SELECT * FROM core_polyschedulesuser WHERE is_instructor = 1";
            // result set from query
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // first name of instructor
                String firstName = rs.getString("first_name");
                // last name of instructor
                String lastName = rs.getString("last_name");
                // username of instructor
                String username = rs.getString("username");
                // instructor active status
                boolean active = rs.getBoolean("is_active_instructor");
                // instructor's maximum wtu
                int wtu = rs.getInt("max_wtu");

                instructors.add(getInstructor(username));
            }
        }
        catch (SQLException exc) {
            System.err
                    .println("InstructorDB GetAll: Could not connect to database.\n\t"
                            + exc.getMessage());
        }
        return instructors;
    }
}
