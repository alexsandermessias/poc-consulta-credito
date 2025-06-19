package br.com.integra.poc.api.externo.caf.dto.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import br.com.banestes.rcd.biziapi.data.TestData;

class FaceIdLivenessResponseBodyTest {

	private FaceIdLivenessResponseBody item = FaceIdLivenessResponseBodyBuilder.build();

	@Test
	void provality() {
		item.setProvality(TestData.vBigDecimal);
		assertEquals(TestData.vBigDecimal, item.getProvality());
	}

	@Test
	void alive() {
		item.setAlive(booleanBuilder.build());
		assertNotNull(item.getAlive());
	}

	@Test
	void to_string(){
		assertNotNull(item.toString());
	}

}
