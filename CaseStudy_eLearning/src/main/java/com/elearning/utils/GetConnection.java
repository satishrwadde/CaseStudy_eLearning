package com.elearning.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetConnection {
	public PreparedStatement ps1, ps2; 
	public ResultSet rs, rs1; 
	public static Connection connection; 
	
	
	public static Connection getMySQLConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			connection = DriverManager.getConnection("jdbc:mysql://localhost/seleniumibm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
			System.out.println("Databse connected...");
			return connection; 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null; 
	}
	public static void main(String[] args) {
		getMySQLConnection();
	}
}
