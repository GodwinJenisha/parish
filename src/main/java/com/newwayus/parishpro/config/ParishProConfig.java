package com.newwayus.parishpro.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:${user.dir}/config.txt")

public class ParishProConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
