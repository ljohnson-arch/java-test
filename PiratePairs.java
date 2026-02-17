public class PiratePairs{
    public static void main(String[] args){

        int numOfPlayers = 5; // chsnge to scanner 
        int losingScore = (60 / numOfPlayers) + 1;

        GameDeck deck = new GameDeck(55);
        Player[] player = new Player[numOfPlayers];
        
        for (int i = 0; i < numOfPlayers; i++){
            player[i] = new Player(i + 1);
        }
        
        //first round everyone player gets a card.
        for (int i = 0; i < numOfPlayers; i++){
            int card = deck.drawCard();
            player[i].addCard(card);

            System.out.println("Player " + player[i].getId() + " draws " + card);
        }

        int playersIn = numOfPlayers;
        int turn = 0;

        //while loop here
            Player current = player[turn % numOfPlayers];

            if(!current.isOut()){

                System.out.println("Player " + current.getId() + "'s turn");

                if(current.handSize() == 0){
                     int card = deck.drawCard();
                     System.out.println("Draws " + card);
                     current.addCard(card);

                } else {
                    //strat if more than 3 cards takes lowest

                    if (current.handSize() > 3){

                        int lowest = findLowest(player);
                        System.out.println("Folds and takes " + lowest + " points");

                        current.addScore(lowest);

                        //discard hand
                        
                    }
                }

            }
     
         
    }

     public static int findLowest(Player[] player){

            int lowest = 11;

            for (Player p: player){
                if(!p.isOut() && p.handSize() > 0){
                    int min = p.lowestCard();
                    if (min < lowest){
                        lowest = min;
                    }
                }
            }
            return lowest;
         }

    public static void discardHand(Player player, GameDeck deck){

        int[] hand = player.getHand();

        for (int i = 0; i < player.handSize(); i++){
            deck.addToDiscard(hand[i]);
        }
    }
 }
