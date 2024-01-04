package utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.xml.DOMConfigurator;

public class ConnectionUtils {
	private static String URL = "jdbc:mysql://localhost:3306/bookstore";
	private static String USER_NAME = "root";
	private static String USER_PASSWORD = "8261716171";
	
	public static Connection openConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	
		DOMConfigurator.configure("loggerConfig.xml");
		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
	}
}
