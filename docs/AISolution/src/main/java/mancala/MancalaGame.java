package mancala;

import java.util.ArrayList;

public class MancalaGame {
    private Board board;
    private Player currentPlayer;
    private Player playerOne;
    private Player playerTwo;

    public MancalaGame() {
        board = new Board();
        currentPlayer = playerOne;
        playerOne = new Player("Player One");
        playerTwo = new Player("Player Two");
        board.registerPlayers(playerOne, playerTwo);
        startNewGame();
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int getNumStones(int pitNum) {
        return board.getNumStones(pitNum);
    }

    public ArrayList<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(playerOne);
        players.add(playerTwo);
        return players;
    }

    public int getStoreCount(Player player) {
        return player.getStore().getTotalStones();
    }

    public Player getWinner() throws GameNotOverException {
        if (!isGameOver()) {
            throw new GameNotOverException();
        }
    
        // Determine the winner as previously defined
        if (playerOne.getStore().getTotalStones() > playerTwo.getStore().getTotalStones()) {
            return playerOne;
        } else if (playerOne.getStore().getTotalStones() < playerTwo.getStore().getTotalStones()) {
            return playerTwo;
        }
    
        return null;
    }
    

    public boolean isGameOver() {
        for (int i = 1; i <= 6; i++) {
            if (board.getNumStones(i) > 0) {
                return false;
            }
        }
        return true;
    }

    public int move(int startPit) {
        int stones = board.moveStones(startPit, currentPlayer);
        if (stones > 0) {
            if (!board.isSideEmpty(startPit)) {
                currentPlayer.getStore().addStones(stones);
            }
            switchPlayer();
        }
        return stones;
    }

    public void setBoard(Board theBoard) {
        board = theBoard;
    }

    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }

    public void setPlayers(Player onePlayer, Player twoPlayer) {
        playerOne = onePlayer;
        playerTwo = twoPlayer;
        board.registerPlayers(playerOne, playerTwo);
        currentPlayer = playerOne; // Set the current player to playerOne
    }
    

    public void startNewGame() {
        board.resetBoard();
        currentPlayer = playerOne;
    }

    public String toString() {
        return "MancalaGame: " + playerOne.getName() + " vs. " + playerTwo.getName();
    }

    private void switchPlayer() {
        if (currentPlayer == playerOne) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
    }
}
