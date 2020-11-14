public class GuessTheNumber extends Game{
    public GuessTheNumber(String mode) {
        super("Guess the Number", mode);
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