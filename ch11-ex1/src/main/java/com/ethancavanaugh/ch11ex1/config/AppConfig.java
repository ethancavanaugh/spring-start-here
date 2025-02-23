package com.ethancavanaugh.ch11ex1.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.ethancavanaugh.ch11ex1.clients"})
public class AppConfig {
}
