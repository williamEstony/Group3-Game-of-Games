import java.util.*;

public class GuessTheNumber extends Game{
    private static int rangeNum;
    private static int numGuesses;
    private static int secretNum;
    private static final String PLAYER = "player";
    private static final String TEST = "test";
    private static final String BUG = "bug";
    private static final int DISPLAY_TIME = 10*1000;

    public GuessTheNumber(String mode) {
        super(mode);
    }

    //Playing the game according to the selected mode
    private static void playGame(String mode){
        rangeNum = getRangeNum();
        numGuesses = getNumGuesses(rangeNum);
        secretNum = secretNum(rangeNum);

        if (mode.equals(TEST))
         System.out.println("The secret number is " + secretNum);

        while(numGuesses>0){
            int guess = guess(); 
            if (guess==secretNum)
                break;
            numGuesses--;
        }
       
        //The seeded bug that increments the number of remaining guesses
        if(mode.equals(BUG))
           numGuesses++;

        if(numGuesses == 0)
            System.out.println("Computer(P2)) won!! The secret number was " + secretNum );
    
        else
            System.out.println("You(P1) won!! The secret number was " + secretNum );
        
        sleepDisplay(DISPLAY_TIME);
    }

    //The guesser enters their guess
    private static int guess(){
        System.out.print("Enter your guess: ");
        return getInputInt();  
    }

    //The selectore selectes a number to be guessed
    private static int secretNum(int rangeNum){
        Random rand = new Random(); 
        return rand.nextInt(rangeNum + 1); 
    }

    //Getting the range number
    private static int getRangeNum(){
        System.out.print("Enter the range number: ");
        return getInputInt();
    }

    //Getting the number of guesses
    private static int getNumGuesses(int rangeNum){
        System.out.print("Enter the number of guesses: ");
        int x = getInputInt();
        while(x > (rangeNum/2)){
            System.out.print("Please enter an integer less than or equal to " + rangeNum/2 + ": ");
            x = getInputInt();
        }
        return x;
    }

    //Getting integer input from console
    private static int getInputInt(){
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

    //Runnig the game in player mode
    public void playerMode(){
        System.out.println();
        System.out.println("Player Mode");
        System.out.println();
        playGame(PLAYER);
    }

    //Running the game in test mode
    public void testMode(){
        System.out.println();
        System.out.println("Test Mode");
        System.out.println();
        playGame(TEST);
    }

    //Running the game in bug mode
    public void bugMode(){
        System.out.println();
        System.out.println("Bug Mode");
        System.out.println();
        playGame(BUG);
    }
    
    //Sleeping the thread for a number of seconds
    private static void sleepDisplay(int numSeconds){
        try{
            Thread.sleep(numSeconds);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

/*
Is the computer the guesser or the selector? Always
No need to confirm if the guess in the range?
Range is 0 to n?
Human should be the one to input range number and number of guesses?

•   Per class: UML Diagrams, with Method Glossary and Data Configuration Table and per Method Unit Tests associated with each class.

•   A unified Data Configuration Table for the entire project organized by class



///
Fix this bug
////

Enter the range number: 1
Enter the number of guesses: 3
Please enter an integer less than 0: 1
Please enter an integer less than 0: -1
You(P1) won!! The secret number was 1
*/
