package com.example.ejemplo.dao;

import com.example.ejemplo.model.Persona;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonaDAO {
    int insertPersona(UUID id, Persona persona);
    default int insertPersona(Persona persona){
        UUID id = UUID.randomUUID();
        return insertPersona(id,persona);
    }


    List<Persona> selectAllPeople();
    Optional<Persona> selectPersonaById(UUID id);

    int deletePersonaById(UUID id);
    int updatePersonaById(UUID id, Persona persona);
}
