package webshop.products.mongo;

import java.util.ArrayList;
import java.util.List;

import org.amdatu.mongo.MongoDBService;
import org.mongojack.DBCursor;
import org.mongojack.JacksonDBCollection;

import com.mongodb.DBCollection;

import webshop.projects.api.Product;
import webshop.projects.api.ProductService;

public class MongoProductService implements ProductService {

	private volatile MongoDBService mongoDbService;
	private volatile DBCollection collection;
	private volatile JacksonDBCollection<Product, String> products;
	
	public void start() {
		collection = mongoDbService.getDB().getCollection("products");
		products = JacksonDBCollection.wrap(collection, Product.class, String.class);
	}
	
	@Override
	public List<Product> list(String category) {
		
		DBCursor<Product> dbCursor = products.find().is("category", category);	
		List<Product> result = new ArrayList<>();
		
		dbCursor.forEach(result::add);
		
		return result;
	}

}
