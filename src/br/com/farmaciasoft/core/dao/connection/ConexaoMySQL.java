package br.com.farmaciasoft.core.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

	private static final String urlDb = "jdbc:mysql://localhost:3307/farmaciasoft";
	private static final String userDb = "root";
	private static final String passDb = "root123";
	
	private static Connection conn;
	
	public static Connection getConexao () {
		try {
		if (conn == null) {
				conn = DriverManager.getConnection(urlDb, userDb, passDb);
				return conn;
			}else {
				return conn;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}