package models.admin.generation;

public class Range {
   
   public static class RangeOutOfBoundsException extends Exception {
      public RangeOutOfBoundsException(String message) {
         super(message);
      }
   }
   
   public static class StartAfterEndException extends Exception {
      public StartAfterEndException(String message) {
         super(message);
      }
   }
   
   int start;
   int end;
   
   /**
    * Used in the Constraint class to set a range of courses that can't overlap, inclusivly.
    * @param start first course, such as 310
    * @param end second course, such 319
    * @throws RangeOutOfBoundsException thrown when start or end is out of range
    * @throws StartAfterEndException thrown when start is greater than end
    */
   /*@
       requires
          start >= 100 && start < 1000 && end >= 100 && end < 1000 && start < end;
   @*/
   public Range(int start, int end) throws RangeOutOfBoundsException, StartAfterEndException {
      if (start < 100 || start > 999)
         throw new RangeOutOfBoundsException("Start must be at least 100 and less than 1000");
      
      if (end < 100 || end > 999)
         throw new RangeOutOfBoundsException("end must be at least 100 and less than 1000");
      
      if (start >= end) 
         throw new StartAfterEndException("Start must be less than end"); 
         
      this.start = start;
      this.end = end;
   }
}