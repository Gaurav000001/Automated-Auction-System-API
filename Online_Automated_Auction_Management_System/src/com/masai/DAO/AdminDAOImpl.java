package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Custom.DBTablePrinter;
import com.masai.DTO.UserDTO;
import com.masai.Exceptions.NoRecordFoundException;

public class AdminDAOImpl implements AdminDAO{

	@Override
	public void showAllUsers() throws NoRecordFoundException {
		// TODO Auto-generated method stub
		List<UserDTO> list = new ArrayList<>();
		
		try(Connection con = DBUtils.connectToDatabase()){
			
			PreparedStatement ps = con.prepareStatement("select concat('U0', user_id) USERID, user_name USERNAME, FIRSTNAME, LASTNAME, mobile_no PHONE, COUNTRY, REGISTERED_DATE from users where is_deleted = 0;");
			
			ResultSet r = ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(r) == false) {
				System.out.println();
				DBTablePrinter.printResultSet(r);
			}
			else 
				throw new NoRecordFoundException("No Record Found");
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new NoRecordFoundException("Something Went Wrong");
		}
	}

}
