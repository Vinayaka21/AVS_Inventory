/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vinayaka prasad
 */



import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(url, "avs", "avs");
			//System.out.println("****TIMEOFFICE******* DATABASE CONNECTED");		
			
			System.out.println("DB CONNECTED-->avs");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (conn);
	}
	
}