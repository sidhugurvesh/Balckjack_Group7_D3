/**
 * @author Krishna Taneja, Gurvesh Sidhu, Aryan Chopra
 */
import java.util.Scanner;
public class Main
{
   public static void main (String[] args)//Main method
   {
      Set play = new Set();//Object of set class
      Set playerCards = new Set();
      Set dealerCards = new Set();
      Scanner in = new Scanner(System.in);//Scanner class object

      System.out.println("WELCOME TO BLACKJACK!!!");
      boolean bool = true;
      while (bool == true) {//Loop to ask user again and again
         System.out.println("Are you 18 or more years old?(Y|N)");
         String str = in.next();
         if (str.charAt(0) == 'n' || str.charAt(0) == 'N') {//Checking age requirements
            System.out.println("Sorry you need to be 18 or over to play this game");
            System.exit(0);//Exiting the program
         }
         System.out.println("How many deck of cards you want to play with?(1-6)");
         int n = in.nextInt();
         if (n < 1 | n > 6) {
            System.out.println("Enter deck only from 1 to 6!!!");
            continue;
         }
         play.createSet(n);//Creating new set of cards
         System.out.println("Shuffling the deck...");
         play.shuffle();//Shuffling the deck of cards

         System.out.println("Drawing cards...");//Distributing cards to dealer and the player
         playerCards.draw(play);
         playerCards.draw(play);
         dealerCards.draw(play);
         dealerCards.draw(play);
         int k = 0;
         System.out.println("Your Cards : \n" + playerCards.toString());
         System.out.println("Value of Cards : \n" + playerCards.cardValue());
         while (true) {
            System.out.println("Dealer's Card : \n" + dealerCards.getCard(0) + "[hidden]");
            System.out.println();
            System.out.println("1.Hit \n2.Stand?");
            int reply = in.nextInt();//Asking user to play the game

            /**
             * Checking conditions to find who wins
             */
            if (reply == 1) {
               playerCards.draw(play);
               System.out.println("Your Cards : \n" + playerCards.toString());
               System.out.println("Value of Cards :\n" + playerCards.cardValue());
               if (playerCards.cardValue() > 21) {
                  System.out.println("Bust.../n Game Over Dealer Wins");
                  k++;
                  break;
               }
            }
            else if (reply == 2) {
               break;
            }
            else {
               System.out.println("Wrong choice");
            }
         }
         System.out.println();
         System.out.println("Dealer Cards:" + dealerCards.toString());

         if ((dealerCards.cardValue() > playerCards.cardValue()) && k == 0) {
            System.out.println("Dealer Wins ");
            k++;
         }

         while ((dealerCards.cardValue() < 17) && k == 0) {
            dealerCards.draw(play);
            System.out.println("Dealer draws a card  ");
            System.out.println("Dealer's cards : " + dealerCards.toString());
         }

         System.out.println("Dealer's cards value : " + dealerCards.cardValue());
         if ((dealerCards.cardValue() > 21) && k == 0) {
            System.out.println("Dealer Busts. You win!");
            k++;
         }

         if ((dealerCards.cardValue() == playerCards.cardValue()) && k == 0) {
            System.out.println("DRAW");
            k++;
         }

         if ((playerCards.cardValue() > dealerCards.cardValue()) && k == 0) {
            System.out.println("You win the round.");
            k++;
         }
         else if (k == 0) {
            System.out.println("Dealer wins.");
         }


         System.out.println("End of Round");//Game over
         System.out.println("\nWant to play again?(Y|N)");//Asking user to play again

         String c = in.next();

         char ch = c.charAt(0);
         if (ch == 'Y' | ch == 'y') {
            bool = true;
         }
         else {
            bool = false;
         }
      }
   }
}
