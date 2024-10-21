package com.libwiz.libwiz.configurations;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfigurations {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-api")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("user-api-doc")
                .pathsToMatch("/api/users/**")
                .build();
    }

    @Bean
    public GroupedOpenApi userProfileApi() {
        return GroupedOpenApi.builder()
                .group("user-profile-api")
                .pathsToMatch("/api/users/userprofiles/**") // Kullanıcı profilleri yolları
                .build();
    }

    @Bean
    public OpenAPI libwizOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Library Wizard API")
                        .description("This API for Library Wizard Automation")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Libwiz Wiki Documentation"));
    }
}