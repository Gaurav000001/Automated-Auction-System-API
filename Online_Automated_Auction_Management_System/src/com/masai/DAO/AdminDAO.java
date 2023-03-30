package com.masai.DAO;

import java.util.List;

import com.masai.DTO.UserDTO;
import com.masai.Exceptions.NoRecordFoundException;

public interface AdminDAO {
	void showAllUsers() throws NoRecordFoundException;
}
