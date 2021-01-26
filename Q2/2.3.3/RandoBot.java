import java.lang.Math;

public class RandoBot implements RPSLSBot {
    public String getBotName() {
        return "RandoBot";
    }

    public String getCoderName() {
        return "Kevin W";
    }

    public RandoBot() {}

    public void opponentsLastMove(int move) {}
    
    public int getMove() {
        return (int)(Math.random() * 5);
    }

    public void reset() {}
}