package com.te.productmanagement2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.productmanagement2.beans.ProductInfoBean;
import com.te.productmanagement2.beans.ProductResponse;
import com.te.productmanagement2.service.ProductService;


@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping(path = "/getEmployee", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ProductResponse getEmployeeData(int id) {
		ProductInfoBean infoBean = service.getProductData(id);
		ProductResponse response = new ProductResponse();
		if (infoBean != null) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data found for id : " + id);
			response.setProductInfoBean(infoBean);
		} else {
			response.setStatusCode(404);
			response.setMsg("Failure");
			response.setDescription("Data not found for id : " + id);
		}
		return response;
	}

	@PostMapping(path = "/addEmployee", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ProductResponse addEmployeeData(@RequestBody ProductInfoBean infoBean) {
		ProductResponse response = new ProductResponse();

		if (service.addProduct(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data inserted Sucessfully");
		} else {
			response.setStatusCode(500);
			response.setMsg("failure");
			response.setDescription("Data Could not be inserted");
		}
		return response;
	}

	@PutMapping(path = "/updateEmployee", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ProductResponse updateEmpData(@RequestBody ProductInfoBean infoBean) {
		ProductResponse response = new ProductResponse();

		if (service.updateRecord(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data Updated Sucessfully");
		} else {
			response.setStatusCode(500);
			response.setMsg("failure");
			response.setDescription("Data Could not be updated");
		}
		return response;
	}

	@DeleteMapping(path = "/deleteRecord/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ProductResponse deleteRecord(@PathVariable int id) {
		ProductResponse response = new ProductResponse();

		if (service.deleteProductData(id)) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data Delete Sucessfully");
		} else {
			response.setStatusCode(500);
			response.setMsg("failure");
			response.setDescription("Data Not Exist");
		}
		return response;

	}//

	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ProductResponse getAllRecord() {
		ProductResponse response = new ProductResponse();
		List<ProductInfoBean> employeeInfoBeans = service.getAllProduct();
		if (employeeInfoBeans != null) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data Found Sucessfully");
			response.setProductInfoBeans(ProductInfoBeans);
		} else {
			response.setStatusCode(500);
			response.setMsg("failure");
			response.setDescription("Data Not Exist");
		}
		return response;
	}

}