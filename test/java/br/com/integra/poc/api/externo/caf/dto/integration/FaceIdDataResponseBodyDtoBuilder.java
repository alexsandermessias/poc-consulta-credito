package br.com.integra.poc.api.externo.caf.dto.integration;
import  br.com.banestes.rcd.biziapi.data.TestData;
import  java.util.List;
import  java.util.ArrayList;

public class FaceIdDataResponseBodyDtoBuilder{
	public static List<FaceIdDataResponseBodyDto> buildList(){
		List<FaceIdDataResponseBodyDto> list = new ArrayList<>();
		list.add(build());
		return list;
	}
	public static FaceIdDataResponseBodyDto build(){
		FaceIdDataResponseBodyDto ret = new FaceIdDataResponseBodyDto();
		ret.setId(TestData.vString);
		ret.setCreatedAt(TestData.vString);
		ret.setPeopleId(TestData.vString);
		ret.setSourceIp(TestData.vString);
		ret.setExecutionOriginId(TestData.vString);
		ret.setRegisteredImageUrl(TestData.vString);
		ret.setReceivedImageUrl(TestData.vString);
		ret.setMath(booleanBuilder.build());
		ret.setFaceMatch(FaceIdFaceMatchResponseBodyBuilder.build());
		ret.setLiveness(FaceIdLivenessResponseBodyBuilder.build());
		return ret;
	}
}
