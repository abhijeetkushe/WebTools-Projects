package com.webtools.springfinal.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import junit.framework.TestCase;

public class InsertValuesController  {

	public static void main(String[] args) throws Exception {


	      // Load the Oracle JDBC driver
	      DriverManager.registerDriver
	              (new oracle.jdbc.driver.OracleDriver());

	      // connect through driver
	     Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@abhijit:1521/orcl","webtools","webtools");

   // Create Oracle DatabaseMetaData object
	     DatabaseMetaData meta = conn.getMetaData();
	      // gets driver info:
        System.out.println("JDBC driver version is " + meta.getDriverVersion());

	         // Create a statement
	      Statement stmt = conn.createStatement();

	          // Do the SQL "Hello World" thing
	    ResultSet rset = stmt.executeQuery("SELECT TABLE_NAME FROM USER_TABLES");

	     while (rset.next())
	        System.out.println(rset.getString(1));

	            // close the result set, the statement and disconnect
	          rset.close();
	             stmt.close();
	           conn.close();
	      System.out.println("Your JDBC installation is correct.");

  }
}
