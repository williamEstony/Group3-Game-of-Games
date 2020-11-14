public class CoinFlip extends Game{
    public CoinFlip(String mode) {
        super("Coin Flip", mode);
    }
    public void playerMode() {
        System.out.println("Pick heads or tails");
        int rand = (int)Math.round(Math.random());
        System.out.println(rand);
        incrementComputerScore();
    }
    public void testMode() {
        System.out.println("Test Mode");
    }
    public void bugMode() {
        System.out.println("Bug Mode");
    }
}