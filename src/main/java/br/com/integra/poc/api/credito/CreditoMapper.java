package br.com.integra.poc.api.credito;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import br.com.integra.poc.api.credito.dto.CreditoDto;
import br.com.integra.poc.api.credito.entity.Credito;

@Component
public class CreditoMapper {

	public Credito toModel(CreditoDto dto) {
		if (Objects.isNull(dto)) {
			return null;
		}
		final Credito model = new Credito();
		model.setNumeroCredito(dto.getNumeroCredito());
		model.setNumeroNfse(dto.getNumeroNfse());
		model.setDataConstituicao(dto.getDataConstituicao());
		model.setValorIssqn(dto.getValorIssqn());
		model.setTipoCredito(dto.getTipoCredito());
		model.setSimplesNacional(dto.isSimplesNacional());
		model.setAliquota(dto.getAliquota());
		model.setValorFaturado(dto.getValorFaturado());
		model.setValorDeducao(dto.getValorDeducao());
		model.setBaseCalculo(dto.getBaseCalculo());
		return model;
	}

	public CreditoDto toDto(Credito model) {
		if (Objects.isNull(model)) {
			return null;
		}
		final CreditoDto dto = new CreditoDto();
		dto.setNumeroCredito(model.getNumeroCredito());
		dto.setNumeroNfse(model.getNumeroNfse());
		dto.setDataConstituicao(model.getDataConstituicao());
		dto.setValorIssqn(model.getValorIssqn());
		dto.setTipoCredito(model.getTipoCredito());
		dto.setSimplesNacional(model.isSimplesNacional());
		dto.setAliquota(model.getAliquota());
		dto.setValorFaturado(model.getValorFaturado());
		dto.setValorDeducao(model.getValorDeducao());
		dto.setBaseCalculo(model.getBaseCalculo());
		return dto;
	}

	public List<Credito> toModelList(List<CreditoDto> dtos) {
		if (dtos != null) {
			return dtos.stream().map(this::toModel).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	public List<CreditoDto> toDtoList(List<Credito> models) {
		if (models != null) {
			return models.stream().map(this::toDto).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}
}

