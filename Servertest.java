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

				
		String a=app.getQuestion();
		serverPrintOut.println(a);
	   
		
		clientSentence = inFromClient.readLine();
		serverPrintOut.println("you wrote: "+clientSentence);
    }
  }
}
