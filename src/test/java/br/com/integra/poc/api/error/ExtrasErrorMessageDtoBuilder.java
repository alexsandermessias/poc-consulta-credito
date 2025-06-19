package br.com.integra.poc.api.error;
import  java.util.ArrayList;
import  java.util.List;
import br.com.integra.poc.api.error.ExtrasErrorMessageDto;
import util.TestData;

public class ExtrasErrorMessageDtoBuilder{
	public static List<ExtrasErrorMessageDto> buildList(){
		List<ExtrasErrorMessageDto> list = new ArrayList<>();
		list.add(build());
		return list;
	}
	public static ExtrasErrorMessageDto build(){
		ExtrasErrorMessageDto ret = new ExtrasErrorMessageDto();
		ret.setMensagem(TestData.vString);
		return ret;
	}
}
