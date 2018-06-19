package com.firebrigadeserver.config;

import com.firebrigadeserver.dto.mapper.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Locale;

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
    public FirefighterTrainingMapper firefighterTrainingMapper() {
        return new FirefighterTrainingMapper();
    }

    @Bean
    public CarMapper carMapper() {
        return new CarMapper();
    }

    @Bean
    public EquipmentMapper equipmentMapper() {
        return new EquipmentMapper();
    }

    @Bean
    public CarEquipmentMapper carEquipmentMapper() {
        return new CarEquipmentMapper();
    }

    @Bean
    public CarIncidentMapper carIncidentMapper() {
        return new CarIncidentMapper();
    }

    @Bean
    public IncidentMapper incidentMapper() {
        return new IncidentMapper();
    }

    @Bean
    public IncidentFullMapper incidentFullMapper() {
        return new IncidentFullMapper();
    }

    @Bean
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy_MM_dd", Locale.getDefault());
    }
}
