package br.com.integra.poc.api.kafka;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import util.TestData;
import util.TestUtil;

class KafkaServiceTest {

	
	@Test
	void sendMessage() {
		final KafkaService servico = new KafkaService();
		TestUtil.setFieldValue(servico, "bootstrapServers", "localhost:9092");
		TestUtil.setFieldValue(servico, "topic", "test-topic");
		ResponseEntity<String> response = ResponseEntity.ok("Teste");
		assertDoesNotThrow(() -> servico.sendMessage(TestData.vString,TestData.vString,response, 200));
	}
	@Test
	void sendMessage2() {
		final KafkaService servico = new KafkaService();
		final ObjectMapper mapper = mock(ObjectMapper.class);
	
		TestUtil.setFieldValue(servico, "bootstrapServers", "localhost:9092");
		TestUtil.setFieldValue(servico, "topic", "test-topic");
		TestUtil.setFieldValue(servico, "mapper", mapper);
		JsonProcessingException ex = mock(JsonProcessingException.class);
		try {
			when(mapper.writeValueAsString(any())).thenThrow(ex);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResponseEntity<String> response = ResponseEntity.ok("Teste");
		assertDoesNotThrow(() -> servico.sendMessage(TestData.vString,TestData.vString,response, 200));
	}
	@Test
	void log() {
		final KafkaService servico = new KafkaService();
		TestUtil.setFieldValue(servico, "bootstrapServers", "localhost:9092");
		TestUtil.setFieldValue(servico, "topic", "test-topic");
		ResponseEntity<String> response = ResponseEntity.ok("Teste");
		assertDoesNotThrow(() -> servico.log(TestData.vString,response));
	}

}
