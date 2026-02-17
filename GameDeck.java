import java.util.Random;
public class GameDeck{
    private int[] deck; 
    private int[] discardPile;
    private int top;
    private int discardCount;

    public GameDeck(int deckSize){
        deck = createDeck(deckSize);
        discardPile = new int[deckSize];
        shuffleDeck();
        top = 0; //top card on deck or index of deck array 
        discardCount = 0;
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

    public void addToDiscard(int card){
        discardPile[discardCount] = card;
        discardCount++;
    }

    public void addMultipleToDiscard(int[] cards, int count){
        for (int i = 0; i < count; i++){
            discardPile[discardCount++] = cards[i];
        }
    }

    public void reshuffleDiscards(){
        if(discardCount == 0){
            return;
        }

        for (int i = 0; i < discardCount; i++){
            deck[i] = discardPile[i];
        }

        top = 0;
        shuffleDeck();
        discardCount = 0;
    }
}