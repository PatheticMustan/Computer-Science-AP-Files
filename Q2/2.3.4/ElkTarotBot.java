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
        opponentMoves[turn-1] = move;
    }
    
    public int getMove() {
        turn++;
        if (turn < diagnosticRounds) {
            // cycle through to see if the opponent responds
            return move(turn % 5);
        }

        // counter them!
        switch (strategy) {
            // s0 - beat opponent's last move
            case 0:
                return move(opponentMoves[turn-1]+1);
        }
        
        // otherwise, just do random
        return move((int)(Math.random() * 5));
    }
    
    public int move(int m) {
        tarotMoves[turn] = m % 5;
        if (turn == 50) pickStrategy();

        return m % 5;
    }

    public void pickStrategy() {
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
            strategy = 0;
        }
        
        // repeat until loss

        // copybot
        //if ()

        // counterbot

        // otherwise do repeat until loss bot
        
        System.out.println();
        strategy = 1;
    }

    // win???
    public int cmp(int tarotMove, int opponentMove) {
        if (tarotMove == opponentMove) return 0;
        if ((opponentMove - tarotMove) % 5 < 3) return -1;
        return 1;
    }
}