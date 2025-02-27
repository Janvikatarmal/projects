package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//load the driver 
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Register the driver
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		//get the connection 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:4996/demo12?user=root&password=root");
		
		// Create Statement
		 Statement statement = connection.createStatement();
				
				// Execute Statement
				statement.execute(
						"CREATE TABLE users(id int primary key, name varchar(20) not null, email varchar(20) not null unique, mobile bigint(10) not null unique, password varchar(20) not null)");
				
				// Process Result
				System.out.println("Table is created");

				// Close Connection
				statement.close();
				connection.close();

				// De-Register the Driver
				DriverManager.deregisterDriver(driver);
	
	}

}
