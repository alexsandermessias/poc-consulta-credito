package br.com.integra.poc.api.error;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreType
public class ExtrasErrorDto implements IExtrasError{
	private static final long serialVersionUID = 879201838694411742L;
}
