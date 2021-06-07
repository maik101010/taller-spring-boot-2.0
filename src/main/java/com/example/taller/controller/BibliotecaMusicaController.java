package com.example.taller.controller;

import com.example.taller.entity.Cancion;
import com.example.taller.service.ServiceCanciones;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/canciones")
public class BibliotecaMusicaController {

    ServiceCanciones serviceCanciones;

    public BibliotecaMusicaController(ServiceCanciones serviceCanciones) {
        this.serviceCanciones = serviceCanciones;
    }

    @GetMapping("/")
    public List<Cancion> canciones(){
        return serviceCanciones.getListCanciones();
    }

    @GetMapping("/{id}")
    public Cancion canciones(@PathVariable Long id){
        return serviceCanciones.getCancionById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Cancion> nuevaCancion(@RequestBody Cancion cancion){
        if(serviceCanciones.guardar(cancion)){
            return new ResponseEntity<>(cancion, HttpStatus.CREATED);
        }
        throw new RuntimeException("No se pudo registrar porque la fecha no es valida");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarCancion(@PathVariable("id") Long idUrl){
        if (serviceCanciones.eliminar(idUrl)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Cancion no encontrada");
    }

    @PutMapping("/{id}")
    ResponseEntity<Cancion> remplazarCancion(@RequestBody Cancion cancionRequest, @PathVariable Long id){
        return new ResponseEntity(serviceCanciones.getById(id).map(
                cancionParaActualizar -> {
                    cancionParaActualizar.setAutor(cancionRequest.getAutor());
                    cancionParaActualizar.setNombre(cancionRequest.getNombre());
                    cancionParaActualizar.setFechaCreacion(cancionRequest.getFechaCreacion());
                    return serviceCanciones.guardar(cancionParaActualizar);
                }).get(), HttpStatus.OK);

    }


}
