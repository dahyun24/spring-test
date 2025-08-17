package com.hackathon.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        servers = {
                @Server(url = "http://223.130.160.49", description = "공인 ip 서버"),
                @Server(url = "http://localhost:8080", description = "로컬 서버")
        }
)
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AskTrace API")
                        .description("Slack 연동 요약 API 문서")
                        .version("v1.0"));
    }
}