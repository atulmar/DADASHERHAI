package com.allianz.shopping.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allianz.shopping.dao.ProductDAO;
import com.allianz.shopping.dao.ProductDAOImpl;
import com.allianz.shopping.dao.ProductDaoDatabaseImpl;
import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DateUtility;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO impl=new ProductDaoDatabaseImpl();
		
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String id=request.getParameter("id");
		if(action!=null && action.equals("delete"))
		{
			boolean flag=impl.deleteProduct(Integer.parseInt(id));
			if(flag)
			{
				response.sendRedirect("ProductController");
			}
		}
		else if(action!=null && action.equals("edit"))
		{
			Product product=impl.getProductById(Integer.parseInt(id));
			if(product!=null)
			{     
				request.setAttribute("product", product);
				request.getRequestDispatcher("product.jsp").forward(request, response);
			}
		}
		
		else if(action!=null && action.equals("new"))
		{
			
			Product product=new Product();
			if(product!=null)
			{
				request.setAttribute("product", product);
				request.getRequestDispatcher("product.jsp").forward(request, response);
			}
				
		}
		
			List<Product>list=impl.getAllProduct();
			request.setAttribute("list", list);
			request.getRequestDispatcher("productList.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action!=null &&( action.equals("update") || action.equals("save")))
		{
			String productId=request.getParameter("productId");
			String productCode=request.getParameter("productCode");
			String productDesc=request.getParameter("productDesc");
			String productPrice=request.getParameter("productPrice");
			String munfDate=request.getParameter("munfDate");
			Product product=new Product();
			product.setProductId(Integer.parseInt(productId));
			product.setProductCode(productCode);
			product.setPrice(Float.parseFloat(productPrice));
			try {
				product.setMunfDate(DateUtility.converStringToDate(munfDate));
				product.setDescription(productDesc);
				boolean flag=false;
				
				if(impl.getProductById(Integer.parseInt(productId))!=null)
				{
					flag=impl.updateProduct(product);
				}
				else
				{
					flag=impl.addProduct(product);
				}
				if(flag)
				response.sendRedirect("ProductController");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(action!=null && action.equals("save"))
		{
			String productId=request.getParameter("productId");
			String productCode=request.getParameter("productCode");
			String productDesc=request.getParameter("productDesc");
			String productPrice=request.getParameter("productPrice");
			String munfDate=request.getParameter("munfDate");
			Product product=new Product();
			product.setProductId(Integer.parseInt(productId));
			product.setProductCode(productCode);
			product.setPrice(Float.parseFloat(productPrice));
			try {
				product.setMunfDate(DateUtility.converStringToDate(munfDate));
				product.setDescription(productDesc);
				boolean flag=false;
				if(impl.getProductById(Integer.parseInt(productId))!=null)
				{
					flag=impl.updateProduct(product);
				}
				else
				{
					flag=impl.addProduct(product);
				}
				if(flag)
				response.sendRedirect("ProductController");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		List<Product>list=impl.getAllProduct();
		request.setAttribute("list", list);
		request.getRequestDispatcher("productList.jsp").forward(request, response);
	}

}
   