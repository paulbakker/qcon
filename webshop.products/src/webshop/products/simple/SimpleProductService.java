package webshop.products.simple;

import java.util.Arrays;
import java.util.List;

import org.apache.felix.dm.annotation.api.Component;

import webshop.projects.api.Product;
import webshop.projects.api.ProductService;

@Component
public class SimpleProductService implements ProductService {

	@Override
	public List<Product> list(String category) {
		return Arrays.asList(new Product("Test product A from service", 10, "Books"), new Product("Test product B", 20, "Books"));
	}

}
