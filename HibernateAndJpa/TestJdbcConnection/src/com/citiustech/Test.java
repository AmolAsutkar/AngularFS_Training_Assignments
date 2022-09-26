package com.citiustech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con=DriverManager.getConnection("jdbc:sqlserver://CM1VA497\\SQLEXPRESS;databaseName=PreImpact13;user=sa;password=password_123");
		System.out.println("connection done");
		Statement stmt=con.createStatement();
		//stmt.executeUpdate("insert into ProductDetails values(5,'mi10i',22000)");
		ResultSet rs = stmt.executeQuery("select * from ProductDetails");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"----"+rs.getString(2)+"------"+rs.getFloat(3));
			
		}
		
		
		con.close();
		} catch (SQLException e) {
			
			e.getMessage();
		}
		
	}

}
