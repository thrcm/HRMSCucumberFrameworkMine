package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class StoringDataFromDB {

	@Test
	public void storeData() throws SQLException {
		String dbUsername="syntax_hrm";
		String dbPassword="syntaxhrm123";
		//	jdbc:typedriver://host:port/nameofdatabase
		String dbUrl="jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";
	
		Connection connect=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = connect.createStatement();
		ResultSet rs = st.executeQuery("select employee_id, emp_firstname, emp_lastname from hs_hr_employees where employee_id between 4000 and 4100");
	
		List<Map<String,String>> list = new ArrayList<>();
		
		while(rs.next()) {
			
			Map<String,String>map = new LinkedHashMap<>();
			map.put("employee_id", rs.getObject("employee_id").toString());
			map.put("emp_firstname", rs.getObject("emp_firstname").toString());
			map.put("emp_lastname", rs.getObject("emp_lastname").toString());
			
			list.add(map);
		}
	
		System.out.println(list);
	}
	
	
	@Test
	public void storeDataDynamically() throws SQLException {
		String dbUsername="syntax_hrm";
		String dbPassword="syntaxhrm123";
		String dbUrl="jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";
		
		Connection connect = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = connect.createStatement();
		ResultSet rs =st.executeQuery("select employee_id, emp_firstname, emp_lastname from hs_hr_employees where employee_id between 4000 and 4100");
		
		ResultSetMetaData rsMetaData=rs.getMetaData();
		int numOfCol = rsMetaData.getColumnCount();
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String, String> map;
		
		while(rs.next()) {
			map=new LinkedHashMap<String, String>();
			
			for(int i=1; i<=numOfCol; i++) {
				map.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());
				list.add(map);
			}
		}
		
		System.out.println(list);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
