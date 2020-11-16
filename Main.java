/**
 * Class to house the main method for the program.
 * Since PlayGames is the true driver class, we simply call PlayGames.start()
 * We also pass PlayGames the appropriate game mode: test, bug, or player.
 * @see PlayGames
 */
public class Main {
    private static PlayGames playGames;
    public static void main(String[] args) {

        if (args.length == 0){
            System.out.println("Invalid game mode passed.");
        }else if(args.length == 1) {
            playGames = new PlayGames(args[0]);
            playGames.start();
        }else {
            System.out.println("Invalid game mode passed.");
        }
    }
}