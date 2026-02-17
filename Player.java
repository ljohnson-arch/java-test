public class Player{
    private int id;
    private int score;
    private boolean out;
   
    private int[] hand = new int[10];
    private int handCount = 0;

    public Player(int id){
        this.id = id; 
        this.score = 0;
        this.out = false;
    }

public int getId(){
    return id;
}

public int getScore(){
    return score;
}

public void addScore(int points){
    score += points;
}

public boolean isOut(){
    return out;
}

public void setOut(boolean value){
    out = value;
}

public void addCard(int card){
    hand[handCount] = card;
    handCount++;
}

public boolean hasCard(int card){
    for (int i = 0; i < handCount; i++){
        if (hand[i] == card){
            return true;
        }
    }
    return false;
}

public int handSize(){
    return handCount;
}

public void clearHand(){
    handCount = 0;
}

public int lowestCard(){
    if (handCount == 0){
        return -1; //no cards in hand
    }

    int min = hand[0];

    for (int i = 1; i < handCount; i++){
        if (hand[i] < min){
            min = hand[i];
        }
    }
    return min;
}

public void printHand(){
    System.out.println("Player " + id + " hand: ");
    for(int i = 0; i < handCount; i++){
        System.out.print(hand[i] + " ");
    } 
}

public int[] getHand(){
    return hand;
}
}



