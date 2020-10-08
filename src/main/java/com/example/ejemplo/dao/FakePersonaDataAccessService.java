package com.example.ejemplo.dao;

import com.example.ejemplo.model.Persona;
import com.example.ejemplo.dao.PersonaDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("fakeDAO")
public class FakePersonaDataAccessService implements PersonaDAO{
    private static List<Persona> DB=new ArrayList<>();
    @Override
    public int insertPersona(UUID id,Persona persona){
        DB.add(new Persona(id,persona.getNombre()));
        return 1;
    }




    @Override
    public List<Persona> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Persona> selectPersonaById(UUID id) {
        return DB.stream().filter(persona -> persona.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonaById(UUID id) {
        Optional<Persona> personaMaybe=selectPersonaById(id);
        if (personaMaybe.isEmpty()){
        return 0;}
        DB.remove(personaMaybe.get());
                return 1;
    }

    @Override
    public int updatePersonaById(UUID id, Persona update) {

        return selectPersonaById(id).map(persona->{
            int indexOfPersonaToUpdate=DB.indexOf(persona);
            if(indexOfPersonaToUpdate >=0) {
                DB.set(indexOfPersonaToUpdate,new Persona(id,update.getNombre()));
                return 1;
            }return 0;
            }
        )
        .orElse(0);
}
}
