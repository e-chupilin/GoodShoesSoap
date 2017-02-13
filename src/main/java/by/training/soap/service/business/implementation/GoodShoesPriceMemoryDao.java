package by.training.soap.service.business.implementation;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import by.training.soap.service.business.exception.DaoException;
import by.training.soap.service.interfaces.GoodShoesPriceDao;
import static by.training.soap.service.constants.Constants.DASH;

public class GoodShoesPriceMemoryDao implements GoodShoesPriceDao {
	private Map<Integer, Integer> prices;
	private static final Logger LOGGER = Logger.getLogger(GoodShoesPriceMemoryDao.class);

	public GoodShoesPriceMemoryDao() {
		super();
		prices = new HashMap<>();
		prices.put(1, 100);
		prices.put(2, 200);
		prices.put(3, 300);
	}

	@Override
	public int getShoesPrice(int id) {
		if (prices.get(id) == null) {
			LOGGER.info("Price not found by id: " + id);
			throw new DaoException("Price not found.");
		}
		return prices.get(id);
	}

	@Override
	public boolean setShoesPrice(int id, int price) {
		prices.put(id, price);
		LOGGER.info("Ok set price: " + id + DASH + price);
		return true;
	}

	@Override
	public Map<Integer, Integer> getAllPrice() {
		LOGGER.info("Return map of price. Size: " + prices.size());
		return prices;
	}

}
