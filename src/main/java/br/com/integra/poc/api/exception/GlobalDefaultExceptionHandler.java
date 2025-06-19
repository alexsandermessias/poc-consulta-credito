package br.com.integra.poc.api.exception;

import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import br.com.integra.poc.api.error.Error;
import br.com.integra.poc.api.error.ExtrasErrorDto;
import br.com.integra.poc.api.error.ExtrasErrorMessageDto;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalDefaultExceptionHandler extends ResponseEntityExceptionHandler {

	private final ExceptionResponseService exceptionResponseService;

	public GlobalDefaultExceptionHandler(ExceptionResponseService exceptionResponseService) {
		super();
		this.exceptionResponseService = exceptionResponseService;
	}

	@ExceptionHandler(value = ErrorException.class)
	public ResponseEntity<Object> errosExceptionErrorHandler(HttpServletRequest req, ErrorException e) {
		if(log.isDebugEnabled()) {
			log.debug(e.getMensagemLog());
		}
		log.error(">ERROR< ErrosException", e);
		return exceptionResponseService.getResponseEntityFromError(e.getErro(), e.getExtras());
	}

	/*
	@ExceptionHandler(value = AccessDeniedException.class)
	public ResponseEntity<Object> accessDeniedHandler(HttpServletRequest req, AccessDeniedException e) {
		this.logRequest(req, e);
		return exceptionResponseService.getResponseEntityFromError(Error.ACESSO_NEGADO, new ExtrasErrorDto());
	}
*/
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> defaultErrorHandler(HttpServletRequest req, Exception e) {
		this.logRequest(req, e);
		ExtrasErrorMessageDto extrasErrorMessageDto = new ExtrasErrorMessageDto();
		extrasErrorMessageDto.setMensagem(e.getMessage());
		return exceptionResponseService.getResponseEntityFromError(Error.FALHA_EFETUAR_OPERACAO, extrasErrorMessageDto);
	}

	private void logRequest(HttpServletRequest request, Exception e) {
		final StringBuilder sb = new StringBuilder();
		sb.append(request.getMethod()).append(' ').append(request.getRequestURI());
		if (request.getQueryString() != null) {
			sb.append('?').append(request.getQueryString());
		}
		sb.append('\n');
		log.error(">ERROR< Erro na requisicao: {}", sb, e);
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Object> constraintViolationHandler(ConstraintViolationException e) {
		logConstraintViolationMessages(e.getConstraintViolations());
		return exceptionResponseService.getResponseEntityFromError(Error.REQUISICAO_INVALIDA, new ExtrasErrorDto());
	}

	private void logConstraintViolationMessages(Set<? extends ConstraintViolation<?>> constraintViolations) {
		log.info(">LOG< Mensagens de retorno das validacoes:");
		constraintViolations.stream().map(ConstraintViolation::getMessage).collect(
				Collectors.toList()).forEach(message -> log.info("- {}", message));
	}
}
