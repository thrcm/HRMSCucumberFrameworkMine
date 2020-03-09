package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JdbcDemo {

	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
	
	//jdbc:typedriver:host:port/nameofdatabase
	String dbUrl="jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";
	
	//@Test
	public void getDataFromDatabase() throws SQLException {
		Connection connect = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("Connection has been created");
		
		Statement statement=connect.createStatement();
		ResultSet rset = statement.executeQuery("select * from ohrm_nationality");
		
		//moving to next row
		rset.next();
		String firstRowData = rset.getString("name");
		System.out.println(firstRowData);
		
		//moving to next row - calling data under NAME column
		rset.next();
		String secondRowData = rset.getObject("name").toString();
		System.out.println(secondRowData);
	
		//iterating thru that column
		String data;
		while(rset.next()) {
			data = rset.getObject("name").toString();
			System.out.println(data);
		}
		
		rset.close();
		statement.close();
		connect.close();
	}

	@Test
	public void retrieveDataofEmployees() throws SQLException {
		
		//retrieve all job titles and store them in ArrayList
		Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement statement = connection.createStatement();
		ResultSet rset = statement.executeQuery("select * from ohrm_job_title;");
		
		List<String> titleList = new ArrayList<>();
		String data;
		while(rset.next()) {
			data=rset.getObject("job_title").toString();
			titleList.add(data); 
		}
		
		for(String list:titleList) {
			System.out.println(list);
		}
		
		connection.close();
		statement.close();
		rset.close();
	}
	
}
