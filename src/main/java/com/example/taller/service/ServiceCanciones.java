package com.example.taller.service;

import com.example.taller.entity.Cancion;

import java.util.List;
import java.util.Optional;

public interface ServiceCanciones {
    List<Cancion> getListCanciones();

    boolean guardar(Cancion cancion);

    boolean eliminar(Long idUrl);

    Optional<Cancion> getById(Long id);

    Cancion getCancionById(Long id);
}
