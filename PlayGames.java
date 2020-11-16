import java.io.IOException;
import java.lang.InterruptedException;

public class PlayGames {

    private MenuObject menuObject;
    private GetInput input;
    private Scoreboard scoreboard;

    

    public PlayGames(String mode) {
        this.input = new GetInput();
        this.scoreboard = MenuObject.getScoreboard();
        Menu.initializeMenu(mode);

        System.out.println("Welcome to the Game of Games");
    }

    public void start() {
        while(scoreboard.getPlayAgain()){
            Menu.displayMenu();
            System.out.print("Input a character to choose a game: ");
            String gameCode = input.getInput();
        
            while(!input.isValidGameCode(gameCode)) {
                clearMenu();
                Menu.displayMenu();
                System.out.print("Please enter a valid Menu Code: ");
                gameCode = input.getInput();
            }
            menuObject = Menu.getMenuObject(gameCode);
            menuObject.execute();
            clearMenu();
        }
        scoreboard.displayOverallWinner();
    }

    private static void clearMenu(){

        try { //Attempt to get the OS from the system
            String os = System.getProperty("os.name");

            if(os.equals("Windows")){
                try {
                    //Attempt to call a Window's specific command to clear the command window.
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } catch (IOException | InterruptedException ex) {

                }
            }else {
                try {//Attempt to call a Linux specific command to clear the command window.
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                } catch (IOException | InterruptedException ex) {

                }
            }

        }catch(Exception e) {}
    }
}