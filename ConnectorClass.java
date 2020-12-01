package ed;

import java.sql.*;

public class ConnectorClass {
	
	public Connection c;
	public Statement s;
	//private ResultSet rs;
	
	public ConnectorClass()  {
	//static void main(String args[]) throws ClassNotFoundException, SQLException {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		 c=DriverManager.getConnection("jdbc:mysql://root@127.0.0.1:3306/employee","root","Root@123");
		 s=c.createStatement();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	
		/*ResultSet rs=s.executeQuery("select * from employeedetails");
		while(rs.next()) 
			 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getString(6)+" "+rs.getInt(7)); 
		 c.close();*/
	}
}
