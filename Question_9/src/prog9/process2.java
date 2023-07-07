package prog9;
import java.util.*;
public class process2 extends Thread {
	public static String digits[]= {"zero","one","two","three","four","five","six","seven","eight","nine"};
	public String number;
	public void run()
	{
		Scanner read=new Scanner(System.in);
		System.out.println("Enter more then 4 digits number:");
		number=read.next();
		for(char ch: number.toCharArray() )
		{   
			int i=(int)ch-48;
			System.out.print("  "+digits[i]);
		}
	}
}
