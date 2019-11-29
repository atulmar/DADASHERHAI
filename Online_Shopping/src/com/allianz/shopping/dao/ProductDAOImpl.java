package com.allianz.shopping.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DateUtility;

import sun.reflect.generics.tree.ReturnType;

public class ProductDAOImpl implements ProductDAO {
private static List<Product> productList=new ArrayList<Product>();
static
{
	try {
		productList.add(new Product(101,"closeUp1","colgate",20,DateUtility.converStringToDate("12/12/1222")));
		productList.add(new Product(102,"closeUp2","colgate",21,DateUtility.converStringToDate("12/12/1222")));
		productList.add(new Product(103,"closeUp3","colgate",22,DateUtility.converStringToDate("12/12/1222")));
		productList.add(new Product(104,"closeUp4","colgate",22,DateUtility.converStringToDate("12/12/1222")));
		productList.add(new Product(105,"closeUp5","colgate",24,DateUtility.converStringToDate("12/12/1222")));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	@Override
	public boolean addProduct(Product product) {
		productList.add(product);
		return true;
		
	}

	@Override
	public boolean updateProduct(Product product) {
		if(productList!=null && productList.size()>0)
		{
			for(int i=0;i<productList.size();i++)
			{
				Product productTemp=productList.get(i);
				if(productTemp.getProductId()==product.getProductId())
				{
					productList.set(i, product);
					return true;
					
				}
			}
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int productId) {
		if(productList!=null && productList.size()>0)
		{
			for(int i=0;i<productList.size();i++)
			{
				Product productTemp=productList.get(i);
				if(productTemp.getProductId()==productId)
				{
					productList.remove(i);
					return true;
					
				}
			}
		}
		return false;
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productList;
	}

	@Override
	public List<Product> getAllProductByName(String productName) {
		
		if(productList!=null && productList.size()>0)
		{
			for(int i=0;i<productList.size();i++)
			{
				Product productTemp=productList.get(i);
				if(productTemp.getDescription().toLowerCase().contains(productName.toLowerCase()))
				{
					 
					productList.add(productTemp);
					
					
				}
			}
		}
		return productList;
	}

	@Override
	public List<Product> getAllProductByPrice(float min,float max) {
		
		if(productList!=null && productList.size()>0)
		{
			for(int i=0;i<productList.size();i++)
			{
				Product productTemp=productList.get(i);
				if(productTemp.getPrice()>=min && productTemp.getPrice()<=max )
				{
					 
					productList.add(productTemp);
					
					
				}
			}
		}
		return productList;
	}

	@Override
	public Product getProductById(int id) {
		if(productList!=null && productList.size()>0)
		{
			for(int i=0;i<productList.size();i++)
			{
				Product productTemp=productList.get(i);
				if(productTemp.getProductId()==id )
				{
					return productTemp;
					
				}
			}
		}
		
		return null;
	}

	@Override
	public Product getAllProductByCategory(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
