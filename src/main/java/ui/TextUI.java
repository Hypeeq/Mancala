package ui;

import mancala.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    private MancalaGame game;
    private Scanner scanner;
    public TextUI() {
        game = new MancalaGame();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Welcome to Mancala!");

        // Set up players
        System.out.print("Enter Player One's name: ");
        String playerOneName = scanner.nextLine();
        Player playerOne = new Player(playerOneName);

        System.out.print("Enter Player Two's name: ");
        String playerTwoName = scanner.nextLine();
        Player playerTwo = new Player(playerTwoName);

        // Set up the game with players
        game.setPlayers(playerOne, playerTwo);
        game.startNewGame();

        // Main game loop
        while (!game.isGameOver()) {
            System.out.println("Current board:");
            printBoard();

            Player currentPlayer = game.getCurrentPlayer();
            System.out.println("It's " + currentPlayer.getName() + "'s turn.");

            if(currentPlayer==playerOne){
                System.out.print("Enter the pit number to move from (1-6): ");
            }
            if(currentPlayer==playerTwo){
                System.out.print("Enter the pit number to move from (7-12): ");
            }
            
            int startPit;
            try {
                startPit = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            try {
                int stonesMoved = game.getNumStones(startPit-1);
                 game.move(startPit-1);
                System.out.println(currentPlayer.getName() + " moved " + stonesMoved + " stones.");
            } catch (InvalidMoveException e) {
                System.out.println("Invalid move. " + e.getMessage());
            }

            System.out.println();
        }

        // Game over, print the final results
        System.out.println("Game Over!");
        printBoard();
        Player winner = game.getWinner();
        if (winner != null) {
            System.out.println(winner.getName() + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public void printBoard() {
        Board board = game.getBoard();
        ArrayList<Pit> pits = board.getPits();
        ArrayList<Store> stores = board.getStores();

        System.out.println("Player Two's Store");
        System.out.print("   ");
        for (int i = 12; i > 6; i--) {
            System.out.print(pits.get(i - 1).getStoneCount() + " ");
        }
        System.out.println();
        System.out.println("[" + stores.get(1).getTotalStones() + "] --- --- --- --- --- --- [" + stores.get(0).getTotalStones() + "]");
        System.out.print("   ");
        for (int i = 1; i <= 6; i++) {
            System.out.print(pits.get(i - 1).getStoneCount() + " ");
        }
        System.out.println();
        System.out.println("Player One's Store");
        System.out.println();
    }

    public static void main(String[] args) {
        TextUI textUI = new TextUI();
        textUI.startGame();
    }
}

