package data;

/**
 * Models a View
 *
 */
public abstract class View {
   public TermsDB terms;
   public Schedule currentSchedule;
   public Term currentTermSelected;

   /*@
      requires term != null;
      ensures currentTermSelected.equals(term);
   @*/	
   public abstract void setTerm(Term term);

   /*@
      requires (* nothing *);
      ensures (* nothing *);
   @*/
   public abstract void viewSchedule();
}
