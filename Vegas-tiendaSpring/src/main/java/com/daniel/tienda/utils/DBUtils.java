package com.daniel.tienda.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(DBUtils.class);
	private static SessionFactory sessionFactory;
	public static Connection conectaBBDD() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String urlDB = "jdbc:mysql://localhost:3306/tienda?serverTimezone=UTC";
		String user = "root";
		String pass = "PracticaRoot";
		Connection connection = DriverManager.getConnection(urlDB, user, pass);
		return connection;
	}
	
	public static SessionFactory creadorSession() {
		
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		
		return sessionFactory;
	}
}
