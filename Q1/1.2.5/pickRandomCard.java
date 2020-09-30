import java.lang.Math;


public class pickRandomCard {
    public static void main(String[] args) {
        int trialsPerJoker = 69; // nice
        
        for (int jokers=0; jokers<=2; jokers++) {
            System.out.println("\n\n\nprintRandomCard(" + jokers + "): ");
            
            for (int i=0; i<trialsPerJoker; i++) {
                printRandomCard(jokers);
            }
        }
    }
    
    public static void printRandomCard(int numJokers) {
        String[] cards = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
        String[] suits = { "Diamonds", "Clubs", "Hearts", "Spades" };
        
        if (numJokers < 0 || numJokers > 2) {
            System.out.println("You're the jokester here!");
            return; // we can use an empty return statement, even in a method with return type void
        }
        
        // pick random from 0-((13*4)+jokers-1)
        int random = (int)(Math.random() * (52+numJokers));
        
        String randomCard = "";
        String randomSuit = "";
        
        // if it's not one of the cards, it must be a joker.
        if (random >= 52) {
            System.out.println("Joker");
        } else {
            randomCard = cards[random % 13];
            randomSuit = suits[random / 13]; // int/int=int
            
            System.out.println(randomCard + " of " + randomSuit);
        }
    }
}