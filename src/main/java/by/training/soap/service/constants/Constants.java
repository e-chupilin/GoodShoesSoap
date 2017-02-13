package by.training.soap.service.constants;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import by.training.soap.service.business.implementation.GoodShoesPriceMemoryDao;
import by.training.soap.service.business.implementation.GoodShoesPriceMySqlDao;

public class Constants {
	
	//	Change for use necessary data source for User
	//public static final String PRICE_DAO = GoodShoesPriceMemoryDao.class.getName();
	public static final String PRICE_DAO = GoodShoesPriceMySqlDao.class.getName();
	
	public static final String DELIMITER = ";";
	public static final String COLON = ":";
	public static final String DOT = ".";
	public static final String DASH = " - ";
	public static final String HTTP_HEADER_NAME = "uname";
	public static final String HTTP_HEADER_PASS = "pass";
	public static final String ENDPOINT_INTERFACE = "by.training.soap.service.interfaces.GoodShoes";	
	
	public static final int MANAGER_INDEX = 0 ;
	public static final int PASSWORD_INDEX = 0 ;
	
	public static final String SQL_DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static final String SQL_DATABASE = "soap";
	public static final String SQL_URL = "jdbc:mysql://localhost:3306/" + SQL_DATABASE;
	public static final String SQL_USER = "root";
	public static final String SQL_PASSWORD = "jeejee";
	public static final String SQL_TABLE_PRICE = "price";
	public static final int SQL_PS_PRICE_INDEX = 2 ;
	public static final int SQL_PS_PRICE_GET_INDEX = 1 ;
	public static final int SQL_PS_ID_INDEX = 1 ;
	public static final String SQL_PS_SELECT_ALL = "SELECT * FROM " + SQL_DATABASE + DOT + SQL_TABLE_PRICE;
	public static final String SQL_PS_SELECT_PRICE = "SELECT * FROM " + SQL_DATABASE + DOT + SQL_TABLE_PRICE
			+ " WHERE id = ?";
	public static final String SQL_PS_INSERT_PRICE = "INSERT INTO " + SQL_DATABASE + DOT + SQL_TABLE_PRICE
			+ "(`id`, `price`) VALUES (?, ?)";
	
	public static final String ERROR_SQL_DAO = "Can not connect to data base. Please try later.";
	public static final String ERROR_SQL_FAIL_CLOSE_RESULT_SET = "Error SQL. Fail close result set.";
	public static final String ERROR_SQL_FAIL_CLOSE_CONNECT = "Error SQL. Fail close connect.";
	public static final String ERROR_SQL_FAIL_CLOSE_STATEMENT = "Error SQL. Fail close statement.";
	
	public static final List<String> MANAGER_LOGINS = 
		    Collections.unmodifiableList(Arrays.asList("manager", "supervizer"));
	public static final List<String> MANAGER_PASSWORDS = 
		    Collections.unmodifiableList(Arrays.asList("12345", "123"));
	
	}
