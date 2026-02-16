public class PiratePairs{
    public static void main(String[] args){
         GameDeck deck = new GameDeck(55);
         int numOfPlayers = 5;

        for (int i = 1; i <= numOfPlayers; i++){
             Player player = new Player(i);
        }
         
        
         deck.printDeck();
         deck.shuffleDeck();
         deck.printDeck();
         
    }
 }
