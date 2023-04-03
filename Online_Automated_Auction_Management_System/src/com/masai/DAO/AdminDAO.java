package com.masai.DAO;

import java.time.LocalDate;
import java.util.List;

import com.masai.DTO.UserDTO;
import com.masai.Exceptions.NoRecordFoundException;
import com.masai.Exceptions.SomethingWentWrongException;

public interface AdminDAO {
	
	void showAllUsers() throws NoRecordFoundException;
	
	void displayAllProductsToBeSold() throws NoRecordFoundException;
	
	void displayAllProductsAlreadySold() throws NoRecordFoundException;
	
	void displayAllProductsByCategory(int catId) throws NoRecordFoundException;
	
	void displayAllTransactions() throws SomethingWentWrongException;
	
	void displayTransactionsInDateRange(LocalDate start, LocalDate end) throws SomethingWentWrongException;
	
	void displayTransactionById(int tid) throws SomethingWentWrongException;
}
