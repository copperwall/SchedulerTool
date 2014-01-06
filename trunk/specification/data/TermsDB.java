package data;

import java.util.Collection;

/**
 * Contains all of the available Terms. Add/edit/delete locations
 * are available.
 */
public abstract class TermsDB {
   public Collection<Term> terms;

   /**
    * Returns a term given a year and season.
    */
   /*@
   requires (* nothing *);
   ensures
     terms.containsAll(\old(terms)) && \old(terms).containsAll(terms);
   // Ensures terms hasn't changed since calling this method.
   @*/
   public abstract Term getTerm(int year, Term.Season season);

   /**
    * Adds a term to the term database.
    */
   /*@
     requires term != null;
     ensures terms.containsAll(\old(terms)) && 
       terms.contains(term);
     // Ensures that none of the old entries are touched and that terms
     // contains the term to be added
    @*/
   public abstract void addTerm(Term term);

   /**
    * Edits the passed term.
    */
   /*@
     requires term != null;
     ensures
     // Ensures that all of the terms are either from the old set of
     // terms, an edited term, or a new term that was added.
     (\forall Term t; terms.contains(t);
       \old(terms).contains(t) || t.equals(term)) &&
     terms.contains(term);
    @*/
   public abstract void editTerm(Term term);

   /**
    * Deletes the given term from the terms database.
    */
   /*@
     requires (* nothing *);
     ensures
     // Ensures that the term gets removed from the collection of terms
       !terms.contains(term);
    @*/
   public abstract void deleteTerm(Term term);
}
