package by.training.soap.service.business.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import by.training.soap.service.business.exception.GoodShoesPriceException;
import static by.training.soap.service.constants.Constants.*;

public class MySqlConnection {
	private static final Logger LOGGER = Logger.getLogger(MySqlConnection.class);
	private static Connection connection = null;

	public static Statement createStatement(Connection cn) throws GoodShoesPriceException {
		try {
			return cn.createStatement();
		} catch (SQLException e) {
			LOGGER.error("Sql error. Error create statement: " + e.getMessage());
			throw new GoodShoesPriceException(ERROR_SQL_DAO);
		}
	}

	private static void loadDriver() throws GoodShoesPriceException {
		try {
			Class.forName(SQL_DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			LOGGER.error("Sql error. Driver not load: " + e.getMessage());
			throw new GoodShoesPriceException(ERROR_SQL_DAO);
		}
	}

	private static void loadConnection() throws GoodShoesPriceException {
		try {
			connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD);
		} catch (SQLException e) {
			LOGGER.error("Sql error. Connection not load: " + e.getMessage());
			throw new GoodShoesPriceException(ERROR_SQL_DAO);
		}
	}

	public static Connection getConnection() throws GoodShoesPriceException {
		if (connection == null) {
			LOGGER.info("Create new data base sql connection.");
			loadDriver();
			loadConnection();
		}
		LOGGER.info("Return data base sql connection.");
		return connection;
	}

	public static void closeConnection() {
		if (connection == null) {
			LOGGER.error("Sql error. Error close connection.");
		} else
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				LOGGER.error("Sql error. Error close connection: " + e.getMessage());
			}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.error("Sql error. Error close result set: " + e.getMessage());
			}
		}
	}

	public static void closeStatement(Statement... statements) {
		for (Statement statement : statements) {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					LOGGER.error("Sql error. Error close statement: " + e.getMessage());
				}
			}
		}
	}
}