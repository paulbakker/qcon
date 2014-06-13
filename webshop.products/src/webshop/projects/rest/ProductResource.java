package webshop.projects.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.ServiceDependency;
import org.osgi.framework.ServiceReference;

import webshop.projects.api.Product;
import webshop.projects.api.ProductService;

@Path("products")
@Component(provides = Object.class)
public class ProductResource {

	private final Map<ServiceReference, ProductService> pServices = new ConcurrentHashMap<>();

	@ServiceDependency(removed = "removeProductService")
	public void addProductService(ServiceReference ref, ProductService pService) {
		pServices.put(ref, pService);
	}

	public void removeProductService(ServiceReference ref) {
		pServices.remove(ref);
	}

	@GET
	@Path("categories")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> categories() {
		return Arrays.asList("Books", "Games");
	}

	@GET
	@Path("{category}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> list(@PathParam("category") String category) {
		List<Product> products = new ArrayList<>();

		pServices.values().forEach(
				pService -> products.addAll(pService.list(category)));
		
		return products;

	}
}
