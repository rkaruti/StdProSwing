package com.swings.login.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.swings.common.db.DBConnector;

public class LoginModel {
	Connection con;
	Statement smt;
	ResultSet rs;
	
	ArrayList<String> list;	

	public ArrayList<String> listAllUsers() {
		
		try {
			con = DBConnector.getDBConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM USERS");
			ResultSet rs = ps.executeQuery();
			
			list = new ArrayList<String>();
			list.add(rs.getString(1));
			list.add(rs.getString(2));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList loginUser(String uname, String password) {
		String name = null;
		String pass = null;
		System.out.println("Name pass are " + uname + " " + password);
		ArrayList list = new ArrayList();
		try {
			con = DBConnector.getDBConnection();
			smt = con.createStatement(); 
			String query = "SELECT ID, NAME, PASS FROM USER WHERE ID = '" + uname + "' AND PASS = '"
					+ password + "'";
			System.out.println("Query " + query);
			rs = smt.executeQuery(query); 
			while (rs.next()) { 
				name = rs.getString("name");
				System.out.println("Name " + name);
				list.add(name);
			}
			rs.close();
			smt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
