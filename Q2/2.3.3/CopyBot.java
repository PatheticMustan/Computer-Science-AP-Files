public class CopyBot implements RPSLSBot {
    int lastRandoMove;
    
    public String getBotName() {
        return "CopyBot";
    }

    //Returns the name of the coder (your full name).
    public String getCoderName() {
        return "Kevin W";
    }
    
    public CopyBot() {
        reset();
    }
    
    public void opponentsLastMove(int move) {
        lastRandoMove = move;
    }
    
    public int getMove() {
        return lastRandoMove;
    }
    
    public void reset() {
        this.lastRandoMove = 0;
    }
}