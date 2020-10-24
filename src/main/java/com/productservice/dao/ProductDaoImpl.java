package com.productservice.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.productservice.model.Product;
import com.productservice.repository.ProductRepository;

@Component
@Transactional
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	EntityTransaction tx = null;

	@Autowired
	ProductRepository repository;

	/**
	 * This method gives List of Products from database.
	 * 
	 * @return list of Products.
	 */
	@Override
	public List<Product> findAll() {

		return repository.findAll();
	}

	/**
	 * this method find Product by Id.
	 * 
	 * @return Product.
	 */
	@Override
	public Product findProductById(Long id) {
		Product product = null;
		try {
			/// product = repository.findById(new Long(id+"sdss")).get();
			Optional<Product> ss = repository.findById(id);
			product = ss.get();
		} catch (Exception e) {
			throw new RuntimeException();
		}

		return product;
	}

	@Override
	public Product getProductByIdAndName(Long id, String name) {

		Query query = em.createQuery("from Product p where p.productId=:arg1 and p.productName=:arg2");
		// Query query = em.createQuery("from Product p where p.productName=:arg2");
		query.setParameter("arg1", id);
		query.setParameter("arg2", name);

		@SuppressWarnings("unchecked")
		List<Product> resultList = query.getResultList();
		resultList.forEach(System.out::println);
		// Product product = resultList.get(0);
		return (resultList.isEmpty() || resultList.get(0) == null) ? null : resultList.get(0);

	}

	@Override
	public void save(Product product) {

		try {

			em.persist(product);
			em.flush();

		} catch (Exception e) {
			// tx.rollback();
		}
		// em.getTransaction().begin();
		// em.persist(product);
		// em.getTransaction().commit();
	}

	@Override
	public void getListOfProduct(List listOfProductId) {
		// TODO Auto-generated method stub
		
	}
 
}
