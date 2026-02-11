import java.util.Arrays;
public class GameDeck{
    private int[] deck;
    private int numOfCards;

    public GameDeck(int numOfCards){
        this.numOfCards = numOfCards;
        this.deck = createDeck(numOfCards);
       System.out.println(Arrays.toString(deck));
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

    public int drawCard(){
        int randomNum = (Int)(Math.random() * numOfCards + 1);
    }
}