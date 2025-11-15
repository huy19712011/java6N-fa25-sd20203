package org.example.java6nfa25sd20203.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    ModelMapper modelMapper() {

        return new ModelMapper();
    }
}
