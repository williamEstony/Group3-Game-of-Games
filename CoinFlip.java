import java.util.HashMap;
import java.util.Map;

public class CoinFlip extends Game{

    private static final String HEADS = "H";
    private static final String TAILS = "T";
    private static final String[] flips = {HEADS, TAILS};
    private static final Map<String, String> map = new HashMap<String, String>()
    {{ 
       put(HEADS, "heads"); 
       put(TAILS, "tails");
    }};

    public CoinFlip(String mode) {
        super("Coin Flip", mode);
    }
    //Playing the game according to the selected mode
    public void playGame(String mode){
        System.out.print("Enter a best of number: ");
        int bestOfNum = getInput.getIntegerInput();
        
        while(!getInput.isValidBestOfNum(bestOfNum)) {
            System.out.print("Enter a valid best of number (must be positive and odd): ");
            bestOfNum = getInput.getIntegerInput();
        }

        if(mode.equals(BUG)) {
            bestOfNum+=2;
        }

        int userScore = 0;
        int computerScore = 0;
        int game = 1;

        while(userScore < (bestOfNum + 1) / 2 && computerScore < (bestOfNum + 1) / 2) {
            int flip = (int)Math.round(Math.random());
            if(mode.equals(TEST) || mode.equals(BUG)) {
                System.out.println("The coin landed on " + map.get(flips[flip]));
            }

            System.out.print("Enter H for heads or T for tails: ");

            String choice = getInput.getInput();

            while(!getInput.isValidAOrBValue(choice, HEADS, TAILS)) {
                System.out.print("Enter H for heads or T for tails: ");
                choice = getInput.getInput();
            }

            System.out.println("The result of the flip was " + map.get(flips[flip]));
            if(mode.equals(BUG)) {
                if(choice.equals(flips[flip])) {
                    computerScore++;
                    System.out.println("You lose game " + game);
                }else {
                    userScore++;
                    System.out.println("You win game " + game);
                }
            } else {
                if(choice.equals(flips[flip])) {
                    userScore++;
                    System.out.println("You win game " + game);
                }else {
                    computerScore++;
                    System.out.println("You lose game " + game);
                }
            }
            game++;
        }

        if(mode.equals(BUG)) {
            if(computerScore > userScore) {
                System.out.println("You Wins the Series!");
                incrementUserScore();
            }else {
                System.out.println("Computer Wins the Series!");
                incrementComputerScore();
            }
        } else {
            if(computerScore > userScore) {
                System.out.println("Computer Wins the Series!");
                incrementComputerScore();
            }else {
                System.out.println("You Wins the Series!");
                incrementUserScore();
            }
        }
    }
}