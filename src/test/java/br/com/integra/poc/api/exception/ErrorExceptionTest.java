package br.com.integra.poc.api.exception;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import br.com.integra.poc.api.error.Error;
import br.com.integra.poc.api.error.IExtrasError;
import br.com.integra.poc.api.exception.ErrorException;

class ErrorExceptionTest {

	@Test
	void build() {
		assertNotNull(new ErrorException(Error.ACESSO_NEGADO));
		assertNotNull(new ErrorException(Error.ACESSO_NEGADO, new Exception()));
		assertNotNull(new ErrorException(Error.ACESSO_NEGADO, "mensagem"));
		assertNotNull(new ErrorException(Error.ACESSO_NEGADO, "mensagem", new Exception()));
	}

	@Test
	void get() {
		assertNotNull(new ErrorException(Error.ACESSO_NEGADO).getErro());
		assertNotNull(new ErrorException(Error.ACESSO_NEGADO).getMensagemLog());
		IExtrasError extras = null;
		assertNotNull(new ErrorException(Error.ACESSO_NEGADO,extras).getMensagemLog());
	}
//	@Test
//	void get2() {
//		assertNotNull(new ErrorException(Error.ACESSO_NEGADO).getExtras());
//	}
}
