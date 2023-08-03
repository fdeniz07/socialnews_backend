package com.batch130.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

//This class created for swagger
@Configuration
@OpenAPIDefinition(info = @Info(title = "Socialnews API", version = "1.0.0"))
public class OpenAPIConfig {
}
