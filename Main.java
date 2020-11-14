public class Main {
    private static Menu menu;
    public static void main(String[] args) {

        if (args.length == 0){
            System.out.println("Invalid game mode passed.");
        }else if(args.length == 1) {
            menu = new Menu(args[0]);
            System.out.println("Welcome to the Game of Games!");    
            menu.displayGames();
        }else {
            System.out.println("Invalid game mode passed.");
        }

        //for dummy push
    }
}