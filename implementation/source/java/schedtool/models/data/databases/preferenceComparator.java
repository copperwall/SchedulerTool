/**
 * 
 */
package models.data.databases;

import java.util.Comparator;

/**
 * @author Jarred
 *
 */
public class preferenceComparator implements
		Comparator<CoursePreference> {

	@Override
	public int compare(CoursePreference o1, CoursePreference o2) {
		return o1.preference - o2.preference;
	}

}
