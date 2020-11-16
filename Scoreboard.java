/**
 * Class to model a scoreboard object. 
 * Holds an important boolean to determine if the user has quit (playAgain)
 * Also holds on to the total number of wins for the user and the computer.
 * We extend Menu (@see Menu), so that we gain access to the MenuObjects HashMap.
 */
public class Scoreboard extends Menu{

    private static boolean playAgain;
    private static int userTotalScore;
    private static int computerTotalScore;

    private static final int GAME_COLUMN_WIDTH = 20; //number of spaces in the Game column of the scoreboard

    /**
     * Constructor for Scoreboard.
     * Initializes user and computer's score to zero.
     * Initializes playAgain to true.
     */
    public Scoreboard() {
        playAgain = true;
        userTotalScore = 0;
        computerTotalScore = 0;
    }

    /**
     * Prints out each game in the Game of Games along with the number of wins the user and the
     * computer have for each game.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|--------------------------------------------------------|\n");
        sb.append("|                        Scoreboard                      |\n");
        sb.append("|--------------------------------------------------------|\n");
        sb.append("|          Game           | Player Wins |  Computer Wins |\n");
        sb.append("|--------------------------------------------------------|\n");

        /* This is probably the ugliest code we have. 
         * Loop through each MenuObject in the menuObjects Map,
         * But check to make sure it's a game so we don't accidentally try and parse a Quit object
        */
        for(MenuObject menuObject: menuObjects.values()) {
            if(menuObject instanceof Game) {
                Game g = (Game)menuObject;
                //Ensure we print the Game in the middle of the column, padded with a dynamic amount of spaces
                //based on how many characters are in the game's name.
                int numberOfSpaces = GAME_COLUMN_WIDTH - g.name.length();
                sb.append(String.format("|     %s%" + numberOfSpaces + "s|      %s      |        %s       |\n", g.name, " ", g.getUserWins(), g.getComputerWins()));
                sb.append("|--------------------------------------------------------|\n");
            }
        }
        return sb.toString();
    }
    
    /** Sets playAgain to false, called when the user quits the game. */
    public void quit() { playAgain = false; }
    
    /** Increment the user's total score */
    public void incrementUserScore() { userTotalScore++; }
    /** Increment the computer's total score */
    public void incrementComputerScore() { computerTotalScore++; }

    /** @return playAgain
     * static so that we don't have to initialize a Scoreboard object in PlayGames
     * @see PlayGames
     */
    public static boolean getPlayAgain() { return playAgain; }

    /** 
     * static so that we don't have to initialize a Scoreboard object in PlayGames
     * @see PlayGames
     * Prints out the overall winner of the Game of Games.
     */
    public static void displayOverallWinner() {
        if(userTotalScore > computerTotalScore) {
            System.out.println("You have won the game of games!");
            System.out.println("Your total number of games won: " + userTotalScore);
            System.out.println("Computer's total number of games won: " + computerTotalScore);
        }else if(computerTotalScore > userTotalScore) {
            System.out.println("The computer has won the game of games!");
            System.out.println("Your total number of games won: " + userTotalScore);
            System.out.println("Computer's total number of games won: " + computerTotalScore);
        }else {
            System.out.println("The game of games has ended in a tie!");
            System.out.println("Your total number of games won: " + userTotalScore);
            System.out.println("Computer's total number of games won: " + computerTotalScore);
        }
    }
}