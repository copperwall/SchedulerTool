package models.data.databases;

import java.util.*;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * An Instructor has a first and last name, their work time units, their time
 * preferences, their class preferences, if they're active, and if their
 * preferences are locked by the administrator.
 * 
 * @author Calvin Elizan (celizan)
 */
public class Instructor extends User {
    /** maximum number of work time units for the instructor */
    private int workTimeUnits;
    /** preferred times to teach */
    private Collection<Day> timePrefs;
    /** preferred courses to teach */
    public List<CoursePreference> coursePrefs;
    /** if the instructor is active for the quarter */
    private boolean active;
    /** if the instructor's preferences are locked */
    private boolean prefsLocked;

    /** name property for the tableview */
    private final SimpleStringProperty name = new SimpleStringProperty("");
    /** work time units property for the tableview */
    private final SimpleIntegerProperty wtu = new SimpleIntegerProperty();
    /** Cal Poly user ID for the TableView */
    private final SimpleStringProperty user = new SimpleStringProperty("");
    /** active property for the TableView */
    private final SimpleBooleanProperty act = new SimpleBooleanProperty();

    /**
     * Creates an instructor with the given properties
     * 
     * @param name
     *            Name of the instructor
     * @param username
     *            Cal Poly username
     * @param wtu
     *            Maximum number of work time units
     * @param active
     *            if the instructor is active for the term
     */
    /*
     * @ ensures // Instructor has all fields defined firstName.equals(first) &&
     * lastName.equals(last) && workTimeUnits == wtu && username.equals(userID)
     * && isActive == active;
     * 
     * @
     */
    public Instructor(String first, String last, String userID, int wtu,
            boolean isActive) {
        this.username = userID;
        this.workTimeUnits = wtu;
        this.active = isActive;
        this.name.set(first + " " + last);
        this.firstName = first;
        this.lastName = last;
        this.wtu.set(wtu);
        this.user.set(username);
        this.act.set(active);
    }

    /**
     * returns the name of the instructor
     * 
     * @return name of the instructor
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
     * Returns a String to be made into the data that shows up in the Name
     * column of the instructor database.
     * 
     * @return the name of the instructor as a string property
     */
    /*
     * @ // return value is the name property ensures \result.equals(name);
     * 
     * @
     */
    public SimpleStringProperty nameProperty() {
        return name;
    }

    /**
     * Returns the maximum number of work time units for the instructor
     * 
     * @return the maximum work time units
     */
    /*
     * @ //Ensures the return value is the work time units ensures \result ==
     * wtu;
     * 
     * @
     */
    public int getWtu() {
        return workTimeUnits;
    }

    /**
     * Returns the maximum work time units as a SimpleIntegerProperty.
     * 
     * @return the maximum work time units
     */
    /*
     * @ //Ensures the return value is the work time units ensures
     * \result.equals(wtu);
     * 
     * @
     */
    public SimpleIntegerProperty wtuProperty() {
        return wtu;
    }

    /**
     * Returns the user ID of the instructor
     * 
     * @return the user ID
     */
    /*
     * @ // Ensures that the username is returned ensures \result.equals(user);
     * 
     * @
     */
    public String getUser() {
        return user.get();
    }

    /**
     * Returns the user ID as a SimpleStringProperty.
     * 
     * @return the user ID
     */
    /*
     * @ ensures // the name returned is the name of the instructor
     * \result.equals(user);
     * 
     * @
     */
    public SimpleStringProperty userProperty() {
        return user;
    }

    /**
     * Returns whether or not the instructor is active for the term.
     * 
     * @return if the instructor is active
     */
    /*
     * @ ensures // the name returned is the name of the instructor \result ==
     * active;
     * 
     * @
     */
    public boolean getAct() {
        return act.get();
    }

    /**
     * Returns the instructor's active state as a SimpleBooleanProperty.
     * 
     * @return the instructor's active state
     */
    /*
     * @ ensures // the name returned is the name of the instructor \result ==
     * active;
     * 
     * @
     */
    public SimpleBooleanProperty actProperty() {
        return act;
    }

    /**
     * Sets the name of the instructor
     * 
     * @param name
     *            the new name of the instructor
     */
    /*
     * @ ensures // value was set this.name.get().equals(name);
     * 
     * @
     */
    public void setName(String name) {
        this.name.set(name);
    }

    /**
     * sets the maximum WTU of the instructor
     * 
     * @param wtu
     *            the new max WTU
     */
    /*
     * @ ensures // value was set this.wtu.get() == wtu;
     * 
     * @
     */
    public void setWtu(int wtu) {
        this.workTimeUnits = wtu;
        this.wtu.set(wtu);
    }

    /**
     * Sets the user ID of the instructor
     * 
     * @param user
     *            the new user ID
     */
    /*
     * @ ensures // value was set this.user.get().equals(user);
     * 
     * @
     */
    public void setUser(String user) {
        this.user.set(user);
    }

    /**
     * Sets the instructor as active or not for the term.
     * 
     * @param act
     *            if the instructor is active for the term.
     */
    /*
     * @ ensures // value was set this.act.get().equals(act);
     * 
     * @
     */
    public void setAct(boolean act) {
        this.active = act;
        this.act.set(act);
    }

    // empty constructor for making dummy objects
    public Instructor() {
    }

    /**
     * Gets the instructor's course preferences.
     * 
     * @return a List of CoursePreferences
     */
    /*
     * @ ensures \result.containsAll(coursePrefs);
     * 
     * @
     */
    public List<CoursePreference> getAllClassPrefs() {
        return new ArrayList<CoursePreference>();
    }

    /**
     * Gets the preference for one course.
     * 
     * @return the preference for that course
     */
    /*
     * @ // not implemented yet
     * 
     * @
     */
    public int getOneClassPref(Course course) {
        System.out.println("Instructor.getOneClassPref()");
        return 0;
    }

    /**
     * Sets all course preferences to the given integer preference
     */
    /*
     * @ requires pref == -1 || pref >= 1 && pref <= 5;
     * 
     * @
     */
    public void setAllClassPrefs(int pref) {
        System.out.println("Instructor.setAllClassPrefs()");
    }

    /**
     * Sets one course's preference
     */
    /*
     * @ ensures this.getOneClassPref(course) == prefNum;
     * 
     * @
     */
    public void setOneClassPref(Course course, int prefNum) {
        System.out.println("Instructor.setOneClassPref()");
    }
}
