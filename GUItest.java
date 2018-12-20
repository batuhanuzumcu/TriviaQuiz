
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
	
	int randomquestionID;
	String qstion;
	String answera;
	String answerb;
	String answerc;
	String answerd;
	String correctanswer;

	TriviaDB t = new TriviaDB();
	

	public void createUI() {
		
		frame = new JFrame("Trivia Quiz");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		randomquestionID = t.getRandomNumber();
		qstion = t.getQuestion(randomquestionID);
		answera = t.getAnswerA(randomquestionID);
		answerb = t.getAnswerB(randomquestionID);
		answerc = t.getAnswerC(randomquestionID);
		answerd = t.getAnswerD(randomquestionID);
		correctanswer = t.getcorrectAnswer(randomquestionID);

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
	
		B = new JButton(answerb);
		B.setBounds(100, 175, 400, 60);
		B.addActionListener(this);
		frame.add(B);
		
		C = new JButton(answerc);
		C.setBounds(100, 250, 400, 60);
		C.addActionListener(this);
		frame.add(C);
		
		D = new JButton(answerd);
		D.setBounds(100, 325, 400, 60);
		D.addActionListener(this);
		frame.add(D);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setSize(width / 2, height / 2);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);				
			
				
			
		

			
			A.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (correctanswer.equals("A")) {

						JOptionPane.showMessageDialog(frame, "Correct!");
						 UpdateUI();
			
					}
					else {
						JOptionPane.showMessageDialog(frame, "Wrong!");
					 UpdateUI();


					}
				}
			});
			
			B.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (correctanswer.equals("B")) {

						JOptionPane.showMessageDialog(frame, "Correct!");
						 UpdateUI();

					}
					else {
						JOptionPane.showMessageDialog(frame, "Wrong!");
					 UpdateUI();

					}
				}
			});
		 

			C.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (correctanswer.equals("C")) {

						JOptionPane.showMessageDialog(frame, "Correct!");
						 UpdateUI();

						
					}
					else {
						JOptionPane.showMessageDialog(frame, "Wrong!");
					 UpdateUI();


					}
				}
			});
		
			D.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (correctanswer.equals("D")) {

						JOptionPane.showMessageDialog(frame, "Correct!");
						 UpdateUI();

						
					}
					else {
						JOptionPane.showMessageDialog(frame, "Wrong!");
					 UpdateUI();


					}
				}
			});

				

	}

	
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(A.getText());
		System.out.println(B.getText());
		System.out.println(C.getText());

		System.out.println(D.getText());
		System.out.println("Clicked");
	}

	
	public void UpdateUI(){
		randomquestionID = t.getRandomNumber();
		qstion = t.getQuestion(randomquestionID);
		answera = t.getAnswerA(randomquestionID);
		answerb = t.getAnswerB(randomquestionID);
		answerc = t.getAnswerC(randomquestionID);
		answerd = t.getAnswerD(randomquestionID);
		correctanswer = t.getcorrectAnswer(randomquestionID);

		
	    label.setText(qstion);
		A.setText(answera);
		B.setText(answerb);
		C.setText(answerc);
		D.setText(answerd);
		
	}
	
	public static void main(String[] args) {
		GUItest a = new GUItest();
		a.createUI();

	}

}