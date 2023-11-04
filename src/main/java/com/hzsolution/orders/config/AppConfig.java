package com.hzsolution.orders.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan
public class AppConfig {
    @Autowired
    private static Environment environment;
    public String getSelectedEnv() {return selectedEnv;}

    public static String selectedEnv;
    @Value("${spring.profiles.active}")
    public void setSelectedEnv(String selectedEnv) {AppConfig.selectedEnv = selectedEnv;}

    // TODO set other environment variables
}
