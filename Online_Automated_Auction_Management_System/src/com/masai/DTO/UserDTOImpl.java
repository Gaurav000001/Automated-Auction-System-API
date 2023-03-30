package com.masai.DTO;

public class UserDTOImpl implements UserDTO{
	private int userId;
	private String username;
	private String firstname;
	private String lastname;
	private String mobile_no;
	private String country;
	private String password;
	
	public UserDTOImpl() {}
	
	public UserDTOImpl(int userId, String username, String firstname, String lastname, String mobile_no, String country,
			String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobile_no = mobile_no;
		this.country = country;
		this.password = password;
	}
	
	
	@Override
	public int getUserId() {
		return userId;
	}
	
	@Override
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String getFirstname() {
		return firstname;
	}
	
	@Override
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Override
	public String getLastname() {
		return lastname;
	}
	
	@Override
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String getMobile_no() {
		return mobile_no;
	}
	
	@Override
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	
	@Override
	public String getCountry() {
		return country;
	}
	
	@Override
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
