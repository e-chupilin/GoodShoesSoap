package by.training.soap.service.business.implementation;

import java.util.HashMap;
import java.util.Map;

import by.training.soap.service.business.exception.DaoException;
import by.training.soap.service.interfaces.GoodShoesPriceDao;

public class GoodShoesPriceMemoryDao implements GoodShoesPriceDao {
	private Map<Integer, Integer> prices;
	
	public GoodShoesPriceMemoryDao() {
		super();
		prices = new HashMap<>();
		prices.put(1, 100);
		prices.put(2, 200);
		prices.put(3, 300);		
	}

	@Override
	public int getShoesPrice(int id) {
		if (prices.get(id) == null) throw new DaoException("Price not found.");
		return prices.get(id);
	}

	@Override
	public boolean setShoesPrice(int id, int price) {
		prices.put(id, price);
		return true;
	}

	@Override
	public Map<Integer, Integer> getAllPrice() {
		return prices;
	}

}
