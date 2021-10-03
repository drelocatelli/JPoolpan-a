package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connections.Connect;

public class UsersController {
	
	public boolean CadastraUser(String nome, String email, String senha) {
		
		if(emailExists(email)) {
			return false;
		}
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;

		try {
			conn = Connect.getConnection();
			st = conn.createStatement();
			var query = "INSERT INTO users(nome, email, password) values(?, ?, ?)";
			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setString(1, nome);
			preparedStmt.setString(2, email);
			preparedStmt.setString(3, senha);
			preparedStmt.execute();

			return true;

		}catch(SQLException e) {
			e.printStackTrace();

			return false;
		}finally{
			Connect.closeResultSet(rs);
			Connect.closeStatement(st);
			//			Connect.closeConnection();
		}
		
	}
	
	public boolean emailExists(String email) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		
		try {
			conn = Connect.getConnection();
			st = conn.createStatement();
			var query = "SELECT * FROM users WHERE email=?";
			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setString(1, email);
			rs = preparedStmt.executeQuery();
			
					
			if(rs.next()) {
				return true;
			}else {
				return false;
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
				data = new String[]{rs.getString("nome")};
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
