public class CopyBot {
    int lastRandoMove;
    
    public CopyBot() {
        this.lastRandoMove = 0;
    }
    
    public void opponentsLastMove(int move) {
        lastRandoMove = move;
    }
    
    public int getMove() {
        return lastRandoMove;
    }
}