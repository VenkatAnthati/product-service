package com.productservice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.productservice.dao.ProductDao;

//@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ProductController.class)
@ActiveProfiles("test")
public class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ProductDao proddao;
	
	@InjectMocks
	private ProductController prodcontroller;

	/*
	 * @Before public void setUp() throws Exception { mockMvc =
	 * MockMvcBuilders.standaloneSetup(prodcontroller).build(); }
	 */

	@Test
	public void testGetProductslist() throws Exception {

		mockMvc.perform(get("/product/All")).andExpect(status().isOk());
	}

	@Test
	public void testgetProductById() throws Exception {

		mockMvc.perform(get("/product/{id}", 10001)).andExpect(status().isOk());
	}

}
