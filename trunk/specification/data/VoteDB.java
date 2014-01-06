package data;

import java.util.Collection;

public abstract class VoteDB {
   public Collection<Vote> votes;

   /**
    * Gets all votes for the current term.
    */
   /*@
      requires (* nothing *);
      ensures \old(votes).equals(votes);
      // Ensures courses hasn't changed since calling this method.
   @*/
   public abstract Collection<Vote> getByAdmin(Term term, Course course);

   /**
    * Retrieves a student's votes.
    */
   /*@
      requires (* nothing *);
      ensures \old(votes).equals(votes);
      // Ensures votes hasn't changed since calling this method.
   @*/
   public abstract Collection<Vote> getByStudent(Term term, String username);
}
