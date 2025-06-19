package br.com.integra.poc.api.externo.caf.dto.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import br.com.banestes.rcd.biziapi.data.TestData;

class FaceIdResponseBodyDtoTest {

	private FaceIdResponseBodyDto item = FaceIdResponseBodyDtoBuilder.build();

	@Test
	void requestid() {
		item.setRequestId(TestData.vString);
		assertEquals(TestData.vString, item.getRequestId());
	}

	@Test
	void data() {
		item.setData(FaceIdDataResponseBodyDtoBuilder.build());
		assertNotNull(item.getData());
	}

	@Test
	void to_string(){
		assertNotNull(item.toString());
	}

}
