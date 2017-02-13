package by.training.soap.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPException;

import org.apache.log4j.Logger;

import by.training.soap.service.business.GoodShoesPrice;
import by.training.soap.service.business.bean.ShoesCost;
import by.training.soap.service.business.exception.GoodShoesPriceException;
import by.training.soap.service.interfaces.GoodShoes;
import static by.training.soap.service.constants.Constants.*;

@WebService(endpointInterface = ENDPOINT_INTERFACE)

public class GoodShoesImpl implements GoodShoes {
	@Resource
	WebServiceContext context;
	
	private static final String GOOD_SHOES_ERROR = "GoodShoesPriceException: ";
	private GoodShoesPrice shoesPrice;
	private static final Logger LOGGER = Logger.getLogger(GoodShoesImpl.class);

	public GoodShoesImpl() {
		super();
		shoesPrice = new GoodShoesPrice();
	}

	@Override
	public int getShoesPrice(int id) {
		try {
			int price = shoesPrice.getShoesPrice(id);
			LOGGER.info("getShoesPrice: " + new ShoesCost(id, price));
			return price;
		} catch (GoodShoesPriceException e) {
			LOGGER.error(GOOD_SHOES_ERROR + "getShoesPrice - throw new HTTPException(401)");
			throw new HTTPException(401);
		}
	}

	@Override
	public boolean setShoesPrice(ShoesCost cost) {
		boolean isAuth = isAuthenticated();
		try {
			LOGGER.info("setShoesPrice: " + cost.toString() + DASH + isAuth);
			return isAuth ? shoesPrice.setShoesPrice(cost.getId(), cost.getPrice()) : false;
		} catch (GoodShoesPriceException e) {
			LOGGER.error(GOOD_SHOES_ERROR + "setShoesPrice - return false");
			return false;
		}
	}

	@Override
	public List<ShoesCost> getAllPrices() {
		try {
		List<ShoesCost> allPriceList = shoesPrice.getAllPrice();
		LOGGER.info("Return: " + allPriceList.size() + " elements.");
		return allPriceList;
	} catch (GoodShoesPriceException e) {
		LOGGER.error(GOOD_SHOES_ERROR + "getAllPrices() - throw new HTTPException(401)");
		throw new HTTPException(401);
	}
	}

	// Use SLL and authentication at application level,
	// also may authentication and authorization managed by container.
	private boolean isAuthenticated() {
		try {
			MessageContext messageContext = context.getMessageContext();
			Map httpHeaders = (Map) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
			List managers = (List) httpHeaders.get(HTTP_HEADER_NAME);
			List passwords = (List) httpHeaders.get(HTTP_HEADER_PASS);
			String manager = (String) managers.get(MANAGER_INDEX);
			String password = (String) passwords.get(PASSWORD_INDEX);
			LOGGER.info("Try to authenticated: " + manager + DASH + password);
			if (MANAGER_LOGINS.contains(manager) && MANAGER_PASSWORDS.contains(password)) {
				LOGGER.info("Authenticated: OK");
				return true;
			} else {
				LOGGER.info("Authenticated: error.");
				return false;
			}
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			LOGGER.error("Authenticated: error. Header authenticated data is empty." + e.toString());
			
			return false;
		}
	}
}