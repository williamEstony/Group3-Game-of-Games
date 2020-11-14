import java.util.concurrent.TimeUnit;

public abstract class Game extends MenuObject {

    private static final int SCOREBOARD_DISPLAY_TIME = 10;
    protected int computerScore;
    protected int userScore;

    public Game(String name, String mode) {
        super(name, mode);
        this.computerScore = 0;
        this.userScore = 0;
    }
    public abstract void playerMode();
    public abstract void testMode();
    public abstract void bugMode();

    public void execute() {
        System.out.println(super.getName());
        if (super.getMode().equals("player")) {
            playerMode();
        }else if(super.getMode().equals("test")) {
            testMode();
        }else if(super.getMode().equals("bug")) {
            bugMode();
        }else {
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