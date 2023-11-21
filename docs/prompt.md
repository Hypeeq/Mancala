# Mancala Package

## Overview

Create a Java package named `mancala` that implements the Mancala game. Mancala is a two-player strategy board game where players distribute stones across pits on the board to capture their opponent's stones.

## Classes

### 1. `Board`

#### Fields
- `private ArrayList<Pit> pits`: Represents the pits on the board.
- `private ArrayList<Store> stores`: Represents the stores for each player.
- `private Player playerOne`: Represents Player One.
- `private Player playerTwo`: Represents Player Two.
- `private Player currentPlayer`: Represents the current player.

#### Methods
- `public Board()`: Initializes a new Mancala board with pits and stores.
- `public int captureStones(int stoppingPoint) throws PitNotFoundException`: Captures stones based on a stopping point.
- `public int getNumStones(int pitNum) throws PitNotFoundException`: Returns the number of stones in a pit.
- `public int distributeStones(int startingPoint) throws PitNotFoundException`: Distributes stones from a given starting point.
- `public ArrayList<Pit> getPits()`: Returns an ArrayList containing only the pits (excluding stores).
- `public ArrayList<Store> getStores()`: Returns an ArrayList containing only the stores.
- `public boolean isSideEmpty(int pitNum) throws PitNotFoundException`: Checks if a side of pits is empty.
- `public int moveStones(int startPit, Player player) throws InvalidMoveException`: Moves stones from a given pit for the current player.
- `public void registerPlayers(Player one, Player two)`: Connects players to their respective stores.
- `public void resetBoard()`: Resets the board by redistributing stones but retains the players.
- `public void setUpPits()`: Initializes 12 pits on the board, each with 4 stones.
- `public void initializeBoard()`: Resets pits and adds 4 stones to each.
- `public void setUpStores()`: Initializes 2 empty stores on the board.
- `public String toString()`: Returns a string representation of the Mancala board.
- `public void summationStore()`: Sums stones in each player's pits and adds them to their respective stores.

### 2. `MancalaGame`

#### Fields
- `private Player playerOne`: Represents Player One.
- `private Player playerTwo`: Represents Player Two.
- `private Player currentPlayer`: Represents the current player.
- `private Board board`: Represents the Mancala board.

#### Methods
- `public MancalaGame()`: Initializes a new Mancala game with a board and players.
- `public Board getBoard()`: Returns the game board.
- `public Player getCurrentPlayer()`: Returns the current player.
- `public int getNumStones(int pitNum) throws PitNotFoundException`: Returns the number of stones in a specified pit.
- `public ArrayList<Player> getPlayers()`: Returns an ArrayList containing both players.
- `public int getStoreCount(Player player) throws NoSuchPlayerException`: Returns the total stones in a player's store.
- `public Player getWinner() throws GameNotOverException`: Returns the winner if the game is over.
- `public boolean isGameOver()`: Checks if the game is over.
- `public int move(int startPit) throws InvalidMoveException`: Moves stones from a specified pit.
- `public void setBoard(Board theBoard)`: Sets a custom board for the game.
- `public void setCurrentPlayer(Player player)`: Sets the current player.
- `public void setPlayers(Player onePlayer, Player twoPlayer)`: Sets the players for the game.
- `public void startNewGame()`: Resets the board and starts a new game.
- `public String toString()`: Returns a string representation of the Mancala game.
- `public void switchPlayer()`: Switches the current player.


### 3. `Pit`

#### Fields
- `private int stoneCount`: Represents the number of stones in a pit.

#### Methods
- `public Pit()`: Initializes a new Pit with zero stones.
- `public int getStoneCount()`: Returns the number of stones in the pit.
- `public void addStones(int count)`: Adds a specified number of stones to the pit.
- `public void addStone()`: Adds one stone to the pit.
- `public int removeStones()`: Removes all stones from the pit and returns the count.
- `public String toString()`: Returns a string representation of the pit.

### 4. `Player`

#### Fields
- `private String name`: Represents the name of the player.
- `private Store store`: Represents the store associated with the player.

#### Methods
- `public Player()`: Initializes a default player with the name "Player" and an associated store.
- `public Player(String playerName)`: Initializes a player with a specified name and an associated store.
- `public String getName()`: Returns the name of the player.
- `public void setName(String playerName)`: Sets the name of the player.
- `public Store getStore()`: Returns the store associated with the player.
- `public int getStoreCount()`: Returns the total number of stones in the player's store.
- `public void setStore(Store newStore)`: Sets a new store for the player.
- `public String toString()`: Returns a string representation of the player.

### 5. `Store`

#### Fields
- `private Player owner`: Represents the player associated with the store.
- `private int stoneCount`: Represents the number of stones in the store.

#### Methods
- `public Store()`: Initializes a new store with zero stones and no associated player.
- `public void setOwner(Player player)`: Sets the player associated with the store.
- `public Player getOwner()`: Returns the player associated with the store.
- `public void addStones(int amount)`: Adds a specified number of stones to the store.
- `public int getTotalStones()`: Returns the total number of stones in the store.
- `public int emptyStore()`: Removes all stones from the store and returns the count.
- `public String toString()`: Returns a string representation of the store.

### 6. `InvalidMoveException`

#### Constructors
- `public InvalidMoveException()`: Initializes an `InvalidMoveException` with the default error message.

### 7. `GameNotOverException`

#### Constructors
- `public GameNotOverException()`: Initializes a `GameNotOverException` with the default error message.

### 8. `NoSuchPlayerException`

#### Constructors
- `public NoSuchPlayerException()`: Initializes a `NoSuchPlayerException` with the default error message.

### 9. `PitNotFoundException`

#### Constructors
- `public PitNotFoundException()`: Initializes a `PitNotFoundException` with the default error message.

## Additional Notes

- Make sure to handle exceptions appropriately and provide clear error messages.
- Implement any additional methods or constructors necessary for the proper functioning of the game.
