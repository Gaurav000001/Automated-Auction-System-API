package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.Custom.ConsoleColors;
import com.masai.Custom.DBTablePrinter;
import com.masai.DTO.ProductDTO;
import com.masai.Exceptions.SomethingWentWrongException;

public class ProductDAOImpl implements ProductDAO{
	
	@Override
	public void displayCategories() {
		
		try(Connection con = DBUtils.connectToDatabase()){
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM category");
			
			ResultSet r = ps.executeQuery();
			
			DBTablePrinter.printResultSet(r);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	@Override
	public void addItemToSell(ProductDTO pro) throws SomethingWentWrongException{
		try(Connection con = DBUtils.connectToDatabase()){
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO Products (category_id, seller_id, product_name, price, quantity, description, start_time, end_time, last_updated) VALUES (?, ?, ?, ?, ?, ?, now(), now() + interval ? minute, CURDATE())");
			
			ps.setInt(1, pro.getCategory().getCategoryId());
			ps.setInt(2, LogedUser.id);
			ps.setString(3, pro.getProduct_name());
			ps.setInt(4, pro.getPrice());
			ps.setInt(5, pro.getQuantity());
			ps.setString(6, pro.getDescription());
			ps.setInt(7, pro.getTime_span());
			
			int n = ps.executeUpdate();
			
			if(n <= 0) {
				throw new SomethingWentWrongException("Not able to add item");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SomethingWentWrongException("Something Went Wrong! Please try again Later!");
		}
	}

	@Override
	public void updateProduct(ProductDTO pro) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		
		try(Connection con = DBUtils.connectToDatabase()){
			
			PreparedStatement ps = con.prepareStatement("UPDATE Products SET category_id = ?, product_name = ?, price = ?, quantity = ?, description = ?, end_time = now() + interval ? minute, last_updated = CURDATE() WHERE seller_id = "+ LogedUser.id +" AND is_deleted = 0");
			
			ps.setInt(1, pro.getCategory().getCategoryId());
			ps.setString(2, pro.getProduct_name());
			ps.setInt(3, pro.getPrice());
			ps.setInt(4, pro.getQuantity());
			ps.setString(5, pro.getDescription());
			ps.setInt(6, pro.getTime_span());
			
			int n = ps.executeUpdate();
			
			if(n <= 0) {
				throw new SomethingWentWrongException("Not able to update item");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SomethingWentWrongException("Something Went Wrong! Please try again Later!");
		}
		
	}

	@Override
	public boolean checkProductAvailibilityAndOwner(int proId) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		try(Connection con = DBUtils.connectToDatabase()){
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE product_id = ? AND seller_id = ? AND is_deleted = 0");
			
			ps.setInt(1, proId);
			ps.setInt(2, LogedUser.id);
			
			ResultSet r = ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(r)) {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SomethingWentWrongException("Something Went Wrong! Please try again Later!");
		}
		return true;
	}

	@Override
	public void DisplayItemsAvailableToBuy() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		try(Connection con = DBUtils.connectToDatabase()){
			
			PreparedStatement ps = con.prepareStatement("SELECT product_id as 'PRODUCT ID', category_name as CATEGORY, product_name as 'PRODUCT NAME', PRICE, QUANTITY, DESCRIPTION "
													  + "FROM Products p INNER JOIN category c ON p.category_id = c.category_id WHERE seller_id <> ? AND sold_status = 0 AND is_deleted = 0");
			
			ps.setInt(1, LogedUser.id);
			
			ResultSet r = ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(r)) {
				System.out.println("\n   "+ConsoleColors.PURPLE_BACKGROUND_BRIGHT+" At this Instance No Item is available to buy!");
			}
			else
				DBTablePrinter.printResultSet(r);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SomethingWentWrongException("Something Went Wrong! Please try again Later!");
		}
		
	}
}
