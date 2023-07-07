package q3;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class StudentInformationApp implements ActionListener  {
	
	static JFrame jf=new JFrame("Student InfoSys");
	static JTextField name = new JTextField(20);
	static JTextField usn = new JTextField(20);
	static JTextField age = new JTextField(5);
	static JTextField address = new JTextField(50);
	static JTextField cat = new JTextField(10);
	static JTextField sg[]=new JTextField[8];
	static JButton submit=new JButton("Submit");
	static JButton done=new JButton("Done");
	static JButton display=new JButton("Display");
	
	static ArrayList<Student> studs= new ArrayList<>();

	public static void main(String[] args) {
		jf.setSize(800,600);
		jf.setLayout(new FlowLayout());
		
		
		jf.add(new JLabel("Enter name:"));
		jf.add(name);
		jf.add(new JLabel("Enter usn:"));
		jf.add(usn);
		jf.add(new JLabel("Enter age:"));
		jf.add(age);
		jf.add(new JLabel("Enter address:"));
		jf.add(address);
		jf.add(new JLabel("Enter category:"));
		jf.add(cat);
		for (int i = 0; i < sg.length; i++) {
			sg[i]=new JTextField(5);
			jf.add(new JLabel("SGPA "+(i+1)));
			jf.add(sg[i]);
		}
		jf.add(submit);
		jf.add(done);
		jf.add(display);
		submit.addActionListener(new StudentInformationApp());
		done.addActionListener(new StudentInformationApp());
		display.addActionListener(new StudentInformationApp());
		jf.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit)
		{
			int a=Integer.parseInt(age.getText());
			if(18>a||a>30)
			{
				System.out.println("Invalide age");
				String temp=JOptionPane.showInputDialog(null,"Enter valid age 18 to 30=");
				age.setText(temp);
			}
			else
			{
				System.out.println("Valide age");
				System.out.println("Its working");
			}
			
		}
		if(e.getSource()==done)
		{
			double sgpa[]=new double[8];
			
			for (int i = 0; i < sgpa.length; i++) {
				sgpa[i]=Double.parseDouble(sg[i].getText());
			}
			double cgpa = Arrays.stream(sgpa).sum()/8.0;
			System.out.println(sg[0].getText());
			studs.add(new Student(name.getText(), usn.getText(), address.getText(), cat.getText(), age.getText(), sgpa, cgpa));
		}
		if(e.getSource()==display)
		{
			jf.setVisible(false);
			JFrame da=new JFrame("All Students");
			da.setSize(800,600);
			da.setVisible(true);
			JTextArea info=new JTextArea(50,50);
			da.add(info);
			for (Student i : studs) {
				info.append(i.toString()+"\n");
			}
			
		}
		
	}
	

}
