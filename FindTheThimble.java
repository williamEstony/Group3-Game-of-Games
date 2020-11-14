public class FindTheThimble extends Game{
    public FindTheThimble(String mode) {
        super("Find the Thimble", mode);
    }
    
    public void playerMode() {
        System.out.println("Player Mode");
    }
    public void testMode() {
        System.out.println("Test Mode");
    }
    public void bugMode() {
        System.out.println("Bug Mode");
    }
}