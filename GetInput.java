import java.util.Scanner;

public class GetInput {
    private Scanner scan;
    public GetInput() {
        scan = new Scanner(System.in);
    }
    public String getInput() {
        return scan.nextLine();
    }
    public boolean isValidGameCode(String s) {
        if(Menu.getMenuObject(s) == null) {
            return false;
        }else {
            return true;
        }
    }

    public boolean isValidThisOrThatValue(String choice, String[] choices) {
        for(String s: choices) {
            
        }
    }

    public boolean isValidBestOfNum(String s) {
        if(isInteger(s)) {
            if(Integer.parseInt(s) > 0 && Integer.parseInt(s) % 2 == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isValidThreadPull(String s) {
        return true;
    }

    //Prompt the user until they enter a valid number of guesses
    public int getValidNumGuesses(int rangeNum){
        System.out.print("Enter the number of guesses: ");
        int numGuesses = getIntegerInput();

        while(numGuesses > (rangeNum/2)){
            System.out.print("Please enter an integer less than or equal to " + rangeNum/2 + ": ");
            numGuesses = getIntegerInput();
        }
        return numGuesses;
    }

    //Promp the user until they enter an integer
    public int getIntegerInput(){
        String inputString = getInput();

        while(!isInteger(inputString)){
            System.out.print("Please enter an integer: ");
            inputString = getInput();
        }

        return Integer.parseInt(inputString);
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }
}