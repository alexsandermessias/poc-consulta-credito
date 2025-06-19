package br.com.integra.poc.api.externo.caf.dto.integration;
import  br.com.banestes.rcd.biziapi.data.TestData;
import  java.util.List;
import  java.util.ArrayList;

public class FaceIdLivenessResponseBodyBuilder{
	public static List<FaceIdLivenessResponseBody> buildList(){
		List<FaceIdLivenessResponseBody> list = new ArrayList<>();
		list.add(build());
		return list;
	}
	public static FaceIdLivenessResponseBody build(){
		FaceIdLivenessResponseBody ret = new FaceIdLivenessResponseBody();
		ret.setProvality(TestData.vBigDecimal);
		ret.setAlive(booleanBuilder.build());
		return ret;
	}
}
