/**
 * @author Krishna Taneja, Gurvesh Sidhu, Aryan Chopra
 */
import java.util.*;

public class Set
{
   private ArrayList<Cards> deck;//ArrayList for deck of cards

   /**
    * Constructor
    */
   public Set ()
   {
      this.deck = new ArrayList<Cards>();
   }

   /**
    * Method to create a new set of cards
    *
    * @param num
    */
   public void createSet (int num)
   {
      for (int i = 0; i < num; i++) {
         for (Suits Suit : Suits.values()) {
            for (Values Value : Values.values()) {
               this.deck.add(new Cards(Suit, Value));//Adding new cards to the deck 
            }
         }
      }
   }

   /**
    * Method to shuffle the deck of cards
    */
   public void shuffle ()
   {
      Collections.shuffle(deck);//shuffle() method to shuffle the deck
   }

   /**
    * Method to return card at certain index
    *
    * @param i
    * @return Cards reference variable
    */
   public Cards getCard (int i)
   {
      return this.deck.get(i);
   }

   /**
    * Method to draw one card from the deck
    *
    * @param drawCard
    */
   public void draw (Set drawCard)
   {
      this.deck.add(drawCard.getCard(0));
      drawCard.removeCard(0);
   }

   /**
    * Method to remove card from deck
    *
    * @param a
    */
   public void removeCard (int a)
   {
      this.deck.remove(a);//Removing card from deck
   }

   /**
    * Method to print details of card
    *
    * @return output
    */
   public String toString ()
   {
      String output = "";
      int c = 0;
      for (Cards card : this.deck) {
         output += card.toString() + "\n";
         c++;
      }
      return output;
   }

   /**
    * Method to return value of card
    *
    * @return val
    */
   public int cardValue ()
   {
      int val = 0;
      for (Cards card : this.deck) {
         if (card.getValue().equals("ACE")) {
            if (val <= 10) {
               val += 11;
            }
            else {
               val += 1;
            }
         }
         else {
            val += card.getValue().getVal();
         }
      }
      return val;//returning value of card
   }


}
