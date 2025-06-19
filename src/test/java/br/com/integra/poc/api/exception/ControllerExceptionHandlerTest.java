package br.com.integra.poc.api.exception;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import br.com.integra.poc.api.error.ControllerExceptionHandler;

public class ControllerExceptionHandlerTest {

	
	@Test
	void constructor() {
		ControllerExceptionHandler handler = new ControllerExceptionHandler();
		handler.handleDefaultException(new Exception(""));
		assertNotNull(handler);
		
	}
}
