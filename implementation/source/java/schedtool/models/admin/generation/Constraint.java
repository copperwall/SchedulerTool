package models.admin.generation;

import java.util.ArrayList;

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
   ArrayList<Integer> notOverlap;
   ArrayList<Range> ranges;
   
   public Constraint(String textToParse) throws InvalidConstraintText {
      StringBuilder builder = new StringBuilder();
      notOverlap = new ArrayList<Integer>();
      
      if (textToParse.contains(",") && !textToParse.contains("{")) {
         String[] courseStrings = textToParse.split(", ");
         int[] courseNums = new int[courseStrings.length];
         
         for (int index = 0; index < courseStrings.length; index++) {
            courseNums[index] = Integer.valueOf(courseStrings[index]);
            notOverlap.add(courseNums[index]);
         }
         int index;
         for (index = 0; index < notOverlap.size() - 1; index++) {
            builder.append(notOverlap.get(index) + notOverlap.size() > 2 ? ", " : " ");
         }
         builder.append("and " + notOverlap.get(index) + " should not overlap");
         text = builder.toString();
      }
      else if (textToParse.contains("X") && !textToParse.contains("{")) {
         char[] chars = textToParse.toCharArray();
         int index = 0;
         int rangeOffset = 99;
         int baseLevel = Integer.valueOf(String.valueOf(chars[index]));
         baseLevel *= 100;
         
         if (chars[++index] != 'X') {
            baseLevel += Integer.valueOf(String.valueOf(chars[index])) * 10;
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
   
   public ArrayList<ArrayList<Integer>> getConstraints() {
      return null;
   }
   
   public String getText() {
      return text;
   }
}
