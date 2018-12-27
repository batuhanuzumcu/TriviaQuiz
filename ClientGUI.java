package TriviaQuiz_1;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ClientGUI extends JFrame implements ActionListener {

	JFrame frame;
	JLabel label1,label2; //first for question, second for score
	JButton A, B, C, D;
	
	int randomquestionID;
	String qstion;
	String answera;
	String answerb;
	String answerc;
	String answerd;
    String correctanswer;
	String TotalScore;

    
	public ClientGUI(){
		
		frame = new JFrame("Trivia Quiz");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		

		label1 = new JLabel(qstion);
		label1.setBounds(70, 50, 1200, 60);
		label1.setLayout(new FlowLayout());
		label1.setForeground(Color.BLACK);
		label1.setFont(new Font(qstion, Font.CENTER_BASELINE, 18));
		frame.add(label1);
		
		label2 = new JLabel(TotalScore);
		label2.setBounds(20, 10, 300, 50);
		label2.setLayout(new FlowLayout());
		label2.setForeground(Color.BLACK);
		label2.setFont(new Font(TotalScore, Font.CENTER_BASELINE, 18));
		frame.add(label2);

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
								
		}

	public void actionPerformed(ActionEvent e) {

	}
	
	//set the new questions values
	public void SetGUI(String quesstion,String a,String b,String c,String d,String corrrect,int MyScore){
	    label1.setText(quesstion);
	    label2.setText("Score: "+String.valueOf(MyScore));
		A.setText(a);
		B.setText(b);
		C.setText(c);
		D.setText(d);
		correctanswer=corrrect;
		
	}
}