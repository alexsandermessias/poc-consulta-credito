package br.com.integra.poc.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {

	@ExceptionHandler({ MethodArgumentNotValidException.class, HttpMessageNotReadableException.class })
	public @ResponseBody ResponseEntity<ErrorDto> handleDefaultException(Throwable ex) {
		final ErrorDto error = new ErrorDto();
		error.setCodigo(Error.REQUISICAO_INVALIDA.getCodigo());
		error.setMensagem(Error.REQUISICAO_INVALIDA.getMensagem());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
