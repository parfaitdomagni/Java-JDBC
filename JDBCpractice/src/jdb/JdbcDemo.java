package jdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

	public static void main(String[] args) {
		
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "pdomagni","Jesus2020");	
			st = con.createStatement();
			//int x = st.executeUpdate("insert into employee values(2, 'Jean', 000.11)");
			
			//System.out.println(x  + "----rows");
			rs = st.executeQuery("select * from Employee");
			while(rs.next()) {
				System.out.println("ID: " + rs.getInt(1) + "\n"+ "Name:  " + rs.getString(2) + "\n" + "Salary:  " + rs.getDouble(3));
			}
			
			}
		
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		}
		
		finally {
			try {
				con.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
			
	

		}
		}

}
