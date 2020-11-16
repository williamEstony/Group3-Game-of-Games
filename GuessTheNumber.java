/**
 * The following class models the game - Guess the Number
 * It inherits from parent class Game and grandparent class MenuObject 
 * @see Game
 * @see MenuObject
 */
public class GuessTheNumber extends Game{
    private int rangeNum;
    private int numGuesses;
    private int secretNum;
    private int guess;
    private GetInput input;

    /**
     * Constructor method for Guess the Number
     * Passes the name of the game, and mode of the game to parent class Game.
     * @param mode - the mode of the Game of Games we are playing represented as a String
     *               Could be: test, bug or player
     */
    public GuessTheNumber(String mode) {
        super("Guess the Number", mode);
        this.input= new GetInput();
    }
    
    /**
     * Single driver method for guess the number game that must be implemented by virtue of the contract with
     * parent class Game.
     * Requests user input for both range and their guess
     * Determines if they won the game and increments the user or computer's score accordingly.
     */
    public void playGame(String mode) {
        rangeNum = getRangeNum();

        System.out.print("Enter the number of guesses: ");
        numGuesses = input.getIntegerInput();
        
        //Prompt the user until they enter a valid number of guesses
        while(!getInput.isValidNumGuesses(numGuesses, rangeNum)){
            System.out.print("Please enter an integer less than or equal to " + (rangeNum/2) + ": ");
            numGuesses = getInput.getIntegerInput();
        }


        secretNum = secretNum(rangeNum);

        if (mode.equals(TEST) || mode.equals(BUG)) {
            System.out.println("The secret number is " + secretNum);
        }

       //First bug that increments the number of remaining guesses
        if(mode.equals(BUG)) {
       //First bug that wrongfully increments the number of guesses
        if(mode.equals(BUG))
            numGuesses++;
        }

        //Check if the guesser still has guesses. Guess as many times as allowed.
        do {
            guess = guess(); 
            numGuesses--;
        }while(numGuesses > 0 && guess != secretNum);
        
        if(numGuesses == 0) {
            System.out.println("Computer won!! The secret number was " + secretNum );

            //Second bug that increments the user's score when the computer wins
            if(mode.equals(BUG)) {
                incrementUserScore();
            } else {
                incrementComputerScore();
            }
        } else{
            System.out.println("User won!! The secret number was " + secretNum );

            //Third bug that increments the computer's score when the user wins
            if(mode.equals(BUG))
                incrementComputerScore();
            else
                incrementUserScore();
        }
    }

    /**
     * @return a guess as to what the secret number is made by the user
     */
    private int guess(){
        System.out.print("Enter your guess: ");
        return input.getIntegerInput();  
    }

    /**
     * @return the secret number the user must guess. Computed by calculating a random number
     * within the user specified range.
     */
    private int secretNum(int rangeNum){
        return (int)(Math.random() * rangeNum + 1);
    }

    /**
     * @return the range number, provided by the user.
     */
    private int getRangeNum(){
        System.out.print("Enter the range number: ");
        return input.getIntegerInput();
    }
}