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
import util.TestData;

@ExtendWith(MockitoExtension.class)
public class CreditoServiceTest {

	@Mock
	private CreditoMapper mapper;
	@Mock
	private CreditoRepository repository;
	
	@InjectMocks
	private CreditoService service;

	
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
	void consultarPorNumeroNfse() {
		final List<CreditoDto> list = new ArrayList<>();
		list.add(getDto());
		when(mapper.toDtoList(any())).thenReturn(list);
		final ResponseEntity<List<CreditoDto>> response = service.consultarPorNumeroNfse(TestData.vString);
		assertEquals(HttpStatus.OK,response.getStatusCode());
	}

	@Test
	void consultarPorNumeroNfse2() {
		final List<CreditoDto> list = new ArrayList<>();
		when(mapper.toDtoList(any())).thenReturn(list);
		final ResponseEntity<List<CreditoDto>> response = service.consultarPorNumeroNfse(TestData.vString);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	void consultarPorNumeroNfse3() {
		when(mapper.toDtoList(any())).thenReturn(null);
		final ResponseEntity<List<CreditoDto>> response = service.consultarPorNumeroNfse(TestData.vString);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	void consultarPorNumeroCredito() {
		when(mapper.toDto(any())).thenReturn(getDto());
		final ResponseEntity<CreditoDto> response = service.consultarPorNumeroCredito(TestData.vString);
		assertEquals(HttpStatus.OK,response.getStatusCode());
	}

	@Test
	void consultarPorNumeroCredito2() {
		final ResponseEntity<CreditoDto> response = service.consultarPorNumeroCredito(TestData.vString);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

}
