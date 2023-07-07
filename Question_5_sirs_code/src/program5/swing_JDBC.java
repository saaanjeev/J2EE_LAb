package program5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;


public class swing_JDBC extends JFrame{
    
	JLabel clabel=new JLabel("CUSTOMER INFORMATION");
	JLabel clabel1=new JLabel("CustNo");
	JLabel clabel2=new JLabel("CustName");
	JLabel clabel3=new JLabel("State");
	JLabel clabel4=new JLabel("Credit_Limit");
	JLabel clabel5=new JLabel("RepNo");
	JTextField ctext1=new JTextField(20);
	JTextField ctext2=new JTextField(20);
	JTextField ctext3=new JTextField(20);
	JTextField ctext4=new JTextField(20);
	JTextField ctext5=new JTextField(20);
	JButton button2=new JButton("Submit");
	
	JLabel xlabel=new JLabel("Customer information when Credit_Limit>15000");
	JButton button3=new JButton("Submit");
	JTextArea display=new JTextArea();
	JPanel panel=new JPanel();
	
	swing_JDBC()
	{
		super("DATA BASE FRAME");
	}
	
	void method2()
	 {	
		panel.add(clabel);
		panel.add(clabel1);
		panel.add(ctext1);
		panel.add(clabel2);
		panel.add(ctext2);
		panel.add(clabel3);
		panel.add(ctext3);
		panel.add(clabel4);
		panel.add(ctext4);
		panel.add(clabel5);
		panel.add(ctext5);
		
		panel.add(button2);
		button2.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
						Class.forName("com.mysql.cj.jdbc.Driver");					
						String url = "jdbc:mysql://localhost:3306/program5";
						String username = "root";
						String password = "1234";
						Connection con = DriverManager.getConnection(url, username, password);
						if (con != null) 
						{
							System.out.println("Database Connected successfully");
						}
						else
						{
				
							System.out.println("Database Connection failed");
						}		
						Statement stm= con.createStatement();
						ResultSet rs1= stm.executeQuery("select * from Customer ");
						show2(rs1);
						String a=ctext1.getText();
						String b=ctext2.getText();
						String c=ctext3.getText();
						
						String d=ctext4.getText();
						String x=ctext5.getText(); 
						//int d=Integer.parseInt(ctext4.getText());
						//int x=Integer.parseInt(ctext5.getText()); 
						String q1="insert into Customer values("+a+",'"+b+"','"+c+"',"+d+","+x+")";
						stm.executeUpdate(q1);				 						
						ResultSet rs2= stm.executeQuery("select * from Customer ");
						show2(rs2);			
								
				 }
				catch(Exception ex)
				{
					System.out.println(ex.getStackTrace());
				}
			}
			
		});
		//setContentPane(panel);
	 }
	void method3()
	{
		
		panel.add(xlabel);
		panel.add(button3);
		panel.add(display);
		
		button3.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");					
					String url = "jdbc:mysql://localhost:3306/program5";
					String username = "root";
					String password = "1234";
					Connection con = DriverManager.getConnection(url, username, password);
					if (con != null) 
					{
						System.out.println("Database Connected successfully");
					}
					else
					{

						System.out.println("Database Connection failed");
					}		
					Statement stm= con.createStatement();					
					ResultSet rs3= stm.executeQuery("select * from Customer where Credit_Limit>15000");
					show2(rs3);
					
				}
				catch(Exception ex)
				{
					System.out.println(ex.getStackTrace());
				}
			}
		});	
		setContentPane(panel);
	}
	
	void show2(ResultSet rs)
	{
		display.setText(null);
		display.append("CustNo \t CustName \t State \t Credit_Limit \t RepNo \n");
		try
		{
			while(rs.next())
			{
				display.append(rs.getString("CustNo"));
				display.append("\t");
				display.append(rs.getString("CustName"));
				display.append("\t");
				display.append(rs.getString("State"));
				display.append("\t");
				display.append(rs.getString("Credit_Limit"));
				display.append("\t");
				display.append(rs.getString("RepNo"));
				display.append("\n");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getStackTrace());
		}
	}
	public static void main(String[] args) throws Exception 
	{
		
		swing_JDBC ob=new swing_JDBC();
		ob.method2();
		ob.method3();
		ob.getContentPane().setLayout(new BoxLayout(ob.getContentPane(),BoxLayout.Y_AXIS));
		ob.setVisible(true);
		ob.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ob.pack();
		
		
	}
}