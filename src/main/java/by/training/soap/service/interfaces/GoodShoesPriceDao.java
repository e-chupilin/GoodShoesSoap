package by.training.soap.service.interfaces;

import java.util.Map;

import by.training.soap.service.business.exception.GoodShoesPriceException;
 
public interface GoodShoesPriceDao {
	
	int getShoesPrice(int id) throws GoodShoesPriceException;
	
	boolean setShoesPrice(int id, int price) throws GoodShoesPriceException;
	
	Map<Integer, Integer> getAllPrice() throws GoodShoesPriceException;	
}

