package br.com.integra.poc.api.credito.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import util.TestData;

class CreditoDtoTest {

	private CreditoDto item = new CreditoDto();

	@Test
	void numerocredito() {
		item.setNumeroCredito(TestData.vString);
		assertEquals(TestData.vString, item.getNumeroCredito());
	}

	@Test
	void numeronfse() {
		item.setNumeroNfse(TestData.vString);
		assertEquals(TestData.vString, item.getNumeroNfse());
	}

	@Test
	void dataconstituicao() {
		item.setDataConstituicao(LocalDate.now());
		assertNotNull(item.getDataConstituicao());
	}

	@Test
	void valorissqn() {
		item.setValorIssqn(TestData.vBigDecimal);
		assertEquals(TestData.vBigDecimal, item.getValorIssqn());
	}

	@Test
	void tipocredito() {
		item.setTipoCredito(TestData.vString);
		assertEquals(TestData.vString, item.getTipoCredito());
	}

	@Test
	void simplesnacional() {
		item.setSimplesNacional(Boolean.TRUE);
		assertTrue(item.isSimplesNacional());
	}

	@Test
	void aliquota() {
		item.setAliquota(TestData.vBigDecimal);
		assertEquals(TestData.vBigDecimal, item.getAliquota());
	}

	@Test
	void valorfaturado() {
		item.setValorFaturado(TestData.vBigDecimal);
		assertEquals(TestData.vBigDecimal, item.getValorFaturado());
	}

	@Test
	void valordeducao() {
		item.setValorDeducao(TestData.vBigDecimal);
		assertEquals(TestData.vBigDecimal, item.getValorDeducao());
	}

	@Test
	void basecalculo() {
		item.setBaseCalculo(TestData.vBigDecimal);
		assertEquals(TestData.vBigDecimal, item.getBaseCalculo());
	}

	@Test
	void to_string(){
		assertNotNull(item.toString());
	}

}