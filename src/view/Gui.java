package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.GameDesign;

public class Gui extends GameWindow {
	private GameDesign board;

	public Gui() {
		this.board = new GameDesign();
		this.board.applyGameOne();

		this.setUpBoard();
	}

	private void setUpBoard() {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				JTextField newTextField = new JTextField();
				newTextField.setBounds((120 + 35 * col), (60 + 30 * row), 30, 20);
				newTextField.setText(this.board.getGameBoard()[row][col] + "");
				this.textFieldGroup[row][col] = newTextField;

				if (this.board.getGameBoard()[row][col] > 0) {
					this.textFieldGroup[row][col].setEditable(false);
				} else {
					this.textFieldGroup[row][col].setEditable(true);
				}

				final int innerRow = row;
				final int innerCol = col;
				this.textFieldGroup[row][col].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int changeNumber = Integer.parseInt(Gui.this.textFieldGroup[innerRow][innerCol].getText());
							Gui.this.board.setNumber(changeNumber, innerRow, innerCol);
						} catch (Exception ex) {
							System.out.println(ex.getMessage());
						}
					}
				});

				contentPane.add(newTextField);
			}
		}
	}

}
