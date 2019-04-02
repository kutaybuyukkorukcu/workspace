package com.phexum.webservice.nlp_webservice;

import com.phexum.sdk.application.ApplicationConfig;
import com.phexum.sdk.application.ApplicationConfigurator;
import com.phexum.sdk.application.PhexumApplicationConfig;

@PhexumApplicationConfig
public class Config implements ApplicationConfigurator {

	public void configure(ApplicationConfig config) {
		config.setName("App1");
		
	}
	
}
