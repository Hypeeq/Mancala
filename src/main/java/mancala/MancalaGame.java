package mancala;

import java.util.ArrayList;

public class MancalaGame {
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;
    private Board board;

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

    public int getNumStones(int pitNum) throws PitNotFoundException {

       if (pitNum >= 0 && pitNum < 12) {
           return board.getNumStones(pitNum);
        } else {
           throw new PitNotFoundException(); // Throw PitNotFoundException for invalid pitNum
        } 
    }

    public ArrayList<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(playerOne);
        players.add(playerTwo);
        return players;
    }

    public int getStoreCount(Player player) throws NoSuchPlayerException {
        if (currentPlayer != playerOne && currentPlayer != playerTwo){
            throw new NoSuchPlayerException();
        }
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
        boolean playerOnePitsEmpty = true;
        boolean playerTwoPitsEmpty = true;

        // Check pits for player one (indices 0 to 5)
        for (int i = 0; i < 6; i++) {
            if (board.getNumStones(i) != 0) {
                playerOnePitsEmpty = false;
                break;  // No need to check further once we find a pit with stones
            }
        }

        // Check pits for player two (indices 6 to 11)
        for (int i = 6; i < 12; i++) {
            if (board.getNumStones(i) != 0) {
                playerTwoPitsEmpty = false;
                break;  // No need to check further once we find a pit with stones
            }
        }

        // If all pits for either player are empty, the game is over
        if (playerOnePitsEmpty || playerTwoPitsEmpty) {
            board.summationStore();
            return true;
        }

        return false;
    }

    public int move(int startPit) throws InvalidMoveException {

        int stones = 0;
        int pitSum = 0;
    
        if (currentPlayer != playerOne && currentPlayer != playerTwo) {
            throw new IllegalStateException("Invalid player");
        } else if (startPit < 0 || startPit > 11) {
            throw new InvalidMoveException();
        } else {
            stones = board.moveStones(startPit, currentPlayer);
            if (stones > 0) {
                switchPlayer();
            }
        }
      
        
        if (currentPlayer == playerOne && startPit > 0 && startPit < 6) {
            for (int i = 0; i < 6; i++) {
                pitSum += board.getNumStones(i);
            }
        } else if (currentPlayer == playerTwo && startPit > 6 && startPit < 12) {
            for (int i = 6; i < 12; i++) {
                pitSum += board.getNumStones(i);
            }
        }
    
        return pitSum;
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
        currentPlayer = playerOne;
    }

    public void startNewGame() {
        board.resetBoard();
        currentPlayer = playerOne;
    }

    public String toString() {
        return "MancalaGame: " + playerOne.getName() + " vs. " + playerTwo.getName();
    }

    public void switchPlayer() {
        if (currentPlayer == playerOne) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
    }
    
}
