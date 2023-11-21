package mancala;
public class NoSuchPlayerException extends RuntimeException {
    private String playerName;

    public NoSuchPlayerException(String newPlayerName) {
        super("Player not found: " + newPlayerName);
        this.playerName = newPlayerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}
