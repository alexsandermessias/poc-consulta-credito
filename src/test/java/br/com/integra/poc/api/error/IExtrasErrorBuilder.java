package br.com.integra.poc.api.error;

import br.com.integra.poc.api.error.IExtrasError;

public class IExtrasErrorBuilder {

	public static IExtrasError build() {
		return new ExtrasErrorImp();
	}
}
