package com.inerza.ulpgc.bookReview;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Book Review API")
                        .description("Example API for a book review application.")
                        .version("v1.0")
                        .contact(new Contact()
                                .url("https://www.inerza.com")
                                .email("info@inerza.com"))
                );
    }
}
