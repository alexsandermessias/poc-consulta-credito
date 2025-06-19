package br.com.integra.poc.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@SecurityScheme(
		  name = "Authorization",
		  type = SecuritySchemeType.HTTP,
		  bearerFormat = "JWT",
		  scheme = "bearer",
		  description = "Bearer authentication - Token gerado a partir das credenciais do gateway, "
		  		+ "utilizando o escopo: poc-api ",
		  in = SecuritySchemeIn.HEADER
		)
public class OpenApiConfig {
	private static final String VERSAO_API = "0.1";
	private static final String TITULO = "poc-api";
	private static final String DESCRICAO = 
			"API responsável pela integracão entre os produtos de biometria.</br></br>"
			+ "Importando este swagger no POSTMAN configure as variáveis:</br></br>";
	private static final String DESCRICAO_URL = "[ Base URL: https://poc-api-segi-dev.apps.ioc.nonprod.bcloud.sfb ]";
	private static final String URL = "https://poc-api-segi-dev.apps.ioc.nonprod.bcloud.sfb/swagger-ui/index.html";

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title(TITULO)
						.description(DESCRICAO)
						.version(VERSAO_API)

		).externalDocs(new ExternalDocumentation().description(DESCRICAO_URL)
				.url(URL));
	}
	
}
