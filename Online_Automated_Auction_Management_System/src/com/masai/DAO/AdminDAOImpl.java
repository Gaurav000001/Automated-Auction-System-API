package com.masai.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.masai.Custom.DBTablePrinter;
import com.masai.Exceptions.NoRecordFoundException;
import com.masai.Exceptions.SomethingWentWrongException;

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
	
	
	@Override
	public void displayAllTransactions() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		try(Connection con = DBUtils.connectToDatabase()){
			
			PreparedStatement ps = con.prepareStatement("SELECT trans_id AS 'TRANSACTION ID', p.product_id AS 'PRODUCT ID', p.product_name AS 'PRODUCT NAME', user_id AS 'USER ID', o.bid_price AS 'ORDER AMOUNT', trans_date AS 'TRANSACTION DATE' FROM Transactions t INNER JOIN Products p INNER JOIN Orders o ON t.product_id = p.product_id AND t.user_id = o.buyer_id WHERE is_canceled = 0 AND order_status = 'Success'");
			
			ResultSet r = ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(r) == false) {
				
				DBTablePrinter.printResultSet(r);
			
			}else {
				throw new SomethingWentWrongException("No record Found");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SomethingWentWrongException("Something Went Wrong! Please try again Later!");
		}
	}

	@Override
	public void displayTransactionsInDateRange(LocalDate start, LocalDate end) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		
		try(Connection con = DBUtils.connectToDatabase()){
			
			PreparedStatement ps = con.prepareStatement("SELECT trans_id AS 'TRANSACTION ID', p.product_id AS 'PRODUCT ID', p.product_name AS 'PRODUCT NAME', user_id AS 'USER ID', o.bid_price AS 'ORDER AMOUNT', trans_date AS 'TRANSACTION DATE' FROM Transactions t INNER JOIN Products p INNER JOIN Orders o ON t.product_id = p.product_id AND t.user_id = o.buyer_id WHERE is_canceled = 0 AND order_status = 'Success' AND (trans_date BETWEEN ? AND ?)");
			ps.setDate(1, Date.valueOf(start));
			ps.setDate(1, Date.valueOf(end));
						
			ResultSet r = ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(r) == false) {
				
				DBTablePrinter.printResultSet(r);
			
			}else {
				throw new SomethingWentWrongException("No record Found");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SomethingWentWrongException("Something Went Wrong! Please try again Later!");
		}
	}

	@Override
	public void displayTransactionById(int tid) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		try(Connection con = DBUtils.connectToDatabase()){
			
			PreparedStatement ps = con.prepareStatement("SELECT p.product_id AS 'PRODUCT ID', p.product_name AS 'PRODUCT NAME', user_id AS 'USER ID', o.bid_price AS 'ORDER AMOUNT', trans_date AS 'TRANSACTION DATE' FROM Transactions t INNER JOIN Products p INNER JOIN Orders o ON t.product_id = p.product_id AND t.user_id = o.buyer_id WHERE is_canceled = 0 AND order_status = 'Success' AND trans_id = ?");
			ps.setInt(1, tid);
			
			ResultSet r = ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(r) == false) {
				
				DBTablePrinter.printResultSet(r);
			
			}else {
				throw new SomethingWentWrongException("No record Found");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SomethingWentWrongException("Something Went Wrong! Please try again Later!");
		}
	}

}
