package br.com.integra.poc.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.integra.poc.api.error.Error;
import br.com.integra.poc.api.error.ErrorDto;
import br.com.integra.poc.api.error.IExtrasError;

@Service
public class ExceptionResponseService {
	public ResponseEntity<Object> getResponseEntityFromError(Error erro, IExtrasError extras) {
		return ResponseEntity.status(erro.getCodigoStatusHttp())
				.body(new ErrorDto(erro.getCodigo(), erro.getMensagem(), extras));
	}
}
