public class Menu {
    private String mode;
    public Menu(String mode) {
        this.mode = mode;
    }
    public void displayGames() {
        System.out.println("Please choose a game.");
        //Game coinFlip = new CoinFlip(this.mode);
        Game guessTheNummber = new GuessTheNumber(mode);
    }
}