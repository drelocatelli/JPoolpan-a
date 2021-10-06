package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connections.Connect;

public class MoneyController {
	
	public boolean setMoney(String email, String password, int newSaldo) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		
		try {
			conn = Connect.getConnection();
			st = conn.createStatement();
			var query = "UPDATE users SET money=? WHERE email=? AND password=?";
			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setString(1, String.valueOf(newSaldo));
			preparedStmt.setString(2, String.valueOf(email));
			preparedStmt.setString(3, String.valueOf(password));
			preparedStmt.execute();
			
			return true;
					
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			Connect.closeResultSet(rs);
			Connect.closeStatement(st);
			//Connect.closeConnection();
		}
		
	}

}
