package mancala;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pit> pits;
    private ArrayList<Store> stores;
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer; // Added currentPlayer field

    public Board() {
        // Initialize a new Mancala board with pits and stores
        pits = new ArrayList<>();
        stores = new ArrayList<>();
        setUpPits();
        setUpStores();
        registerPlayers(null, null);
        initializeBoard();
    
    
    }

    public int captureStones(int stoppingPoint) {
        int stonesCaptured = 0;
        int startIndex = stoppingPoint - 1;

        if (startIndex >= 0 && startIndex < 6 && pits.get(startIndex).getStoneCount() == 1) {
            // Capture the stones in the opponent's pit
            int oppositePitIndex = 11 - startIndex;
            stonesCaptured = pits.get(oppositePitIndex).removeStones();
            stonesCaptured += pits.get(startIndex).removeStones();
            return stonesCaptured;
        }

        return stonesCaptured;
    }

    public int getNumStones(int pitNum) {
        if (pitNum >= 0 && pitNum < 12) {
            return pits.get(pitNum - 1).getStoneCount();
        } else {
            throw new PitNotFoundException();
        }
    }
    
    public int distributeStones(int startingPoint) {
        int stonesToDistribute = pits.get(startingPoint - 1).removeStones();
        int currentIndex = startingPoint;

        while (stonesToDistribute > 0) {
            currentIndex++;
            if (currentIndex > 12) {
                currentIndex = 1;
            }

            // Set the currentPlayer based on the current player's store
            if (currentIndex == 7) {
                currentPlayer = playerTwo;
            } else if (currentIndex == 1) {
                currentPlayer = playerOne;
            }

            // Place one stone in each pit, except for the opponent's store
            if (!(currentIndex == 7 && currentPlayer == playerOne) && !(currentIndex == 1 && currentPlayer == playerTwo)) {
                pits.get(currentIndex - 1).addStone();
                stonesToDistribute--;
            }
        }

        return currentIndex; // Return the last pit where a stone was placed
    }

    public ArrayList<Pit> getPits() {
        // Create a new ArrayList that includes only the pits (excluding stores)
        ArrayList<Pit> boardPits = new ArrayList<>(pits.subList(0, 12));
        return boardPits;
    }

    public ArrayList<Store> getStores() {
        // Create a new ArrayList that includes only the stores
        ArrayList<Store> boardStores = new ArrayList<>(stores);
        return boardStores;
    }



    public boolean isSideEmpty(int pitNum) {
        int startIndex = pitNum - 1;
        // 0-5 for Player One, 7-12 for Player Two
        int endIndex = (startIndex <= 5) ? 0 : 7;

        for (int i = startIndex; i >= endIndex; i--) {
            if (pits.get(i).getStoneCount() > 0) {
                return false;
            }
        }
        return true;
    }

    public int moveStones(int startPit, Player player) {
        int stonesToMove = pits.get(startPit - 1).removeStones();
        int currentIndex = startPit;

        while (stonesToMove > 0) {
            currentIndex++;
            if (currentIndex > 12) {
                currentIndex = 1;
            }

            // Place one stone in each pit, except for the opponent's store
            if (!(currentIndex == 7 && player == playerOne) && !(currentIndex == 1 && player == playerTwo)) {
                pits.get(currentIndex - 1).addStone();
                stonesToMove--;
            }
        }

        // Check for capture if the last stone lands in an empty pit on the player's side
        if (currentIndex - 1 >= 0 && currentIndex - 1 <= 5 && pits.get(currentIndex - 1).getStoneCount() == 1) {
            int oppositePitIndex = 11 - (currentIndex - 1);
            int capturedStones = pits.get(oppositePitIndex).removeStones();
            capturedStones += pits.get(currentIndex - 1).removeStones();
            player.getStore().addStones(capturedStones);
        }

        return currentIndex;
    }

    public void registerPlayers(Player one, Player two) {
        // Connects Players to their Stores
        if (one != null && two != null) {
            stores.get(0).setOwner(one);
            stores.get(1).setOwner(two);
            playerOne = one; // Assign players to class variables
            playerTwo = two;
        }
    }

    public void resetBoard() {
        // Resets the board by redistributing stones but retains the players
        initializeBoard();
    }

    public void setUpPits() {
        // Establishes 12 Pits in the board, each initialized with 4 stones
        for (int i = 0; i < 12; i++) {
            Pit pit = new Pit();
           // pit.addStones(4); // Add 4 stones to each pit
            pits.add(pit);
        }
    }
    
    public void initializeBoard(){
        for(Pit pit: pits){
            pit.removeStones();
            pit.addStones(4);
        }
         for (Store store : stores) {
            store.emptyStore();
        }
    }
    

    public void setUpStores() {
        // Establishes 2 empty Stores in the board
        stores.add(new Store());
        stores.add(new Store());
    }

    public String toString() {
        StringBuilder boardString = new StringBuilder();
        boardString.append("Mancala Board\n");

        // Add pits and stores information here
        for (int i = 0; i < 12; i++) {
            boardString.append("Pit ").append(i + 1).append(": ").append(pits.get(i).getStoneCount()).append(" stones\n");
        }
        boardString.append("Store 1: ").append(stores.get(0).getTotalStones()).append(" stones\n");
        boardString.append("Store 2: ").append(stores.get(1).getTotalStones()).append(" stones\n");

        return boardString.toString();
    }
}
