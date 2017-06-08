package josefmayer.spring.orm.service;

import josefmayer.spring.orm.dao.ProductDao;
import josefmayer.spring.orm.model.Product;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductService {

	@Autowired
	private ProductDao productDao;

	@Transactional
	public void add(Product product) {
		productDao.persist(product);
	}
	
	@Transactional
	public void addAll(Collection<Product> products) {
		for (Product product : products) {
			productDao.persist(product);
		}
	}

	@Transactional(readOnly = true)
	public List<Product> listAll() {
		return productDao.findAll();
	}

	@Transactional(readOnly = true)
	public List<Product> findByType(String type) {
		return productDao.findByType(type);
	}


}
