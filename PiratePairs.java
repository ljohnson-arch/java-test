public class PiratePairs{
    public static void main(String[] args){
        GameDeck deck = new GameDeck(55);
        int numOfPlayers = 5; // chsnge to scanner 
        Player[] player = new Player[numOfPlayers];
        
        for (int i = 0; i < numOfPlayers; i++){
            player[i] = new Player(i + 1);
        }
        
        player[1].addCard(deck.drawCard());
        
         
         
    }
 }
