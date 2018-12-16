package TriviaQuiz_1;
import java.io.*;
import java.net.*; 

public class Servertest {

	public static void main(String args[]) throws Exception{
	
		String clientSentence;
	
	ServerSocket welcomeSocket = new ServerSocket(6789);
	
	while(true) 
	{
		TriviaDB app = new TriviaDB();
		Socket connectionSocket = welcomeSocket.accept();
		
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 
		DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        PrintWriter serverPrintOut = new PrintWriter(new OutputStreamWriter(outToClient, "UTF-8"), true);

		
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
    }
  }
}
