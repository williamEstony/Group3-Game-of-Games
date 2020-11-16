import java.util.*;

public class GuessTheNumber extends Game{
    private int rangeNum;
    private int numGuesses;
    private int secretNum;
    private GetInput input;

    public GuessTheNumber(String mode) {
        super("Guess the Number", mode);
        this.input= new GetInput();
    }
    
    //Playing the game according to the selected mode
    public void playGame(String mode) {
        rangeNum = getRangeNum();
        numGuesses = input.getValidNumGuesses(rangeNum);
        secretNum = secretNum(rangeNum);

        if (mode.equals(TEST) || mode.equals(BUG)) {
            System.out.println("The secret number is " + secretNum);
        }

       //First bug that increments the number of remaining guesses
        if(mode.equals(BUG)) {
            numGuesses++;
        }

        //check if the guesser still has guesses
        while(numGuesses > 0){
            int guess = guess(); 
            if (guess==secretNum) {
                break;
            }
            numGuesses--;
        }

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

    //The guesser enters their guess
    private int guess(){
        System.out.print("Enter your guess: ");
        return input.getIntegerInput();  
    }

    //The selector selects a number to be guessed
    private int secretNum(int rangeNum){
        Random rand = new Random(); 
        return rand.nextInt(rangeNum + 1); 
    }

    //Getting the range number
    private int getRangeNum(){
        System.out.print("Enter the range number: ");
        return input.getIntegerInput();
    }
}