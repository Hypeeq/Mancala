package mancala;
public class NoSuchPlayerException extends RuntimeException {
    private String playerName;

    public NoSuchPlayerException(String newPlayer) {
        super("Player: "  + newPlayer + " not found.");
        this.playerName = newPlayer;
    }

    public String getPlayerName() {
        return playerName;
    }
}