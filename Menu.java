import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {
    protected static Map<String, MenuObject> menuObjects = new LinkedHashMap<String, MenuObject>();

    public Menu() {}
    public Menu(String mode) {
        menuObjects.put("A", new FindTheThimble(mode));
        menuObjects.put("B", new CoinFlip(mode));
        menuObjects.put("C", new GuessTheNumber(mode));
        menuObjects.put("D", new EvenOrOdd(mode));
        menuObjects.put("E", new FindTheRedThread(mode));
        menuObjects.put("Q", new Quit(mode));
    }

    public void displayMenu() {
        menuObjects.forEach((k, v) -> {
            System.out.format("%s. %s\n", k, v.getName());
        });
    }

    public static MenuObject getMenuObject(String menuCode) {
        return menuObjects.get(menuCode);
    }
}