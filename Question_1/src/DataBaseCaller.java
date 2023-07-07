import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class DataBaseCaller {
	private static HashMap<Long, String> phBook=new HashMap<>();
	private static LinkedList<MissedCallDetails> miss=new LinkedList<>();
	static Scanner sc=new Scanner(System.in);
	static
	{	//Some default values in Phone book
		phBook.put(6872687216l, "Person 1");
		phBook.put(6515466854l, "Person 2");
		phBook.put(6125411354l, "Person 3");
		phBook.put(6515141545l, "Person 4");
	}
	public static void addNewContact()
	{
		System.out.println("Enter  ph no");
		long phno=sc.nextLong();
		System.out.println("Enter name");
		String name=sc.nextLine();
		name+=sc.nextLine();
		System.out.println("Adding new Contact...");
		if(phBook.put(phno, name)!=null)
			System.out.println("CONTACT ALREADY EXSISTS.....Renaming existing contact");
	}
	public static void displayPhoneBook() 
	{
		System.out.println("\n()()()()()()()()Phone book()()()()()()()()()");
		System.out.printf("| %-15s | %-12s |%n","Name","Phno");
		for (Map.Entry<Long,String> i : phBook.entrySet())
			System.out.printf("| %-15s | %-12s |%n",i.getValue(),i.getKey());
	}
	public static void deleteContact()
	{
		System.out.println("Enter phone number to delete");
		long phno=sc.nextLong();
		if(phBook.remove(phno)==null)
			System.out.println("NO SUCH NUMBER");
		else
			System.out.println("Removing.........done");
	}
	public static void addMissedCall()
	{
		System.out.println("Enter missed call number");
		long phno=sc.nextLong();
		Calendar cal=Calendar.getInstance();
		miss.addFirst(new MissedCallDetails(cal, phno));
	}
	public static void displayMissedCalls()
	{	
		for(MissedCallDetails i:miss)
		{
			String name=phBook.get(i.phno);
			if(name==null)name="Private Caller";
			System.out.println("\nName:"+name+"\tPhNO:"+i.phno+"\tTime:"+i.cal.getTime());
		}
	}
}