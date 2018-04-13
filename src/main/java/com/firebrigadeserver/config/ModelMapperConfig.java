package com.firebrigadeserver.config;

import com.firebrigadeserver.dto.mapper.*;
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

    @Bean
    public FirefighterMapper firefighterMapper() {
        return new FirefighterMapper();
    }

    @Bean
    public TrainingMapper trainingMapper() {
        return new TrainingMapper();
    }

    @Bean
    FirefighterTrainingMapper firefighterTrainingMapper() {
        return new FirefighterTrainingMapper();
    }
}
