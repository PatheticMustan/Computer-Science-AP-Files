import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class RPSLSArena {
    public static final int NUM_PLAYERS = 4;
    public static final boolean PAUSE_AFTER_MATCH = true;
    public static final int NUM_GAMES_PER_MATCH = 10000;
    
    public static void main(String[] args) {
        //playRPSLSMatch(new RandoBot(), new RepeatUntilLossBot(), 50, true);
        
        //initialize stats arrays
        RPSLSBot[] players = new RPSLSBot[NUM_PLAYERS];
        players[0] = new RandoBot();
        players[1] = new CopyBot();
        players[2] = new RepeatUntilLossBot();
        players[3] = new RockBot();
        int[] scores = new int[NUM_PLAYERS];
        
        //set up tournament schedule
        //Each row of matrix is a match, containing two player indices, referencing
        //players array above
        int[][] matches = new int[NUM_PLAYERS * (NUM_PLAYERS-1) / 2][2];
        int dest = 0;
        for (int p1 = 0; p1 < NUM_PLAYERS - 1; p1++) {
            for (int p2 = p1 + 1; p2 < NUM_PLAYERS; p2++) {
                matches[dest][0] = p1;
                matches[dest][1] = p2;
                dest++;
            }
        }
        for (int[] match : matches)
            System.out.println(Arrays.toString(match));
        
        //shuffle tournament schedule
        Random randGen = new Random();
        for (int i = matches.length - 1; i > 0; i--) {
            int j = randGen.nextInt(i+1);
            int[] temp = matches[i];
            matches[i] = matches[j];
            matches[j] = temp;
        }
        
        //play tournament
        Scanner input = new Scanner(System.in);
        for (int round = 0; round < matches.length; round++) {
            RPSLSBot p1 = players[matches[round][0]];
            RPSLSBot p2 = players[matches[round][1]];
            System.out.println("Match " + (round + 1) + ": " + p1.getBotName() + " vs. " +
                                                 p2.getBotName());
            int[] matchResults = playRPSLSMatch(p1, p2, NUM_GAMES_PER_MATCH, false);
            scores[matches[round][0]] += matchResults[0];
            scores[matches[round][1]] += matchResults[1];
            if (PAUSE_AFTER_MATCH) {
                System.out.print("Press enter to continue.");
                input.nextLine();
            }
            System.out.println();
        }
        
        //print tournament results
        System.out.println("Tournament results: ");
        for (int i = 0; i < players.length; i++) {
            System.out.printf("%30s: %d\n", players[i].getBotName(), scores[i]);
        }

        input.close();
    }
    
    public static int judgeRPSLS(int player1move, int player2move) {
        if (player1move < 0 || player1move > 4 || player2move < 0 || player2move > 4)
            throw new IllegalArgumentException("Illegal move: " + player1move + ", " +
                                                                                 player2move);
        int[][] resultMatrix = { 
            {0, 2, 1, 1, 2},
            {1, 0, 2, 2, 1},
            {2, 1, 0, 1, 2},
            {2, 1, 2, 0, 1},
            {1, 2, 1, 2, 0}};
        return resultMatrix[player1move][player2move];
    }
    
    //Runs numGames of RPSLS games between player1 and player2.
    //Prints the outcome of the whole match.
    //Returns [player1's score, player2's score]
    //If verbose is true, will also print a play-by-play of every turn.
    public static int[] playRPSLSMatch(RPSLSBot player1, RPSLSBot player2,
                                                                        int numGames, boolean verbose) {
        int player1Score = 0;
        int player2Score = 0;
        player1.reset();
        player2.reset();
        for (int i = 1; i <= numGames; i++) {
            int player1Move = player1.getMove();
            int player2Move = player2.getMove();
            player1.opponentsLastMove(player2Move);
            player2.opponentsLastMove(player1Move);
            int winner = judgeRPSLS(player1Move, player2Move);
            if (winner == 1)
                player1Score += 2;
            else if (winner == 2)
                player2Score += 2;
            else {
                player1Score++;
                player2Score++;
            }
            if (verbose) {
                String[] moves = {"Rock        ", "Paper     ", "Scissors", "Lizard    ", "Spock     "};
                System.out.print(i + ". " + player1.getBotName() +": " + moves[player1Move]
                                                     + "     " + player2.getBotName() +": " + moves[player2Move] + "     ");
                if (winner == 1)
                    System.out.println(player1.getBotName() + " wins!");
                else if (winner == 2)
                    System.out.println(player2.getBotName() + " wins!");
                else
                    System.out.println("It's a tie!");
            }
        }
        System.out.println(player1.getBotName() + "(" + player1.getCoderName() +
                                             "): " + player1Score);
        System.out.println(player2.getBotName() + "(" + player2.getCoderName() +
                                             "): " + player2Score);
        if (player1Score > player2Score)
            System.out.println(player1.getBotName() + " wins!");
        else if (player1Score < player2Score)
            System.out.println(player2.getBotName() + " wins!");
        else
            System.out.println("It's a tie!");
        
        int[] result = {player1Score, player2Score};
        return result;
    }
}