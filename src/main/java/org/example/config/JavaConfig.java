package org.example.config;

import org.example.profile.SystemProfile;
import org.example.profile.DevProfile;
import org.example.profile.ProductionProfile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;

@Configuration
public class JavaConfig {

    @Bean
    //@ConditionalOnProperty(name = "netology.profile.dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    //@ConditionalOnProperty(name = "netology.profile.dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }

    @Bean
    public SystemProfile systemProfile(@Value("${netology.profile.dev}") boolean isDev) {
        return isDev ? devProfile() : prodProfile();
    }
}