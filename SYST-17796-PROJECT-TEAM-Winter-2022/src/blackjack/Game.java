package blackjack;

import java.util.Scanner;

/* This class  +++ Enter class description here +++
 *
 * @author David Freitas
 */

public class Game {
    
    public static void playRound(Deck deck, Dealer dealer, Player player) {
        
        Scanner input = new Scanner(System.in);
        Scanner wagerInput = new Scanner(System.in);
        int wager = 0;
        
        System.out.println(">>Shuffling deck...\n");
        deck.generateDeck();
        deck.shuffle();
        deck.cutTheDeck();
        
        System.out.println(">>Dealing cards...\n");
        Player[] players = {dealer, player};
        dealer.dealHands(deck, players);
        
        System.out.println("What is your wager: ");
        while(wager <= 0 || wager > player.getScore()) {
            wager = wagerInput.nextInt();
            if(wager > player.getScore()) {
                System.out.println("Your wager cannot be more than your current score.");
            } else if(wager <= 0) {
                System.out.println("Your wager needs to be more than 0");
            }
        }
        
        System.out.println("Dealer's Hand:\n"
                + dealer.getHand().get(0).toString() + " [?]\n");
        System.out.println("Your Hand: \n" + player.handToString());
        
        String hitOrStand = "";
        
        while(!hitOrStand.equals("stand")) {
            
            System.out.println("Would you like to 'hit' or 'stand'?");
            hitOrStand = input.nextLine();
            
            if(hitOrStand.equals("hit")) {
                dealer.dealCard(deck, player);
                System.out.println("Your Hand: \n" + player.handToString());
                if(checkBust(player) == true) {
                    System.out.println("Player Bust!");
                    hasLost(player, wager);
                    return;
                }
                hitOrStand = "";
            } else if(hitOrStand.equals("stand")) {
                System.out.println("Dealer's Hand:\n" + dealer.handToString());
                
                while(dealer.getHandValue() < 16) {
                    dealer.dealCard(deck, dealer);
                    System.out.println(dealer.handToString());
                }
                
                if(checkBust(dealer) == true) {
                    System.out.println("Dealer Bust!");
                    hasWon(player, wager);
                } else {
                    if(player.getHandValue() > dealer.getHandValue()) {
                        hasWon(player, wager);
                    } else {
                        hasLost(player, wager);
                    }
                }
                return;
            }
        }
    }
    
    public static boolean checkBust(Player player) {
        return player.getHandValue() > 21;
    }
    
    public static boolean checkWin(Player player, Dealer dealer) {
        return player.getHandValue() > dealer.getHandValue();
    }
    
    public static void hasWon(Player player, int wager) {
        System.out.println(player.getName() + " Wins!");
        player.addScore(wager*2);
        System.out.println("You won: " + wager*2);
        System.out.println("Your score is now: " + player.getScore() + "\n");
    }
    public static void hasLost(Player player, int wager) {
        System.out.println(player.getName() + " Lost :(");
        try {
            player.addScore(-(wager));
            if(player.getScore() <= 0)
                throw new Exception();
            System.out.println("You lost: " + wager);
            System.out.println("Your score is now " + player.getScore() + "\n");
            
        } catch (Exception ex) {
            System.out.println("Game Over!");
            System.exit(0);
        }
    }
}