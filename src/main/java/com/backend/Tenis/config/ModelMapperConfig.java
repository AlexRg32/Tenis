package com.backend.Tenis.config;

import com.backend.Tenis.entity.Torneo;
import com.backend.Tenis.entity.relaciones.Gana;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Configuración explícita para evitar ambigüedades
        modelMapper.addMappings(new PropertyMap<Gana, Torneo>() {
            @Override
            protected void configure() {
                map(source.getId().getTorneoId(), destination.getId());
            }
        });

        return modelMapper;
    }
}