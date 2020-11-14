public class Quit extends MenuObject {
    
    public Quit(String mode) {
        super("Quit", mode);
    }
    public void execute() {
        getScoreboard().quit();
    }
}