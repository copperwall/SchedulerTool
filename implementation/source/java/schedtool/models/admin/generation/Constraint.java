package models.admin.generation;

import java.util.ArrayList;
import java.util.HashSet;

public class Constraint {
   
   public static class InvalidConstraintText extends Exception {
      public InvalidConstraintText(String message) {
         super(message);
      }
   }
   /**
    * The text that's displayed in the Constraint list in the GUI
    */
   String text;
   
   ArrayList<Integer> notOverlapArr;
   ArrayList<Range> ranges;
   
   /*@ 
        requires 
           textToParse != null && !textToParse.trim().isEmpty();
        ensures
           notOverLapArr != null || ranges != null;
    @*/
   public Constraint(String textToParse) throws InvalidConstraintText {
      StringBuilder builder = new StringBuilder();
      HashSet<Integer> notOverlap = new HashSet<Integer>();
      
      if (textToParse.contains(",") && !textToParse.contains("{")) {
         String[] courseStrings = textToParse.split(", ");
         if (courseStrings.length < 2)
            throw new InvalidConstraintText("Must contain more than one course separated by ', '");
         
         
         
         char[] arr = textToParse.toCharArray();
         int commaCount = 0;
         for (char c : arr) {
            if (c == ',')
               commaCount++;
         }
         
         if (courseStrings.length - 1 != commaCount) {
            throw new InvalidConstraintText("Constraint list cannot have extra commas");
         }
         
         int[] courseNums = new int[courseStrings.length];
         
         for (int index = 0; index < courseStrings.length; index++) {
            try {
               courseNums[index] = Integer.valueOf(courseStrings[index]);
            }
            catch (NumberFormatException e) {
               throw new InvalidConstraintText("Invalid course number");
            }
            notOverlap.add(courseNums[index]);
         }
         
         if (notOverlap.size() != courseStrings.length)
            throw new InvalidConstraintText("No duplicate courses can be in a constraint");
         
         int index;
         notOverlapArr = new ArrayList<Integer>();
         notOverlapArr.addAll(notOverlap);
         for (index = 0; index < notOverlap.size() - 1; index++) {
            builder.append(notOverlapArr.get(index).toString() + (notOverlapArr.size() > 2 ? ", " : " "));
         }
         builder.append("and " + notOverlapArr.get(index) + " should not overlap");
         text = builder.toString();
      }
      else if (textToParse.contains("X") && !textToParse.contains("{") && !textToParse.contains("}")) {
         char[] chars = textToParse.toCharArray();
         int index = 0;
         int rangeOffset = 99;
         int baseLevel;
         try {
            baseLevel = Integer.valueOf(String.valueOf(chars[index]));
         }
         catch (NumberFormatException e) {
            throw new InvalidConstraintText("First character must be a number");
         }
         baseLevel *= 100;
         
         char[] arr = textToParse.toCharArray();
         int xCount = 0;
         for (char c : arr) {
            if (c == 'X')
               xCount++;
         }
         
         if (xCount > 2) {
            throw new InvalidConstraintText("More than two X's not supported");
         }
         
         if (chars[++index] != 'X') {
            try {
               baseLevel += Integer.valueOf(String.valueOf(chars[index])) * 10;
            }
            catch (NumberFormatException e) {
               throw new InvalidConstraintText("Non-integers nor non-X's are not allowed");
            }
            rangeOffset = 9;
         }
         
         ranges = new ArrayList<Range>();
         ranges.add(new Range(baseLevel, baseLevel + rangeOffset));

         
         builder.append(baseLevel + "-level courses should not overlap");
         text = builder.toString();
      }
      else if (textToParse.contains("X") && textToParse.contains("{")
       && textToParse.contains("}")) {
         char[] chars = textToParse.toCharArray();
         int index = 0;
         int rangeOffset = 99;
         int baseLevel = Integer.valueOf(String.valueOf(chars[index]));
         baseLevel *= 100;
         
         ranges = new ArrayList<Range>();
         
         if (chars[++index] == '{') {
            rangeOffset = 9;
            String[] courseStrings = textToParse.substring(++index, textToParse.indexOf('}')).split(",");
            int[] courseNums = new int[courseStrings.length];
            
            for (index = 0; index < courseStrings.length; index++) {
               int tempBase = baseLevel;
               courseNums[index] = Integer.valueOf(courseStrings[index]);
               tempBase += courseNums[index] * 10;
               ranges.add(new Range(tempBase, tempBase + rangeOffset));
            }
         }

         for (index = 0; index < ranges.size() - 1; index++) {
            builder.append(ranges.get(index).start + "s" + (ranges.size() > 2 ? ", " : " "));
         }
         builder.append("and " + ranges.get(index).start + "s should not overlap");
         text = builder.toString();
      }
      else {
         throw new InvalidConstraintText("A parsing error occurred");
      }
   }
   
   public ArrayList<Integer> getConstraints() throws InvalidConstraintText {
      if (notOverlapArr != null && notOverlapArr.size() > 1)
         return notOverlapArr;
      else if (ranges != null && ranges.size() >= 1) {
         
      }
      throw new InvalidConstraintText("Could not create constraint list");
   }
   
   public String getText() {
      return text;
   }
}
