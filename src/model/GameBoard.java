package model;

/**
 * Game board for Sudoku game
 * 
 * @author Jennifer Parks
 */
public class GameBoard {
	private int rows;
	private int columns;
	private int[][] gameBoard;

	/**
	 * Game board constructor
	 */
	public GameBoard() {
		this.rows = 9;
		this.columns = 9;
		this.gameBoard = new int[rows][columns];
	}

	/**
	 * Returns array representing game board
	 * 
	 * @return 2d array of integers in game board
	 */
	public int[][] getGameBoard() {
		return this.gameBoard;
	}

	/**
	 * Builds board with 0 in each space
	 */
	public void buildBoard() {
		for (int row = 0; row < this.rows; row++) {
			for (int col = 0; col < this.columns; col++) {
				this.gameBoard[row][col] = 0;
			}
		}
	}

	/**
	 * Plays a number after validating choice. Currently cannot replace an
	 * already-played value
	 * 
	 * @param number     Number to be played
	 * @param playRow    Row of location for number
	 * @param playColumn Column of location for number
	 */
	public void setNumber(int number, int playRow, int playColumn) {
		if (number > 9 || number < 1) {
			throw new IllegalArgumentException("Number must be between 1 and 9");
		}
		if (playRow > 8 || playRow < 0) {
			throw new IllegalArgumentException("Row must be between 0 and 8");
		}
		if (playColumn > 8 || playColumn < 0) {
			throw new IllegalArgumentException("Column must be between 0 and 8");
		}
		if (this.gameBoard[playRow][playColumn] != 0) {
			throw new IllegalArgumentException("Game area is not empty");
		}

		boolean testRow = this.validateRow(number, this.buildRowFromRow(playRow));
		boolean testColumn = this.validateRow(number, this.buildRowFromColumn(playColumn));
		boolean testBox = this.validateRow(number, this.buildRowFromBox(playRow, playColumn));

		if (testRow && testColumn && testBox) {
			this.gameBoard[playRow][playColumn] = number;
		}
	}

	/**
	 * Determines if number to be played already exists in the area being tested
	 * 
	 * @param number   Number to be played
	 * @param testArea Array of digits to be tested for existing number
	 * @return True if number does not exist in area tested
	 */
	private boolean validateRow(int number, int[] testArea) {
		for (int played : testArea) {
			if (played == number) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Generates an array to be tested for duplicate numbers - based on row played
	 * 
	 * @param playRow Row of location for number
	 * @return Array of integers built from row
	 */
	private int[] buildRowFromRow(int playRow) {
		int[] testBox = new int[9];
		for (int col = 0; col < 9; col++) {
			testBox[col] = this.gameBoard[playRow][col];
		}
		return testBox;
	}

	/**
	 * Generates an array to be tested for duplicate numbers - based on column
	 * played
	 * 
	 * @param playColumn Column of location for number
	 * @return Array of integers built from column
	 */
	private int[] buildRowFromColumn(int playColumn) {
		int[] testBox = new int[9];
		for (int row = 0; row < 9; row++) {
			testBox[row] = this.gameBoard[row][playColumn];
		}
		return testBox;
	}

	/**
	 * Generates an array to be tested for duplicate numbers - based on 3x3 box
	 * where number is played
	 * 
	 * @param playRow    Row of location for number
	 * @param playColumn Column of location for number
	 * @return Array of integers built from box
	 */
	private int[] buildRowFromBox(int playRow, int playColumn) {
		int[] testBox = new int[9];
		int count = 0;
		int baseRow = (playRow / 3) * 3;
		int baseCol = (playColumn / 3) * 3;

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				testBox[count] = this.gameBoard[row + baseRow][col + baseCol];
				count++;
			}
		}

		return testBox;
	}

	/**
	 * Returns true if all locations are filled with a number that is not 0
	 * 
	 * @return True if game is over
	 */
	public boolean isGameFinished() {
		boolean result = true;
		for (int row = 0; row < this.rows; row++) {
			for (int col = 0; col < this.columns; col++) {
				if (this.gameBoard[row][col] == 0) {
					result = false;
				}
			}
		}

		return result;
	}

}
