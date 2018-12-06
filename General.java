package TriviaQuiz_1;
import java.util.*;

public class General {
	
	public static void Menu()
	{
		System.out.println("Welcome to our game: Can you become a millionaire! \n");
		System.out.println("In this game you will be asked 12 questions in total and you will be rewarded, ");
		System.out.println("with respect to the amount of questions you have done correctly.");
		System.out.println("After every 4 questions the difficulty will get harder, so be careful.");
		System.out.println("Also for the first 4 questions you get to choose the category. \n");
		System.out.print("The possible rewards for the question reached: \n 1st-100tl, 2nd-500tl, 3rd-1.000tl, ");
		System.out.print("4th-2.000tl, 5th-3.000tl, 6th-5.000tl, 7th-7.500tl,8th-15.000tl, \n 9th-30.000tl, 10th-60.000tl, ");
		System.out.println("11th-125.000tl, 12th-250.000tl,if you win 1.000.000tl");
		System.out.println("If you want to start a new game type in 1, if you want to quit the game type in 0: ");	
	}
	
	public static int[] pickNRandom(int[] array, int n) {

	    List<Integer> list = new ArrayList<Integer>(array.length);
	    for (int i : array)
	        list.add(i);
	    Collections.shuffle(list);

	    int[] answer = new int[n];
	    for (int i = 0; i < n; i++)
	        answer[i] = list.get(i);
	    Arrays.sort(answer);

	    return answer;
	}
	
public static double prize(int a) {
		
		int[] amount=new int[] {100,500,1000,2000,3000,5000,7500,15000,30000,60000,125000,250000,1000000};
		return amount[a-1];
	}

}
