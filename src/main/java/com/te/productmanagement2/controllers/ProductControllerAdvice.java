package com.te.productmanagement2.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.productmanagement2.beans.ProductResponse;
import com.te.productmanagement2.customexp.ProductException;

@RestControllerAdvice
public class ProductControllerAdvice {

	@ExceptionHandler(ProductException.class)
	public ProductResponse handleEmployeeException(ProductException exception) {
		ProductResponse response = new ProductResponse();
		response.setStatusCode(500);
		response.setMsg("Failure");
		response.setDescription(exception.getMessage());
		return response;
	}
}