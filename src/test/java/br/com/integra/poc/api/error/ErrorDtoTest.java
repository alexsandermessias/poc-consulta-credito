package br.com.integra.poc.api.error;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import br.com.integra.poc.api.error.ErrorDto;
import util.TestData;

class ErrorDtoTest {

	private ErrorDto item = ErrorDtoBuilder.build();

	@Test
	void codigo() {
		item.setCodigo(TestData.vString);
		assertEquals(TestData.vString, item.getCodigo());
	}

	@Test
	void mensagem() {
		item.setMensagem(TestData.vString);
		assertEquals(TestData.vString, item.getMensagem());
	}

	@Test
	void extras() {
		item.setExtras(IExtrasErrorBuilder.build());
		assertNotNull(item.getExtras());
	}

	@Test
	void to_string(){
		assertNotNull(item.toString());
	}

}
