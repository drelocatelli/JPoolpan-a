package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connections.Connect;

public class RegisterController {
	
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

}
