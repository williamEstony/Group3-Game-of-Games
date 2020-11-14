import java.util.*;

public class GuessTheNumber extends Game{
    private int rangeNum;
    private int numGuesses;
    private int secretNum;
    private static final String PLAYER = "player";
    private static final String TEST = "test";
    private static final String BUG = "bug";

    public GuessTheNumber(String mode) {
        super("Guess the Number", mode);
    }

    //Runnig the game in player mode
    public void playerMode(){
        System.out.println();
        playGame(PLAYER);
    }

    //Running the game in test mode
    public void testMode(){
        System.out.println();
        playGame(TEST);
    }

    //Running the game in bug mode
    public void bugMode(){
        System.out.println();
        playGame(BUG);
    }    

    //Playing the game according to the selected mode
    private void playGame(String mode){
        rangeNum = getRangeNum();
        numGuesses = getNumGuesses(rangeNum);
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
        return getInputInt();  
    }

    //The selectore selectes a number to be guessed
    private int secretNum(int rangeNum){
        Random rand = new Random(); 
        return rand.nextInt(rangeNum + 1); 
    }

    //Getting the range number
    private int getRangeNum(){
        System.out.print("Enter the range number: ");
        return getInputInt();
    }

    //Getting the number of guesses
    private int getNumGuesses(int rangeNum){
        System.out.print("Enter the number of guesses: ");
        int x = getInputInt();
        while(x > (rangeNum/2)){
            System.out.print("Please enter an integer less than or equal to " + rangeNum/2 + ": ");
            x = getInputInt();
        }
        return x;
    }

    //Getting integer input from console
    private int getInputInt(){
        Scanner input = new Scanner(System.in);
        int inputNum = Integer.MAX_VALUE;
     
        while(true){
            try{
                inputNum = Integer.parseInt(input.nextLine());
                break;
            }catch(Exception e){
                System.out.print("Please enter an integer: ");
                continue;
            }
        }
        return inputNum;
    }
}


/* Questions to group 2
Is the computer the guesser or the selector? Always
No need to confirm if the guess is in the range?
Range is 0 to n? Should we reject n < 1
*/
