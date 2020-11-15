public class CoinFlip extends Game{

    public static final String[] flips = {"H", "T"};

    public CoinFlip(String mode) {
        super("Coin Flip", mode);
    }
    //Playing the game according to the selected mode
    public void playGame(String mode){
        System.out.print("Enter a best of number: ");
        String bestOfNum = getInput.getInput();
        
        while(!getInput.isValidBestOfNum(bestOfNum)) {
            System.out.print("Enter a valid best of number: ");
            bestOfNum = getInput.getInput();
        }

        int userScore = 0;
        int computerScore = 0;
        int game = 1;

        while(userScore < (Integer.parseInt(bestOfNum) + 1) / 2 && computerScore < (Integer.parseInt(bestOfNum) + 1) / 2) {
            System.out.print("Enter H for heads or T for tails: ");
            
            
            String choice = getInput.getInput();

            


            int flip = (int)Math.round(Math.random());
            System.out.println("The result of the flip was: " + flips[flip]);

            if(choice.equals(flips[flip])) {
                userScore++;
                System.out.println("You win game " + game);
            }else {
                computerScore++;
                System.out.println("You lose game " + game);
            }
        }

        if(computerScore > userScore) {
            incrementComputerScore();
        }else {
            incrementUserScore();
        }
    }
}