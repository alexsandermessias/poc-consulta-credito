package br.com.integra.poc.api.exception;

import br.com.integra.poc.api.error.Error;
import br.com.integra.poc.api.error.ExtrasErrorDto;
import br.com.integra.poc.api.error.IExtrasError;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorException extends RuntimeException {
	private static final long serialVersionUID = 1930583446094956114L;

	private final Error erro;
	private final String mensagemLog;
	private final IExtrasError extras;

	public ErrorException(Error erro) {
		super(erro.getCodigo().concat(" - ").concat(erro.name()));
		this.erro = erro;
		this.mensagemLog = erro.getCodigo();
		this.extras = new ExtrasErrorDto();
	}

	public ErrorException(Error erro, Exception e) {
		super(e);
		this.erro = erro;
		this.mensagemLog = erro.getCodigo();
		this.extras = new ExtrasErrorDto();
	}

	public ErrorException(Error erro, String mensagemLog) {
		super(erro.getCodigo().concat(" - ").concat(erro.name()));
		this.erro = erro;
		this.mensagemLog = mensagemLog;
		this.extras = new ExtrasErrorDto();
	}

	public ErrorException(Error erro, String mensagemLog, Exception e) {
		super(e);
		this.erro = erro;
		this.mensagemLog = mensagemLog;
		this.extras = new ExtrasErrorDto();
	}
	
	public ErrorException(Error erro, IExtrasError extras) {
		super(erro.getCodigo().concat(" - ").concat(erro.name()));
		this.erro = erro;
		this.mensagemLog = erro.getCodigo();
		this.extras = extras;
	}
}
