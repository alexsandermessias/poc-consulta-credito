package br.com.integra.poc.api.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExtrasErrorMessageDto extends ExtrasErrorDto {
	private static final long serialVersionUID = -839800362873567764L;
	private String mensagem;
}
