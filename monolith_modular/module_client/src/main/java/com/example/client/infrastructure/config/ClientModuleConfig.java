package com.example.client.infrastructure.config;


import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = "com.example.client")
@EntityScan(basePackages = "com.example.client.infrastructure.persistence.entities")
@EnableJpaRepositories(basePackages = "com.example.client.infrastructure.persistence.repositories")
public class ClientModuleConfig { }