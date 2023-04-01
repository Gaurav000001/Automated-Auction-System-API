package com.masai.DAO;

import java.util.List;

import com.masai.DTO.UserDTO;
import com.masai.Exceptions.NoRecordFoundException;

public interface AdminDAO {
	
	void showAllUsers() throws NoRecordFoundException;
	
	void displayAllProductsToBeSold() throws NoRecordFoundException;
	
	void displayAllProductsAlreadySold() throws NoRecordFoundException;
	
	void displayAllProductsByCategory(int catId) throws NoRecordFoundException;
}
