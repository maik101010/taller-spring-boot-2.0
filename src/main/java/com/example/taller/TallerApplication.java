package com.example.taller;

import com.example.taller.entity.Cancion;
import com.example.taller.repository.CancionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TallerApplication implements CommandLineRunner {

    private CancionRepository repository;

    public TallerApplication(CancionRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TallerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Cancion cancion1 = new Cancion(1L, "Como no amarte", "Juanes", LocalDate.of(2018, 5, 20));
        Cancion cancion2 = new Cancion(2L, "Without you", "David Guetta", LocalDate.of(2016, 3, 18));
        Cancion cancion3 = new Cancion(3L, "Tus ojos", "Shakira", LocalDate.of(2020, 5, 4));
        Cancion cancion4 = new Cancion(4L, "Me gustas mucho", "Maluma", LocalDate.of(2021, 3, 7));

        List<Cancion> canciones = Arrays.asList(cancion1, cancion2, cancion3, cancion4);

        canciones.stream()
                //registrar en base de datos
                .forEach(
                        repository::save
                );
    }
}
