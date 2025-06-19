package br.com.integra.poc.api.exception;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.format.TextStyle;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import br.com.integra.poc.api.error.Error;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import util.TestUtil;

public class GlobalDefaultExceptionHandlerTest {

	public static class TesteValidador {

		@NotBlank
		private String valor = "";

		public String getValor() {
			return valor;
		}
	}

	@Test
	void constructor() {
		ExceptionResponseService service = new ExceptionResponseService();
		GlobalDefaultExceptionHandler error = new GlobalDefaultExceptionHandler(service);
		assertNotNull(error);
	}

	@Test
	void accessDeniedHandler() {
		ExceptionResponseService service = new ExceptionResponseService();
		GlobalDefaultExceptionHandler error = new GlobalDefaultExceptionHandler(service);
		//assertNotNull(error.accessDeniedHandler(new MockHttpServletRequest(), null));
	}

	@Test
	void accessDeniedHandler2() {
		ExceptionResponseService service = new ExceptionResponseService();
		GlobalDefaultExceptionHandler error = new GlobalDefaultExceptionHandler(service);
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setQueryString("?teste=123");
	//	assertNotNull(error.accessDeniedHandler(request, null));
	}

	@Test
	void errosExceptionErrorHandler() {
		ExceptionResponseService service = new ExceptionResponseService();
		GlobalDefaultExceptionHandler error = new GlobalDefaultExceptionHandler(service);
		ErrorException err = new ErrorException(Error.ACESSO_NEGADO);
		assertNotNull(error.errosExceptionErrorHandler(new MockHttpServletRequest(), err));
	}
	@Test
	void errosExceptionErrorHandler2() {
		ExceptionResponseService service = new ExceptionResponseService();
		GlobalDefaultExceptionHandler error = new GlobalDefaultExceptionHandler(service);
		LoggerContext ctx = (LoggerContext) LoggerFactory.getILoggerFactory();
		Logger logger = ctx.getLogger("br.com.integra.poc.api.exception.GlobalDefaultExceptionHandler");
		((ch.qos.logback.classic.Logger) logger).setLevel(Level.WARN);
			
		ErrorException err = new ErrorException(Error.ACESSO_NEGADO);
		assertNotNull(error.errosExceptionErrorHandler(new MockHttpServletRequest(), err));
	}

	@Test
	void defaultErrorHandler() {
		ExceptionResponseService service = new ExceptionResponseService();
		LoggerContext ctx = (LoggerContext) LoggerFactory.getILoggerFactory();
		ctx.getLogger(Logger.ROOT_LOGGER_NAME).setLevel(Level.WARN);	 
		GlobalDefaultExceptionHandler error = new GlobalDefaultExceptionHandler(service);
		 
		ErrorException err = new ErrorException(Error.ACESSO_NEGADO);
		
		assertNotNull(error.defaultErrorHandler(new MockHttpServletRequest(), err));
	}
	@Test
	void defaultErrorHandler_q() {
		ExceptionResponseService service = new ExceptionResponseService();
		LoggerContext ctx = (LoggerContext) LoggerFactory.getILoggerFactory();
		ctx.getLogger(Logger.ROOT_LOGGER_NAME).setLevel(Level.WARN);	 
		GlobalDefaultExceptionHandler error = new GlobalDefaultExceptionHandler(service);
		 
		ErrorException err = new ErrorException(Error.ACESSO_NEGADO);
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setQueryString("?teste=123");
	//	assertNotNull(error.accessDeniedHandler(re
		assertNotNull(error.defaultErrorHandler(request, err));
	}
	@Test
	void defaultErrorHandler_info() {
		ExceptionResponseService service = new ExceptionResponseService();
		LoggerContext ctx = (LoggerContext) LoggerFactory.getILoggerFactory();
		ctx.getLogger(Logger.ROOT_LOGGER_NAME).setLevel(Level.ERROR);	 
		GlobalDefaultExceptionHandler error = new GlobalDefaultExceptionHandler(service);
		 
		ErrorException err = new ErrorException(Error.ACESSO_NEGADO);
		
		assertNotNull(error.defaultErrorHandler(new MockHttpServletRequest(), err));
	}

	@Test
	void defaultErrorHandler2() {
		ExceptionResponseService service = new ExceptionResponseService();
		GlobalDefaultExceptionHandler error = new GlobalDefaultExceptionHandler(service);
		try {

			// ValidatorFactory factory = Validation.();
			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

			Set<ConstraintViolation<TesteValidador>> violations = validator.validate(new TesteValidador());
			if (!violations.isEmpty()) {
				// Eclipse refuses to let me use my violations variable
				throw new ConstraintViolationException(violations);
			}

		} catch (ConstraintViolationException ex) {
			assertNotNull(error.constraintViolationHandler(ex));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		assertNotNull(error);
	}

}
