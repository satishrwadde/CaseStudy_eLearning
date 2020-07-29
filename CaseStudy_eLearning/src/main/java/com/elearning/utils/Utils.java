package com.elearning.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

	
	public static String FirstLetterCaps(String str) {
		
		String finalStr = str.substring(0, 1).toUpperCase() + str.substring(1);
		return finalStr;
		//System.out.println(output);
		
		
	}
	
	public static String getTestMessageFromDB(){
		String sql ="select * from message where message_id='1'"; 
		
		String msgString=null;
		GetConnection gc = new GetConnection(); 
		
		try {
			gc.ps1 = GetConnection.getMySQLConnection().prepareStatement(sql);
			gc.rs = gc.ps1.executeQuery(); 
			
				while(gc.rs.next()) {
					msgString=gc.rs.getString("msg_contents");
				}
			}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return msgString; 
	}


	
	public static void main(String[] args) {
		
		System.out.println("DB Message :"+ getTestMessageFromDB());
	}
}
