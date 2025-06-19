package br.com.integra.poc.api.credito;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.integra.poc.api.credito.dto.CreditoDto;
import br.com.integra.poc.api.kafka.KafkaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "Authorization")
public class CreditoResource implements CreditoResourceDoc {

	private final CreditoService creditoService;
	private final KafkaService kafkaService;
	
	public CreditoResource(CreditoService creditoService,KafkaService kafkaService) {
		this.creditoService = creditoService;
		this.kafkaService = kafkaService;
	}
	
	@GetMapping("/api/creditos/{numeroNfse}")
	@Override
	public ResponseEntity<List<CreditoDto>> consultarPorNumeroNfse(String token, String numeroNfse) {
		final ResponseEntity<List<CreditoDto>> response = creditoService.consultarPorNumeroNfse(numeroNfse);
		kafkaService.log(String.format("/api/creditos/%s",numeroNfse), response);
		return response;
	}
	@GetMapping("/api/creditos/credito/{numeroCredito}")
	@Override
	public ResponseEntity<CreditoDto> consultarPorNumeroCredito(String token, String numeroCredito) {
		final ResponseEntity<CreditoDto> response = creditoService.consultarPorNumeroCredito(numeroCredito);
		kafkaService.log(String.format("/api/creditos/credito/%s",numeroCredito), response);
		return response;
	}

}
 