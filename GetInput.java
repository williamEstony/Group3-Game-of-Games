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

    public boolean isValidBestOfNum(int i) {
        if(i > 0 && i % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidAOrBValue(String input, String a, String b) {
        if(input.equals(a) || input.equals(b)) {
            return true;
        }
        return false;
    }

    public boolean isValidThreadPull(String s) {
      if(isInteger(s)) {
          if(Integer.parseInt(s) > 0 && Integer.parseInt(s) <= 10) {
              return true;
          } else {
              return false;
          }
      } else {
          return false;
      }
    }
    public boolean isValidThread(String s) {
      if(isInteger(s)) {
          if(Integer.parseInt(s) > 0 && Integer.parseInt(s) <= 20) {
              return true;
          } else {
              return false;
          }
      } else {
          return false;
      }
    }
    public boolean isValidThreadNum(int i, int upperBound) {
          if(i > 0 && i <= upperBound) {
              return true;
          } else {
              return false;
          }
      }
    //Prompt the user until they enter a valid number of guesses
    public int getValidNumGuesses(int rangeNum){
        System.out.print("Enter the number of guesses: ");
        int numGuesses = getIntegerInput();

        if(rangeNum < 2 && numGuesses > 1){
            System.out.println("Setting the number of guesses equal to 1");
            return 1;
        }

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
