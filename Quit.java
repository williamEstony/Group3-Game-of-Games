/**
 * Super simple class to model a Quit object. Quit is a child of MenuObject,
 * so we expect to see it displayed on the menu for the Game of Games.
 */
public class Quit extends MenuObject {
    
    /**
     * Simple constructor for Quit object.
     * @param mode the mode of the game we are playing: test, bug, player 
     */
    public Quit(String mode) { super("Quit", mode); }
    
    /** When called, flips the boolean on the universal scoreboard, ending the Game of Games. */
    public void execute() { scoreboard.quit(); }
}