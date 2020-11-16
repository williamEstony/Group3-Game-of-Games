import java.util.Random;
public class FindTheRedThread extends Game{
  private static final int upperBound = 21;
  private static final int redThread = 1;
  private static final int otherThread = 0;
  private static final int removedThread = -1;
  private static int randInt = 0;
  private static int numGuesses = 0;
  private static int Thread = 0;
  private static String pullsPerTurn;
  private static Random rand = new Random();

  public FindTheRedThread(String mode) {
      super("Find the Red Thread", mode);
  }

  public void playGame(String mode) {
    boolean isWinner = false;
    numGuesses = 0;
    int numOfPulls = 0;
    int[] boxOfThreads = new int[upperBound];
    int[] playerPulls = new int[upperBound];
    int[] computerPulls = new int[upperBound];

    populateArray(boxOfThreads, mode);

    if(mode.equals(TEST) || mode.equals(BUG)){
      System.out.println("The Red Thread is in slot " + (randInt));
    }

    System.out.println("Please Enter the Number of Threads to be Pulled: ");
    pullsPerTurn = getInput.getInput();
    if(getInput.isValidThreadPull(pullsPerTurn, upperBound)) {
      numOfPulls = Integer.parseInt(pullsPerTurn);
    }
    else{
      while(!getInput.isValidThreadPull(pullsPerTurn, upperBound)){
        invalidInput();
        System.out.println("Please Enter a Valid Number of Threads to be Pulled: ");
        pullsPerTurn = getInput.getInput();
      }
      numOfPulls = Integer.parseInt(pullsPerTurn);
    }

    if (mode.equals(TEST) || mode.equals(BUG)){
      System.out.println("Number of Threads to be Pulled = " + numOfPulls);
    }

    while(numGuesses + numOfPulls <= upperBound && !isWinner){
      isWinner = winCheck(playerPulls, computerPulls);
      if(!isWinner){
        System.out.println("No Winner Yet!");
        System.out.println("Your Turn");
        for(int i = 0; i < numOfPulls; i++){
          pullThreads(i, boxOfThreads, playerPulls);
        }
        System.out.println("Computer's Turn");
        for(int i = 0; i < numOfPulls; i++){
          computerPullThreads(i, boxOfThreads, computerPulls);
        }
      }
    }


    if(!isWinner){
      isWinner = winCheck(playerPulls, computerPulls);
      if(numGuesses % 2 == 0){
        System.out.println("Your Final Turn");
        for(int i = 0; i < (upperBound - numGuesses); i++){
          pullThreads(i, boxOfThreads, playerPulls);
        }
      }
      else{
        if(!mode.equals(BUG)){
          System.out.println("Computer's Final Turn");
          for(int i = 0; i < upperBound - numGuesses; i++){
            computerPullThreads(i, boxOfThreads, playerPulls);
          }
        }
      }
      if(!isWinner){
        if(!mode.equals(BUG)){
          isWinner = winCheck(playerPulls, computerPulls);
        }
      }
    }
  }

  public void invalidInput(){
    System.out.println("Invalid Input Detected!");
  }

  public void populateArray(int[] boxOfThreads, String mode){
    for(int i = 0; i < upperBound; i++){
        boxOfThreads[i] = otherThread;
    }
    randInt = rand.nextInt(upperBound);
    if(!mode.equals(BUG)){
      boxOfThreads[randInt] = redThread;
    }
  }

  public void pullThreads(int numberOfPull, int[] boxOfThreads, int[] playerPulls){
      String threadPull;
      System.out.println("Please Enter Thread to be Pulled: ");
      threadPull = getInput.getInput();
      if(getInput.isValidThread(threadPull, upperBound - 1) && boxOfThreads[Integer.parseInt(threadPull)] != removedThread) {
        Thread = Integer.parseInt(threadPull);
      }
      else{
        while(!getInput.isValidThread(threadPull, upperBound - 1) || boxOfThreads[Integer.parseInt(threadPull)] == removedThread){
          invalidInput();
          System.out.println("Please Enter a Valid Thread to be Pulled: ");
          threadPull = getInput.getInput();
        }
        Thread = Integer.parseInt(threadPull);
      }
      playerPulls[numberOfPull] = boxOfThreads[Thread];
      boxOfThreads[Thread] = removedThread;
      numGuesses++;
  }

  public void computerPullThreads(int numberOfPull, int[] boxOfThreads, int[] computerPulls){
    int random = rand.nextInt(upperBound);
    while(!getInput.isValidThreadNum(random, upperBound) || boxOfThreads[random] == removedThread){
      random = rand.nextInt(upperBound);
    }
    System.out.println("Computer Pulled: " + random);
    computerPulls[numberOfPull] = boxOfThreads[random];
    boxOfThreads[random] = removedThread;
    numGuesses++;
  }

  public boolean winCheck(int[] playerPulls, int[] computerPulls){
    for(int i = 0; i < upperBound; i++){
      if(playerPulls[i] == redThread){
        System.out.println("Player Wins! The Red Thread Was in Slot " + (randInt));
        incrementUserScore();
        return true;
      }
      else if(computerPulls[i] == redThread){
        System.out.println("Computer Wins! The Red Thread Was in Slot " + (randInt));
        incrementComputerScore();
        return true;
      }
    }
    return false;

  }
}
