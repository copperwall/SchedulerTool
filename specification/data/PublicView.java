package data;

/**
 * Models the view for users that are not an admin, and changes depending on 
 * the kind of user set to it. Includes the functionality described in sections
 * 2.6.2 and 2.6.3
 */
abstract public class PublicView extends View{
   
   User currentUser;

   /**
    * Opens the vote dialog if the current user is a student.
    */
   /*@
      requires (* nothing *);
      ensures (* nothing *);
   @*/
   public abstract void vote();

   /**
    * Opens the instructor preferences dialog if the current user is an instructor.
    */
   /*@
      requires (* nothing *);
      ensures (* nothing *);
   @*/
   public abstract void viewPreferences();
}
