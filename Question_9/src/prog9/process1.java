package prog9;
import java.util.*;
public class process1 extends Thread {
	public String word;
	public static String vowels="aeiou";
	public void run()
	{
		Scanner read=new Scanner(System.in);
		System.out.println("Enter word");
		word=read.next();
		int count=0;
		for(char item1: vowels.toCharArray())
		{
			for(char item2: word.toCharArray())
			{
				if(item1==item2)    count++;
			}
		}
		System.out.println("Number of vowels given word="+count);
	}
}
