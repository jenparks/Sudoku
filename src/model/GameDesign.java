package model;

public class GameDesign extends GameBoard {
	private String[] gameTypes = { "Game One", "Game Two" };

	public GameDesign() {
	}

	public String[] getGameTypes() {
		return this.gameTypes;
	}

	public void applyGameOne() {
		this.setNumber(9, 1, 1);
		this.setNumber(8, 2, 1);
		this.setNumber(7, 3, 1);
		this.setNumber(6, 4, 1);
		this.setNumber(5, 5, 1);
		this.setNumber(4, 6, 1);
		this.setNumber(3, 7, 1);
		this.setNumber(2, 8, 1);
	}

	public void applyGameTwo() {
		this.setNumber(4, 0, 0);
		this.setNumber(3, 0, 4);
		this.setNumber(2, 0, 5);
		this.setNumber(5, 0, 8);
		this.setNumber(5, 1, 0);
		this.setNumber(8, 1, 2);
		this.setNumber(7, 1, 3);
		this.setNumber(6, 1, 4);
		this.setNumber(4, 1, 5);
		this.setNumber(2, 1, 6);
		this.setNumber(1, 1, 7);
		this.setNumber(2, 2, 2);
		this.setNumber(5, 2, 3);
		this.setNumber(9, 2, 4);
		this.setNumber(7, 2, 6);
		this.setNumber(4, 2, 8);
		this.setNumber(3, 3, 0);
		this.setNumber(5, 3, 2);
		this.setNumber(8, 3, 3);
		this.setNumber(1, 3, 5);
		this.setNumber(6, 3, 8);
		this.setNumber(2, 4, 1);
		this.setNumber(6, 4, 2);
		this.setNumber(4, 4, 4);
		this.setNumber(9, 4, 5);
		this.setNumber(5, 4, 7);
		this.setNumber(8, 5, 0);
		this.setNumber(1, 5, 2);
		this.setNumber(4, 5, 6);
		this.setNumber(9, 6, 0);
		this.setNumber(3, 6, 2);
		this.setNumber(7, 6, 5);
		this.setNumber(5, 6, 6);
		this.setNumber(8, 7, 1);
		this.setNumber(2, 8, 0);
		this.setNumber(4, 8, 2);
		this.setNumber(6, 8, 3);
		this.setNumber(8, 8, 4);
	}

}
