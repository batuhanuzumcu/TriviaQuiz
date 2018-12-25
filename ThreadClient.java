package TriviaQuiz_1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
//import java.util.concurrent.CountDownLatch;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;

public class ThreadClient implements Runnable {
	private static Socket clientSocket = null; // The client socket
	private static PrintWriter os = null; // The output stream
	private static BufferedReader inFromServer = null; // The input stream
	private static BufferedReader inFromUser = null;
	private static DataOutputStream outToServer = null;
	
   
	private static String questioon,ansa,ansb,ansc,ansd,correctans;	
	
	public static synchronized void getfromserver() throws IOException {
		questioon=inFromServer.readLine();
		System.out.println(questioon);
		ansa=inFromServer.readLine();
		System.out.println(ansa);
		ansb=inFromServer.readLine();
		System.out.println(ansb);
		ansc=inFromServer.readLine();
		System.out.println(ansc);
		ansd=inFromServer.readLine();
		System.out.println(ansd);
		correctans=inFromServer.readLine();
		System.out.println(correctans);
	}
	
	public static void main(String[] args) {
		int portNumber = 3333;
		String host = "localhost";

		// Open a socket on a given host and port. Open input and output streams.
		try {
			clientSocket = new Socket(host, portNumber);
			inFromUser = new BufferedReader(new InputStreamReader(System.in));
			inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			os = new PrintWriter(clientSocket.getOutputStream(), true); 
			outToServer = new DataOutputStream(clientSocket.getOutputStream());
			
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + host);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to the host " + host);
		}
		//buraya kadar np sonrasinda thread yaratimi ve managementi var.
		
		if (clientSocket != null && os != null && inFromServer != null) {
			new Thread(new ThreadClient()).start();				
		}
	}//end of main
	@Override
	public void run() {		
		try {
			getfromserver();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 
		GUItest alpha = new GUItest();
		alpha.SetGUI(questioon, ansa, ansb, ansc, ansd, correctans);
		//JOptionPane.showMessageDialog(alpha.frame, "Welcome to the game! Please Wait for others to connect.");

		if (alpha.correctanswer.equals("A")) {
			alpha.A.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//JOptionPane.showMessageDialog(alpha.frame, "Correct! Wait for other players.")
						try {
							os.println("waiting");
							getfromserver();
							alpha.SetGUI(questioon, ansa, ansb, ansc, ansd, correctans);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 				
				}
			});
		}
		else{
			alpha.A.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//JOptionPane.showMessageDialog(alpha.frame, "Wrong! Wait for other players.")
						try {
							os.println("waiting");
							getfromserver();
							alpha.SetGUI(questioon, ansa, ansb, ansc, ansd, correctans);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 				
				}
			});
		}
		
		if (alpha.correctanswer.equals("B")) {
			alpha.B.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//JOptionPane.showMessageDialog(alpha.frame, "Correct! Wait for other players.")
						try {
							os.println("waiting");
							getfromserver();
							alpha.SetGUI(questioon, ansa, ansb, ansc, ansd, correctans);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 				
				}
			});
		}
		else{
			alpha.B.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//JOptionPane.showMessageDialog(alpha.frame, "Wrong! Wait for other players.")
						try {
							os.println("waiting");
							getfromserver();
							alpha.SetGUI(questioon, ansa, ansb, ansc, ansd, correctans);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 				
				}
			});
		}
		
		if (alpha.correctanswer.equals("C")) {
			alpha.C.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//JOptionPane.showMessageDialog(alpha.frame, "Correct! Wait for other players.")
						try {
							os.println("waiting");
							getfromserver();
							alpha.SetGUI(questioon, ansa, ansb, ansc, ansd, correctans);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 				
				}
			});
		}
		else{
			alpha.C.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//JOptionPane.showMessageDialog(alpha.frame, "Wrong! Wait for other players.")
						try {
							os.println("ready");
							getfromserver();
							alpha.SetGUI(questioon, ansa, ansb, ansc, ansd, correctans);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 				
				}
			});
		}
		
		
		if (alpha.correctanswer.equals("D")) {
			alpha.D.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//JOptionPane.showMessageDialog(alpha.frame, "Correct! Wait for other players.")
						try {
							os.println("waiting");
							getfromserver();
							alpha.SetGUI(questioon, ansa, ansb, ansc, ansd, correctans);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 				
				}
			});
		}
		else{
			alpha.D.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//JOptionPane.showMessageDialog(alpha.frame, "Wrong! Wait for other players.")
						try {
							os.println("waiting");
							getfromserver();
							alpha.SetGUI(questioon, ansa, ansb, ansc, ansd, correctans);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 				
				}
			});
		}
				
	}//end of run
	
}//end of class
