# Mancala Game Implementation

## Overview

This Java package implements the Mancala game, a two-player strategy board game where players distribute stones across pits on the board to capture their opponent's stones.

## Table of Contents
1. [Classes](#classes)
2. [Development History](#development-history)
3. [Usage](#usage)
4. [Installation](#installation)
5. [Contributing](#contributing)
6. [License](#license)
7. [Additional Notes](#additional-notes)

## Classes

### 1. `Board`
- Represents the Mancala game board with pits, stores, and player information.
- Handles stone distribution, capturing, and game state.

### 2. `MancalaGame`
- Represents the Mancala game itself, managing players, the game board, and game flow.
- Checks for game over conditions, determines winners, and handles player turns.

### 3. `Pit`
- Represents an individual pit on the Mancala board.
- Tracks the number of stones in the pit and provides methods for stone manipulation.

### 4. `Player`
- Represents a player in the Mancala game, associated with a store.
- Manages player-specific information such as name, store, and store count.

### 5. `Store`
- Represents a store associated with a player, where captured stones are kept.
- Tracks the number of stones in the store and provides methods for manipulation.

### 6. `InvalidMoveException`
- Exception class for invalid moves in the Mancala game.

### 7. `GameNotOverException`
- Exception class for attempts to determine a winner when the game is not over.

### 8. `NoSuchPlayerException`
- Exception class for cases where a player is not found.

### 9. `PitNotFoundException`
- Exception class for cases where a pit is not found.

## Development History

### Version 1.0.0 (2023-01-01)
- Initial implementation of the Mancala game classes.
- Added classes: `Board`, `MancalaGame`, `Pit`, `Player`, `Store`, `InvalidMoveException`, `GameNotOverException`, `NoSuchPlayerException`, `PitNotFoundException`.
- Included methods for initializing the board, managing players, distributing stones, capturing stones, checking game over conditions, and handling exceptions.

### Version 1.1.0 (2023-01-15)
- Added additional methods to the `Pit` and `Player` classes.
- Improved error handling and exception messages.
- Implemented a development history section in the README file.

## Usage

To use the Mancala game implementation, follow these steps:

1. Clone the repository to your local machine.
2. Compile the Java classes using your preferred IDE or build tool.
3. Create an instance of `MancalaGame` and interact with the game through its methods.

Example:

```java
// Create a new Mancala game
MancalaGame mancalaGame = new MancalaGame();

// Get the current player
Player currentPlayer = mancalaGame.getCurrentPlayer();

// Make a move
int startPit = 2;
int stonesMoved = mancalaGame.move(startPit);

// Check the updated board state
Board updatedBoard = mancalaGame.getBoard();
System.out.println(updatedBoard.toString());

Installation

To install the Mancala game, follow these steps:

Download the source code or clone the repository.
Compile the Java classes using a Java compiler.
Contributing

Contributions are welcome! If you have ideas for improvements, bug fixes, or new features, please open an issue or submit a pull request.

License

This project is licensed under the MIT License.

Additional Notes

Handle exceptions appropriately to ensure a smooth user experience.
For detailed information on each class and its methods, refer to the inline comments in the source code.


Replace `(YYYY-MM-DD)` with the actual date of each release or development update. Adjust the "Usage," "Installation," "Contributing," and "License" sections to fit your project's specific details.


| Test Case                  | Description                                | Expected Result                                   |
|----------------------------|--------------------------------------------|---------------------------------------------------|
| testCaptureStones          | Test capturing stones from a specified pit | Verify that no stones are captured initially      |
| testDistributeStones       | Test distributing stones from a pit        | Verify that stones are added to adjacent pits      |
| testGetNumStones           | Test getting the number of stones in a pit | Verify the initial number of stones in a specific pit |
| testIsSideEmpty            | Test checking if a side is empty            | Verify that the side is not empty initially        |
| testResetBoard             | Test resetting the board                    | Verify that the board reset operation doesn't throw an exception |
| testRegisterPlayers        | Test registering players                    | Verify that registering players doesn't throw an exception |
