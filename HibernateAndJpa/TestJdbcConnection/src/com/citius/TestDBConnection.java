package com.citius;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDBConnection {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
		Connection con=DriverManager.getConnection("jdbc:sqlserver://CM1VA497\\SQLEXPRESS;databaseName=TestDb;user=sa;password=password_123");
		System.out.println("Connected");
		} catch (SQLException e) {
		System.out.println(e.getMessage());
		}
}
}