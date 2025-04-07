package com.example.rama.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String grupo;
    private String materia;
    private String horario;

    public Grupo() {}

    public Grupo(String grupo, String materia, String horario) {
        this.grupo = grupo;
        this.materia = materia;
        this.horario = horario;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getGrupo() { return grupo; }
    public void setGrupo(String grupo) { this.grupo = grupo; }

    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
}

