package by.training.soap.service.constants;


import by.training.soap.service.business.implementation.GoodShoesPriceMemoryDao;

public class Constants {
	
	//	Change for use necessary data source for User
	public static final String PRICE_DAO = GoodShoesPriceMemoryDao.class.getName();
	// public static final String PRICE_DAO = GoodShoesPriceMySqlImpl.class.getName();
	
	public static final String DELIMITER = ";";
	public static final String COLON = ":";
	public static final String DOT = ".";
	public static final String DASH = " - ";
	public static final String HTTP_HEADER_NAME = "uname";
	public static final String HTTP_HEADER_PASS = "pass";
	public static final String ENDPOINT_INTERFACE = "by.training.soap.service.interfaces.GoodShoes";
	
	
	
	
	public static final String SQL_DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static final String SQL_DATABASE = "web1";
//	public static final String SQL_TABLE_USER = "user";
	public static final String SQL_URL = "jdbc:mysql://localhost:3306/" + SQL_DATABASE;
	public static final String SQL_USER = "jse";
	public static final String SQL_PASSWORD = "jsejse";
//	public static final String SQL_PS_SELECT_USER = "SELECT * FROM " + SQL_DATABASE + DOT + SQL_TABLE_USER
//			+ " WHERE login = ?";
//	public static final String SQL_PS_INSERT_USER = "INSERT INTO " + SQL_DATABASE + DOT + SQL_TABLE_USER
//			+ "(`login`, `password`, `fullName`, `phoneNumber`) VALUES (?, ?, ?, ?)";
//	
//	public static final String ERROR_HARDCODED_DAO = "Data memory access error.";
//	public static final String ERROR_USER_VERIFICATION = "Wrong user name or password.";
	public static final String ERROR_SQL_DAO = "Can not connect to data base. Please try later.";
	public static final String ERROR_SQL_FAIL_CLOSE_RESULT_SET = "Error SQL. Fail close result set.";
	public static final String ERROR_SQL_FAIL_CLOSE_CONNECT = "Error SQL. Fail close connect.";
	public static final String ERROR_SQL_FAIL_CLOSE_STATEMENT = "Error SQL. Fail close statement.";
	
	}
