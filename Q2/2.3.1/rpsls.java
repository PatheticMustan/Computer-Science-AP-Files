public class rpsls {
    public static void main(String[] args) {
        for (int i=0; i<5; i++) {
            for (int o=0; o<5; o++) {
                System.out.println(judgeRPSLS(i, o));
            }
        }
        
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
