package com.hibernate.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static final String URL_STUDENT_TRACKER = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
	public static final String USER = "hbstudent";
	public static final String PASSWORD = "hbstudent";

	public static void main(String[] args) {
		Connection connection = null;

		try {

			System.out.println("[Connecting] " + URL_STUDENT_TRACKER);
			connection = DriverManager.getConnection(URL_STUDENT_TRACKER, USER, PASSWORD);
			System.out.println("[Connecting] SUCCESSFUL ");

		} catch (Exception e) {
			System.out.println("[Connecting] FAIL ");
			e.printStackTrace();

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
