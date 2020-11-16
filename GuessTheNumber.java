import java.util.*;


//Class for playing Guess the Number
public class GuessTheNumber extends Game{
    private int rangeNum;
    private int numGuesses;
    private int secretNum;
    private int guess;
    private GetInput input;

    public GuessTheNumber(String mode) {
        super("Guess the Number", mode);
        this.input= new GetInput();
    }
    
    //Playing the game according to the selected mode
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

        //check if the guesser still has guesses
        //Guess as many times as allowed
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

    //Get a guess from the user
    private int guess(){
        System.out.print("Enter your guess: ");
        return input.getIntegerInput();  
    }

    //The selector selects a number to be guessed
    //Selecting the secret number
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