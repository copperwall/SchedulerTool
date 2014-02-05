/**
 * Model to load and save Schedules for later refinement or use.
 * @author Jarred Stelfox
 * @version 1
 */
package models.admin.generation;

public class AdminExistingSchedules {
	/**
	 * Called when a user clicks the load button on a highlighted schedule in the table. This should load all the data for this schedule including instructors.
	 */
	public void load() {
		System.out.println("AdminExistingSchedules.load");
	}
	/**
	 * User clicked cancel(probably not needed, but was implemented for milestone 2)
	 */
	public void cancel(){
		System.out.println("AdminExistingSchedules.cancel");
	}

}
