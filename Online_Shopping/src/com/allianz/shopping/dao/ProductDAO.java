package com.allianz.shopping.dao;

import java.util.List;

import com.allianz.shopping.model.Product;

public interface ProductDAO {
public boolean addProduct(Product product);
public boolean updateProduct(Product product);
public boolean deleteProduct(int productId);
public List<Product> getAllProduct();
public List<Product> getAllProductByName(String productName);
public List<Product> getAllProductByPrice(float min,float max);
public Product getProductById(int id);
public Product getAllProductByCategory(int id);

}
