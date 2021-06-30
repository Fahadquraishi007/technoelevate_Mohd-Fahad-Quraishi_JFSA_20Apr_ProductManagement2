package com.te.productmanagement2.dao;

import java.util.List;

import com.te.productmanagement2.beans.ProductInfoBean;

public interface ProductDAO {

	public ProductInfoBean authenticate(int id, String pwd);

	public ProductInfoBean getProductData(int id);

	public boolean deleteProductData(int id);

	public boolean addEmployee(ProductInfoBean productInfoBean);

	public boolean updateRecord(ProductInfoBean productInfoBean);

	public List<ProductInfoBean> getAllProducts();
}