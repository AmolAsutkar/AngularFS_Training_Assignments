package com.citius;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDBInsert {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con=DriverManager.getConnection("jdbc:sqlserver://CM1VA497\\SQLEXPRESS;databaseName=Impact13Hibernate;user=sa;password=password_123");
		System.out.println("connection done");
		Statement stmt=con.createStatement();
		stmt.executeUpdate("insert into Product values('mi1097',22000)");
		
		
		
		con.close();
		} catch (SQLException e) {
			
			e.getMessage();
		}
		
	}	}


