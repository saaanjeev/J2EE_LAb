import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class backend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public backend() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a=request.getParameter("pid");
		String b=request.getParameter("pname");
		String c=request.getParameter("page");
		String d=request.getParameter("pdate");
		String e=request.getParameter("pcause");
		String f=request.getParameter("dname");
		String g=request.getParameter("treatment");
		PrintWriter out=response.getWriter();
		out.println("<h1> Patient id:"+a);
		out.println("<h1> Patient Name:"+b);
		out.println("<h1> Patient age:"+c);
		out.println("<h1> Patient date of admission:"+d);
		out.println("<h1> Patient cause:"+e);
		out.println("<h1> Doctor name:"+f);
		out.println("<h1> Treatment Name:"+g);
		//out.close();
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/msrit";
			String username = "root";
			String password = "password";

			Connection con = DriverManager.getConnection(url, username, password);
			
			if (con != null) {
				out.println("<h1>Database Connected successfully");
			}
			else
			{
			
				out.println("Database Connection failed");
			}		
			Statement stm= con.createStatement();
			String q1="insert into hospital values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"')";
			stm.executeUpdate(q1);
			out.println("<h1>----------hospital Table-------------------</h1>");
			ResultSet rs= stm.executeQuery("select * from hospital");
			out.println("<h2>PID		PNAME 	PAGE	 PDATE		PCAUSES		DOCTOR  	TREATMENT	</h2>");
					
			
			while(rs.next())
			{
					out.println("<h2>"+rs.getInt(1)+"		"+rs.getString(2)+"		"+rs.getString(3)+"   ");
					out.println(rs.getString(4)+"    "+rs.getString(5)+"    "+rs.getString(6)+"  "+rs.getString(7)+"</h2>");
			}
			out.close();
		}
		catch(Exception e1)
		{
			e1.getStackTrace(); 
		}
		
	}
	

}
