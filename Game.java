import java.util.concurrent.TimeUnit;

/**
 * This abstract class models a generic Game object for the Game of Games.
 * Here we define the 3 different modes a game can be played in: player, test, bug.
 * We also keep track of the number of times the user and the computer have one a particular game.
 * Finally, we implement a required method called execute() from parent class MenuObject.
 * 
 * @see MenuObject
 */
public abstract class Game extends MenuObject {

    private static final int SCOREBOARD_DISPLAY_TIME = 10;
    
    protected int computerWins;
    protected int userWins;

    protected static final String PLAYER = "player";
    protected static final String TEST = "test";
    protected static final String BUG = "bug";

    protected GetInput getInput;

    //Every Game object must implement the following playGame method.
    public abstract void playGame(String mode);

    /**
     * Constructor for a Game object. Passes the name of the game and mode of the game to parent MenuObject.
     * initializes the wins for computer and user and the input object used by each game.
     */
    public Game(String name, String mode) {
        super(name, mode);
        this.computerWins = 0;
        this.userWins = 0;
        this.getInput = new GetInput();
    }

    
    /**
     * Calls each Games individual playGame method with the corresponding mode specified.
     * When a game is over, the scoreboard is displayed for 10 seconds.
     */
    public void execute() {
        
        playGame(mode);
        displayScoreboard();
        wait(SCOREBOARD_DISPLAY_TIME);
    }
    
    /**
     * Helper method that pauses the program for a specified amount of time.
     * @param seconds - the number of seconds we want the program to not do anything.
     */
    private static void wait(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch(InterruptedException e) {}
    }

    /**
     * Helper method that simply prints the scoreboard to the console by calling
     * Scoreboard's toString() method.
     * @see Scoreboard.
     */
    private void displayScoreboard() {
        System.out.println(scoreboard);
    }

    /** @return the number of wins for the computer holds for a particular */
    protected int getComputerWins() { return computerWins; }

    /** @return the number of wins for the user holds for a particular */
    protected int getUserWins() { return userWins; }

    /** Increments both the computer's individual game wins and overall total wins*/
    protected void incrementComputerScore() { 
        computerWins++;
        scoreboard.incrementComputerScore(); 
    }

    /** Increments both the user's individual game wins and overall total wins*/
    protected void incrementUserScore() { 
        userWins++; 
        scoreboard.incrementUserScore();
    }
}