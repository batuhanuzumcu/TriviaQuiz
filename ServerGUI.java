package TriviaQuiz_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ServerGUI  extends JFrame implements ActionListener {
	JFrame frame;
	JLabel label1,label2,label3,label4, labelwinner; //where score's and the winner will be shown
	JButton Quit;  // quit button to exit
	
	
	public ServerGUI(String score1,String score2,String score3,String score4, String winner){
		
		frame = new JFrame("Score Table");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		label1 = new JLabel("Player 1's Score: "+score1);
		label1.setBounds(150, 30, 500, 60);
		label1.setLayout(new FlowLayout());
		label1.setForeground(Color.BLACK);
		label1.setFont(new Font(score1, Font.CENTER_BASELINE, 18));
		frame.add(label1);
		
		label2 = new JLabel("Player 2's Score: "+score2);
		label2.setBounds(150, 90, 500, 60);
		label2.setLayout(new FlowLayout());
		label2.setForeground(Color.BLACK);
		label2.setFont(new Font(score2, Font.CENTER_BASELINE, 18));
		frame.add(label2);
		
		label3 = new JLabel("Player 3's Score: "+score3);
		label3.setBounds(150, 150, 500, 60);
		label3.setLayout(new FlowLayout());
		label3.setForeground(Color.BLACK);
		label3.setFont(new Font(score3, Font.CENTER_BASELINE, 18));
		frame.add(label3);
		
		label4 = new JLabel("Player 4's Score: "+score4);
		label4.setBounds(150, 210, 500, 60);
		label4.setLayout(new FlowLayout());
		label4.setForeground(Color.BLACK);
		label4.setFont(new Font(score4, Font.CENTER_BASELINE, 18));
		frame.add(label4);
		
		labelwinner = new JLabel(winner);
		labelwinner.setBounds(150, 270, 500, 60);
		labelwinner.setLayout(new FlowLayout());
		labelwinner.setForeground(Color.BLACK);
		labelwinner.setFont(new Font(score4, Font.CENTER_BASELINE, 18));
		frame.add(labelwinner);
		
		Quit = new JButton("Exit");
		Quit.setBounds(150, 330, 100, 40);
		Quit.addActionListener(this);
		frame.add(Quit);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setSize(width / 2, height / 2);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}
}
