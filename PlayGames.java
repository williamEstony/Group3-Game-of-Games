import java.io.IOException;
import java.lang.InterruptedException;

/**
 * PlayGames acts as a driver class to handle how the menu is displayed and how the user
 * interacts with the menu.
 */
public class PlayGames {

    private MenuObject menuObject;
    private GetInput input;

    /**
     * Constructor for PlayGames. 
     * Initializes the GetInput object needed to get input from the user. @see GetInput
     * Initializes the Menu. @see Menu
     * Finally, prints a greeting.
     */
    public PlayGames(String mode) {
        this.input = new GetInput();
        Menu.initializeMenu(mode);

        System.out.println("Welcome to the Game of Games");
    }

    /**
     * The following method controls the main loop for the Game of Games.
     * When this method ends, so does the Game of Games and the program.
     */
    public void start() {
        while(Scoreboard.getPlayAgain()){ //Loop until the user quits
            Menu.displayMenu();
            System.out.print("Input a character to choose a game: ");
            String gameCode = input.getInput();
        
            while(!input.isValidGameCode(gameCode)) { //Loop until the user enters a valid game code
                clearMenu();
                Menu.displayMenu();
                System.out.print("Please enter a valid Menu Code: ");
                gameCode = input.getInput();
            }

            menuObject = Menu.getMenuObject(gameCode);
            menuObject.execute();
            clearMenu();
        }
        Scoreboard.displayOverallWinner();
    }

    /**
     * The following method attempts to determine the user's operating system.
     * Based on this information, it then attempts to clear the command line window.
     */
    private static void clearMenu(){

        try { //Attempt to get the OS from the system
            String os = System.getProperty("os.name");

            if(os.equals("Windows")){
                try {
                    //Attempt to call a Window's specific command to clear the command window.
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } catch (IOException | InterruptedException ex) {}
            }else {
                try {//Attempt to call a Linux specific command to clear the command window.
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                } catch (IOException | InterruptedException ex) {}
            }
        }catch(Exception e) {}
    }
}