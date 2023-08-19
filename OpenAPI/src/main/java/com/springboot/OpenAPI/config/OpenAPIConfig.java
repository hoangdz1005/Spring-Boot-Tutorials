package com.springboot.OpenAPI.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {
    private String devUrl = "http://localhost:8080";
    private String prodUrl = "https://bezkoder-api.com";

    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("nnh1005@gmail.com");
        contact.setName("Ngoc Hoang");
        contact.setUrl("https://www.nnh1005.com");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Book Management API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage books.").termsOfService("https://www.nnh1005.com/terms")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
    }

