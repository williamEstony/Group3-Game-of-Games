

public class Scoreboard extends Menu{
    private boolean playAgain;
    private static final int GAME_COLUMN_WIDTH = 20;

    public Scoreboard() {
        this.playAgain = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|--------------------------------------------------------|\n");
        sb.append("|                        Scoreboard                      |\n");
        sb.append("|--------------------------------------------------------|\n");
        sb.append("|          Game           | Player Wins |  Computer Wins |\n");
        sb.append("|--------------------------------------------------------|\n");

        for(MenuObject menuObject: menuObjects.values()) {
            if(menuObject instanceof Game) {
                Game g = (Game)menuObject;
                int numberOfSpaces = GAME_COLUMN_WIDTH - g.getName().length();
                sb.append(String.format("|     %s%" + numberOfSpaces + "s|      %s      |        %s       |\n", g.getName(), " ", g.getUserScore(), g.getComputerScore()));
                sb.append("|--------------------------------------------------------|\n");
            }
        }
        return sb.toString();
    }
    
    public void quit() { this.playAgain = false; }
    public boolean getPlayAgain() { return playAgain; }

    public void displayOverallWinner() {
        int userTotalScore = 0;
        int computerTotalScore = 0;
        for(MenuObject menuObject: menuObjects.values()) {
            if(menuObject instanceof Game) {
                Game g = (Game)menuObject;
                userTotalScore += g.getUserScore();
                computerTotalScore += g.getComputerScore();
            }
        }
        if(userTotalScore > computerTotalScore) {
            System.out.println("You have won the game of games!");
            System.out.println("Your score: " + userTotalScore);
            System.out.println("Computer's score: " + computerTotalScore);
        }else if(computerTotalScore > userTotalScore) {
            System.out.println("The computer has won the game of games!");
            System.out.println("Your score: " + userTotalScore);
            System.out.println("Computer's score: " + computerTotalScore);
        }else {
            System.out.println("The game of games has ended in a tie!");
            System.out.println("Your score: " + userTotalScore);
            System.out.println("Computer's score: " + computerTotalScore);
        }
    }
}