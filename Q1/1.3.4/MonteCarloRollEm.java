public class MonteCarloRollEm {
    public static void main(String[] args) {
        int wins = 0;
        // 1 million trials just for kahoots and giggles
        int trials = 1000000;
        
        int percentageAmount = trials / 100;
        
        for (int i=0; i<trials; i++) {
            boolean trial = rollEm();
            
            if (trial) wins++;
            if (i % percentageAmount == 0) System.out.println(((i / percentageAmount) + 1) + "% run.");
        }
        
        System.out.println("Out of " + trials + " trials, " + wins + " were wins.");
        System.out.println("The experimental probability of winning RollEm is " + (((double)wins/trials)*100) + "%");
    }
    
    public static int roll() {
        return (int)(Math.random()*6) + 1;
    }
        
    public static boolean rollEm() {
        // we roll 4 dice, so the condition is i<4
        // if any of the 4 dice return 6, the player loses.
        for (int i=0; i<4; i++) if (roll() == 6) return false;
        
        // if none of the dice roll 6, the player wins
        return true;
    }
}