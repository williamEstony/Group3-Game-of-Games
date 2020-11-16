/**
 * Highest level of abstraction in the Game of Games. 
 * This class is the parent of Game (@see Game) and Quit (@see Quit).
 * Generally, defines the object we would expect to see on the menu of the Game of Games.
 */
public abstract class MenuObject {
    
    protected String name;
    protected String mode;
    
    //Important because both a Game and a Quit object both need to mutate the Scoreboard
    //in different ways.
    protected static Scoreboard scoreboard = new Scoreboard();

    //Every MenuObject must implement a method called execute.
    public abstract void execute();

    /**
     * Constructor for MenuObject.
     * @param name the name of the menu object (should match the name displayed by the menu)
     * @param mode the mode of the game we are playing: test, bug, player
     */
    public MenuObject(String name, String mode) {
        this.name = name;
        this.mode = mode;
    }
}