public class FindTheRedThread extends Game{
    
    private static final int THREAD_BOX_SIZE = 20;

    private static final int NOBODY = 0;
    private static final int USER = 1;
    private static final int COMPUTER = 2;

    private static final int THREAD = 1;
    private int winner;

    private int threadsPulled = 0;
    private int[] threadBox = new int[THREAD_BOX_SIZE];
    
    public FindTheRedThread(String mode) {
        super("Find the Red Thread", mode);
    }

    public void playGame(String mode) {
      winner = NOBODY;
      initializeThreadBox();
      System.out.println("Please enter the number of threads to be pulled each round: ");
      
      int threadPullsPerRound = getInput.getIntegerInput();
      
      while(!getInput.isValidNumThreadPullsPerRound(threadPullsPerRound, THREAD_BOX_SIZE)){
        System.out.println("Invalid thread pulls per round number entered.");
        System.out.println("Please enter a valid number of threads to be pulled each round: ");
        threadPullsPerRound = getInput.getIntegerInput();
      }

      if (mode.equals(TEST) || mode.equals(BUG)){
        System.out.println("The number of threads that each player will pull per round is " + threadPullsPerRound);
      }

      while(threadsPulled + threadPullsPerRound <= THREAD_BOX_SIZE && winner == NOBODY){

        // User pulls threads from box 
        for(int i = 1; i <= threadPullsPerRound; i++){
          System.out.println("Your Pull: " + i + "/" + threadPullsPerRound);
          pullThreads(USER);
        }
        
        // Computer pulls threads from box
        for(int i = 1; i <= threadPullsPerRound; i++){
          System.out.println("Computer's Pull: " + i + "/" + threadPullsPerRound);
          pullThreads(COMPUTER);
        }
      }   
      
      //There aren't enough threads left in the box for each player to grab, so the computer pulls the
      //remaining threads.
      if(THREAD_BOX_SIZE - threadsPulled > 0 && winner == NOBODY) {
        for(int i = 0; i < THREAD_BOX_SIZE - threadsPulled; i++){
          System.out.println("Computer is pulling the remaining threads.");
          pullThreads(COMPUTER);
        }
      }
    }

    private void initializeThreadBox() {
      int redThreadIndex = (int)(Math.random() * THREAD_BOX_SIZE);

      for(int i = 0; i < THREAD_BOX_SIZE; i++){
          threadBox[i] = 0;
      }
      if(!mode.equals(BUG)) {
        threadBox[redThreadIndex] = 1;
      }
    }

    public void pullThreads(int turn) {
      int threadIndex = 0;
      if(turn == USER){
        System.out.println("Please enter a thread slot to be pulled: ");
        threadIndex = getInput.getIntegerInput();
        
        while(!getInput.isValidThreadPull(threadIndex, THREAD_BOX_SIZE) || threadBox[threadIndex - 1] == -1){
          System.out.println("Invalid thread pull entered");
          System.out.println("Please enter a valid thread slot: ");
          threadIndex = getInput.getIntegerInput();
        }

        threadIndex--;
        
        if(threadBox[threadIndex] == THREAD) {
          winner = USER;
          if(mode.equals(BUG)) {
            incrementComputerScore();
          } else {
            incrementUserScore();
          }
        }
      }else if(turn == COMPUTER) {
        threadIndex = (int)(Math.random() * THREAD_BOX_SIZE);
        while(threadBox[threadIndex] == -1){
          threadIndex = (int)(Math.random() * THREAD_BOX_SIZE);
        }
        System.out.println("Computer Pulled: " + (threadIndex + 1));
        
        if(threadBox[threadIndex] == THREAD) {
          winner = COMPUTER;
          if(mode.equals(BUG)) {
            incrementUserScore();
          } else {
            incrementComputerScore();
          }
        }
      }
      threadBox[threadIndex] = -1;
      threadsPulled++;
  }      
}