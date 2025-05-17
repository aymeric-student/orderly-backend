package com.orderly.votybe.core;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI orderlyOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Orderly API")
                        .description("API de gestion de restaurants et menus")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Équipe Orderly")
                                .email("contact@orderly.com")))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Développement"),
                        new Server().url("https://api.orderly.com").description("Production")))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }
}
