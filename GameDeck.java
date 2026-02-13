import java.util.Arrays;
import java.util.Random;
public class GameDeck{
    private int[] deck;
    private int numOfCards;

    public GameDeck(int cardNum){
        numOfCards = cardNum;
        this.deck = createDeck(numOfCards);
      
    }

    public int[] createDeck(int deckSize){
        int[] newDeck = new int[deckSize];
        int deckIndex = 0; 
        for (int i = 1; i <= 10; i++){
            for (int j = 0; j < i; j++){
                if (deckIndex < deckSize){
                    newDeck[deckIndex] = i;
                    deckIndex++;
                }
            }
        }
        return newDeck;
    } 

    public void shuffleDeck(){
        Random num = new Random();
        for (int i = deck.length - 1; i > 0; i--){
            int j = num.nextInt(i + 1);

            int temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public void printDeck(){
        for(int card : deck){
            System.out.print(card + " ");
        }
    }
}