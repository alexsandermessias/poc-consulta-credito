package br.com.integra.poc.api.credito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import br.com.integra.poc.api.credito.dto.CreditoDto;
import br.com.integra.poc.api.credito.entity.Credito;
import util.TestData;

public class CreditoMapperTest {
	
	private CreditoMapper mapper = new CreditoMapper();

	
	private Credito getModel() {
		final Credito model = new Credito();
		model.setAliquota(TestData.vBigDecimal);
		model.setNumeroCredito(TestData.vString);
		model.setNumeroNfse(TestData.vString);
		model.setDataConstituicao(LocalDate.now());
		model.setValorIssqn(TestData.vBigDecimal);
		model.setTipoCredito(TestData.vString);
		model.setSimplesNacional(TestData.vBoolean);
		model.setAliquota(TestData.vBigDecimal);
		model.setValorFaturado(TestData.vBigDecimal);
		model.setValorDeducao(TestData.vBigDecimal);
		model.setBaseCalculo(TestData.vBigDecimal);
		return model;
	}
	
	
	
	
	private CreditoDto getDto(){
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
	void toModel() {
	    CreditoDto dto = getDto();
	    assertNotNull(mapper.toModel(dto));
	}
	@Test
	void toModel2() {
	    assertNull(mapper.toModel(null));
	}
	@Test
	void toDto() {
	    Credito model = getModel();
	    assertNotNull(mapper.toDto(model));
	}
	@Test
	void toDto2() {
	    assertNull(mapper.toDto(null));
	}
	@Test
	void toDtoList() {
	    Credito model = getModel();
	    List<Credito> list = new ArrayList<>();
	    list.add(model);
	    assertNotNull(mapper.toDtoList(list));
	}
	@Test
	void toDtoList2() {
	    assertNotNull(mapper.toDtoList(null));
	}
	@Test
	void toModelList() {
	    CreditoDto dto = getDto();
	    List<CreditoDto> list = new ArrayList<>();
	    list.add(dto);
	    assertNotNull(mapper.toModelList(list));
	}
	@Test
	void toModelList2() {
	    assertNotNull(mapper.toModelList(null));
	}
}

