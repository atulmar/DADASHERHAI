package com.allianz.shopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.model.Category;
import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DBUtility;
import com.allianz.shopping.utility.DateUtility;


public class ProductDaoDatabaseImpl implements ProductDAO{
	
	Connection con;
	CategoryDAO impl=new CategoryDAODatabaseImpl();
	@Override
	public Product getAllProductByCategory(int id) {
		String sql="select * from tbl_category where category_id in(select category_id from product_category where productId=?)";
	     List<Product> productList=new ArrayList<Product>();
		/* List<Category> categoryList=new ArrayList<Category>(); */
	     
	     con=DBUtility.getConnection();
			try {
				PreparedStatement pst=con.prepareStatement(sql);
				
				pst.setInt(1, id);
				ResultSet rs=pst.executeQuery();
				if(rs.next())
				{
					Product product=new Product();
					product.setProductId(rs.getInt(1));
					product.setProductCode(rs.getString(2));
					product.setDescription(rs.getString(3));
					product.setPrice(rs.getFloat(4));
					product.setMunfDate(rs.getDate(5));
					product.setCategoryList( impl.getAllCategoryByProduct(product.getProductId()));
					productList.add(product);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					return (Product) productList;
	}

	@Override
	public boolean addProduct(Product product)  {
		
		String sql="insert into tbl_product(productId,productCode,productDesc,productPrice,manfDate) values(?,?,?,?,?)";
		con=DBUtility.getConnection();
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,product.getProductId());
			pst.setString(2, product.getProductCode());
			pst.setString(3, product.getDescription());
			pst.setFloat(4, product.getPrice());
			pst.setDate(5, DateUtility.convertUtilToSql(product.getMunfDate()));
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
	public boolean updateProduct(Product product) {
		String sql="update tbl_product set productId=?,productCode=?, productDesc=?,productPrice=?,manfDate=? where productId=?";
		con=DBUtility.getConnection();		
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,product.getProductId());
			pst.setString(2, product.getProductCode());
			pst.setString(3, product.getDescription());
			pst.setFloat(4, product.getPrice());
			pst.setDate(5, DateUtility.convertUtilToSql(product.getMunfDate()));
			pst.setInt(6,product.getProductId());
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
	public boolean deleteProduct(int productId) {
		
		String sql="delete from tbl_product where productId=?";
		con=DBUtility.getConnection();
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,productId);
			
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
	public List<Product> getAllProduct() {
String sql="select productId,productCode,productDesc,productPrice,manfDate from tbl_product";
     List<Product> productList=new ArrayList<Product>();
     con=DBUtility.getConnection();
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Product product=new Product();
				product.setProductId(rs.getInt(1));
				product.setProductCode(rs.getString(2));
				product.setDescription(rs.getString(3));
				product.setPrice(rs.getFloat(4));
				product.setMunfDate(rs.getDate(5));
				product.setCategoryList( impl.getAllCategoryByProduct(product.getProductId()));
				productList.add(product);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				return productList;
		
	}

	@Override
	public List<Product> getAllProductByName(String productName) {
		
		String sql="select productId,productCode,productDesc,productPrice,manfDate from tbl_product where productDesc=?";
	     List<Product> productList=new ArrayList<Product>();
	     con=DBUtility.getConnection();
			try {
				PreparedStatement pst=con.prepareStatement(sql);
				
				pst.setString(1, productName);
				ResultSet rs=pst.executeQuery();
				if(rs.next())
				{
					Product product=new Product();
					product.setProductId(rs.getInt(1));
					product.setProductCode(rs.getString(2));
					product.setDescription(rs.getString(3));
					product.setPrice(rs.getFloat(4));
					product.setMunfDate(rs.getDate(5));
					productList.add(product);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					return productList;
	}

	@Override
	public List<Product> getAllProductByPrice(float min, float max) {
		
		String sql="select productId,productCode,productDesc,productPrice,manfDate from tbl_product where productPrice>=? and productPrice<=?";
	     List<Product> productList=new ArrayList<Product>();
	     con=DBUtility.getConnection();
			try {
				PreparedStatement pst=con.prepareStatement(sql);
				
				pst.setFloat(1, min);
				pst.setFloat(2, max);
				ResultSet rs=pst.executeQuery();
				if(rs.next())
				{
					Product product=new Product();
					product.setProductId(rs.getInt(1));
					product.setProductCode(rs.getString(2));
					product.setDescription(rs.getString(3));
					product.setPrice(rs.getFloat(4));
					product.setMunfDate(rs.getDate(5));
					productList.add(product);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					return productList;
	}

	@Override
	public Product getProductById(int id) {
		
		String sql="select productId,productCode,productDesc,productPrice,manfDate from tbl_product where productId=?";
	     con=DBUtility.getConnection();
	     Product product=new Product();
			try {
				PreparedStatement pst=con.prepareStatement(sql);
				
				pst.setInt(1, id);
				
				ResultSet rs=pst.executeQuery();
				if(rs.next())
				{
					product.setProductId(rs.getInt(1));
					product.setProductCode(rs.getString(2));
					product.setDescription(rs.getString(3));
					product.setPrice(rs.getFloat(4));
					product.setMunfDate(rs.getDate(5));
					return product;
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
					
	}

	
}
