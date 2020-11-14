import java.io.IOException;
import java.lang.InterruptedException;

public class PlayGames {

    private String mode;
    private static Menu menu;
    private GetInput input;
    private MenuObject menuObject;

    

    public PlayGames(String mode) {
        this.mode = mode;
        this.input = new GetInput();
        menu = new Menu(mode);

        System.out.println("Welcome to the Game of Games");
    }

    public void start() {
        while(MenuObject.getPlayAgain()) {
            menu.displayMenu();
            System.out.print("Input a character to choose a game: ");
            String gameCode = input.getInput();
        
            while(!input.isValidGameCode(gameCode)) {
                clearMenu();
                menu.displayMenu();
                System.out.print("Please enter a valid Menu Code: ");
                gameCode = input.getInput();
            }
            menuObject = Menu.getMenuObject(gameCode);
            menuObject.execute();
            clearMenu();
        }
        System.out.println("Player [insert some logic here] Won!");
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

        }catch(Exception e) {

        }
    }
}