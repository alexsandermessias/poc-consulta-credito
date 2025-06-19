package util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.time.OffsetDateTime;

public final class TestData {
	public static BigInteger vBigInteger = BigInteger.ONE;
	public static BigDecimal vBigDecimal = BigDecimal.ONE;
	public static Date vDate = new Date(1L);
	public static Long vLong = 1L;
	public static Double vDouble = 1.0;
	public static OffsetDateTime vOffsetDateTime = OffsetDateTime.now();
	public static Integer vInteger = 1;
	public static String vString = "1";
	public static String vStringSqlDate = "2000-01-30";
	public static String vStringIsoDate = "2000-01-30T00:00:00.000Z";
	public static String vStringCpf = "36951888043";
	public static Boolean vBoolean = true;
	
}
