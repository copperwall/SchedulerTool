package models.admin.generation;

import models.data.databases.Day;

public class TimePrefRow {
   String label;
   Day prefs;
   
   public TimePrefRow(String time, Day prefs) {
      this.label = time;
      this.prefs = prefs;
   }
   
   
   public String getTimeColumn() {
      return label;
   }

   public String getMonColumn() {
      return "";
   }

   public String getTuesColumn() {
      return "";
   }

   public String getWedColumn() {
      return "";
   }
   public String getThursColumn() {
      return "";
   }
   public String getFriColumn() {
      return "";
   }
}