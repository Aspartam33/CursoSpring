package com.example.ejemplo.dao;

import com.example.ejemplo.model.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonaDataAccessService implements PersonaDAO {

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public PersonaDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }


    @Override
    public int insertPersona(UUID id, Persona persona) {
        return 0;
    }

    @Override
    public List<Persona> selectAllPeople() {
        final String sql = "SELECT id, nom FROM persona";
         List<Persona> gente =   jdbcTemplate.query(sql,(resultSet,i)->{
            UUID id=(UUID.fromString(resultSet.getString("id")));
           String nom = resultSet.getString("nom");
            return new Persona(id,nom);
        });
        return gente;
    }

    @Override
    public Optional<Persona> selectPersonaById(UUID id){
        final String sql = "SELECT id, nom FROM persona where id=?";
        Persona persona =   jdbcTemplate.queryForObject(sql,new Object[]{id}, (resultSet,i)->{
            UUID PersonaId=(UUID.fromString(resultSet.getString("id")));
            String nom = resultSet.getString("nom");
            return new Persona(id,nom);
        });
        return Optional.ofNullable(persona);
    }

    @Override
    public int deletePersonaById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonaById(UUID id, Persona persona) {
        return 0;
    }
}
