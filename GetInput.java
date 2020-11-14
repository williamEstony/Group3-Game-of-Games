import java.util.Scanner;

public class GetInput {
    private Scanner scan;
    public GetInput() {
        scan = new Scanner(System.in);
    }
    public String getInput() {
        return scan.nextLine();
    }
    public boolean isValidGameCode(String s) {
        if(Menu.getMenuObject(s) == null) {
            return false;
        }else {
            return true;
        }
    }

    public boolean isValidBestOfNum(String s) {
        if(isInteger(s)) {
            if(Integer.parseInt(s) > 0 && Integer.parseInt(s) % 2 == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isValidThreadPull(String s) {
        return true;
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }
}