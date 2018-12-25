package TriviaQuiz_1;

import java.net.*;
import java.io.*;

class ThreadServer implements Runnable {
	static BufferedReader inFromClient;
	static PrintWriter serverPrintOut;
	
	private static TriviaDB app;
	static String quest,aa,bb,cc,dd,correctcorrect;
	static int randomquestionID,connectionnumber;
	static String SendNextQuestion;
	static int[] IDarray = new int[10];
	//static Thread[] threads = new Thread[4];
	static int waitingcounter=0;

    
	  public static void getrandomvalues(int randomquestionlol) {
  		quest = app.getQuestion(randomquestionlol);
  		aa = app.getAnswerA(randomquestionlol);
  		bb = app.getAnswerB(randomquestionlol);
  		cc = app.getAnswerC(randomquestionlol);
  		dd = app.getAnswerD(randomquestionlol);
  		correctcorrect = app.getcorrectAnswer(randomquestionlol);
      }   

		public static synchronized void settoclient(int fixedquestionID){
			//randomquestionID=app.getRandomNumber();
			//getrandomvalues(randomquestionID);
			getrandomvalues(fixedquestionID);
			serverPrintOut.println(quest);
			serverPrintOut.println(aa);
			serverPrintOut.println(bb);
			serverPrintOut.println(cc);
			serverPrintOut.println(dd);
			serverPrintOut.println(correctcorrect);
		}
		public synchronized int sendnextquestion(int x){
			try {
				SendNextQuestion=inFromClient.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(SendNextQuestion.equals("waiting")){
				waitingcounter++;
				if(waitingcounter==4){
					settoclient(IDarray[x]);
					waitingcounter=0;
					return x+1;
				}
			}
			return 0;
		}

	public static void main(String args[]) throws Exception {
		app = new TriviaDB();
		
		for(int count=0;count<IDarray.length;count++){
			randomquestionID=app.getRandomNumber();
             IDarray[count]=randomquestionID=app.getRandomNumber();
		}
		
		ServerSocket ss = new ServerSocket(3333);		
		
		for (connectionnumber=0;connectionnumber<4;connectionnumber++) {	
			Socket s = null;
	        try {
	            s = ss.accept();
	            System.out.println("A new client is connected : " + s);
	             // obtaining input and out streams 
	            inFromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
	    		serverPrintOut = new PrintWriter(s.getOutputStream(), true);
	            
	            System.out.println("Assigning new thread for this client"); 
	             
	             } catch (IOException e) {
	            throw new RuntimeException("Error accepting client connection", e);
	        }    
	        new Thread(new ThreadServer()).start();
	        //threads[connectionnumber] = new Thread(new ThreadServer());	  
	        //threads[connectionnumber].start();
		}//end of for loop

		
	}//end of main
	@Override
	public void run() {
		settoclient(IDarray[0]);
		int i=1;
		while(true){
		int trying=sendnextquestion(i);
		if(trying>i){
			i++;
		}
		if(i==10){
			break;
		}
			
			break;
		}//end of for loop
		System.out.println("10 questions asked.Ending...");
	}//end of run
	
}//end of class
