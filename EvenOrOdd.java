import java.util.Random;


/*public class EvenOrOdd extends Game {

    public EvenOrOdd(String mode) {
        super("Even and Odd", mode);
    }

    public void playGame(String mode){
        Random rand = new Random();

         //Getting the range number
         private int getRangeNum(){
        System.out.print("Enter the range number: ");
        return input.getIntegerInput();
        }
        
        System.out.print("Enter a best of number: ");
        String bestOfNum = getInput.getInput();
        
        while(!getInput.isValidBestOfNum(bestOfNum)) {
            System.out.print("Enter a valid best of number: ");
            bestOfNum = getInput.getInput();
        }


}*/



import java.util.Scanner;

public class EvenOrOdd extends Game {
    private Scanner s;
    public int bestof;

    public int EPScore;
    public int OPScore;

    EvenOrOdd() {
        s = new Scanner(System.in);
        EPScore = 0;
        OPScore = 0;
    }

    private void start() {
        String start;
        do {
            start = s.next();
        } while (!start.equals("D"));
    }

    public void bestof() {
        do {
            System.out.print("Input bestof number: ");
            bestof = s.nextInt();
        } while (bestof % 2 == 0 || bestof <= 0);
    }

    public void sum(int EvenplayerTHROW, int OddplayerTHROW) {
        int sum = EvenplayerTHROW + OddplayerTHROW;
        if (sum % 2 == 0)
            EPScore++;
        else
            OPScore++;

        result(OPScore);
    }

    public void result(int n) {
        if (EPScore > bestof / 2) {
            System.out.println("Even player has won the game of games!");
            EPScore = OPScore = 0;
        } else if (OPScore > bestof / 2) {
            System.out.println("Odd player has won the game of games!");
            EPScore = OPScore = 0;
        }
    }

    public void Throw() {
        int EvenplayerTHROW, OddplayerTHROW;
        int range = 5;

        do {
            System.out.print("Input throw number for even player:");
            EvenplayerTHROW = s.nextInt();
        } while (EvenplayerTHROW > range);

        do {
            System.out.print("Input throw number for odd player:");
            OddplayerTHROW = s.nextInt();
        } while (OddplayerTHROW > range);

        sum(EvenplayerTHROW, OddplayerTHROW);
    }
}