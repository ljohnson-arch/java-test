import java.util.Scanner;
public class PiratePairs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number of PLayers: ");
        int numOfPlayers = input.nextInt();
        int losingScore = (60 / numOfPlayers) + 1;

        GameDeck deck = new GameDeck(55);
        Player[] player = new Player[numOfPlayers];

        for (int i = 0; i < numOfPlayers; i++) {
            player[i] = new Player(i + 1);
        }

        // first round everyone player gets a card.
        for (int i = 0; i < numOfPlayers; i++) {
            int card = deck.drawCard();
            player[i].addCard(card);

            System.out.println("Player " + player[i].getId() + " draws " + card);
        }

        int playersIn = numOfPlayers;
        int turn = 0;

        // while loop here
        while (playersIn > 1) {
            Player current = player[turn % numOfPlayers];

            if (!current.isOut()) {

                System.out.println("Player " + current.getId() + "'s turn");

                if (current.handSize() == 0) {
                    int card = deck.drawCard();
                    System.out.println("Draws " + card);
                    current.addCard(card);

                } else {
                    // strat if more than 3 cards takes lowest

                    if (current.handSize() > 3) {

                        int lowest = findLowest(player);
                        System.out.println("Folds and takes " + lowest + " points");

                        current.addScore(lowest);

                        // discard hand
                        discardHand(current, deck);
                        current.clearHand();

                    } else {

                        int card = deck.drawCard();
                        System.out.println("Draws " + card);

                        if (current.hasCard(card)) {
                            System.out.println("Pair! add " + card + " to score");
                            current.addScore(card);

                            // discard hand and pair card
                            deck.addToDiscard(card);
                            discardHand(current, deck);

                            current.clearHand();
                        } else {
                            current.addCard(card);
                        }
                    }
                }

                // check if player is out
                if (current.getScore() > losingScore) {
                    System.out.println("Player " + current.getId() + " is OUT!");
                    current.setOut(true);
                    playersIn--;
                }
            }
            turn++;
        }

        // declare winner
        for (Player p : player) {
            if (!p.isOut()) {
                System.out.println("Playe " + p.getId() + " Wins!");
            }
        }
        input.close();
    }

    public static int findLowest(Player[] player) {

        int lowest = 11;

        for (Player p : player) {
            if (!p.isOut() && p.handSize() > 0) {
                int min = p.lowestCard();
                if (min < lowest) {
                    lowest = min;
                }
            }
        }
        return lowest;
    }

    public static void discardHand(Player player, GameDeck deck) {

        int[] hand = player.getHand();

        for (int i = 0; i < player.handSize(); i++) {
            deck.addToDiscard(hand[i]);
        }
        
    }
}
