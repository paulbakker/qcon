package webshop.products.external;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.List;

import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.ConfigurationDependency;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

import webshop.projects.api.Product;
import webshop.projects.api.ProductService;

@Component
public class ExternalProductService implements ProductService, ManagedService {

	private volatile String remoteUrl;
	
	@Override
	public List<Product> list(String category) {
		
		return Arrays.asList(new Product("Product from external: " + remoteUrl, 50, "Books"));
	}

	@Override
	@ConfigurationDependency(pid="webshop.products.external")
	public void updated(Dictionary properties) throws ConfigurationException {
		
		remoteUrl = (String)properties.get("remoteUrl");
		
	}

}
