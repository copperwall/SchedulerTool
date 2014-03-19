/**
 * 
 */
package controllers.admin.analytics;

import java.util.Comparator;

import models.data.databases.Instructor;

/**
 * @author Jarred
 *
 */
public class pickinessComparator implements Comparator<Instructor> {

	@Override
	public int compare(Instructor o1, Instructor o2) {
		return o1.lastName.compareTo(o2.lastName);
	}

}
