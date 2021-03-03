import java.lang.Math;
import java.util.*;

public class ElkTarotBot implements RPSLSBot {
    int turn;
    int diagnosticRounds;
    int[] opponentMoves;
    int[] tarotMoves;
    boolean[] wins;
    int strategy;
    
    
    public String getBotName() { return "ElkTarotBot"; }
    public String getCoderName() { return "Kevin W"; }
    public ElkTarotBot() { reset(); }
    public void reset() {
        turn = -1;
        diagnosticRounds = 50;
        tarotMoves = new int[10000];
        opponentMoves = new int[10000];
        wins = new boolean[diagnosticRounds];
        strategy = -1;
    }

    // 50 turns of diagnostics, try to trick the opponent into revealing their method
    // rpsls, we beat them if ourMove == (n + 1) % 5 || ourMove == (n + 3) % 5
    public void opponentsLastMove(int move) {
        opponentMoves[turn] = move;
    }
    
    public int getMove() {
        turn++;
        if (turn < diagnosticRounds) {
            // cycle through to see if the opponent responds
            if (turn <= 30) return move(turn);
            // constant spock to see if they use opponent's last move
            return 4;
        }
        
        // counter them!
        switch (strategy) {
            // s0 - beat opponent's last move
            case 0:
                return move(opponentMoves[turn-1]+1);
            case 1:
                System.out.println((turn%5) + " --> " + opponentMoves[turn]);
                return move(turn);
        }
        
        // otherwise, just do random
        return move((int)(Math.random() * 5));
    }
    
    public int move(int m) {
        tarotMoves[turn] = m % 5;
        if (turn == 50) pickStrategy();

        return tarotMoves[turn];
    }

    public void pickStrategy() {
        boolean talk = true;
        
        int[] pm = Arrays.copyOfRange(tarotMoves, 0, diagnosticRounds);
        int[] om = Arrays.copyOfRange(opponentMoves, 0, diagnosticRounds);

        // track wins
        int[] win = new int[diagnosticRounds];
        for (int i=0; i<diagnosticRounds; i++) {
            win[i] = cmp(pm[i], om[i]);
        }
        
        // constant
        // get unique moves, if there's only one unique move, it's constant
        Set<Integer> unique = new HashSet<Integer>();
        for (int i=0; i<diagnosticRounds; i++) {
            unique.add(om[i]);
        }
        if (unique.size() == 1) {
            if (talk) System.out.println("Constant");
            strategy = 0;
            return;
        }
        
        // copybot
        int[] trm = Arrays.copyOfRange(tarotMoves, 0, 20);
        int[] opm = Arrays.copyOfRange(opponentMoves, 1, 21);
        System.out.println(Arrays.toString(trm));
        System.out.println(Arrays.toString(opm));
        if (Arrays.equals(trm, opm)) {
            if (talk) System.out.println("Copybot");
            strategy = 1;
            return;
        }
        

        // repeat until loss

        // counterbot

        // otherwise do repeat until loss bot
        
        System.out.println();
    }

    public int cmp(int player1move, int player2move) {
        if (player1move < 0 || player1move > 4 || player2move < 0 || player2move > 4)
            throw new IllegalArgumentException("Illegal move: " + player1move + ", " +
                                                                                 player2move);
        int[][] resultMatrix = { 
            {0, 2, 1, 1, 2}, // +1, +4
            {1, 0, 2, 2, 1}, // +1, +2
            {2, 1, 0, 1, 2}, // +2, +3
            {2, 1, 2, 0, 1}, // +2, +4
            {1, 2, 1, 2, 0}}; //+2, +4
        return resultMatrix[player1move][player2move];
    }
}