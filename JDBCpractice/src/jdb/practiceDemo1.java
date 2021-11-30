package jdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.MyConnection;

public class practiceDemo1 {
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
		con = MyConnection.getConnection();
		pst = con.prepareStatement("select from employee where empId = ?");
		
		rs = pst.executeQuery();
		rs.getInt(1);
		if(rs.next()) {
			rs = pst.executeQuery();
			if(rs.next()) {
				System.out.println("ID:  " + rs.getInt(1));
				System.out.println("Name:  " + rs.getString(2));
				System.out.println("Salary:  " + rs.getDouble(3));
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		finally {
			try {
				pst.close();
				con.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
