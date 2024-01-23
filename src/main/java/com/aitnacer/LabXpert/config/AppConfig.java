package com.aitnacer.LabXpert.config;

import com.aitnacer.LabXpert.dtos.echantillon.EchantillonDto;
import com.aitnacer.LabXpert.entity.Echantillon;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
@ComponentScan("com.aitnacer.LabXpert")
@RequiredArgsConstructor
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();


        // Create a TypeMap with explicit mappings for Echantillon to EchantillonDto
        TypeMap<Echantillon, EchantillonDto> typeMap = modelMapper.createTypeMap(Echantillon.class, EchantillonDto.class);
        typeMap.addMapping(src -> src.getPatient().getId(), EchantillonDto::setPatientId);
        typeMap.addMapping(src -> src.getUtilisateur().getId(), EchantillonDto::setUtilisateurId);

        return modelMapper;
    }

    //This configuration will tell Jackson to serialize LocalDateTime
    // instances into strings in the format yyyy-MM-dd'T'HH:mm:ss.

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        return objectMapper;
    }
}
