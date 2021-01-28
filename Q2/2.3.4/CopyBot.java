public class CopyBot implements RPSLSBot {
    private int oppMove;
    
    public CopyBot() {
        reset();
    }
    
    //Returns the name of the bot.
    public String getBotName() {
        return "CopyBot";
    }
    
    //Informs the bot that a new match is going to start.
    public void reset() {
        oppMove = 4;    //start with Spock, of course
    }
    
    //Returns the name of the coder (your full name).
    public String getCoderName() {
        return "Mr. W";
    }
    
    //Returns the choice of move for the next turn of the bot.
    //Note: this method MUST return a value between 0 and 4, inclusive.
    //0 = rock, 1 = paper, 2 = scissors, 3 = lizard, 4 = Spock
    public int getMove() {
        return oppMove;
    }
    
    //Informs the bot of the move just made by the bot's opponent.
    //This information can be used to guide the bot's choice of next move.
    public void opponentsLastMove(int move) {
        oppMove = move;
    }
}