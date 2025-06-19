package br.com.integra.poc.api.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import br.com.integra.poc.api.config.ObjectMapperConfig;

public class ObjectMapperConfigTest {

	
	@Test
	void constructor() {
		ObjectMapperConfig  config = new ObjectMapperConfig();
		assertNotNull(config);
	}
	@Test
	void getMapper() {
		ObjectMapperConfig  config = new ObjectMapperConfig();
		assertNotNull(config.objectMapper());
	}
	@Test
	void getMapper3() {
		ObjectMapperConfig  config = new ObjectMapperConfig();
		ObjTestDto parametro = new ObjTestDto();
		parametro.setDataAlteracao(OffsetDateTime.now());
		String json = null;
		try {
			 json = config.objectMapper().writeValueAsString(parametro);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		assertNotNull(json);
	}
}
