package models.admin.generation;

import java.util.ArrayList;

public class Constraint {
   /**
    * The text that's displayed in the Constraint list in the GUI
    */
   String text;
   ArrayList<Integer> notOverlap;
   ArrayList<Range> ranges;
   
   public ArrayList<ArrayList<Integer>> getConstraints() {
      return null;
   }
   
   public String getText() {
      return text;
   }
}
