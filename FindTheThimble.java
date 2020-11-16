import java.util.HashMap;
import java.util.Map;

/**
 * The following class models the game - Find the Thimble.
 * Fundamentally it is the same as Coin Flip.
 * It inherits from parent class Game and grandparent class MenuObject 
 * @see Coin Flip
 * @see Game
 * @see MenuObject
 */
public class FindTheThimble extends Game{

    private static final String LEFT = "L";
    private static final String RIGHT = "R";
    private static final String[] hands = {LEFT, RIGHT};

    //Maps user input for left hand/right hand to their String literals
    private static final Map<String, String> map = new HashMap<String, String>()
    {{ 
       put(LEFT, "left hand"); 
       put(RIGHT, "right hand");
    }};

    /**
     * Constructor method for Find the Thimble.
     * Passes the name of the game, and mode of the game to parent class Game.
     * @param mode - the mode of the Game of Games we are playing represented as a String
     *               Could be: test, bug or player
     */
    public FindTheThimble(String mode) {
        super("Find the Thimble", mode);
    }

    /**
     * Single driver method for find the thimble game that must be implemented by virtue of the contract with
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

        //Keep playing individual find the thimble games until a player wins a majority of the 
        //games in the series.
        while(userScore < (bestOfNum + 1) / 2 && computerScore < (bestOfNum + 1) / 2) {
            int hand = (int)Math.round(Math.random());
            if(mode.equals(TEST) || mode.equals(BUG)) {
                System.out.println("The thimble is in my " + map.get(hands[hand]));
            }

            System.out.println("Which hand am I hiding the thimble in?");
            System.out.print("Enter L to guess left hand or R to guess right hand: ");

            String choice = getInput.getInput();

            while(!getInput.isValidAOrBValue(choice, LEFT, RIGHT)) {
                System.out.print("Enter L to guess left hand or R to guess right hand: ");
                choice = getInput.getInput();
            }

            System.out.println("The thimble was in my " + map.get(hands[hand]));
            if(mode.equals(BUG)) {
                if(choice.equals(hands[hand])) {
                    computerScore++;
                    System.out.println("You lose game " + game);
                } else {
                    userScore++;
                    System.out.println("You win game " + game);
                }
            } else {
                if(choice.equals(hands[hand])) {
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