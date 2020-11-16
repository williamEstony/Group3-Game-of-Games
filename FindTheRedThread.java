import java.util.Random;
/**
 * The following class models the game - Find the Red Thread.
 * It inherits from parent class Game and grandparent class MenuObject
 * @see Game
 * @see MenuObject
 */
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

   /**
    * Constructor method for Find the Red Thread.
    * Passes the name of the game, and mode of the game to parent class Game.
    * @param mode - the mode of the Game of Games we are playing represented as a String
    *               Could be: test, bug or player
    */
  public FindTheRedThread(String mode) {
      super("Find the Red Thread", mode);
  }

  /**
   * Single driver method for the Find the Red Thread game that must be implemented by virtue of the contract with
   * parent class Game.
   * Requests user input for the number of threads that should be pulled each turn
   * @param mode - the mode of the Game of Games we are playing represented as a String
   *               Could be: test, bug or player
   */
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

  /**
   * Print method for any inputs that are deemed invalid.
   */
  public void invalidInput(){
    System.out.println("Invalid Input Detected!");
  }
  /**
   * Method to populate the array that represents the box of threads
   * @param boxOfThreads - the array that contains the numbers representing the threads
   *                       that would be present in the box
   * @param mode - the mode of the Game of Games we are playing represented as a String
   *               Could be: test, bug or player
   */
  public void populateArray(int[] boxOfThreads, String mode){
    for(int i = 0; i < upperBound; i++){
        boxOfThreads[i] = otherThread;
    }
    randInt = rand.nextInt(upperBound);
    if(!mode.equals(BUG)){
      boxOfThreads[randInt] = redThread;
    }
  }

  /**
   * Method to ask the user for the thread they wish to pull and adds the thread to the player's array
   * @param numberOfPull - an integer representing the number of the current thread pull
   * @param boxOfThreads - the array that contains the numbers representing the threads
   *                       that would be present in the box
   * @param playerPulls - the array that contains the numbers representing the threads
   *                      that the player has pulled
   */
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

  /**
   * Method to have the computer randomly pull the thread for their turn and adds the thread to the computer's array
   * @param numberOfPull - an integer representing the number of the current thread pull
   * @param boxOfThreads - the array that contains the numbers representing the threads
   *                       that would be present in the box
   * @param computerPulls - the array that contains the numbers representing the threads
   *                        that the computer has pulled
   */
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
  /**
   * A method to check if either the computer or the player have pulled the red thread.
   * @param playerPulls - the array that contains the numbers representing the threads
   *                      that the player has pulled
   * @param computerPulls - the array that contains the numbers representing the threads
   *                        that the computer has pulled
   */
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
