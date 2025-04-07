package com.example.rama.service;

import java.util.List;

import java.util.Optional;

import com.example.rama.model.Materia;

public interface MateriaService {
    Materia crear(Materia materia);
    List<Materia> obtenerTodas();
    Optional<Materia> obtenerPorId(Long id);
    Materia actualizar(Long id, Materia materia);
    void eliminar(Long id);
}
