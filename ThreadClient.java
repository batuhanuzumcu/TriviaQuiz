package TriviaQuiz_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JOptionPane;
import java.awt.event.*;

public class ThreadClient implements Runnable {
	private static Socket clientSocket = null; // The client socket
	private static PrintWriter os = null; // The output stream
	private static BufferedReader inFromServer = null; // The input stream
	private static Scanner inputforIP = new Scanner(System.in); // to get connection IP from user

	//the values to enter for GUI.
	private static String question, ansA, ansB, ansC, ansD, correctans; 
	
	// General score is a player's overall score
	private int Generalscore = 0, questionsanswered = 0;
															
	private static int questionscore; // value of a single question (varies from question)

	
	// function to get the next question's values from server
	public static void getfromserver() throws IOException {
		question = inFromServer.readLine();
		ansA = inFromServer.readLine();
		ansB = inFromServer.readLine();
		ansC = inFromServer.readLine();
		ansD = inFromServer.readLine();
		correctans = inFromServer.readLine();
		questionscore = Integer.parseInt((inFromServer.readLine()));
	}// end of getfromserver

	public static void main(String[] args) {
		int portNumber = 3333;
		String host = "localhost";

		
		System.out.print("Hello! Please enter the ip of the host: ");
		host = inputforIP.nextLine();
		System.out.println("");

		
		// Open a socket on a given host and port. Open input and output streams
		try {
			clientSocket = new Socket(host, portNumber);
			inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			os = new PrintWriter(clientSocket.getOutputStream(), true);
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + host);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to the host " + host);
		}

		if (clientSocket != null && os != null && inFromServer != null) {
			// time to start the thread
			new Thread(new ThreadClient()).start();
		}

	}// end of main

	@Override
	public void run() {
		try {
			getfromserver(); // get the first question for GUI
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		ClientGUI alpha = new ClientGUI(); // initialize GUI
		alpha.SetGUI(question, ansA, ansB, ansC, ansD, correctans, Generalscore); //set the first question data for GUI																				

		JOptionPane.showMessageDialog(alpha.frame,
	"Welcome to the game! Out of 10 questions, \n Please choose the correct answers to get the most score.");

		
		// we add action listeners to buttons to calculate points and get next question.

		
		alpha.A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (alpha.correctanswer.equals("A")) {
					JOptionPane.showMessageDialog(alpha.frame, "Correct! Onto the next question.");
					try {
						questionsanswered++;
						Generalscore += questionscore;

						if (questionsanswered == 10) {
							os.println(Generalscore);
							JOptionPane.showMessageDialog(alpha.frame, "It's over! now let's wait for other players.");
							System.exit(0);
						} // end of inner if
						else {
							getfromserver();
							alpha.SetGUI(question, ansA, ansB, ansC, ansD, correctans, Generalscore);
						} // end of inner else
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} // end of outer if

				else {
					JOptionPane.showMessageDialog(alpha.frame, "Wrong! Onto the next question.");
					try {
						questionsanswered++;

						if (questionsanswered == 10) {
							os.println(Generalscore);
							JOptionPane.showMessageDialog(alpha.frame, "It's over! now let's wait for other players.");
							System.exit(0);
						} // end of inner if
						else {
							getfromserver();
							alpha.SetGUI(question, ansA, ansB, ansC, ansD, correctans, Generalscore);
						} // end of inner else
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} // end of outer else

			}
		});

		// the other action listeners are added in the same pattern.

		alpha.B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (alpha.correctanswer.equals("B")) {
					JOptionPane.showMessageDialog(alpha.frame, "Correct! Onto the next question.");
					try {
						questionsanswered++;
						Generalscore += questionscore;

						if (questionsanswered == 10) {
							os.println(Generalscore);
							JOptionPane.showMessageDialog(alpha.frame, "It's over! now let's wait for other players.");
							System.exit(0);
						} // end of inner if
						else {
							getfromserver();
							alpha.SetGUI(question, ansA, ansB, ansC, ansD, correctans, Generalscore);
						} // end of inner else
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} // end of outer if

				else {
					JOptionPane.showMessageDialog(alpha.frame, "Wrong! Onto the next question.");
					try {
						questionsanswered++;

						if (questionsanswered == 10) {
							os.println(Generalscore);
							JOptionPane.showMessageDialog(alpha.frame, "It's over! now let's wait for other players.");
							System.exit(0);
						} // end of inner if
						else {
							getfromserver();
							alpha.SetGUI(question, ansA, ansB, ansC, ansD, correctans, Generalscore);
						} // end of inner else
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} // end of outer else

			}
		});

		alpha.C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (alpha.correctanswer.equals("C")) {
					JOptionPane.showMessageDialog(alpha.frame, "Correct! Onto the next question.");
					try {
						questionsanswered++;
						Generalscore += questionscore;

						if (questionsanswered == 10) {
							os.println(Generalscore);
							JOptionPane.showMessageDialog(alpha.frame, "It's over! now let's wait for other players.");
							System.exit(0);
						}// end of inner if 
						else {
							getfromserver();
							alpha.SetGUI(question, ansA, ansB, ansC, ansD, correctans, Generalscore);
						}// end of inner else
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} // end of outer if

				else {
					JOptionPane.showMessageDialog(alpha.frame, "Wrong! Onto the next question.");
					try {
						questionsanswered++;

						if (questionsanswered == 10) {
							os.println(Generalscore);
							JOptionPane.showMessageDialog(alpha.frame, "It's over! now let's wait for other players.");
							System.exit(0);
						}// end of inner if 
						else {
							getfromserver();
							alpha.SetGUI(question, ansA, ansB, ansC, ansD, correctans, Generalscore);
						}// end of inner else
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} // end of outer else

			}
		});

		alpha.D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (alpha.correctanswer.equals("D")) {
					JOptionPane.showMessageDialog(alpha.frame, "Correct! Onto the next question.");
					try {
						questionsanswered++;
						Generalscore += questionscore;

						if (questionsanswered == 10) {
							os.println(Generalscore);
							JOptionPane.showMessageDialog(alpha.frame, "It's over! now let's wait for other players.");
							System.exit(0);
						} // end of inner if
						else {
							getfromserver();
							alpha.SetGUI(question, ansA, ansB, ansC, ansD, correctans, Generalscore);
						} // end of inner else
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} // end of outer if

				else {
					JOptionPane.showMessageDialog(alpha.frame, "Wrong! Onto the next question.");
					try {
						questionsanswered++;

						if (questionsanswered == 10) {
							os.println(Generalscore);
							JOptionPane.showMessageDialog(alpha.frame, "It's over! now let's wait for other players.");
							System.exit(0);
						} //end of inner if
						else {
							getfromserver();
							alpha.SetGUI(question, ansA, ansB, ansC, ansD, correctans, Generalscore);
						}//end of inner else
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} // end of outer else

			}
		});

	}// end of run

}// end of class
