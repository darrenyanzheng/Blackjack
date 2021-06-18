import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        double startingMoney = 100;
        while (startingMoney > 0) {

            Deck playingDeck = new Deck();
            playingDeck.createDeck();
            playingDeck.shuffle();
            Deck playerDeck = new Deck();
            Deck dealerDeck = new Deck();

            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);

            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

            boolean endRound = false;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to Blackjack! You have " + "$" + startingMoney + ". How much would you like to wager?");
            double wager = scanner.nextDouble();
            if (wager > startingMoney) {
                System.out.println("You cannot bet more money than what you have. Please enter a lower value.");
                wager = scanner.nextDouble();

            }
            if (wager < 0 ) {
                System.out.println("You cannot bet negative money.");
                wager = scanner.nextDouble();
            }
            if (wager == 0) {
                scanner.close();
                System.out.println("You cannot bet nothing.");
                break;
            }
            while (true) {
                System.out.println("Your hand consists of: " + playerDeck.toString());
                System.out.println("Your hand is valued at " + playerDeck.valueOfCards());
                System.out.println("Dealer hand: " + dealerDeck.getCard(0).toString() + " and HIDDEN");
                if (playerDeck.deckSize() == 2 && dealerDeck.deckSize() == 2) {
                    if (playerDeck.valueOfCards() == 21 && dealerDeck.valueOfCards() != 21) {
                        System.out.println("Blackjack! You win.");
                        endRound = true;
                        startingMoney += wager;
                        break;
                    }
                    if (playerDeck.valueOfCards() == 21 && dealerDeck.valueOfCards() == 21) {
                        System.out.println("Push blackjack.");
                        System.out.println("Dealer's deck: " + dealerDeck.valueOfCards());

                        endRound = true;
                        break;
                    }
                }
                System.out.println("Would you like to hit (1) or stand? (2)");

                int response = scanner.nextInt();
                if (response == 1) {
                    playerDeck.draw(playingDeck);
                    System.out.println("You drew a " + playerDeck.getCard(playerDeck.deckSize() - 1).toString());
                    if (playerDeck.valueOfCards() > 21) {
                        System.out.println("Bust. The value of your cards is " + playerDeck.valueOfCards() + ".");
                        startingMoney = startingMoney - wager;
                        endRound = true;
                        break;

                    }

                }
                if (response == 2) {
                    break;
                }
            }
            while (!endRound) {
                System.out.println("Dealer's cards = " + dealerDeck.valueOfCards());

                while (dealerDeck.valueOfCards() < 17) {
                    dealerDeck.draw(playingDeck);
                    System.out.println("Dealer draws " + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());
                    System.out.println("Dealer's new value = " + dealerDeck.valueOfCards());
                    endRound = true;


                }
                if (dealerDeck.valueOfCards() > 21) {
                    System.out.println("Dealer busts. You win.");
                    startingMoney += wager;
                    break;
                }

                if (dealerDeck.valueOfCards() < playerDeck.valueOfCards()) {
                    System.out.println("You win!");
                    startingMoney += wager;
                    endRound = true;
                }

                if (dealerDeck.valueOfCards() == playerDeck.valueOfCards()) {
                    System.out.println("Push. It's a tie.");
                    endRound = true;
                }
                if (dealerDeck.valueOfCards() > playerDeck.valueOfCards()) {
                    System.out.println("You lose!");
                    startingMoney -= wager;
                    endRound = true;
                }
                dealerDeck.resetDeck(playingDeck);
                playerDeck.resetDeck(playingDeck);

            }

        }
        System.out.println("Thanks for playing!");

    }
}
