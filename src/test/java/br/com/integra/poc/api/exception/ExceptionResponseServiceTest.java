package br.com.integra.poc.api.exception;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import br.com.integra.poc.api.error.Error;
import br.com.integra.poc.api.error.ExtrasErrorDto;
import br.com.integra.poc.api.exception.ExceptionResponseService;


@ExtendWith(MockitoExtension.class)
class ExceptionResponseServiceTest {

	ExceptionResponseService exceptionResponseService = new ExceptionResponseService();
	
	@Test
	void getResponseEntityFromError() {
		assertDoesNotThrow(()->exceptionResponseService.getResponseEntityFromError(Error.ACESSO_NEGADO, new ExtrasErrorDto()));
	}
}
