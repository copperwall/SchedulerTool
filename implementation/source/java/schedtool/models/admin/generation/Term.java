package models.admin.generation;

import java.util.Collection;
import java.util.Date;

/**
 * Models a Term that has a collection of schedules,
 * student votes for that term, its available courses,
 * a Date for when student votes are locked, a Date
 * for when intstructor preferences are locked, 
 * the year, and 
 */
public class Term {
   Collection<Schedule> schedules;
   Date voteLock;
   Date prefLock;
   Collection<Section> availableSections;
   int year;
   enum Season {FALL, WINTER, SPRING, SUMMER};
   Schedule publishedSchedule;
   
    public Collection<Schedule> getSchedules() {
		return schedules;
	}
	public void setSchedules(Collection<Schedule> schedules) {
		this.schedules = schedules;
	}
	public Date getVoteLock() {
		return voteLock;
	}
	public void setVoteLock(Date voteLock) {
		this.voteLock = voteLock;
	}
	public Date getPrefLock() {
		return prefLock;
	}
	public void setPrefLock(Date prefLock) {
		this.prefLock = prefLock;
	}
	public Collection<Section> getAvailableSections() {
		return availableSections;
	}
	public void setAvailableSections(Collection<Section> availableSections) {
		this.availableSections = availableSections;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Schedule getPublishedSchedule() {
		return publishedSchedule;
	}
	public void setPublishedSchedule(Schedule publishedSchedule) {
		this.publishedSchedule = publishedSchedule;
	}
   
}