package TriviaQuiz_1;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

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
    
	public GUItest(){
		frame = new JFrame("Trivia Quiz");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		

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
								
		}

	public void actionPerformed(ActionEvent e) {
		System.out.println("button pressed");
	}
	
	public void SetGUI(String quesstion,String a,String b,String c,String d,String corrrect){
	    label.setText(quesstion);
		A.setText(a);
		B.setText(b);
		C.setText(c);
		D.setText(d);
		correctanswer=corrrect;
		
	}
}