public class Player{
    private int id;
    private int score;
   
    private int[] hand = new int[10];
    private int handCount = 0;
}

public Player(int id){
   this.id = id; 
   this.score = 0;
}

public int getId(){
    return id;
}

public int getScore(){
    return score;
}

public int addScore(int points){
    score += points;
}


