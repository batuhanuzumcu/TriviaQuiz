package TriviaQuiz_1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.*;
import javax.swing.*;

public class ThreadClient implements Runnable {
	private static Socket clientSocket = null; // The client socket
	private static PrintWriter os = null; // The output stream
	private static BufferedReader inFromServer = null; // The input stream
	private static BufferedReader inFromUser = null;
	private static DataOutputStream outToServer = null;

	private static boolean closed = false;
	private static String questioon,ansa,ansb,ansc,ansd,correctans;
	
	public static void getfromserver() throws IOException {
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
	
	public static void main(String[] args) throws ClassNotFoundException {
		int portNumber = 3333;
		String host = "192.168.1.11";

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

		/*
		 * If everything has been initialized then we want to write some data to
		 * the socket we have opened a connection to on the port portNumber.
		 */
		//buraya kadar np sonrasinda thread yaratimi ve managementi var.
		
		
		
		
		
		if (clientSocket != null && os != null && inFromServer != null) {
			try {		
				/* Create a thread to read from the server. */
				new Thread(new ThreadClient()).start();
				//here we go boii :)
				
			    getfromserver();
				GUItest alpha = new GUItest();
				alpha.SetGUI(questioon, ansa, ansb, ansc, ansd, correctans);
				alpha.A.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (alpha.correctanswer.equals("A")) {

							JOptionPane.showMessageDialog(alpha.frame, "Correct!");
							
							try {
								getfromserver();
								alpha.SetGUI(questioon, ansa, ansb, ansc, ansd, correctans);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else {
							JOptionPane.showMessageDialog(alpha.frame, "Wrong!");
							
					    try {
							getfromserver();
							alpha.SetGUI(questioon, ansa, ansb, ansc, ansd, correctans);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						}
					}
				});
				
				alpha.B.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (alpha.correctanswer.equals("B")) {

							JOptionPane.showMessageDialog(alpha.frame, "Correct!");
								
							try {
								getfromserver();
								alpha.SetGUI(questioon, ansa, ansb, ansc, ansd, correctans);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else {
							JOptionPane.showMessageDialog(alpha.frame, "Wrong!");
							
							try {
								getfromserver();
								alpha.SetGUI(questioon, ansa, ansb, ansc, ansd, correctans);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}
					}
				});
				
				alpha.C.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (alpha.correctanswer.equals("C")) {

							JOptionPane.showMessageDialog(alpha.frame, "Correct!");
							
							try {
								getfromserver();
								alpha.SetGUI(questioon, ansa, ansb, ansc, ansd, correctans);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}
						else {
							JOptionPane.showMessageDialog(alpha.frame, "Wrong!");
							
							try {
								getfromserver();
								alpha.SetGUI(questioon, ansa, ansb, ansc, ansd, correctans);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}
					}
				});
				
				alpha.D.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (alpha.correctanswer.equals("D")) {

							JOptionPane.showMessageDialog(alpha.frame, "Correct!");
							
							try {
								getfromserver();
								alpha.SetGUI(questioon, ansa, ansb, ansc, ansd, correctans);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}
						else {
							JOptionPane.showMessageDialog(alpha.frame, "Wrong!");
							
							try {
								getfromserver();
								alpha.SetGUI(questioon, ansa, ansb, ansc, ansd, correctans);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}
					}
				});
						
				while (!closed) {						
					//String answer = inFromUser.readLine();
					//outToServer.writeBytes(answer+'\n');
					//os.println(answer+'\n');													
				}
				// Close the output stream, close the input stream, close the socket
				os.close();
				inFromServer.close();
				outToServer.close();
				clientSocket.close();
			} catch (IOException e) {
				System.err.println("IOException:  " + e);
			}
		}
	}

	// Create a thread to read from the server. 
	public void run() {
		// Keep on reading from the socket till we receive "Bye" from the
		// server. Once we received that then we want to break.
		//bu rundaki son commentleri salla su an run bos kalcak xddd
		
	}
}