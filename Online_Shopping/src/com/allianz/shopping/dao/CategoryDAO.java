package com.allianz.shopping.dao;

import java.util.List;

import com.allianz.shopping.model.Category;
import com.allianz.shopping.model.Product;



public interface CategoryDAO {
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(int categoryId);
	public List<Category> getAllCategory();
	public List<Category> getAllCategoryByName(String categoryName);
	public List<Category> getAllCategoryByPrice(float min,float max);
	public Category getCategoryById(int id);
	public List<Category> getAllCategoryByProduct(int id);
}
