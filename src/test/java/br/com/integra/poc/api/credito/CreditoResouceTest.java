package br.com.integra.poc.api.credito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import br.com.integra.poc.api.credito.dto.CreditoDto;
import br.com.integra.poc.api.kafka.KafkaService;
import util.TestData;

@ExtendWith(MockitoExtension.class)
class CreditoResouceTest {

	@Mock
	private CreditoService service;
	@Mock
	private KafkaService kafkaService;
	
	@InjectMocks
	private CreditoResource resource;
	
	
	private CreditoDto getDto() {
		final CreditoDto dto = new CreditoDto();
		dto.setAliquota(TestData.vBigDecimal);
		dto.setNumeroCredito(TestData.vString);
		dto.setNumeroNfse(TestData.vString);
		dto.setDataConstituicao(LocalDate.now());
		dto.setValorIssqn(TestData.vBigDecimal);
		dto.setTipoCredito(TestData.vString);
		dto.setSimplesNacional(TestData.vBoolean);
		dto.setAliquota(TestData.vBigDecimal);
		dto.setValorFaturado(TestData.vBigDecimal);
		dto.setValorDeducao(TestData.vBigDecimal);
		dto.setBaseCalculo(TestData.vBigDecimal);
		return dto;
	}
	@Test
	void consultarPorNumeroNfse_200() {
		final List<CreditoDto> list = new ArrayList<>();
		list.add(getDto());
		final ResponseEntity<List<CreditoDto>>  response = ResponseEntity.ok(list);
		when(service.consultarPorNumeroNfse(any())).thenReturn(response);
		assertEquals(HttpStatus.OK, resource.consultarPorNumeroNfse( TestData.vString).getStatusCode());
	}
	@Test
	void consultarPorNumeroNfse_400() {
		final ResponseEntity<List<CreditoDto>>  response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		when(service.consultarPorNumeroNfse(any())).thenReturn(response);
		assertEquals(HttpStatus.BAD_REQUEST, resource.consultarPorNumeroNfse( TestData.vString).getStatusCode());
	}
	@Test
	void consultarPorNumeroNfse_404() {
		final ResponseEntity<List<CreditoDto>>  response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		when(service.consultarPorNumeroNfse(any())).thenReturn(response);
		assertEquals(HttpStatus.NOT_FOUND, resource.consultarPorNumeroNfse( TestData.vString).getStatusCode());

	}
	@Test
	void consultarPorNumeroNfse_500() {
		final ResponseEntity<List<CreditoDto>>  response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		when(service.consultarPorNumeroNfse(any())).thenReturn(response);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, resource.consultarPorNumeroNfse( TestData.vString).getStatusCode());
	}
	@Test
	void consultarPorNumeroCredito_200() {
	
		final ResponseEntity<CreditoDto>  response = ResponseEntity.ok(getDto());
		when(service.consultarPorNumeroCredito(any())).thenReturn(response);
		assertEquals(HttpStatus.OK, resource.consultarPorNumeroCredito( TestData.vString).getStatusCode());
	}
	@Test
	void consultarPorNumeroCredito_400() {
		final ResponseEntity<CreditoDto>  response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		when(service.consultarPorNumeroCredito(any())).thenReturn(response);
		assertEquals(HttpStatus.BAD_REQUEST, resource.consultarPorNumeroCredito( TestData.vString).getStatusCode());
	}
	@Test
	void consultarPorNumeroCredito_404() {
		final ResponseEntity<CreditoDto>  response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		when(service.consultarPorNumeroCredito(any())).thenReturn(response);
		assertEquals(HttpStatus.NOT_FOUND, resource.consultarPorNumeroCredito( TestData.vString).getStatusCode());

	}
	@Test
	void consultarPorNumeroCredito_500() {
		final ResponseEntity<CreditoDto>  response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		when(service.consultarPorNumeroCredito(any())).thenReturn(response);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, resource.consultarPorNumeroCredito( TestData.vString).getStatusCode());
	}
	
	
}
