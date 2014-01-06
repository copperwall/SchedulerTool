package admin;
import java.util.Collection;

public abstract class Constraint {
   Collection<Integer> notOverlap;
   Collection<Range> ranges;
   
   public abstract Collection<Collection<Integer>> getConstraints();
}