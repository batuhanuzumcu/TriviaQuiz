package TriviaQuiz_1;

import java.net.*;
import java.io.*;

class ThreadServer implements Runnable {
	private static BufferedReader inFromClient;
	private static PrintWriter serverPrintOut;
	private static boolean closed = false;
	
	public static void main(String args[]) throws Exception {
		TriviaDB app = new TriviaDB();
		ServerSocket ss = new ServerSocket(3333);
		Socket s = ss.accept();
		
		inFromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
		serverPrintOut = new PrintWriter(s.getOutputStream(), true);
		
		String clientSentence = "";
		
		new Thread(new ThreadServer()).start();
		while (!clientSentence.equals("stop")) 
		{		
			int randomquestionID=app.getRandomNumber();		
			String qstion=app.getQuestion(randomquestionID);
			String answera=app.getAnswerA(randomquestionID);
			String answerb=app.getAnswerB(randomquestionID);
			String answerc=app.getAnswerC(randomquestionID);
			String answerd=app.getAnswerD(randomquestionID);
			serverPrintOut.println(qstion);
			serverPrintOut.println("A) "+answera);
			serverPrintOut.println("B) "+answerb);
			serverPrintOut.println("C) "+answerc);
			serverPrintOut.println("D) "+answerd);
			
			clientSentence = inFromClient.readLine();
			String correctanswer=app.getcorrectAnswer(randomquestionID);

			if(clientSentence.equals(correctanswer)){
				serverPrintOut.println("Congrats! You got the right answer which is: "+clientSentence);
			}
			else{
				serverPrintOut.println("Nope... The correct answer was: "+correctanswer);
			}
			serverPrintOut.flush();
		}
		
		System.out.println("closing");
		inFromClient.close();
		s.close();
		ss.close();
		closed = true;
		System.exit(0);
	}
	
	public void run() {
		/*
		 * Keep on reading from the socket till we receive "Bye" from the
		 * server. Once we received that then we want to break.
		 */
		String responseLine;
		try {
			System.out.println("Waiting");
			while ((responseLine = inFromClient.readLine()) != null) {
				System.out.println(responseLine);
				if (responseLine.indexOf("*** Bye") != -1)
					break;
				if (closed)
					break;
			}
		} catch (IOException e) {
			System.err.println("IOException:  " + e);
		}
	}
}