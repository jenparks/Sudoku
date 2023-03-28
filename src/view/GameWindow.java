package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class GameWindow extends JFrame {

	protected JPanel contentPane;
	protected JTextField[][] textFieldGroup;
	protected JLabel gameSelectLabel;
	protected JComboBox gameSelectComboBox;
	protected JSeparator separatorHorizontal1;
	protected JSeparator separatorHorizontal2;
	protected JSeparator separatorVertical1;
	protected JSeparator separatorVertical2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow frame = new GameWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 451);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		gameSelectLabel = new JLabel("Choose game");
		gameSelectLabel.setBounds(22, 28, 102, 20);
		contentPane.add(gameSelectLabel);
		
		gameSelectComboBox = new JComboBox();
		gameSelectComboBox.setEditable(true);
		gameSelectComboBox.setBounds(124, 28, 147, 21);
		contentPane.add(gameSelectComboBox);
		
		separatorHorizontal1 = new JSeparator();
		separatorHorizontal1.setForeground(new Color(0, 0, 0));
		separatorHorizontal1.setBorder(new LineBorder(Color.BLACK, 2));
		separatorHorizontal1.setBounds(120, 181, 340, 3);
		contentPane.add(separatorHorizontal1);
		
		separatorHorizontal2 = new JSeparator();
		separatorHorizontal2.setForeground(new Color(0, 0, 0));
		separatorHorizontal2.setBorder(new LineBorder(Color.BLACK, 2));
		separatorHorizontal2.setBounds(120, 265, 340, 3);
		contentPane.add(separatorHorizontal2);
		
		separatorVertical1 = new JSeparator();
		separatorVertical1.setOrientation(SwingConstants.VERTICAL);
		separatorVertical1.setForeground(new Color(0, 0, 0));
		separatorVertical1.setBorder(new LineBorder(Color.BLACK, 2));
		separatorVertical1.setBounds(231, 100, 3, 250);
		contentPane.add(separatorVertical1);
		
		separatorVertical2 = new JSeparator();
		separatorVertical2.setOrientation(SwingConstants.VERTICAL);
		separatorVertical2.setForeground(new Color(0, 0, 0));
		separatorVertical2.setBorder(new LineBorder(Color.BLACK, 2));
		separatorVertical2.setBounds(345, 100, 3, 250);
		contentPane.add(separatorVertical2);

		this.textFieldGroup = new JTextField[9][9];

	}
}
