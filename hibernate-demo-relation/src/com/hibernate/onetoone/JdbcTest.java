package com.hibernate.onetoone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {

    public static final String URL_DB = "jdbc:mysql://localhost:3306/hb_relation?useSSL=false&serverTimezone=UTC";
    public static final String USER = "hbstudent";
    public static final String PASSWORD = "hbstudent";

    public static void main(String[] args) {

	Connection connection = null;

	try {

	    System.out.println("[Connecting] " + URL_DB);
	    connection = DriverManager.getConnection(URL_DB, USER, PASSWORD);
	    System.out.println("[Connecting] SUCCESSFUL ");

	} catch (SQLException e) {
	    e.printStackTrace();
	    System.out.println("[Connecting] FAIL ");
	} finally {
	    if (connection != null) {

		try {
		    connection.close();
		    System.out.println("[Connecting] CLOSE ");
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	    }
	}

    }

}
