package br.com.integra.poc.api.externo.caf.dto.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import br.com.banestes.rcd.biziapi.data.TestData;

class FaceIdFaceMatchResponseBodyTest {

	private FaceIdFaceMatchResponseBody item = FaceIdFaceMatchResponseBodyBuilder.build();

	@Test
	void similarity() {
		item.setSimilarity(TestData.vBigDecimal);
		assertEquals(TestData.vBigDecimal, item.getSimilarity());
	}

	@Test
	void facematch() {
		item.setFaceMatch(booleanBuilder.build());
		assertNotNull(item.getFaceMatch());
	}

	@Test
	void to_string(){
		assertNotNull(item.toString());
	}

}
