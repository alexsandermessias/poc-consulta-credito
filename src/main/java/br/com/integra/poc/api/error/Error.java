package br.com.integra.poc.api.error;

import lombok.Getter;

@Getter
public enum Error {
	ACESSO_NEGADO("1", 403, "poc-api.1", "Acesso negado."),
	REQUISICAO_INVALIDA("2", 400, "poc-api.2", "Requisição inválida."),
	FALHA_EFETUAR_OPERACAO("3", 500, "poc-api.3", "Falha ao efetuar a operação.");
	
	private String id;
	private int codigoStatusHttp;
	private String codigo;
	private String mensagem;
	
	Error(final String id, final int codigoStatusHttp, final String codigo, final String mensagem) {
		this.id = id;
		this.codigoStatusHttp = codigoStatusHttp;
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public static Error getByCodigo(String codigo) {
		for (final Error valor : Error.values()) {
			if (valor.getCodigo().equals(codigo)) {
				return valor;
			}
		}
		return null;
	}
	
}
