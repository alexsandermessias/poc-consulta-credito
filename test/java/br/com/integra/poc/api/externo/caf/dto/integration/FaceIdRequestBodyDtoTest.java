package br.com.integra.poc.api.externo.caf.dto.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import br.com.banestes.rcd.biziapi.data.TestData;

class FaceIdRequestBodyDtoTest {

	private FaceIdRequestBodyDto item = FaceIdRequestBodyDtoBuilder.build();

	@Test
	void tenant() {
		item.setTenant(TestData.vString);
		assertEquals(TestData.vString, item.getTenant());
	}

	@Test
	void onboardingid() {
		item.setOnboardingId(TestData.vString);
		assertEquals(TestData.vString, item.getOnboardingId());
	}

	@Test
	void type() {
		item.setType(TestData.vString);
		assertEquals(TestData.vString, item.getType());
	}

	@Test
	void personid() {
		item.setPersonId(TestData.vString);
		assertEquals(TestData.vString, item.getPersonId());
	}

	@Test
	void attemptid() {
		item.setAttemptId(TestData.vString);
		assertEquals(TestData.vString, item.getAttemptId());
	}

	@Test
	void match() {
		item.setMatch(booleanBuilder.build());
		assertNotNull(item.getMatch());
	}

	@Test
	void date() {
		item.setDate(TestData.vString);
		assertEquals(TestData.vString, item.getDate());
	}

	@Test
	void onboardingtoken() {
		item.setOnboardingToken(TestData.vString);
		assertEquals(TestData.vString, item.getOnboardingToken());
	}

	@Test
	void canal() {
		item.setCanal(TestData.vString);
		assertEquals(TestData.vString, item.getCanal());
	}

	@Test
	void to_string(){
		assertNotNull(item.toString());
	}

}
