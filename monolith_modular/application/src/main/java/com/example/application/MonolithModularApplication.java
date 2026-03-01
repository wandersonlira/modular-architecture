package com.example.application;

import com.example.client.infrastructure.config.ClientModuleConfig;
import com.example.order.infrastructure.config.ModuleOrderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ClientModuleConfig.class, ModuleOrderConfig.class})
final class MonolithModularApplication {
	public static void main(String[] args) { SpringApplication.run(MonolithModularApplication.class, args);	}
}
