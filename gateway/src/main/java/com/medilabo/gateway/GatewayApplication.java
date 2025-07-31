package com.medilabo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("patients", r -> r
						.path("/api/patients/**")
						.uri("http://patient:8081"))
				.route("notes", r -> r
						.path("/api/notes/**")
						.filters(f -> f.stripPrefix(1))
						.uri("http://notes:9101"))
				.route("risk", r -> r
						.path("/api/risks/**")
						.uri("http://risk:8082"))
				.build();
	}

}
