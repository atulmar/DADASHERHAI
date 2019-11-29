package com.allianz.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.model.Category;
import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DBUtility;
import com.allianz.shopping.utility.DateUtility;

public class CategoryDAODatabaseImpl implements CategoryDAO {
	Connection con;
	public CategoryDAODatabaseImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCategory(Category category) {
		String sql="insert into tbl_category(category_id,category_code,category_desc) values(?,?,?)";
		con=DBUtility.getConnection();
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,category.getCategoryId());
			pst.setString(2,category.getCategoryCode());
			pst.setString(3, category.getCateDesc());
			
			int i=pst.executeUpdate();
			if(i<0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllCategoryByName(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllCategoryByPrice(float min, float max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllCategoryByProduct(int id) {
		String sql="select * from tbl_category where category_id in(select category_id from product_category where productId=?)";
	    // List<Product> productList=new ArrayList<Product>();
		 List<Category> categoryList=new ArrayList<Category>();
		 Category category=new Category();
	     con=DBUtility.getConnection();
			try {
				PreparedStatement pst=con.prepareStatement(sql);
				
				pst.setInt(1, id);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					category.setCategoryId(rs.getInt(1));
					category.setCategoryCode(rs.getString(2));
					category.setCateDesc(rs.getString(3));
					categoryList.add(category);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					return categoryList;
	}

}
