package by.training.soap.service.business.factory;

import java.util.HashMap;
import java.util.Map;

import by.training.soap.service.business.implementation.GoodShoesPriceMemoryDao;
import by.training.soap.service.business.implementation.GoodShoesPriceMySqlDao;
import by.training.soap.service.interfaces.GoodShoesPriceDao;

public class PriceFactory {
	protected static Map<String, GoodShoesPriceDao> map = new HashMap<>();
	static {
		map.put(GoodShoesPriceMemoryDao.class.getName(), new GoodShoesPriceMemoryDao());
		map.put(GoodShoesPriceMySqlDao.class.getName(), new GoodShoesPriceMySqlDao());
	}
	
	public static GoodShoesPriceDao getPriceFromFactory(String className) {
		return map.get(className);
	}
}
