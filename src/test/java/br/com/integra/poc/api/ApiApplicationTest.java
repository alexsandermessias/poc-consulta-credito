package br.com.integra.poc.api;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class ApiApplicationTest {
	
	@Test
    void contextLoads(ApplicationContext context) {
        assertNotNull(context);
    }

    @Test
    void sourcesMustNotBeEmpty() {
        assertDoesNotThrow(() -> ApiApplication.main(new String[] {}));
    }
}
