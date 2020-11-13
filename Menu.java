public class Menu {
    private String mode;
    public Menu(String mode) {
        this.mode = mode;
    }
    public void displayGames() {
        System.out.println("Please choose a game.");
        Game CoinFlip = new CoinFlip(this.mode);
    }
}