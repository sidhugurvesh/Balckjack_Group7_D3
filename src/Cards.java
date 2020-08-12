/**
 * @author Krishna Taneja, Gurvesh Sidhu, Aryan Chopra
 */
public class Cards
{
   private Suits suit;
   private Values value;

   /**
    * Default Constructor
    *
    * @param suit
    * @param value
    */
   public Cards (Suits suit, Values value)
   {
      this.suit = suit;
      this.value = value;
   }

   /**
    * Method to print the card details
    *
    * @return
    */
   @Override
   public String toString ()
   {
      return this.suit.toString() + "-" + this.value.toString();
   }

   /**
    * Method to return the value of cards
    *
    * @return value of cards
    */
   public Values getValue ()
   {
      return this.value;
   }
}
