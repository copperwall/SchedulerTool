package models.admin.analytics;

import java.util.ArrayList;
import java.util.Observable;
import java.util.HashMap;

/**
 * Loads data for the admin analytics view.
 * 
 * @author Alex Kavanaugh
 * 
 */
public class AdminAnalytics
{
    private HashMap<String, ArrayList<Integer>> overallAnalytics;
    private ArrayList<AnalyticsRow> individualAnalytics;

    public AdminAnalytics()
    {
        this.overallAnalytics = new HashMap<String, ArrayList<Integer>>();
        this.individualAnalytics = new ArrayList<AnalyticsRow>(30);
        
        this.overallAnalytics.put("Average", new ArrayList<Integer>(1));
        this.overallAnalytics.put("Median", new ArrayList<Integer>(1));
        this.overallAnalytics.put("Mode", new ArrayList<Integer>());
        this.overallAnalytics.put("Standard Deviation", new ArrayList<Integer>(1));
    }

    public void calculate()
    {
        calculate_overall();

        // TODO: Iterate over all current instructors, pass in his/her id
        calculate_individual(0);
    }
    
    public ArrayList<AnalyticsRow> getIndividualAnalytics()
    {
        return this.individualAnalytics;
    }
    
    public HashMap<String, ArrayList<Integer>> getOverallAnalytics()
    {
        return this.overallAnalytics;
    }

    private void calculate_overall()
    {
        ArrayList<Integer> average = new ArrayList<Integer>(1);
        ArrayList<Integer> median = new ArrayList<Integer>(1);
        ArrayList<Integer> mode = new ArrayList<Integer>();
        ArrayList<Integer> stdDev = new ArrayList<Integer>(1);

        // TODO: Perform the actual calculations here
        average.add(81);
        median.add(82);
        mode.add(76);
        mode.add(80);
        mode.add(87);
        stdDev.add(10);

        this.overallAnalytics.put("Average", average);
        this.overallAnalytics.put("Median", median);
        this.overallAnalytics.put("Mode", mode);
        this.overallAnalytics.put("Standard Deviation", stdDev);
    }

    private void calculate_individual(int userId)
    {
        // TODO: actually pull instructor stuff
        this.individualAnalytics.add(new AnalyticsRow("Paul Hatalsky", 80));
        this.individualAnalytics.add(new AnalyticsRow("Clint Staley", 76));
        this.individualAnalytics.add(new AnalyticsRow("John Seng", 90));
        this.individualAnalytics.add(new AnalyticsRow("Phillip Nico", 82));
        this.individualAnalytics.add(new AnalyticsRow("Julie Workman", 93));
        this.individualAnalytics.add(new AnalyticsRow("Timothy Kearns", 67));
        this.individualAnalytics.add(new AnalyticsRow("Hasmik Gharibyan", 80));
        this.individualAnalytics.add(new AnalyticsRow("John Dalby", 87));
        this.individualAnalytics.add(new AnalyticsRow("Kurt Mammen", 92));
        this.individualAnalytics.add(new AnalyticsRow("Ignatios Vakalis", 79));
        this.individualAnalytics.add(new AnalyticsRow("John Clements", 58));
        this.individualAnalytics.add(new AnalyticsRow("David Janzen", 96));
        this.individualAnalytics.add(new AnalyticsRow("Clark Turner", 65));
        this.individualAnalytics.add(new AnalyticsRow("Gene Fisher", 87));
        this.individualAnalytics.add(new AnalyticsRow("William Buckalew", 76));
        this.individualAnalytics.add(new AnalyticsRow("Christopher Lupo", 84));
        this.individualAnalytics.add(new AnalyticsRow("Alexander Dekhtyar", 88));
        this.individualAnalytics.add(new AnalyticsRow("Foaad Khosmood", 84));
    }
}
