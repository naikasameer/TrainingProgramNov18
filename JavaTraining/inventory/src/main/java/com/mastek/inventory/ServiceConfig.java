package com.mastek.inventory;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig extends ResourceConfig{

	public ServiceConfig() {
		//register the CORS Filter for Service
		register(CORSFilter.class);
		// register the class as a Service
		register(ProductAccessAPI.class);
		
	}
}
