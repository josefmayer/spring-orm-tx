package josefmayer.spring.orm.main;

import josefmayer.spring.orm.model.Product;
import josefmayer.spring.orm.service.ProductService;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class SpringOrmMain {
	
	public static void main(String[] args) {
		
		//Create Spring application context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");
		
		//Get service from context. (service's dependency (ProductDAO) is autowired in ProductService)
		ProductService productService = ctx.getBean(ProductService.class);

		//Do some data operation
		insertProducts(productService);
		printProducts(productService);

		insertDuplicateId(productService);
		printProducts(productService);

		printProductsByType(productService, "fruit");



		ctx.close();
		
	}

	static void insertProducts(ProductService productService){
		productService.add(new Product(1, "Kiwi", "fruit"));
		productService.add(new Product(2, "Banana", "fruit"));
		productService.add(new Product(3, "Mobile", "tech"));
		productService.add(new Product(4, "Bike", "sports"));
		productService.add(new Product(5, "Notebook", "tech"));
	}

	static void insertDuplicateId(ProductService productService){
		try {
			productService.add(new Product(3, "Orange", "fruit"));
		} catch (DataAccessException dataAccessException) {
		}

	}

	static void printProducts(ProductService productService){
		System.out.println("*** Products in List ***");
		for (Product product : productService.listAll()){
			System.out.println(product);
		}
	}

	static void printProductsByType(ProductService productService, String type){
		System.out.println("*** Products in List ***");
		for (Product product : productService.findByType(type)){
			System.out.println(product);
		}
	}

}
