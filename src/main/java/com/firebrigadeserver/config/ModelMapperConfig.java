package com.firebrigadeserver.config;

import com.firebrigadeserver.dto.mapper.FireBrigadeIncidentMapper;
import com.firebrigadeserver.dto.mapper.FireBrigadeMapper;
import com.firebrigadeserver.dto.mapper.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean
    public FireBrigadeMapper fireBrigadeMapper() {
        return new FireBrigadeMapper();
    }

    @Bean
    public FireBrigadeIncidentMapper fireBrigadeIncidentMapper() {
        return new FireBrigadeIncidentMapper();
    }
}
