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
        
         
         
    }
 }
