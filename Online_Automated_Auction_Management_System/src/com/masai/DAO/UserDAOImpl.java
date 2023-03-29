package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.DTO.UserDTO;
import com.masai.Exceptions.SomethingWentWrongException;

public class UserDAOImpl implements UserDAO{

	@Override
	public boolean registerUser(UserDTO user) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		try(Connection con = DBUtils.connectToDatabase()){
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO Users (user_name, firstname, lastname, mobile_no, country, registered_date, password) VALUES (?, ?, ?, ?, ?, CURDATE(), ?)");
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getFirstname());
			ps.setString(3, user.getLastname());
			ps.setString(4, user.getMobile_no());
			ps.setString(5, user.getCountry());
			ps.setString(6, user.getPassword());
			
			int n = ps.executeUpdate();
			
			if(n > 0) {
				return true;
			}
			else {
				throw new SomethingWentWrongException("Something Went Wrong! Please try again Later!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	public boolean userLogin(String username, String password) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		try(Connection con = DBUtils.connectToDatabase()){
			
			 PreparedStatement ps = con.prepareStatement("SELECT * FROM Users WHERE user_name = ? AND password = ?");
			 ps.setString(1, username);
			 ps.setString(2, password);
			 
			 ResultSet r = ps.executeQuery();
			 
			 if(DBUtils.isResultSetEmpty(r)) {
				 return false;
			 }
			 else {
				 r.next();
				 
				 LogedUser.adminLoged = false;
				 LogedUser.id = r.getInt("user_id");
				 LogedUser.password = r.getString("password");
				 LogedUser.username = r.getString("user_name");
				 
				 return true;
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SomethingWentWrongException("Something Went Wrong! Please try again Later!");
		}
		
	}
	
	
	@Override
	public boolean updateProfile(UserDTO user) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		try(Connection con = DBUtils.connectToDatabase()){
			
			PreparedStatement ps = con.prepareStatement("UPDATE Users SET firstname = ?, lastname = ?, mobile_no = ?, country = ? WHERE user_id = ?");
			
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getMobile_no());
			ps.setString(4, user.getCountry());
			ps.setInt(5, LogedUser.id);
			
			int n = ps.executeUpdate();
			
			if(n > 0) {
				return true;
			}
			else {
				throw new SomethingWentWrongException("Something Went Wrong! Please try again Later!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	public boolean changePassword(String pass) throws SomethingWentWrongException{
		
		try(Connection con = DBUtils.connectToDatabase()){
			
			PreparedStatement ps = con.prepareStatement("UPDATE Users SET password = ? WHERE user_id = ?");
			
			ps.setString(1, pass);
			ps.setInt(2, LogedUser.id);
			
			int n = ps.executeUpdate();
			
			if(n > 0) {
				return true;
			}
			else {
				throw new SomethingWentWrongException("Something Went Wrong! Please try again Later!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	
	
	
	

	@Override
	public boolean isUsernameExists(String username) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		try(Connection con = DBUtils.connectToDatabase()){
			
			 PreparedStatement ps = con.prepareStatement("SELECT * FROM Users WHERE user_name = ?");
			 ps.setString(1, username);
			 
			 ResultSet r = ps.executeQuery();
			 
			 if(DBUtils.isResultSetEmpty(r)) {
				 return false;
			 }
			 else {
				 return true;
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SomethingWentWrongException("Something Went Wrong! Please try again Later!");
		}
		
	}


	@Override
	public void recordLogin() {
		// TODO Auto-generated method stub
		try(Connection con = DBUtils.connectToDatabase()){
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO login_logout_record (user_id, logedin_at) VALUES (?, now())");
			if(LogedUser.adminLoged == false) {
				ps.setString(1, "U"+LogedUser.id);
			}
			else {
				ps.setString(1, "Admin");
			}
			
			ps.executeUpdate();
			
			PreparedStatement p = con.prepareStatement("SELECT * FROM login_logout_record ORDER BY record_id DESC LIMIT 1");
			ResultSet r = p.executeQuery();
			
			if(!DBUtils.isResultSetEmpty(r)) {
				r.next();
				
				LogedUser.loginRecordID = r.getInt("record_id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void recordLogout() {
		// TODO Auto-generated method stub
		try(Connection con = DBUtils.connectToDatabase()){
			
			PreparedStatement ps = con.prepareStatement("UPDATE login_logout_record SET logedout_at = now() WHERE record_id = ?");
			ps.setInt(1, LogedUser.loginRecordID);
			
			ps.executeUpdate();
			
			if(LogedUser.adminLoged) {
				LogedUser.adminLoged = false;
			}
			
			LogedUser.id = -1;
			LogedUser.loginRecordID = -1;
			LogedUser.password = null;
			LogedUser.username = null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
















}
