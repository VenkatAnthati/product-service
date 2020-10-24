package com.productservice.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.productservice.dao.ProductDao;
import com.productservice.model.Product;
import com.productservice.service.EmployeePdfGeneratorService;
import com.productservice.service.ProductSevice;

@RestController
public class ProductController {

	@Autowired
	ProductDao proddao;
	@Autowired
	ProductSevice productService;
	@Autowired
	EmployeePdfGeneratorService pdfSevice;

	/**
	 * @return Product list
	 */
	@GetMapping("/product/All")
	public List<Product> getProductList() {

		List<Product> prodList = proddao.findAll();

		return prodList;
	}

	/**
	 * @param id
	 * @return Product
	 */
	@GetMapping("/product/{id}")
	@HystrixCommand(fallbackMethod = "fallbackdefaultProduct")
	public Product getProductById(@PathVariable Long id) {
		Product prod= null;
		try {
			 prod = proddao.findProductById(id);
         }catch(Exception e) {
        	        throw new RuntimeException();                        
         }
		//Product prod = proddao.findProductById(id);
		return prod;
	}
	
	/**
	 * @param id
	 * @return Product
	 */
	@GetMapping("/product/{id}/{name}")
	public Product getProductByIdAndName(@PathVariable("id") Long id, @PathVariable("name") String name) {
		Product prod= null;
		try {
			 prod = productService.getProductByIdAndName(id, name);
         }catch(Exception e) {
        	        throw new RuntimeException();                        
         }
		//Product prod = proddao.findProductById(id);
		return prod;
	}
	
	@PostMapping("/product/save")
	public String saveProduct(@RequestBody Product product) {
		Product prod= null;
		try {
			 productService.save(product);
         }catch(Exception e) {
        	        throw new RuntimeException();                        
         }
		//Product prod = proddao.findProductById(id);
		return "Product saved successfully";
	}

	public Product fallbackdefaultProduct(@PathVariable Long id) {
    System.out.println("this is default hystrix callback method");
		return new Product();
	}
	
	@GetMapping("/product/excel")
	public String generateExcel() {
		Product prod= null;
		try {
			 productService.generateExcel();;
         }catch(Exception e) {
        	        throw new RuntimeException();                        
         }
		//Product prod = proddao.findProductById(id);
		return "Excel generated successfully";
	}
	
	@GetMapping("/product/pdf")
	public String generatePdf() {
		Product prod= null;
		try {
			 productService.generatePdf();;
         }catch(Exception e) {
        	        throw new RuntimeException();                        
         }
		//Product prod = proddao.findProductById(id);
		return "Pdf generated successfully";
	}
	@GetMapping("/product/empPdf")
	public String generateEmpployee() throws FileNotFoundException, DocumentException {

		pdfSevice.preparetable();
		return "Emp Pdf generated successfully";
	}

}
