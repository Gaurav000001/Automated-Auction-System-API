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

	@Override
	public void displayAllProductsToBeSold() throws NoRecordFoundException {
		// TODO Auto-generated method stub
		try(Connection con = DBUtils.connectToDatabase()){
			
			PreparedStatement ps = con.prepareStatement("SELECT CONCAT('P0', product_id) AS 'PRODUCT ID', c.category_name AS CATEGORY, CONCAT('S0', seller_id) AS 'SELLER ID', product_name AS 'PRODUCT NAME', PRICE, QUANTITY, DESCRIPTION, start_time AS 'START TIME', end_time AS 'END TIME' FROM products p INNER JOIN category c ON p.category_id = c.category_id AND p.sold_status = 0 AND p.is_deleted = 0");
			
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

	@Override
	public void displayAllProductsAlreadySold() throws NoRecordFoundException {
		// TODO Auto-generated method stub
		try(Connection con = DBUtils.connectToDatabase()){
			
			PreparedStatement ps = con.prepareStatement("SELECT CONCAT('P0', product_id) AS 'PRODUCT ID', c.category_name AS CATEGORY, CONCAT('S0', seller_id) AS 'SELLER ID', product_name AS 'PRODUCT NAME', PRICE, QUANTITY, DESCRIPTION, start_time AS 'START TIME', end_time AS 'END TIME' FROM products p INNER JOIN category c ON p.category_id = c.category_id AND p.sold_status = 1 AND p.is_deleted = 0");
			
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

	@Override
	public void displayAllProductsByCategory(int catId) throws NoRecordFoundException {
		// TODO Auto-generated method stub
		try(Connection con = DBUtils.connectToDatabase()){
			
			PreparedStatement ps = con.prepareStatement("SELECT CONCAT('P0', product_id) AS 'PRODUCT ID', CONCAT('S0', seller_id) AS 'SELLER ID', product_name AS 'PRODUCT NAME', PRICE, QUANTITY, DESCRIPTION, start_time AS 'START TIME', end_time AS 'END TIME' FROM products p INNER JOIN category c ON p.category_id = c.category_id AND p.is_deleted = 0 AND c.category_id = ?");
		
			ps.setInt(1, catId);
			
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
