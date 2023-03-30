package com.masai.DTO;

import java.time.LocalDateTime;

public class ProductDTOImpl implements ProductDTO{
	private CategoryDTO category;
	private UserDTO user;
	private String product_name;
	private int price;
	private int quantity;
	private String description;
	private LocalDateTime lastUpdated;
	private int soldStatus;
	
	
	public ProductDTOImpl(CategoryDTO category, UserDTO user, String product_name, int price, int quantity,
			String description, LocalDateTime lastUpdated, int soldStatus) {
		super();
		this.category = category;
		this.user = user;
		this.product_name = product_name;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.lastUpdated = lastUpdated;
		this.soldStatus = soldStatus;
	}
	
	
	public CategoryDTO getCategory() {
		return category;
	}
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public int getSoldStatus() {
		return soldStatus;
	}
	public void setSoldStatus(int soldStatus) {
		this.soldStatus = soldStatus;
	}
	
	
}
