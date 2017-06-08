package josefmayer.spring.orm.dao;

import josefmayer.spring.orm.model.Product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

@Component
public class ProductDao {

	@PersistenceContext
	private EntityManager em;

	public void persist(Product product) {
		em.persist(product);
	}

	public List<Product> findAll() {
		return em.createQuery("SELECT p FROM Product p").getResultList();
	}

	public List<Product>findByType(String type){
		Query query = em.createQuery(
				"SELECT p FROM Product p WHERE p.type = :typeName"
		).setParameter("typeName", type);
		return query.getResultList();
	}

}
