package view;

import java.util.Scanner;

import model.GameDesign;

public class PlayGame {
	private Scanner input;
	private GameDesign game;
	
	public PlayGame() {
		this.game = new GameDesign();
		this.game.buildBoard();
		this.game.applyGameOne();
		this.input = new Scanner(System.in);
	}

	public void run() {
		boolean gameOver = false;
		System.out.println("Let's play sudoku!");
		this.drawBoard();
		do {
			try {
				System.out.print("What row to change (0-8): ");
				String inputData = this.input.nextLine();
				int userRow = Integer.parseInt(inputData);
				System.out.println();
				
				System.out.print("What column to change (0-8): ");
				inputData = this.input.nextLine();
				int userColumn = Integer.parseInt(inputData);
				System.out.println();
				
				System.out.print("What number to use (1-9): ");
				inputData = this.input.nextLine();
				int userNumber = Integer.parseInt(inputData);
				System.out.println();
				
				this.game.setNumber(userNumber, userRow, userColumn);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			this.drawBoard();
			gameOver = this.game.isGameFinished();
		} while (!gameOver);
		System.out.println("Thank you for playing!");
	}
	
	private void drawBoard() {
		int rows = this.game.getGameBoard().length;
		int columns = this.game.getGameBoard()[0].length;
    	System.out.println(" -------------------------------------");
	    for (int row = 0; row < rows; row++) {
	        for (int col = 0; col < columns; col++) {
	        	System.out.print(" | ");
	        	System.out.print(this.game.getGameBoard()[row][col]);
	        }
        	System.out.println(" |");
        	System.out.println(" -------------------------------------");
	    }
		
	}
}
