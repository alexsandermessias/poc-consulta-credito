package br.com.integra.poc.api.error;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
public class ErrorTest {

	
	@Test
	void getid() {
		
		assertNotNull(Error.ACESSO_NEGADO.getId());
	}
	@Test
	void getByCodigo() {
		
		assertNotNull(Error.getByCodigo("poc-api.1"));
	}
	@Test
	void getByCodigo2() {
		
		assertNull(Error.getByCodigo("lixo"));
	}
}
