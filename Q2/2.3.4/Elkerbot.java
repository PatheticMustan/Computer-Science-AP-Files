import java.util.*;

public class Elkerbot implements RPSLSBot {
    private int[] moves;
    private Random rand;
    private int[][] plusbank;
    private int rut;

    public Elkerbot() { reset(); }
    public String getBotName() { return "Elkerbot"; }
    public String getCoderName() { return "Kevin W >:D"; }
    public void reset() {
        moves = new int[] { 1, 1, 1, 1, 1 };
        rand = new Random();
        plusbank = new int[][] {
            {1, 4}, // rock
            {1, 2}, // paper
            {2, 3}, // scissors
            {2, 4}, // lizard
            {2, 4}  // spock
        };
        rut = 1000;
    }
    
    // the idea is simple. If the opponent moves rock a lot, increase the probabilites of moving paper or spock.
    // It's impossible to counter random bot, so we might as well try a kinda-random bot. This should easily handle rockbot,
    // but get 50-50 on the rest.
    public int getMove() {
        if (rut-- <= 0) reset();
        
        int[] probabilities = new int[] { 0, 0, 0, 0, 0 };
        for (int i=0; i<5; i++) {
            probabilities[(i+plusbank[i][0]) % 5] += moves[i];
            probabilities[(i+plusbank[i][1]) % 5] += moves[i];
        }

        int sum = 0;
        for (int i=0; i<5; i++) {
            sum += probabilities[i];
        }

        int r = rand.nextInt(sum);
        int y = 0;
        //System.out.println(Arrays.toString(moves));
        //System.out.println(Arrays.toString(probabilities));
        //System.out.println(r);
        for (int i=0; i<5; i++) {
            // 2, (r probably), 500, 2, 500, 2
            y += probabilities[i];
            if (r <= y) return i;
        }

        
        // should never happen, but what the heck
        return 0;
    }
    
    public void opponentsLastMove(int move) {
        moves[move]++;
    }
}