import java.util.HashMap;
import java.util.Map;

/**
 * The following class models the game - Coin Flip.
 * Fundamentally it is the same as Find the Thimble.
 * It inherits from parent class Game and grandparent class MenuObject 
 * @see Find the Thimble
 * @see Game
 * @see MenuObject
 */
public class CoinFlip extends Game{

    private static final String HEADS = "H";
    private static final String TAILS = "T";
    private static final String[] flips = {HEADS, TAILS};

    //Maps user input for heads/tails to their String literals
    private Map<String, String> map = new HashMap<String, String>()
    {{ 
       put(HEADS, "heads"); 
       put(TAILS, "tails");
    }};

    /**
     * Constructor method for Coin Flip.
     * Passes the name of the game, and mode of the game to parent class Game.
     * @param mode - the mode of the Game of Games we are playing represented as a String
     *               Could be: test, bug or player
     */
    public CoinFlip(String mode) {
        super("Coin Flip", mode);
    }

    /**
     * Single driver method for coin flip game that must be implemented by virtue of the contract with
     * parent class Game.
     * Requests user input for both their "guess" and their "best out of number."
     * Determines if they won the game and increments the user or computer's score accordingly.
     */
    public void playGame(String mode){
        System.out.print("Enter a best of number: ");
        int bestOfNum = getInput.getIntegerInput();
        
        while(!getInput.isValidBestOfNum(bestOfNum)) {
            System.out.print("Enter a valid best of number (must be positive and odd): ");
            bestOfNum = getInput.getIntegerInput();
        }

        if(mode.equals(BUG)) {
            bestOfNum += 2;
        }

        int userScore = 0;
        int computerScore = 0;
        int game = 1;

        //Keep playing individual coin flip games until a player wins a majority of the 
        //games in the series.
        while(userScore < (bestOfNum + 1) / 2 && computerScore < (bestOfNum + 1) / 2) {
            int flip = (int)Math.round(Math.random());
            if(mode.equals(TEST) || mode.equals(BUG)) {
                System.out.println("The coin landed on " + map.get(flips[flip]));
            }

            System.out.print("Enter H for heads or T for tails: ");

            String choice = getInput.getInput();

            while(!getInput.isValidAOrBValue(choice, HEADS, TAILS)) {
                System.out.print("Enter H for heads or T for tails: ");
                choice = getInput.getInput();
            }

            System.out.println("The result of the flip was " + map.get(flips[flip]));
            if(mode.equals(BUG)) {
                if(choice.equals(flips[flip])) {
                    computerScore++;
                    System.out.println("You lose game " + game);
                } else {
                    userScore++;
                    System.out.println("You win game " + game);
                }
            } else {
                if(choice.equals(flips[flip])) {
                    userScore++;
                    System.out.println("You win game " + game);
                } else {
                    computerScore++;
                    System.out.println("You lose game " + game);
                }
            }
            game++;
        }

        if(mode.equals(BUG)) {
            if(computerScore > userScore) {
                System.out.println("You win the series!");
                incrementUserScore();
            } else {
                System.out.println("Computer wins the series!");
                incrementComputerScore();
            }
        } else {
            if(computerScore > userScore) {
                System.out.println("Computer wins the series!");
                incrementComputerScore();
            } else {
                System.out.println("You win the series!");
                incrementUserScore();
            }
        }
    }
}