package TriviaQuiz_1;

import java.net.*;
import java.io.*;

class ThreadServer extends Thread implements Runnable {

	static BufferedReader inFromClient;
	static PrintWriter serverPrintOut;

	private static TriviaDB app; // our Database
	
	static String Question, AnswerA, AnswerB, AnswerC, AnswerD, correctAnswer, scorevalue;
	
	static int randomquestionID, connectionnumber,score;
	
	static int[] IDarray = new int[10]; // to keep 10 random question ID's to be
										// asked for a game.
	
	static int[] playerscore = new int[4]; // to collect players scores at the
											// end of the game.
	
	static ThreadServer[] threads = new ThreadServer[4]; //to collect threads
	
	static int currentquestion = 1, playersfinished = 0;
	
	Socket socket;

	// constructor for server
	public ThreadServer(Socket s) {
		socket = s;
		score = 0;
		try {
			inFromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			serverPrintOut = new PrintWriter(s.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	// function used to get the values from database and set them using their
	// ID in the database as parameter.
	public static void getvalues(int questionID) {
		Question = app.getQuestion(questionID);
		AnswerA = app.getAnswerA(questionID);
		AnswerB = app.getAnswerB(questionID);
		AnswerC = app.getAnswerC(questionID);
		AnswerD = app.getAnswerD(questionID);
		correctAnswer = app.getcorrectAnswer(questionID);
		scorevalue = app.getQuestionScore(questionID);
	}

	
	// function used to call getvalues and then send the data taken from it to clients.
		public synchronized static void settoclient(int fixedquestionID) {
		getvalues(fixedquestionID);
		serverPrintOut.println(Question);
		serverPrintOut.println(AnswerA);
		serverPrintOut.println(AnswerB);
		serverPrintOut.println(AnswerC);
		serverPrintOut.println(AnswerD);
		serverPrintOut.println(correctAnswer);
		serverPrintOut.println(scorevalue);
	}
		

	public static void main(String args[]) throws Exception {
		
		app = new TriviaDB(); // Database initialization

		// taking 10 random questions to ask from database for this game.
		for (int count = 0; count < IDarray.length; count++) {
			
			randomquestionID = app.getRandomNumber();
			IDarray[count] = randomquestionID = app.getRandomNumber();
			
			//to prevent duplicate entry in a row.
			if(count>=1 && IDarray[count]==IDarray[count-1]){
				IDarray[count] = randomquestionID = app.getRandomNumber();
			}
		}

		ServerSocket ss = new ServerSocket(3333);

		for (connectionnumber = 0; connectionnumber < 4; connectionnumber++) {
			Socket s = null;
			try {
				s = ss.accept();
				System.out.println("A new client is connected : " + s);
			} catch (IOException e) {
				throw new RuntimeException("Error accepting client connection", e);
			}
			System.out.println("Assigning new thread for this client");

			threads[connectionnumber] = new ThreadServer(s);
			threads[connectionnumber].start();

		} // end of connection number for loop

	}// end of main

	
	@Override
	public void run() {
		// send 10 questions to client
		for (currentquestion = 0; currentquestion < 10; currentquestion++) {
			settoclient(IDarray[currentquestion]);
		}
		
		if (currentquestion == 10) {
			try {
				// take the score from a finished player.
				score = Integer.parseInt(inFromClient.readLine());
				playerscore[playersfinished] = score;
				playersfinished++;
				System.out.println("Waiting for "+(4-playersfinished)+" more player(s) to finish");
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("The player's score is: " + score);
			
			if (playersfinished == 4) {
				System.out.println("game finished! time to see the scores.");
				int max = 0, bestplayer = 0;
				for (int playernum = 0; playernum < 4; playernum++) {
					if (max < playerscore[playernum]) {
						max = playerscore[playernum];
						bestplayer = playernum;
					}
				}
				//initialize the end game table for scores and winner.
				ServerGUI results = new ServerGUI(String.valueOf(playerscore[0]), String.valueOf(playerscore[1]),String.valueOf(playerscore[2]), String.valueOf(playerscore[3]),("The winner is player" + (bestplayer + 1) + " with score: " + max));

			}
		}
	}// end of run

}// end of class
