package TriviaQuiz_1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ThreadClient implements Runnable {
	private static Socket clientSocket = null; // The client socket
	private static PrintWriter os = null; // The output stream
	private static BufferedReader inFromServer = null; // The input stream
	private static BufferedReader inFromUser = null;
	private static DataOutputStream outToServer = null;


	private static boolean closed = false;

	public static void main(String[] args) {
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
				System.out.println("You are connected! Welcome to our game!");
				System.out.println("Now you will see a question on your screen. Please choose the correct answer: ");
				while (!closed) {
					String answer = inFromUser.readLine();
					outToServer.writeBytes(answer+'\n');
					os.println(answer+'\n');
					
					//String str = inFromUser.readLine().trim();
					//System.out.println(str);
					//outToServer.println(str);
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
		String responseLine;
		try {
			while ((responseLine = inFromServer.readLine()) != null) {
				System.out.println(responseLine);
				if (responseLine.indexOf("*** Bye") != -1)
					break;
			}
			closed = true;
			System.out.println("Closing....");
		} catch (IOException e) {
			System.err.println("IOException:  " + e);
		}
	}
}