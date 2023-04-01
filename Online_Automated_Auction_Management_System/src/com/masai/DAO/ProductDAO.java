package com.masai.DAO;

import com.masai.DTO.ProductDTO;
import com.masai.Exceptions.SomethingWentWrongException;

public interface ProductDAO {

	void displayCategories();
	
	void addItemToSell(ProductDTO pro) throws SomethingWentWrongException;
	
	void updateProduct(ProductDTO pro) throws SomethingWentWrongException;
	
	boolean checkProductAvailibilityAndOwner(int proId) throws SomethingWentWrongException;
	
	void DisplayItemsAvailableToBuy() throws SomethingWentWrongException;
}
