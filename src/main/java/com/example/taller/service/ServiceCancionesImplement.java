package com.example.taller.service;

import com.example.taller.entity.Cancion;
import com.example.taller.repository.CancionRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ServiceCancionesImplement implements ServiceCanciones {
    private CancionRepository repository;

    public ServiceCancionesImplement(CancionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cancion> getListCanciones() {
        return repository.findAll();
    }

    @Override
    public boolean guardar(Cancion cancion) {
        boolean result;
        if (cancion.getFechaCreacion().isAfter(LocalDate.now())) {
            result = false;
        } else {
            repository.save(cancion);
            result = true;
        }

        return result;
    }

    @Override
    public boolean eliminar(Long idUrl) {
        boolean result;
        if (repository.existsById(idUrl)) {
            repository.deleteById(idUrl);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public Optional<Cancion> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Cancion getCancionById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("La cancion no existe"));
    }
}
