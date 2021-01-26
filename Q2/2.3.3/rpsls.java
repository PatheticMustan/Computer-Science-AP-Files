public class rpsls {
    public static void main(String[] args) {
        playRPSLSMatch(new RandoBot(), new CopyBot(), 100, false);

        System.out.println("\n\n");

        playRPSLSMatch(new RandoBot(), new CopyBot(), 5, true);
    }

    public static void playRPSLSMatch(RPSLSBot player1, RPSLSBot player2, int numGames, boolean verbose) {
        int player1score = 0,
            player2score = 0;
        
        String[] moves = new String[] {"Rock", "Paper", "Scissors", "Lizard", "Spock"};

        player1.reset();
        player2.reset();

        String player1Name = player1.getBotName();
        String player2Name = player2.getBotName();
        String player1FinalName = player1.getBotName() + " (" + player1.getCoderName() + ")";
        String player2FinalName = player2.getBotName() + " (" + player2.getCoderName() + ")";

        for (int i=0; i<numGames; i++) {
            int player1move = player1.getMove();
            int player2move = player2.getMove();
            player1.opponentsLastMove(player2move);
            player2.opponentsLastMove(player1move);

            int result = judgeRPSLS(player1move, player2move);
            String resultString = "";

            switch (result) {
                case 1:
                    player1score++;
                    resultString = player1Name + " wins!";
                    break;
                case 2:
                    player2score++;
                    resultString = player2Name + " wins!";
                    break;
                default:
                    resultString = "It's a tie!";
                    break;
            }

            if (verbose) {
                // 1. RandoBot: Lizard CopyBot: Spock RandoBot wins!
                System.out.println(
                    (i+1) + ". " +
                    player1Name + ": " + moves[player1move] + "    " +
                    player2Name + ": " + moves[player2move] + "    " +
                    " " + resultString
                );
            }
        }

        // RandoBot: 7
        // CopyBot: 3
        // RandoBot wins!
        System.out.println(player1Name + ": " + player1score);
        System.out.println(player2Name + ": " +player2score);

        int diff = player1score - player2score;
        if (diff > 0)      System.out.println(player1FinalName + " wins!");
        else if (diff < 0) System.out.println(player2FinalName + " wins!");
        else               System.out.println("It's a tie!");
    }

    // 0 = rock, 1 = paper, 2 = scissors, 3 = lizard, 4 = Spock
    public static int judgeRPSLS(int player1move, int player2move) {
        if (!(0 <= player1move && player1move <= 4) || !(0 <= player2move && player2move <= 4)) throw new IllegalArgumentException();

        // the only way I can see doing this would be manually entering win/loss/tie
        // the advanced solution would be pretty similar to this, just make a new movebank, but with words
        // 0 for tie, 1 for win, 2 for loss
        int[][] movebank = new int[][] {
            // rock
            {0, 2, 1, 1, 2},
            // paper
            {1, 0, 2, 2, 1},
            // scissors
            {2, 1, 0, 1, 2},
            // lizard
            {2, 1, 2, 0, 1},
            // spock
            {1, 2, 1, 2, 0}
        };

        return movebank[player1move][player2move];
    }
}
