package br.com.integra.poc.api.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;

class ConstantsTest {

	@Test
	void constructor_Exception() {

		try {
			Constructor<Constants> constructor = Constants.class.getDeclaredConstructor();
			assertTrue(Modifier.isPrivate(constructor.getModifiers()));
			constructor.setAccessible(true);
			constructor.newInstance();
		} catch (Exception e) {
			
		}
	}
	
}
