import java.util.concurrent.TimeUnit;

public abstract class Game extends MenuObject {

    private static final int SCOREBOARD_DISPLAY_TIME = 10;
    protected int computerScore;
    protected int userScore;
    protected static final String PLAYER = "player";
    protected static final String TEST = "test";
    protected static final String BUG = "bug";
    protected GetInput getInput;

    public Game(String name, String mode) {
        super(name, mode);
        this.computerScore = 0;
        this.userScore = 0;
        this.getInput = new GetInput();
    }
    public abstract void playGame(String mode);

    public void execute() {
        if (super.getMode().equals(PLAYER) || super.getMode().equals(TEST) || super.getMode().equals(BUG)) {
            playGame(super.getMode());
        } else {
            System.out.println("Invalid game mode detected");
        }
        
        displayScoreboard();
        wait(SCOREBOARD_DISPLAY_TIME);
    }

    private static void wait(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch(InterruptedException e) {}
    }

    private void displayScoreboard() {
        System.out.println(getScoreboard());
    }

    protected int getComputerScore() { return computerScore; }
    protected int getUserScore() { return userScore; }
    protected void incrementComputerScore() { computerScore++; }
    protected void incrementUserScore() { userScore++; }
}