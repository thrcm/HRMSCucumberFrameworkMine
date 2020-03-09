package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;


public class Recap {
	
	@Test
	public void getDatabaseInfo() throws SQLException{
		
		String dbUsername="syntax_hrm";
		String dbPassword="syntaxhrm123";
		
		//	jdbc:typedriver://host:port/nameofdatabase
		String dbUrl="jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";
		
		
		Connection connect=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		DatabaseMetaData dbmd=connect.getMetaData();
		String productName = dbmd.getDatabaseProductName();
		String version = dbmd.getDatabaseProductVersion();
		System.out.println(productName+ "--" + version);
		
		System.out.println("\n****************");
		
		Statement st=connect.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_job_title;");
		
		ResultSetMetaData rsmd=rs.getMetaData();
		int numOfCol = rsmd.getColumnCount();
		System.out.println("Total col: " + numOfCol);
		
		String colName;
		for(int i=1; i<=numOfCol; i++) {
			colName=rsmd.getColumnName(i);
			System.out.println(colName);
		}
		
		System.out.println("\n****************");
		
		String id;
		String jobTitle;
		
		while(rs.next()) {
			id=rs.getObject("id").toString();
			jobTitle=rs.getObject("job_title").toString();
			System.out.println(id+"--"+jobTitle);
		}
		
		rs.close();
		st.close();
		connect.close();
		
	}
}
