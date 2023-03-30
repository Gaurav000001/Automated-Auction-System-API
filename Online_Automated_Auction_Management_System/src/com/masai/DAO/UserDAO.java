package com.masai.DAO;

import com.masai.DTO.ProductDTO;
import com.masai.DTO.UserDTO;
import com.masai.Exceptions.SomethingWentWrongException;

public interface UserDAO {
	
	boolean registerUser(UserDTO user) throws SomethingWentWrongException;
	
	boolean userLogin(String username, String password) throws SomethingWentWrongException;
	
	boolean updateProfile(UserDTO user) throws SomethingWentWrongException;
	
	boolean changePassword(String pass) throws SomethingWentWrongException;
	
	boolean deleteAccount() throws SomethingWentWrongException;
	
	void addItemToSell(ProductDTO pro) throws SomethingWentWrongException;
	
	
	
	
	
	boolean isUsernameExists(String username) throws SomethingWentWrongException;
	
	void recordLogin();
	
	void recordLogout();
}
