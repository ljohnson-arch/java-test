import java.util.Random;
public class GameDeck{
    private int[] deck;
    private int numOfCards;
    private int top;

    public GameDeck(int cardNum){
        numOfCards = cardNum;
        this.deck = createDeck(numOfCards);
        shuffleDeck();
        top = 0; //top card on deck or index of deck array 
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

    public int drawCard(){
        
        if (top >= deck.length){
            top = 0;
            shuffleDeck();
        }

        int card = deck[top];
        top++;
        return card;
    }
}