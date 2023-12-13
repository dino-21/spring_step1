package com.dino.persistence;


import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
	 static {
		  try{
			  Class.forName("com.mysql.cj.jdbc.Driver");
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
	  
	  @Test
	  public void testConnection() {
		  try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs","root","1234")){
			  log.info(">>>>>" + con);
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
	
}
