package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MetaDataDemo {

	@Test
	public void getMetaData() throws SQLException {
		
		String dbUsername="syntax_hrm";
		String dbPassword="syntaxhrm123";
		String dbUrl="jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";
		
		Connection connect = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		DatabaseMetaData metaData = connect.getMetaData();
		String dbName = metaData.getDatabaseProductName();
		String version = metaData.getDatabaseProductVersion();
		System.out.println(dbName);
		System.out.println(version);
		
		
		Statement statement = connect.createStatement();
		ResultSet result = statement.executeQuery("select * from hs_hr_employees where emp_number=5978;");
		
		ResultSetMetaData rsMetaData = result.getMetaData();
		int colNum = rsMetaData.getColumnCount();
		
		for(int i=1; i<=colNum; i++) {
			String col=rsMetaData.getColumnName(i);
			System.out.print(col+" ");
		}
		
		
	}
}
