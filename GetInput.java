import java.util.Scanner;

public class GetInput {
    private Scanner scan;
    public GetInput() {
        scan = new Scanner(System.in);
    }
    public String getInput() {
        return scan.nextLine();
    }
    public boolean isGameCode(String s) {
        if(Menu.getMenuObject(s) == null) {
            return false;
        }else {
            return true;
        }
    }
}