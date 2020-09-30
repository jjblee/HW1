
public class CardGameSimulator {

    private static final Player[] players = new Player[2];
    private static final Card[][] decks = new Card[2][];


    public static void simulateCardGame(String inputA, String inputB) {
        String[] arr1=inputA.split(" ");
        String[] arr2=inputB.split(" ");
        decks[0]=new Card[10];
        decks[1]=new Card[10];

        for(int i=0; i<arr1.length; i++){
            decks[0][i]=new Card(arr1[i].charAt(0)-48, arr1[i].charAt(1));
        }
        for(int i=0; i<arr2.length; i++){
            decks[1][i]=new Card(arr2[i].charAt(0)-48, arr2[i].charAt(1));
        }

        players[0]=new Player("A", decks[0]);
        players[1]=new Player("B", decks[1]);

        char[] toss;
        toss=Card.firstCard(players, decks);
        int sum=1;
        while(true){
            toss=Card.selectCard(toss,players[1], decks[1]);
            sum+=1;
            if(toss==null){
                printLoseMessage(players[1]);
                break;
            }
            toss=Card.selectCard(toss,players[0], decks[0]);
            sum+=1;
            if(toss==null){
                printLoseMessage(players[0]);
                break;
            }
            if(sum==20){
                printLoseMessage(players[0]);
            }

        }
    }

    private static void printLoseMessage(Player player) {
        System.out.printf("Player %s loses the game!\n", player);
    }

}


class Player {
    private String name;
    private Card[] deck;

    Player(String name, Card[] deck){
        this.name=name;
        this.deck=deck;
    }

    public void playCard(Card card) {System.out.printf("Player %s: %s\n", name, card); }

    @Override
    public String toString() {
        return name;
    }
}


class Card {
    private int number;
    private char shape;

    Card(int number, char shape){
        this.number=number;
        this.shape=shape;
    }

    public static char[] firstCard(Player[] players, Card[][] decks) {
        int max = Integer.MIN_VALUE;
        char[] current=new char[2];
        for (int i = 0; i < 10; i++) {
            if (decks[0][i].number > max) {
                max = decks[0][i].number;
            }
        }

        for (int i = 0; i < 10; i++) {
            if ( (decks[0][i].number == max&&decks[0][i].shape=='O')|| decks[0][i].number == max&&decks[0][i].shape=='X'){
                players[0].playCard(decks[0][i]);
                current[0]=(char) decks[0][i].number;
                current[1]=decks[0][i].shape;
                decks[0][i]=null;
            }
        }
        return current;
    }

    public static char[] selectCard(char[] toss, Player players, Card[] deck){
        char[] current=new char[2];
        int count=0, nullCount=0;
        for (int i = 0; i < deck.length; i++) {
            if(deck[i]==null){
                nullCount+=1;
                continue;
            }
            if (deck[i].number == toss[0]){
                players.playCard(deck[i]);
                current[0]=(char)deck[i].number;
                current[1]=deck[i].shape;
                deck[i]=null;
                break;
            } else{
                count+=1;
            }
        }
        if(count==(10-nullCount)){
            int max = Integer.MIN_VALUE;
            int endCondition=0;
            for (int i = 0; i < deck.length; i++) {
                if(deck[i]==null||deck[i].shape!=toss[1]){
                    endCondition+=1;
                    continue;
                }
                if (deck[i].number > max && deck[i].shape==toss[1]) {
                    max = deck[i].number;
                }
            }
            if(endCondition==10){
                return null;
            }

            for (int i = 0; i < deck.length; i++) {
                if(deck[i]==null||deck[i].shape!=toss[1]){
                    continue;
                }
                if (deck[i].number == max){
                    players.playCard(deck[i]);
                    current[0]=(char)deck[i].number;
                    current[1]=deck[i].shape;
                    deck[i]=null;
                    break;
                }
            }

        }
        return current;
    }


    @Override
    public String toString() {
        return "" + number + shape;
    }
}