package br.com.integra.poc.api.externo.caf.dto.integration;
import  br.com.banestes.rcd.biziapi.data.TestData;
import  java.util.List;
import  java.util.ArrayList;

public class FaceIdResponseBodyDtoBuilder{
	public static List<FaceIdResponseBodyDto> buildList(){
		List<FaceIdResponseBodyDto> list = new ArrayList<>();
		list.add(build());
		return list;
	}
	public static FaceIdResponseBodyDto build(){
		FaceIdResponseBodyDto ret = new FaceIdResponseBodyDto();
		ret.setRequestId(TestData.vString);
		ret.setData(FaceIdDataResponseBodyDtoBuilder.build());
		return ret;
	}
}
