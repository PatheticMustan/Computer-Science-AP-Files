public class rpsls {
    public static void main(String[] args) {
        playRPSLSMatch(new RandoBot(), new CopyBot(), 100, false);

        playRPSLSMatch(new RandoBot(), new CopyBot(), 5, true);
    }

    public static void playRPSLSMatch(RandoBot rb, CopyBot cb, int numGames,
boolean verbose) {
        int rbs = 0,
            cbs = 0;
        
        String[] moves = new String[] {"Rock", "Paper", "Scissors", "Lizard", "Spock"};

        for (int i=0; i<numGames; i++) {
            int rbm = rb.getMove();
            int cbm = cb.getMove();
            cb.opponentsLastMove(rbm);

            int result = judgeRPSLS(rbm, cbm);
            String resultString = "";

            switch (result) {
                case 1:
                    rbs++;
                    resultString = "RandoBot wins!";
                    break;
                case 2:
                    cbs++;
                    resultString = "CopyBot wins!";
                    break;
                default:
                    resultString = "It's a tie!";
                    break;
            }

            if (verbose) {
                // 1. RandoBot: Lizard CopyBot: Spock RandoBot wins!
                System.out.println((i+1) + ". RandoBot: " + moves[rbm] + " CopyBot: " + moves[cbm] + " " + resultString);
            }
        }

        // RandoBot: 7
        // CopyBot: 3
        // RandoBot wins!
        System.out.println("RandoBot: " + rbs);
        System.out.println("CopyBot: " + cbs);

        int diff = rbs - cbs;
        String resultString = "";

        if (diff > 0)      resultString = "RandoBot wins!";
        else if (diff < 0) resultString = "CopyBot wins!";
        else               resultString = "It's a tie!";

        System.out.println("RandoBot: " + resultString);
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
