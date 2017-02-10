package by.training.soap.service.business;

import static by.training.soap.service.constants.Constants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import by.training.soap.service.GoodShoesImpl;
import by.training.soap.service.business.bean.ShoesCost;
import by.training.soap.service.business.exception.DaoException;
import by.training.soap.service.business.exception.GoodShoesPriceException;
import by.training.soap.service.business.factory.PriceFactory;
import by.training.soap.service.interfaces.GoodShoesPriceDao;

public class GoodShoesPrice {
	private GoodShoesPriceDao priceDao;
	private static final Logger LOGGER = Logger.getLogger(GoodShoesImpl.class);

	public GoodShoesPrice() {
		super();
		priceDao = PriceFactory.getPriceFromFactory(PRICE_DAO);
	}

	public int getShoesPrice(int id) {

		try {
			return priceDao.getShoesPrice(id);
		} catch (DaoException e) {
			LOGGER.error("Error get shoes price by id: " + id + DASH + e.toString());
			throw new GoodShoesPriceException(e.toString());
		}

	}

	public boolean setShoesPrice(int id, int price) {
		try {
			return priceDao.setShoesPrice(id, price);
		} catch (DaoException e) {
			LOGGER.error("Error get shoes price by id: " + id + DASH + e.toString());
			throw new GoodShoesPriceException(e.toString());
		}
	}

	public List<ShoesCost> getAllPrice() {
		Map<Integer, Integer> mapPrices;
		try {
			mapPrices = priceDao.getAllPrice();
			List<ShoesCost> listShoesCosts = new ArrayList<>(mapPrices.size());
			for (Map.Entry<Integer, Integer> entry : mapPrices.entrySet()) {
				listShoesCosts.add(new ShoesCost(entry.getKey(), entry.getValue()));
			}
			return listShoesCosts;
		} catch (DaoException e) {
			LOGGER.error("Error get all shoes price" + DASH + e.toString());
			throw new GoodShoesPriceException(e.toString());
		}
	}
}