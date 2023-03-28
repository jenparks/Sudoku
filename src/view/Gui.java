package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.GameDesign;

public class Gui extends GameWindow {
	private GameDesign board;

	public Gui() {
		this.board = new GameDesign();
		this.setUpGameChooser();

	}

	private void setUpGameChooser() {
		this.gameSelectComboBox.addItem("No Game");
		for (String item : this.board.getGameTypes()) {
			this.gameSelectComboBox.addItem(item);
		}
		this.gameSelectComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = Gui.this.gameSelectComboBox.getSelectedIndex();
				if (index == 1) {
					Gui.this.board.applyGameOne();
				} else if (index == 2) {
					Gui.this.board.applyGameTwo();
				}
				Gui.this.setUpBoard();
			}
		});

	}

	private void setUpBoard() {
		Color editColor = new Color(204, 230, 220);
		Color noEditColor = new Color(229, 246, 240);
		
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				JTextField newTextField = new JTextField();
				newTextField.setBounds((120 + 38 * col), (100 + 28 * row), 35, 25);
				newTextField.setText(this.board.getGameBoard()[row][col] + "");
				newTextField.setBorder(new LineBorder(Color.BLACK, 1));
				this.textFieldGroup[row][col] = newTextField;

				if (this.board.getGameBoard()[row][col] > 0) {
					this.textFieldGroup[row][col].setEditable(false);
					this.textFieldGroup[row][col].setBackground(noEditColor);

				} else {
					this.textFieldGroup[row][col].setEditable(true);
					this.textFieldGroup[row][col].setBackground(editColor);
				}

				final int innerRow = row;
				final int innerCol = col;
				this.textFieldGroup[row][col].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int changeNumber = Integer.parseInt(Gui.this.textFieldGroup[innerRow][innerCol].getText());
							Gui.this.board.setNumber(changeNumber, innerRow, innerCol);
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, ex.getMessage());
						}
					}
				});

				contentPane.add(newTextField);
			}
		}
	}

}
