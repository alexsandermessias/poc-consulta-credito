package br.com.integra.poc.api.credito;

import java.util.List;
import java.util.Objects;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.integra.poc.api.credito.dto.CreditoDto;

@Service
public class CreditoService {

	
	private final CreditoMapper mapper;
	private final CreditoRepository repository;
	
	public CreditoService(CreditoMapper mapper, CreditoRepository repository) {
		this.mapper = mapper;
		this.repository = repository;
	}
	
	public ResponseEntity<List<CreditoDto>> consultarPorNumeroNfse(String numeroNfse) {
		final List<CreditoDto> ret = mapper.toDtoList(repository.consultarPorNumeroNfse(numeroNfse));
		if (Objects.isNull(ret) || ret.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ret);
	}

	public ResponseEntity<CreditoDto> consultarPorNumeroCredito(String numeroCredito) {
		final CreditoDto dto = mapper.toDto(repository.consultarPorNumeroCredito(numeroCredito));
		if (Objects.isNull(dto)) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().body(dto);
		}
		
	}
	

}
