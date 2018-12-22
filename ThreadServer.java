package TriviaQuiz_1;

import java.net.*;

import java.io.*;

class ThreadServer implements Runnable {
	private static BufferedReader inFromClient;
	private static PrintWriter serverPrintOut;
	private static boolean closed = false;
	
	private static TriviaDB app;
	static String sendnext;
	static String quest,aa,bb,cc,dd,correctcorrect;
	static int randomquestionID;

	  public static void getrandomvalues(int randomquestionlol) {
  		quest = app.getQuestion(randomquestionlol);
  		aa = app.getAnswerA(randomquestionlol);
  		bb = app.getAnswerB(randomquestionlol);
  		cc = app.getAnswerC(randomquestionlol);
  		dd = app.getAnswerD(randomquestionlol);
  		correctcorrect = app.getcorrectAnswer(randomquestionlol);
      }   
		public static void settoclient(){
			randomquestionID=app.getRandomNumber();
			getrandomvalues(randomquestionID);
			serverPrintOut.println(quest);
			serverPrintOut.println(aa);
			serverPrintOut.println(bb);
			serverPrintOut.println(cc);
			serverPrintOut.println(dd);
			serverPrintOut.println(correctcorrect);
		}

	public static void main(String args[]) throws Exception {
		app = new TriviaDB();
		ServerSocket ss = new ServerSocket(3333);
		Socket s = ss.accept();
		
		inFromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
		serverPrintOut = new PrintWriter(s.getOutputStream(), true);
        
		String clientSentence = "";
		new Thread(new ThreadServer()).start();
		//here we go :)
        settoclient();

		
		while (!clientSentence.equals("stop")) 
		{	
			
				settoclient();
			           
			//clientSentence = inFromClient.readLine();
			//serverPrintOut.flush();
		}
		System.out.println("closing");
		inFromClient.close();
		s.close();
		ss.close();
		closed = true;
		System.exit(0);
	}//end of main
	
	public void run() {

			/*
		 * Keep on reading from the socket till we receive "Bye" from the
		 * server. Once we received that then we want to break.
		 */
		
		//String responseLine;
		//try {
		//	System.out.println("Waiting");
		//	while ((responseLine = inFromClient.readLine()) != null) {
		//		System.out.println(responseLine);
		//		if (responseLine.indexOf("*** Bye") != -1)
		//   		break;
		//		if (closed)
		//			break;
		//	}
	//	} catch (IOException e) {
	//		System.err.println("IOException:  " + e);
	//	}
		
	
	}//end of run
}//end of class