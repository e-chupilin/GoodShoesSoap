package by.training.soap.service.interfaces;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import by.training.soap.service.business.bean.ShoesCost;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)


public interface GoodShoes   { 
	
	@WebMethod int getShoesPrice(int id); 
	
	@WebMethod boolean setShoesPrice(ShoesCost cost);
	
	@WebMethod public List<ShoesCost> getAllPrices(); 
	
}
