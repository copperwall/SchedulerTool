package models.admin.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import models.admin.generation.Schedule;
import models.admin.generation.Section;
import models.data.databases.Course;
import models.data.databases.CoursePreference;
import models.data.databases.Day;
import models.data.databases.Instructor;
import models.data.databases.InstructorDB;

/**
 * Loads data for the admin analytics view.
 * 
 * @author Alex Kavanaugh
 * @author Katie Keim
 */
public class AdminAnalytics
{
    private HashMap<String, ArrayList<Integer>> overallAnalytics;
    private ArrayList<AnalyticsRow> individualAnalytics;
    private InstructorDB instructorDB;
    private ArrayList<Integer> allScores;
    private Vector<Section> sections;

    /**
     * The default constructor. All analytics data is static at this point, so
     * HashMaps of data are created here.
     */
    public AdminAnalytics()
    {
    	instructorDB = new InstructorDB();
    	allScores = new ArrayList<Integer>();
        this.overallAnalytics = new HashMap<String, ArrayList<Integer>>();
        this.individualAnalytics = new ArrayList<AnalyticsRow>(30);
        
        this.overallAnalytics.put("Average", new ArrayList<Integer>(1));
        this.overallAnalytics.put("Median", new ArrayList<Integer>(1));
        this.overallAnalytics.put("Mode", new ArrayList<Integer>());
        this.overallAnalytics.put("Standard Deviation", new ArrayList<Integer>(1));
    }

    /**
     * A public accessor to the calculate methods.
     */
    public void calculate()
    {
    	Vector<Instructor> instructors = instructorDB.getAllInstructors();
    	Schedule schedule = AdminGenerating.getSchedule();
    	sections = schedule.getAllSections();
        
        for (Instructor instructor : instructors) {
           calculateIndividual(instructor);
        }
        
        calculateOverall();
    }
    
    /**
     * Returns the individual analytics for each instructor.
     * 
     * @return Returns a list of individual analytics.
     */
    /*
     * @ ensures // the list returned is the list in this class.
     * \result.equals(individualAnalytics);
     * 
     * @
     */
    public ArrayList<AnalyticsRow> getIndividualAnalytics()
    {
        return this.individualAnalytics;
    }
    
    /**
     * Returns the overall analytics for the current schedule.
     * 
     * @return Returns a list of overall analytics.
     */
    /*
     * @ ensures // the list returned is the list in this class.
     * \result.equals(overallAnalytics);
     * 
     * @
     */
    public HashMap<String, ArrayList<Integer>> getOverallAnalytics()
    {
        return this.overallAnalytics;
    }

    /**
     * Calculates the overall analytics.
     */
    /*
     * @ ensures // the overall analytics list has calculations in it.
     * !overallAnalytics.isEmpty();
     * 
     * @
     */
    private void calculateOverall()
    {
        ArrayList<Integer> average = new ArrayList<Integer>(1);
        ArrayList<Integer> median = new ArrayList<Integer>(1);
        ArrayList<Integer> mode = new ArrayList<Integer>();
        ArrayList<Integer> stdDev = new ArrayList<Integer>(1);
        
        int avg = 0;
        int med = 90;
        int mod = 90;
        int dev = 0;
        
        int[] modeArray = new int[100];
        
        for (int i = 0; i < 100; i++) {
        	modeArray[i] = 0;
        }
        
        for (Integer score : allScores) {
        	avg += score;
        	modeArray[score]++;
        }
        
        for (int i = 0; i < 100; i++) {
        	if (modeArray[i] > mod) {
        		mod = modeArray[i];
        	}
        }
        
        avg = avg / allScores.size();
        
        Collections.sort(allScores);
        med = allScores.get(allScores.size() / 2);
        
        for (Integer score : allScores) {
        	dev += score - avg;
        }
        dev = (int)Math.floor(Math.sqrt(dev / allScores.size()));

        // TODO: Perform the actual calculations here
        average.add(avg);
        median.add(med);
        mode.add(mod);
        stdDev.add(dev);

        this.overallAnalytics.put("Average", average);
        this.overallAnalytics.put("Median", median);
        this.overallAnalytics.put("Mode", mode);
        this.overallAnalytics.put("Standard Deviation", stdDev);
    }

    /**
     * Calculates the individual analytics.
     */
    /*
     * @ ensures // the individual analytics list has calculations in it.
     * !individualAnalytics.isEmpty();
     * 
     * @
     */
    private void calculateIndividual(Instructor instructor)
    {
    	int score = 0;
    	Instructor courseInstructor;
    	Course course;
    	
    	int prefNum = 0;
    	int numCourses = 0;
    	
    	int timeNum = 0;
    	
    	List<CoursePreference> coursePrefs = instructor.getAllClassPrefs();	
    	ArrayList<Day> timePrefs = instructor.getTimePrefs(); 
    	
    	for (Section section : sections) {
    		courseInstructor = section.getInstructor();
    		
    		if (courseInstructor.equals(instructor)) {
    		   numCourses++;
    		   course = section.getCourse();
    		   
    		   for (CoursePreference pref : coursePrefs) {
    			   if (pref.course.equals(course)) {
    				   prefNum += pref.preference;
    			   }
    		   }
    		}
    	}
    	
    	if (numCourses > 0) {
    		prefNum /= numCourses;
    		timeNum /= numCourses;
    	}
    	
    	score = 100 * (prefNum + timeNum) / 2;
    	
        this.individualAnalytics.add(new AnalyticsRow(instructor.getName(), score));
        allScores.add(score);
    }
}
