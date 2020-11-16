import java.util.Random;
public class FindTheRedThread extends Game{
    private static final int upperBound = 21;
    private static int randInt = 0;
    public FindTheRedThread(String mode) {
        super("Find the Red Thread", mode);
    }
    public void playGame(String mode) {
      Random rand = new Random();
      int n = 0;
      int t = 0;
      int fill = 0;
      int[] intArray = new int[upperBound];
      int[] playerArray = new int[upperBound];
      int[] computerArray = new int[upperBound];
      String number;
      String Thread;
      boolean isWinner = false;
      randInt = rand.nextInt(upperBound);
      if (mode.equals(TEST)){
        System.out.println("The Red Thread is in slot " + (randInt - 1));
      }
      for(int i = 0; i < upperBound; i++){
          intArray[i] = 0;
      }
      if(!mode.equals(BUG)){
        intArray[randInt - 1] = 1;
      }

      System.out.println("Please Enter the Number of Threads to be Pulled: ");
      number = getInput.getInput();
      if(getInput.isValidThreadPull(number)) {
        n = Integer.parseInt(number);
      }
      else{
        while(!getInput.isValidThreadPull(number)){
          System.out.println("Invalid Number of Threads to be Pulled Detected");
          System.out.println("Please Enter a Valid Number of Threads to be Pulled: ");
          number = getInput.getInput();
        }
        n = Integer.parseInt(number);
      }
      if (mode.equals(TEST)){
        System.out.println("Number of Threads to be Pulled = " + n);
      }

      while(fill + n <= upperBound && !isWinner){
        isWinner = winCheck(playerArray, computerArray);
        if(!isWinner){
          System.out.println("No Winner Yet!");
          for(int i = 0; i < n; i++){
            System.out.println("Your Turn");
            pullThreads(i, intArray, playerArray, fill);
          }
          for(int i = 0; i < n; i++){
            System.out.println("Computer's Turn");
            computerPullThreads(i, intArray, computerArray, fill);
          }
        }
      }

      if(!isWinner){
        if(fill % 2 == 0){
          for(int i = 0; i < upperBound - fill; i++){
            System.out.println("Your Final Turn");
            pullThreads(i, intArray, playerArray, fill);
          }
        }
        else{
          if(!mode.equals(BUG)){
            for(int i = 0; i < upperBound - fill; i++){
              System.out.println("Computer's Final Turn");
              computerPullThreads(i, intArray, playerArray, fill);
            }
          }
        }
        if(!mode.equals(BUG)){
          isWinner = winCheck(playerArray, computerArray);
        }
      }
    }

    public void pullThreads(int pullNumber, int[] intArray, int[] playerArray, int fill){
        String Thread;
        int t;
        System.out.println("Please Enter Thread to be Pulled: ");
        Thread = getInput.getInput();
        if(getInput.isValidThread(Thread) && intArray[Integer.parseInt(Thread)] != -1) {
          t = Integer.parseInt(Thread);
        }
        else{
          while(!getInput.isValidThread(Thread) || intArray[Integer.parseInt(Thread)] == -1){
            System.out.println("Invalid Thread to be Pulled Detected");
            System.out.println("Please Enter a Valid Thread to be Pulled: ");
            Thread = getInput.getInput();
          }
          t = Integer.parseInt(Thread);
        }
        playerArray[pullNumber] = intArray[t];
        intArray[t] = -1;
        fill++;
    }

    public void computerPullThreads(int pullNumber, int[] intArray, int[] computerArray, int fill){
      Random rand = new Random();
      int random = rand.nextInt(upperBound);
      while(!getInput.isValidThreadNum(random, upperBound) || intArray[random] == -1){
        random = rand.nextInt(upperBound);
      }
      System.out.println("Computer Pulled: " + random);
      computerArray[pullNumber] = intArray[random];
      intArray[randInt] = -1;
      fill++;
    }

    public boolean winCheck(int[] playerArray, int[] computerArray){
      int winner = 0;
      for(int i = 0; i < upperBound; i++){
        if(playerArray[i] == 1){
          System.out.println("Player Wins! The Red Thread Was in Slot " + (randInt - 1));
          incrementUserScore();
          return true;
        }
        else if(computerArray[i] == 1){
          System.out.println("Computer Wins!");
          incrementComputerScore();
          return true;
        }
      }
      return false;

    }
}
