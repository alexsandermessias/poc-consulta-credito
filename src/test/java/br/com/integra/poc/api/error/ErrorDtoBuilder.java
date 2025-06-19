package br.com.integra.poc.api.error;
import  java.util.ArrayList;
import  java.util.List;
import br.com.integra.poc.api.error.ErrorDto;
import util.TestData;

public class ErrorDtoBuilder{
	public static List<ErrorDto> buildList(){
		List<ErrorDto> list = new ArrayList<>();
		list.add(build());
		return list;
	}
	public static ErrorDto build(){
		ErrorDto ret = new ErrorDto();
		ret.setCodigo(TestData.vString);
		ret.setMensagem(TestData.vString);
		ret.setExtras(IExtrasErrorBuilder.build());
		return ret;
	}
}
