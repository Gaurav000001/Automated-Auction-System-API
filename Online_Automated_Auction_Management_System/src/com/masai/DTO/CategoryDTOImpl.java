package com.masai.DTO;

public class CategoryDTOImpl implements CategoryDTO{
	private int categoryId;
	private String category_name;
	
	
	public CategoryDTOImpl(int categoryId, String category_name) {
		super();
		this.categoryId = categoryId;
		this.category_name = category_name;
	}
	
	@Override
	public int getCategoryId() {
		return categoryId;
	}
	
	@Override
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	@Override
	public String getCategory_name() {
		return category_name;
	}
	
	@Override
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	
}
