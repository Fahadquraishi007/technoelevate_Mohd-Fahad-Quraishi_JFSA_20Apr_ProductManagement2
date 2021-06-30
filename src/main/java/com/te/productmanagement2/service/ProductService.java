package com.te.productmanagement2.service;

import java.util.List;

import com.te.productmanagement2.beans.ProductInfoBean;

public interface ProductService {

	public ProductInfoBean authenticate(int pid, String pwd);

	public ProductInfoBean getProductData(int pid);

	public boolean deleteProductData(int id);
	
	public boolean addProduct(ProductInfoBean ProductInfoBean);
	
	public boolean updateRecord(ProductInfoBean productInfoBean);
	
	public List<ProductInfoBean> getAllProducts();
}