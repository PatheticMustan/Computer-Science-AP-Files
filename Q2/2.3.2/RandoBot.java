import java.lang.Math;

public class RandoBot {
    public RandoBot() {}
    
    public int getMove() {
        return (int)(Math.random() * 5);
    }
}