import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.db.MyConnection;

public class practiceDemo {
	
	public static void main(String[] main) {
		Scanner input = new Scanner(System.in);
		Connection con = null;
		String choice;
		
		PreparedStatement pst = null;
		try {
		con = MyConnection.getConnection();
		pst = con.prepareStatement("insert into employee values(?, ?, ?)");
		ResultSet rs = null;
		
		do {
			System.out.println("Enter Your ID");
			int id = input.nextInt();
			pst.setInt(1, id);
			System.out.println("Enter Your name");
			String name = input.next();
			pst.setString(2, name);
			System.out.println("Enter Your salary");
			double salary = input.nextDouble();
			pst.setDouble(3, salary);
			int x = pst.executeUpdate();
			System.out.println(x +"  Row");
			System.out.println("Do you want to continue (Y/N");
			choice = input.next();
			
		} while(choice.equalsIgnoreCase("Y"));
		
		}
		catch(Exception e) {
			
		}
		
		finally {
			try {
				input.close();
				con.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}
