package by.training.soap.service.business.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.training.soap.service.business.exception.GoodShoesPriceException;
import static by.training.soap.service.constants.Constants.*;

public class MySqlConnection {
	private static Connection connection = null;

	public static Statement createStatement(Connection cn) throws GoodShoesPriceException {
		try {
			return cn.createStatement();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			throw new GoodShoesPriceException(ERROR_SQL_DAO);
		}
	}

	private static void loadDriver() throws GoodShoesPriceException {
		try {
			Class.forName(SQL_DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			throw new GoodShoesPriceException(ERROR_SQL_DAO);
		}
	}

	private static void loadConnection() throws GoodShoesPriceException {
		try {
			connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			throw new GoodShoesPriceException(ERROR_SQL_DAO);
		}
	}

	public static Connection getConnection() throws GoodShoesPriceException {
		if (connection == null) {
			loadDriver();
			loadConnection();
		}
		return connection;
	}

	public static void closeConnection() {
		if (connection == null) {
			System.err.println(ERROR_SQL_FAIL_CLOSE_CONNECT);
		} else
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				System.err.println(ERROR_SQL_FAIL_CLOSE_CONNECT);
				e.printStackTrace();
			}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.err.println(ERROR_SQL_FAIL_CLOSE_RESULT_SET);
				e.printStackTrace();
			}
		}
	}

	public static void closeStatement(Statement... statements) {
		for (Statement statement : statements) {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.err.println(ERROR_SQL_FAIL_CLOSE_STATEMENT);
					e.printStackTrace();
				}
			}
		}
	}
}