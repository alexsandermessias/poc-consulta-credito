package br.com.integra.poc.api.externo.caf.dto.integration;
import  br.com.banestes.rcd.biziapi.data.TestData;
import  java.util.List;
import  java.util.ArrayList;

public class FaceIdRequestBodyDtoBuilder{
	public static List<FaceIdRequestBodyDto> buildList(){
		List<FaceIdRequestBodyDto> list = new ArrayList<>();
		list.add(build());
		return list;
	}
	public static FaceIdRequestBodyDto build(){
		FaceIdRequestBodyDto ret = new FaceIdRequestBodyDto();
		ret.setTenant(TestData.vString);
		ret.setOnboardingId(TestData.vString);
		ret.setType(TestData.vString);
		ret.setPersonId(TestData.vString);
		ret.setAttemptId(TestData.vString);
		ret.setMatch(booleanBuilder.build());
		ret.setDate(TestData.vString);
		ret.setOnboardingToken(TestData.vString);
		ret.setCanal(TestData.vString);
		return ret;
	}
}
