package by.training.soap.service.business.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import by.training.soap.service.GoodShoesImpl;
import by.training.soap.service.business.connection.MySqlConnection;
import by.training.soap.service.business.exception.DaoException;
import by.training.soap.service.interfaces.GoodShoesPriceDao;
import static by.training.soap.service.constants.Constants.*;

public class GoodShoesPriceMySqlDao implements GoodShoesPriceDao {
	private static final Logger LOGGER = Logger.getLogger(GoodShoesPriceMySqlDao.class);

	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection cn = null;

	@Override
	public int getShoesPrice(int id) {
		cn = MySqlConnection.getConnection();
		try {
			ps = cn.prepareStatement(SQL_PS_SELECT_PRICE);
			ps.setInt(SQL_PS_PRICE_GET_INDEX, id);
			rs = ps.executeQuery();
			if (rs.first()) {
				int result = rs.getInt(SQL_PS_PRICE_INDEX);
				LOGGER.info("Return form DB: " + id + DASH + result );
				return result;
			} else {
				LOGGER.error("Data base field empty for id: " + id);
				throw new SQLException("Sql error. Data base field empty.");
			}			
		} catch (SQLException e) {
			LOGGER.error("Error get price from db by id: " + id);
			throw new DaoException(e);
		} finally {
			MySqlConnection.closeStatement(ps);
			MySqlConnection.closeResultSet(rs);			
		}
	}

	@Override
	public boolean setShoesPrice(int id, int price) {
		cn = MySqlConnection.getConnection();
		try {
			ps = cn.prepareStatement(SQL_PS_INSERT_PRICE);
			ps.setInt(SQL_PS_ID_INDEX, id);
			ps.setInt(SQL_PS_PRICE_INDEX, price);
			ps.executeUpdate();
			LOGGER.info("Ok set.");
			return true;
		} catch (SQLException e) {
			LOGGER.error("Sql error set price in DB: " + e.getMessage());
			return false;
		} finally {
			MySqlConnection.closeStatement(ps);
			MySqlConnection.closeResultSet(rs);
		}
	}

	@Override
	public Map<Integer, Integer> getAllPrice() {
		cn = MySqlConnection.getConnection();
		Map<Integer, Integer> prices = new HashMap<Integer, Integer>();
		try {
			ps = cn.prepareStatement(SQL_PS_SELECT_ALL);
			rs = ps.executeQuery();
			
			while(rs != null && rs.next()){
				int id = rs.getInt(SQL_PS_ID_INDEX);
				int price = rs.getInt(SQL_PS_PRICE_INDEX);				
				LOGGER.info("Add: " + id + DASH + price);	
				prices.put(id, price);
			}	
			
			return prices;

		} catch (SQLException e) {
			LOGGER.error("Error get all price from db: " + e.getMessage());
			throw new DaoException(e);
		} finally {
			MySqlConnection.closeStatement(ps);
			MySqlConnection.closeResultSet(rs);			
		}		
	}
}
