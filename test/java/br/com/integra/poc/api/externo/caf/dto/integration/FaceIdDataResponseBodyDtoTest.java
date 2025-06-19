package br.com.integra.poc.api.externo.caf.dto.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import br.com.banestes.rcd.biziapi.data.TestData;

class FaceIdDataResponseBodyDtoTest {

	private FaceIdDataResponseBodyDto item = FaceIdDataResponseBodyDtoBuilder.build();

	@Test
	void id() {
		item.setId(TestData.vString);
		assertEquals(TestData.vString, item.getId());
	}

	@Test
	void createdat() {
		item.setCreatedAt(TestData.vString);
		assertEquals(TestData.vString, item.getCreatedAt());
	}

	@Test
	void peopleid() {
		item.setPeopleId(TestData.vString);
		assertEquals(TestData.vString, item.getPeopleId());
	}

	@Test
	void sourceip() {
		item.setSourceIp(TestData.vString);
		assertEquals(TestData.vString, item.getSourceIp());
	}

	@Test
	void executionoriginid() {
		item.setExecutionOriginId(TestData.vString);
		assertEquals(TestData.vString, item.getExecutionOriginId());
	}

	@Test
	void registeredimageurl() {
		item.setRegisteredImageUrl(TestData.vString);
		assertEquals(TestData.vString, item.getRegisteredImageUrl());
	}

	@Test
	void receivedimageurl() {
		item.setReceivedImageUrl(TestData.vString);
		assertEquals(TestData.vString, item.getReceivedImageUrl());
	}

	@Test
	void math() {
		item.setMath(booleanBuilder.build());
		assertNotNull(item.getMath());
	}

	@Test
	void facematch() {
		item.setFaceMatch(FaceIdFaceMatchResponseBodyBuilder.build());
		assertNotNull(item.getFaceMatch());
	}

	@Test
	void liveness() {
		item.setLiveness(FaceIdLivenessResponseBodyBuilder.build());
		assertNotNull(item.getLiveness());
	}

	@Test
	void to_string(){
		assertNotNull(item.toString());
	}

}
