import java.util.*;

public class GuessTheNumber extends Game{
    static int rangeNum;
    static int numGuesses;
    static int secretNum;
    static String mode;

    public GuessTheNumber(String mode) {
        super(mode);
    }

    public void playerMode(){
        mode= "player";
        System.out.println();
        System.out.println("Player Mode");
        System.out.println();
        playGame(mode);
    }

    public void testMode(){
        mode = "test";
        System.out.println();
        System.out.println("Test Mode");
        System.out.println();
        playGame(mode);
    }

    public void bugMode(){
        mode = "bug";
        System.out.println();
        System.out.println("Bug Mode");
        System.out.println();
        playGame(mode);
    }
    
    private static void playGame(String mode){
        rangeNum = getRangeNum();
        numGuesses = getNumGuesses(rangeNum);
        secretNum = secretNum(rangeNum);

        if (mode.equals("test"))
         System.out.println("The secret number is " + secretNum);

        while(numGuesses>0){
            int guess = guess(); 
            if (guess==secretNum)
                break;
            numGuesses--;
        }
       
        //The seeded bug that increment the number of remaining guesses
        if(mode.equals("bug"))
           numGuesses++;

        if(numGuesses == 0)
            System.out.println("Computer(P2)) won!! The secret number was " + secretNum );
    
        else
            System.out.println("You(P1) won!! The secret number was " + secretNum );
        
        sleepDisplay(10);
    }

    private static int guess(){
        System.out.print("Enter your guess: ");
        return getInputInt();  
    }

    private static int secretNum(int rangeNum){
        Random rand = new Random(); 
        return rand.nextInt(rangeNum + 1); 
    }

    private static int getRangeNum(){
        System.out.print("Enter the range number: ");
        return getInputInt();
    }

    private static int getNumGuesses(int rangeNum){
        System.out.print("Enter the number of guesses: ");
        int x = getInputInt();
        while(x > (rangeNum/2)){
            System.out.print("Please enter an integer less than or equal to " + rangeNum/2 + ": ");
            x = getInputInt();
        }
        return x;
    }

    private static int getInputInt(){
        Scanner in = new Scanner(System.in);
        int inputNum = Integer.MAX_VALUE;
     
        while(true){
            try{
                inputNum = Integer.parseInt(in.nextLine());
                break;
            }catch(Exception e){
                System.out.print("Please enter an integer: ");
                continue;
            }
        }

        return inputNum;
    }

    private static void sleepDisplay(int numSeconds){
        try{
            Thread.sleep(numSeconds*1000);

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
