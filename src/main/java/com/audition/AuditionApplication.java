package com.audition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
/**
 * @author Hari
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Audition Application REST API Documentation",
                description = "Audition Application REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Harikrishna Gopal",
                        email = "harikrishnag2007@gmail.com",
                        url = "https://www.google.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.google.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description =  "Audition Application REST API Documentation",
                url = "http://localhost:8080/swagger-ui.html"
        )
)

@SpringBootApplication
public class AuditionApplication {

    public static void main(final String[] args) {
        SpringApplication.run(AuditionApplication.class, args);
    }

}
