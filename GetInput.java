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

    public boolean isValidRange(int input, int maxRange) {
        if(input > 0 && input <= maxRange) {
            return true;
        }
        return false;
    }

    public boolean isValidAOrBValue(String input, String a, String b) {
        if(input.equals(a) || input.equals(b)) {
            return true;
        }
        return false;
    }
    public boolean isValidThreadPull(String s, int upperBound) {
      if(isInteger(s)) {
          if(Integer.parseInt(s) > 0 && Integer.parseInt(s) <= (upperBound / 2)) {
              return true;
          } else {
              return false;
          }
      } else {
          return false;
        }
      }
    public boolean isValidThread(String s, int upperBound) {
      if(isInteger(s)) {
          if(Integer.parseInt(s) > 0 && Integer.parseInt(s) <= upperBound) {
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


    public boolean isValidNumGuesses(int numGuesses, int rangeNum){
        if(numGuesses <= (rangeNum / 2)) {
            return true;
        }
        return false;
    }

    //Prompt the user until they enter an integer
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
