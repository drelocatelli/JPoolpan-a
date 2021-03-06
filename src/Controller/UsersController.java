package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connections.Connect;

public class UsersController {
	
	public String[] getUserInfo(String email, String password) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		
		String data[] = null;
		
		try {
			conn = Connect.getConnection();
			st = conn.createStatement();
			var query = "SELECT * FROM users WHERE email=? AND password=?";
			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setString(1, String.valueOf(email));
			preparedStmt.setString(2, String.valueOf(password));
			rs = preparedStmt.executeQuery();
			
			
					
			if(rs.next()) {
				data = new String[]{rs.getString("nome"), rs.getString("money")};
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			Connect.closeResultSet(rs);
			Connect.closeStatement(st);
			//Connect.closeConnection();
		}
		
		return data;
		
	}
	
	public boolean checkUser(String email, String password) {
	
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;

		try {
			conn = Connect.getConnection();
			st = conn.createStatement();
			var query = "SELECT * FROM users WHERE email=? AND password=?";
			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setString(1, String.valueOf(email));
			preparedStmt.setString(2, String.valueOf(password));
			rs = preparedStmt.executeQuery();
			
			if(!rs.next()) {
				return false;
			}else {
				return true;
			}

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
