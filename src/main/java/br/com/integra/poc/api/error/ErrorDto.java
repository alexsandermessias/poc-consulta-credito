package br.com.integra.poc.api.error;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreType
@JsonInclude(Include.NON_NULL)
public class ErrorDto implements Serializable {
	private static final long serialVersionUID = 8084762779773072148L;
	private String codigo;
	private String mensagem;
	private IExtrasError extras;
}
