public class test {
    public static void main(String[] args){

        Player p1 = new Player(1);
      

       p1.addCard(4);
       p1.addCard(2);

       System.out.println("has Card: " + p1.hasCard(4));
        System.out.println("Score: " + p1.getScore());

        p1.addScore(6);

        System.out.println("Score: " + p1.getScore());

        p1.setOut(true);
        System.out.println("is out: " + p1.isOut());

    }
}
