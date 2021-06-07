package com.example.taller.configuration;

import com.example.taller.repository.CancionRepository;
import com.example.taller.service.ServiceCanciones;
import com.example.taller.service.ServiceCancionesImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {

    @Bean
    ServiceCanciones serviceCanciones(CancionRepository repository){
        return new ServiceCancionesImplement(repository);
    }
}
