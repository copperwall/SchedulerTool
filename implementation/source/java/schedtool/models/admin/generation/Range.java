package models.admin.generation;

public class Range {
   int start;
   int end;
   
   public Range(int start, int end) {
      this.start = start;
      this.end = end;
      System.out.println("New range: " + start + " end: " + end);
   }
}