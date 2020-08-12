/**
 * @author Krishna Taneja, Gurvesh Sidhu, Aryan Chopra
 */
/**
 *Enumeration for Value of cards
 */
public enum Values
{
   ACE(1),
   TWO(2),
   THREE(3),
   FOUR(4),
   FIVE(5),
   SIX(6),
   SEVEN(7),
   EIGHT(8),
   NINE(9),
   TEN(10),
   JACK(10),
   QUEEN(10),
   KING(10);

   private int val;//private variable

   /**
    * Constructor
    *
    * @param val
    */
   private Values (int val)
   {
      this.val = val;
   }

   /**
    * getter method for val
    *
    * @return val variable
    */
   public int getVal ()
   {
      return val;
   }
}
