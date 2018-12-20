package TriviaQuiz_1;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUItest extends JFrame implements ActionListener {

	JFrame frame;
	JLabel label;
	JButton A, B, C, D;

	TriviaDB t = new TriviaDB();

	public void createUI() {
		frame = new JFrame("Trivia Quiz");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		int randomquestionID = t.getRandomNumber();
		String qstion = t.getQuestion(randomquestionID);
		String answera = t.getAnswerA(randomquestionID);
		String answerb = t.getAnswerB(randomquestionID);
		String answerc = t.getAnswerC(randomquestionID);
		String answerd = t.getAnswerD(randomquestionID);
		String correctanswer = t.getcorrectAnswer(randomquestionID);

		label = new JLabel(qstion);
		label.setBounds(100, 20, 2000, 60);
		label.setLayout(new FlowLayout());
		label.setForeground(Color.BLACK);
		label.setFont(new Font(qstion, Font.CENTER_BASELINE, 18));
		frame.add(label);

		A = new JButton(answera);
		A.setBounds(100, 100, 400, 60);
		A.addActionListener(this);
		frame.add(A);

		if (correctanswer.equals("A")) {
			A.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					JOptionPane.showMessageDialog(frame, "Correct!");

				}
			});
		} else {
			A.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					JOptionPane.showMessageDialog(frame, "Wrong!");

				}
			});

		}

		B = new JButton(answerb);
		B.setBounds(100, 175, 400, 60);
		B.addActionListener(this);
		frame.add(B);
		if (correctanswer.equals("B")) {
			B.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					JOptionPane.showMessageDialog(frame, "Correct!");

				}
			});
		} else {
			B.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					JOptionPane.showMessageDialog(frame, "Wrong!");

				}
			});

		}

		C = new JButton(answerc);
		C.setBounds(100, 250, 400, 60);
		C.addActionListener(this);
		frame.add(C);
		if (correctanswer.equals("C")) {
			C.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					JOptionPane.showMessageDialog(frame, "Correct!");

				}
			});
		} else {
			C.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					JOptionPane.showMessageDialog(frame, "Wrong!");

				}
			});

		}

		D = new JButton(answerd);
		D.setBounds(100, 325, 400, 60);
		D.addActionListener(this);
		frame.add(D);
		if (correctanswer.equals("D")) {
			D.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					JOptionPane.showMessageDialog(frame, "Correct!");

				}
			});
		} else {
			D.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					JOptionPane.showMessageDialog(frame, "Wrong!");

				}
			});

		}

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setSize(width / 2, height / 2);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		A = (JButton) e.getSource();
		B = (JButton) e.getSource();
		C = (JButton) e.getSource();
		D = (JButton) e.getSource();

		System.out.println("Clicked");
	}

	public static void main(String[] args) {
		GUItest a = new GUItest();
		a.createUI();
	}

}
