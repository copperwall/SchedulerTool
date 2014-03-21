package scheduler_tool;

import models.admin.analytics.*;
import models.admin.generation.*;
import models.data.databases.*;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CourseDBTest.class, CourseTest.class, InstructorDBTest.class,
   InstructorTest.class, LocationDBTest.class, LocationTest.class, ConstraintTest.class, RangeTest.class,
   AvailableCoursesRowTest.class, ScheduleTest.class, SectionTest.class, AnalyticsRowTest.class,
   AdminAnalyticsTest.class})

public class RunTests {
   public static void main(String[] args) {
      JUnitCore.main("scheduler_tool.RunTests");
   }
}
