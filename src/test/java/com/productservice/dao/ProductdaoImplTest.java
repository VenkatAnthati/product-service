package com.productservice.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.productservice.model.Product;
import com.productservice.repository.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductdaoImplTest {

	
	
	@Mock
	ProductRepository repository;

	@InjectMocks
	ProductDaoImpl dao;
	
	@Test
	public void testfindAll() {
		List<Product> prodlist=new ArrayList<Product>();
		when(repository.findAll()).thenReturn(prodlist);
		assertEquals(prodlist, dao.findAll());
	}
	
	@Test
	public void testfindProductById() {
		Product prod = new Product();// = Optional.of(new Product());
		//Object listdo;
		when(repository.findById((long) 10001)).thenReturn(Optional.of(prod));
		assertEquals(prod, dao.findProductById((long) 10001));
	}
	
}
