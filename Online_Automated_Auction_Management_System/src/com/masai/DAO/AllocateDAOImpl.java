package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllocateDAOImpl implements AllocateDAO{

	@Override
	public void allocateProductsToUsers() {
		// TODO Auto-generated method stub
		List<int[]> list = new ArrayList<>();
		
		try(Connection con = DBUtils.connectToDatabase()) {
			
			PreparedStatement ps = con.prepareStatement("SELECT o.order_id, o.buyer_id, o.product_id, o.bid_price FROM ( SELECT order_id, buyer_id, product_id, bid_price, ROW_NUMBER() OVER (PARTITION BY product_id ORDER BY bid_price DESC) AS rn FROM orders ) o WHERE o.rn = 1");
			
			ResultSet r = ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(r)) {
				return;
			}
			
			
			while(r.next()) {
				
				int[] arr = new int[4];
				
				arr[0] = r.getInt("order_id");
				arr[1] = r.getInt("buyer_id");
				arr[2] = r.getInt("product_id");
				arr[3] = r.getInt("bid_price");
				
				list.add(arr);
			}
			
			list.forEach(i -> {
				
				PreparedStatement changeProductSoldStatus;
				PreparedStatement changeOrderStatusToSuccess;
				PreparedStatement changeOrderStatusToRejected;
				PreparedStatement insertIntoTransactions;
				
				try {
					
					//updating the product sold status to 1
					changeProductSoldStatus = con.prepareStatement("UPDATE Products SET sold_status = 1 WHERE product_id = ?");
					changeProductSoldStatus.setInt(1, i[2]);
					
					changeProductSoldStatus.executeUpdate();
					
					//updating the order status to Success in Orders table
					changeOrderStatusToSuccess = con.prepareStatement("UPDATE Orders SET order_status = 'Success' WHERE order_id = ?");
					changeOrderStatusToSuccess.setInt(1, i[0]);
					
					changeOrderStatusToSuccess.executeUpdate();
					
					
					//updating the order status to rejected in Orders table
					changeOrderStatusToRejected = con.prepareStatement("UPDATE Orders SET order_status = 'Rejected' WHERE order_id <> ? AND product_id = ?");
					changeOrderStatusToRejected.setInt(1, i[0]);
					changeOrderStatusToRejected.setInt(2, i[2]);
					
					
					//insert into transactions table the selected orders
					insertIntoTransactions = con.prepareStatement("INSERT INTO Transactions (product_id, user_id, trans_date) VALUES (?, ?, CURDATE())");
					insertIntoTransactions.setInt(1, i[2]);
					insertIntoTransactions.setInt(2, i[1]);
					
					insertIntoTransactions.executeUpdate();
					
							
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			});
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
