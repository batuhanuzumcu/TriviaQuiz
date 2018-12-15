package TriviaQuiz_1;

import java.io.*;
import java.net.*;

class Clienttest {
	public static void main(String args[]) throws Exception {

		String answer;
		String returnedanswer;

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		Socket clientSocket = new Socket("192.168.1.11", 6789); // baglanacagın hostun ipsi ve port xdd
		System.out.println("You are connected! Welcome to our game!");
		System.out.println("Now you will a question on your screen. Please choose the correct answer: ");
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		String lel = inFromServer.readLine();
		System.out.println(lel);

		answer = inFromUser.readLine();
		outToServer.writeBytes(answer + '\n');
		returnedanswer = inFromServer.readLine();
		System.out.println(returnedanswer);
		clientSocket.close();

	}
}