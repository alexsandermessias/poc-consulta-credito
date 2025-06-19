package br.com.integra.poc.api.kafka;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.integra.poc.api.credito.dto.CreditoDto;
import io.netty.handler.codec.http.HttpMethod;

@Service
public class KafkaService {

	private static final Logger log = LoggerFactory.getLogger(KafkaService.class);

	@Value("${kafka.bootstrapServers}")
	String bootstrapServers;
	@Value("${kafka.topic}")
	String topic;
	final ObjectMapper mapper;

	public KafkaService() {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(Include.NON_NULL);
	}

	public void sendMessage(String url, String method, Object obj, Integer status) {
		final KafkaMsg msg = new KafkaMsg();
		msg.setDateTime(new Date());
		msg.setMethod(method);
		msg.setEndpoint(url);
		msg.setStatusCode(status);
		msg.setBody(obj);
		try {
			final Properties properties = new Properties();
			properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
			properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
			properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
			final KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
			final String json = mapper.writeValueAsString(msg);
			final ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, json);
			producer.send(producerRecord);
			producer.flush();
			producer.close();
		} catch (JsonProcessingException e) {
			log.error("error sending message", e);
		}
	}

	public  <T> void log(String url,ResponseEntity<T> response) {
		sendMessage(url, "GET", response.getBody(), response.getStatusCodeValue());
	}
}

