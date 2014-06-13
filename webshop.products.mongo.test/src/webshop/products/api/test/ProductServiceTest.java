package webshop.products.api.test;

import java.util.List;
import java.util.Properties;

import org.amdatu.bndtools.test.BaseOSGiServiceTest;

import webshop.projects.api.Product;
import webshop.projects.api.ProductService;

public class ProductServiceTest extends BaseOSGiServiceTest<ProductService>{

	public ProductServiceTest() {
		super(ProductService.class);
	}
	
	@Override
	public void setUp() throws Exception {
		
		Properties props = new Properties();
		props.put("dbName", "osgiwebshop");
		configureFactory("org.amdatu.mongo", props);
		
		super.setUp();
	}
	
	public void test() {
		
		List<Product> list = instance.list("Books");
		assertEquals(4, list.size());
	}
}