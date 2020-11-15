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
    public void playGame(String mode){
        rangeNum = getRangeNum();
        numGuesses = input.getValidNumGuesses(rangeNum);
        secretNum = secretNum(rangeNum);

        if (mode.equals(TEST))
         System.out.println("The secret number is " + secretNum);

        //check if the guesser still has guesses
        while(numGuesses>0){
            int guess = guess(); 
            if (guess==secretNum)
                break;
            numGuesses--;
        }
       
        //The seeded bug that increments the number of remaining guesses
        if(mode.equals(BUG))
           numGuesses++;

        if(numGuesses == 0){
            System.out.println("Computer(P2) won!! The secret number was " + secretNum );
            incrementComputerScore();
        }
            
        else{
            System.out.println("User(P1) won!! The secret number was " + secretNum );
            incrementUserScore();
        }
    }

    //The guesser enters their guess
    private int guess(){
        System.out.print("Enter your guess: ");
        return input.getIntegerInput();  
    }

    //The selectore selectes a number to be guessed
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


/* Questions to group 2
Can I assume that the guesser is always the user?
No need to confirm if the guess is in the range?
Range is 0 to n? Should we reject n < 1
How about even and odd values of n?
*/
