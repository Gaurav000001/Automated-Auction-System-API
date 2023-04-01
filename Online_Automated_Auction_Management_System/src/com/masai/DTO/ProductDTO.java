package com.masai.DTO;

import java.time.LocalDateTime;

public interface ProductDTO {
	public int getTime_span();
	public void setTime_span(int time_span);
	public CategoryDTO getCategory();
	public void setCategory(CategoryDTO category);
	public UserDTO getUser();
	public void setUser(UserDTO user);
	public String getProduct_name();
	public void setProduct_name(String product_name);
	public int getPrice();
	public void setPrice(int price);
	public int getQuantity();
	public void setQuantity(int quantity);
	public String getDescription();
	public void setDescription(String description);
	public LocalDateTime getLastUpdated();
	public void setLastUpdated(LocalDateTime lastUpdated);
	public int getSoldStatus();
	public void setSoldStatus(int soldStatus);
}
