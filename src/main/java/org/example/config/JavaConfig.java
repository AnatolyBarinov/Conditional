package org.example.config;

import org.example.SystemProfile;
import org.example.controller.DevProfile;
import org.example.profile.ProductionProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan("org.example.controller")
public class JavaConfig {

    @Bean
    @Profile("dev")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @Profile("prod")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }

}