package com.example.ejemplo.service;
import com.example.ejemplo.dao.PersonaDAO;
import com.example.ejemplo.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class PersonaService {
    private  final PersonaDAO personaDAO;

    @Autowired
    public PersonaService(@Qualifier("postgres") PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }
    public int addPersona(Persona persona){
        return personaDAO.insertPersona(persona);

    }

    public List<Persona> getAllPeople(){
        return personaDAO.selectAllPeople();
    }
    public Optional<Persona> getPersonaById(UUID id){
        return personaDAO.selectPersonaById(id);
    }
    public int deletePersona(UUID id){
        return personaDAO.deletePersonaById(id);
    }
    public int updatePersona(UUID id, Persona nuevaPersona){
        return personaDAO.updatePersonaById(id,nuevaPersona);
    }
}
