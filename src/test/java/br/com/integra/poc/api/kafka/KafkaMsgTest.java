package br.com.integra.poc.api.kafka;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import util.TestData;

class KafkaMsgTest {

	private KafkaMsg item = new KafkaMsg();

	@Test
	void endpoint() {
		item.setEndpoint(TestData.vString);
		assertEquals(TestData.vString, item.getEndpoint());
	}

	@Test
	void method() {
		item.setMethod(TestData.vString);
		assertEquals(TestData.vString, item.getMethod());
	}

	@Test
	void datetime() {
		item.setDateTime(TestData.vDate);
		assertEquals(TestData.vDate, item.getDateTime());
	}

	@Test
	void statuscode() {
		item.setStatusCode(TestData.vInteger);
		assertEquals(TestData.vInteger, item.getStatusCode());
	}

	@Test
	void body() {
		item.setBody("");
		assertNotNull(item.getBody());
	}

	@Test
	void to_string(){
		assertNotNull(item.toString());
	}

}