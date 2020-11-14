

public class Scoreboard extends Menu{
    private boolean playAgain;
    private static final int GAME_COLUMN_WIDTH = 20;

    public Scoreboard() {
        this.playAgain = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|---------------------------------------------|\n");
        sb.append("|                 Scoreboard                  |\n");
        sb.append("|---------------------------------------------|\n");
        sb.append("|          Game           | P1 Wins | P2 Wins |\n");
        sb.append("|---------------------------------------------|\n");

        for(MenuObject menuObject: menuObjects.values()) {
            if(menuObject instanceof Game) {
                Game g = (Game)menuObject;
                int numberOfSpaces = GAME_COLUMN_WIDTH - g.getName().length();
                sb.append(String.format("|     %s%" + numberOfSpaces + "s|    %s    |    %s    |\n", g.getName(), " ", g.getUserScore(), g.getComputerScore()));
                sb.append("|---------------------------------------------|\n");
            }
        }
        return sb.toString();
    }
    
    public void quit() { this.playAgain = false; }
    public boolean getPlayAgain() { return playAgain; }
}