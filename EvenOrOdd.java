/**
 * The following class models the game - EvenOrOdd.
 * It inherits from parent class Game and grandparent class MenuObject 
 * @see Game
 * @see MenuObject
 */

public class EvenOrOdd extends Game {

    private static final int MAX_FINGERS = 5;
    private static final String EVEN = "even";
    private static final String ODD = "odd";
    private static final String[] evenOrOddMapping = {EVEN, ODD};

    /**
     * Constructor method for Coin EvenOrOdd.
     * Passes the name of the game, and mode of the game to parent class Game.
     * @param mode - the mode of the Game of Games we are playing represented as a String
     *               Could be: test, bug or player
     */
    public EvenOrOdd(String mode) {
        super("Even and Odd", mode);
    }

    public void playGame(String mode) {

        int userScore = 0;  
        int computerScore = 0;
        int game = 1;

        System.out.print("Enter the range to be used for throws: ");
        int range = getInput.getIntegerInput();

        while(!getInput.isValidRange(range, MAX_FINGERS)) {
            System.out.print("Enter a valid range to be used for throws: ");
            range = getInput.getIntegerInput();
        }

        /**
         * Requests user input for both their "guess" and their "best out of number."
         * Determines if they won the game and increments the user or computer's score accordingly.
         */
        System.out.print("Enter a best of number: ");
        int bestOfNum = getInput.getIntegerInput();

        while(!getInput.isValidBestOfNum(bestOfNum)) {
            System.out.print("Enter a valid best of number (must be positive and odd): ");
            bestOfNum = getInput.getIntegerInput();
        }

        // Randomly assign the user even or odd for every game in the series [assumption]
        String evenOrOddAssignment = evenOrOddMapping[(int)Math.round(Math.random())];
        

        if(evenOrOddAssignment.equals(EVEN)) {
            System.out.println("I will be " + ODD + ", ");
        } else {
            System.out.println("I will be " + EVEN + ", "); 
        }

        System.out.println("You will be " + evenOrOddAssignment + ".");

        //Keep playing individual even or odd games until a player wins the majority of the 
        //games in the series.
        while(userScore < (bestOfNum + 1) / 2 && computerScore < (bestOfNum + 1) / 2) {

            int computerThrow = (int)(Math.random() * range) + 1;

            // In bug and test mode. The user will see be able to see the computer throw 
            if(mode.equals(TEST) || mode.equals(BUG)) {
                System.out.println("I am going to throw: " + computerThrow);
            }

            System.out.print("Enter your throw: ");
            int userThrow = getInput.getIntegerInput();

            while(!getInput.isValidRange(userThrow, range)) {
                System.out.print("Enter a valid throw (positive within the range): ");
                userThrow = getInput.getIntegerInput();
            }

            // In bug mode. computer Throw get incremented 
            if(mode.equals(BUG) && computerThrow != range) {
                computerThrow++;
            } else if(mode.equals(BUG)) {
                computerThrow--;
            }

            System.out.println("You threw: " + userThrow);
            System.out.println("I threw: " + computerThrow);

            System.out.println("The sum of the throws is: " + (userThrow + computerThrow));
            
            if(userThrow + computerThrow % 2 == 0) {

                //In bug mode. The win will not go to the winner.
                if(mode.equals(BUG)) {
                    if (evenOrOddAssignment.equals(EVEN)) {
                        System.out.println("I win game " + game);
                        computerScore++;
                    } else {
                        System.out.println("You win game " + game);
                        userScore++;
                    }
                } else {
                    if (evenOrOddAssignment.equals(EVEN)) {
                        System.out.println("You win game " + game);
                        userScore++;
                    } else {
                        System.out.println("I win game " + game);
                        computerScore++;
                    }
                }
            } else {

                //In bug mode. The win will not go to the winner.
                if(mode.equals(BUG)) {
                    if (evenOrOddAssignment.equals(ODD)) {
                        System.out.println("I win game " + game);
                        computerScore++;
                    } else {
                        System.out.println("You win game " + game);
                        userScore++;
                    }
                } else {
                    if (evenOrOddAssignment.equals(ODD)) {
                        System.out.println("You win game " + game);
                        userScore++;
                    } else {
                        System.out.println("I win game " + game);
                        computerScore++;
                    }
                }
            }
            game++;
        }

        //In bug mode. it bugs the game.
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