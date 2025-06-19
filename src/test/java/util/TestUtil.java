package util;

import java.lang.reflect.Field;
import org.springframework.util.ReflectionUtils;

public class TestUtil {

	public static void setFieldValue(Object obj, String fieldName, Object value) {
		Field field = ReflectionUtils.findField(obj.getClass(), fieldName);
		ReflectionUtils.makeAccessible(field);
		ReflectionUtils.setField(field, obj, value);
		
	}
}
