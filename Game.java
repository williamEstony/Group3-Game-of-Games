public abstract class Game {
    // player, test, bug
    public Game(String mode) {
        if (mode.equals("player")) {
            playerMode();
        }else if(mode.equals("test")) {
            testMode();
        }else if(mode.equals("bug")) {
            bugMode();
        }else {
            System.out.println("Invalid game mode detected");
        }
    }
    public abstract void playerMode();
    public abstract void testMode();
    public abstract void bugMode();
}