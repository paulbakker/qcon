package webshop.products.mongo;

import java.util.Properties;

import org.amdatu.mongo.MongoDBService;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

import webshop.projects.api.ProductService;

public class Activator extends DependencyActivatorBase {

	@Override
	public void destroy(BundleContext arg0, DependencyManager arg1)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(BundleContext bc, DependencyManager dm) throws Exception {

		Properties props = new Properties();
		props.put("persistent", "true");
		
		dm.add(createComponent()
				.setInterface(ProductService.class.getName(), props)
				.setImplementation(MongoProductService.class)
				.add(createServiceDependency().setService(MongoDBService.class)
						.setRequired(true)));
	}

}
