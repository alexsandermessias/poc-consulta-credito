package br.com.integra.poc.api.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import br.com.integra.poc.api.config.OpenApiConfig;

public class OpenApiConfigTest {

	
	@Test
	void constructor() {
		OpenApiConfig  config = new OpenApiConfig();
		assertNotNull(config);
	}
	@Test
	void getMapper() {
		OpenApiConfig  config = new OpenApiConfig();
		assertNotNull(config.springShopOpenAPI());
	}
}
