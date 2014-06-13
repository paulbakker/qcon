package webshop.projects.api;

import java.util.List;

public interface ProductService {
	
	List<Product> list(String category);
}
