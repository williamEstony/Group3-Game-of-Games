import java.util.LinkedHashMap;
import java.util.Map;

/**
 * One of the more interesting classes for the Game of Games. Defines how the menu
 * looks and behaves. Implemented with a LinkedHashMap. We prefer LinkedHashMap as opposed
 * to regular HashMap because Linked ensures the order items are placed into the data structure is preserved.
 * Another interesting thing we've done here is made all the methods static.
 * This allows us to not have to instantiate a Menu object. We believe this to be a cleaner approach.
 */
public class Menu {
    protected static Map<String, MenuObject> menuObjects = new LinkedHashMap<String, MenuObject>();

    /**
     * The source of truth for our Game of Games menu. Maps the menu codes to their respective MenuObject
     * Only called and run once in PlayGames (@see PlayGames).
     */
    public static void initializeMenu(String mode) {
        menuObjects.put("A", new FindTheThimble(mode));
        menuObjects.put("B", new CoinFlip(mode));
        menuObjects.put("C", new GuessTheNumber(mode));
        menuObjects.put("D", new EvenOrOdd(mode));
        menuObjects.put("E", new FindTheRedThread(mode));
        menuObjects.put("Q", new Quit(mode));
    }

    /** Prints out each menu code followed by the name of the game that the code maps to. */
    public static void displayMenu() {
        menuObjects.forEach((k, v) -> {
            System.out.format("%s. %s\n", k, v.name);
        });
    }
    /**
     * @param menuCode the menu code we are attempting to find the MenuObject of
     * @return the MenuObject of the code passed to the method.
     */
    public static MenuObject getMenuObject(String menuCode) {
        return menuObjects.get(menuCode);
    }
}