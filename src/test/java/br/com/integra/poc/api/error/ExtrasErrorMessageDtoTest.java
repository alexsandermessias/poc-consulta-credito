package br.com.integra.poc.api.error;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import br.com.integra.poc.api.error.ExtrasErrorMessageDto;
import util.TestData;

class ExtrasErrorMessageDtoTest {

	private ExtrasErrorMessageDto item = ExtrasErrorMessageDtoBuilder.build();

	@Test
	void mensagem() {
		item.setMensagem(TestData.vString);
		assertEquals(TestData.vString, item.getMensagem());
	}

	@Test
	void to_string(){
		assertNotNull(item.toString());
	}

}
