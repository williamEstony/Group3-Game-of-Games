public abstract class MenuObject {
    
    private String name;
    private String mode;
    private static Scoreboard scoreboard = new Scoreboard();

    public MenuObject(String name, String mode) {
        this.name = name;
        this.mode = mode; // player, test, bug
    }
    public abstract void execute();
    public String getName() { return name; }
    public String getMode() { return mode; }
    public Scoreboard getScoreboard() { return scoreboard; }
    public static boolean getPlayAgain() { return scoreboard.getPlayAgain(); }
}