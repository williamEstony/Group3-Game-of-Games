import java.util.Random;
public class FindTheRedThread extends Game{
    public FindTheRedThread(String mode) {
        super("Find the Red Thread", mode);
    }
    public void playGame(String mode) {
      Random rand = new Random();
      int upperBound = 20;
      int n = 0;
      int t = 0;
      int fill = 0;
      int[] intArray = new int[20];
      int[] playerArray = new int[20];
      int[] computerArray = new int[20];
      String number;
      String Thread;
      boolean isWinner = false;
      int randInt = rand.nextInt(upperBound);
      if (mode.equals(TEST)){
        System.out.println("The Red Thread is in slot " + randInt);
      }
      for(int i = 0; i < 20; i++){
          intArray[i] = 0;
      }
      intArray[randInt - 1] = 1;
      if (mode.equals(TEST)){
        for(int i = 0; i < 20; i++){
            System.out.println(i + 1 + " " + intArray[i]);
        }
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

      while(fill + n <= 20 && !isWinner){
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
          for(int i = 0; i < 20 - fill; i++){
            System.out.println("Your Final Turn");
            pullThreads(i, intArray, playerArray, fill);
          }
        }
        else{
          for(int i = 0; i < 20 - fill; i++){
            System.out.println("Computer's Final Turn");
            computerPullThreads(i, intArray, playerArray, fill);
          }
        }
        isWinner = winCheck(playerArray, computerArray);
      }

      if (mode.equals(TEST)){
        for(int i = 0; i < 20; i++){
            System.out.println(i+1 + " Player Array: " + playerArray[i]+ " Computer Array: " + computerArray[i]);
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
      int upperBound = 20;
      Random rand = new Random();
      int randInt = rand.nextInt(upperBound);
      while(!getInput.isValidThreadNum(randInt) || intArray[randInt] == -1){
        randInt = rand.nextInt(upperBound);
      }
      System.out.println("Computer Pulled: " + randInt);
      computerArray[pullNumber] = intArray[randInt];
      intArray[randInt] = -1;
      fill++;
    }

    public boolean winCheck(int[] playerArray, int[] computerArray){
      int winner = 0;
      for(int i = 0; i < 20; i++){
        if(playerArray[i] == 1){
          System.out.println("Player Wins!");
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
