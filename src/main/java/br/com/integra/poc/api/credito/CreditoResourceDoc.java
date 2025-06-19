package br.com.integra.poc.api.credito;

import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import br.com.integra.poc.api.credito.dto.CreditoDto;
import br.com.integra.poc.api.error.ErrorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "API",  description = "Endpoints consulta de créditos constituídos")
public interface CreditoResourceDoc {

	@GetMapping("/api/creditos/{numeroNfse}")
    @Operation(summary = "Consultar creditos pelo número da NFS-e", 
    		description = "<b>Retorna uma lista de créditos constituídos com base no número da NFS-e.</b></br>"
    		+ "GET  /api/creditos/{numeroNfse}<br/>")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreditoDto[].class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class),
                            examples = {@ExampleObject(value = "{\"codigo\":\"poc-api.2\",\"mensagem\":\"Requisição inválida.\"}") })),
            @ApiResponse(responseCode = "403", description = "Acesso Negado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class),
                            examples = {@ExampleObject(value = "{\"codigo\":\"poc-api.1\",\"mensagem\":\"Acesso Negado.\"}") })),
            @ApiResponse(responseCode = "500", description = "Falha ao efetuar a operação.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class),
                            examples = {@ExampleObject(value = "{\"codigo\":\"poc-api.3\",\"mensagem\":\"Falha ao efetuar a operação.\"}") }))
    })
    ResponseEntity<List<CreditoDto>> consultarPorNumeroNfse(
    		@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
    		@Parameter(description = "numeroNfse", example = "1" ,required = true) @PathVariable String numeroNfse);
    
	
	@GetMapping("/api/creditos/credito/{numeroCredito}")
    @Operation(summary = "Consultar creditos pelo número do crédito constituído.", 
    		description = "<b>Retorna os detalhes de um crédito constituído específico com base no número do crédito constituído.</b></br>"
    		+ "GET  /api/creditoscredito/{numeroCredito}<br/>")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class),
                            examples = {@ExampleObject(value = "{\"codigo\":\"poc-api.2\",\"mensagem\":\"Requisição inválida.\"}") })),
            @ApiResponse(responseCode = "403", description = "Acesso Negado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class),
                            examples = {@ExampleObject(value = "{\"codigo\":\"poc-api.1\",\"mensagem\":\"Acesso Negado.\"}") })),
            @ApiResponse(responseCode = "500", description = "Falha ao efetuar a operação.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class),
                            examples = {@ExampleObject(value = "{\"codigo\":\"poc-api.3\",\"mensagem\":\"Falha ao efetuar a operação.\"}") }))
    })
    
    ResponseEntity<CreditoDto> consultarPorNumeroCredito(
    		@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
    		@Parameter(description = "numeroCredito", example = "1", required = true)  @PathVariable String numeroCredito);
   
    
}
