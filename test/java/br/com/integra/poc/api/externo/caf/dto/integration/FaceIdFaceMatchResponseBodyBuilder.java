package br.com.integra.poc.api.externo.caf.dto.integration;
import  br.com.banestes.rcd.biziapi.data.TestData;
import  java.util.List;
import  java.util.ArrayList;

public class FaceIdFaceMatchResponseBodyBuilder{
	public static List<FaceIdFaceMatchResponseBody> buildList(){
		List<FaceIdFaceMatchResponseBody> list = new ArrayList<>();
		list.add(build());
		return list;
	}
	public static FaceIdFaceMatchResponseBody build(){
		FaceIdFaceMatchResponseBody ret = new FaceIdFaceMatchResponseBody();
		ret.setSimilarity(TestData.vBigDecimal);
		ret.setFaceMatch(booleanBuilder.build());
		return ret;
	}
}
