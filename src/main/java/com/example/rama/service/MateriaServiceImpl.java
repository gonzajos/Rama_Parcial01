package com.example.rama.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.rama.model.Materia;
import com.example.rama.repository.MateriaRepository;

@Service
public class MateriaServiceImpl implements MateriaService {

    private final MateriaRepository materiaRepository;

    public MateriaServiceImpl(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    @Override
    public Materia crear(Materia materia) {
        return materiaRepository.save(materia);
    }

    @Override
    public List<Materia> obtenerTodas() {
        return materiaRepository.findAll();
    }

    @Override
    public Optional<Materia> obtenerPorId(Long id) {
        return materiaRepository.findById(id);
    }

    @Override
    public Materia actualizar(Long id, Materia materia) {
        materia.setId(id);
        return materiaRepository.save(materia);
    }

    @Override
    public void eliminar(Long id) {
        materiaRepository.deleteById(id);
    }
}
