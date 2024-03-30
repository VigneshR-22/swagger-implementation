package com.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Value("${info.title}")
    private String title;

    @Value("${info.description}")
    private String description;

    @Value("${info.version}")
    private String version;

    @Bean
    public OpenAPI mySwagger() {

        Contact contact = new Contact();
        contact.setEmail("viggy22vs@gmail.com");
        contact.setName("Vignesh R");

        Info info = new Info()
                .title(title)
                .version(version)
                .description(description)
                .contact(contact);

        return new OpenAPI().info(info);

    }
}
