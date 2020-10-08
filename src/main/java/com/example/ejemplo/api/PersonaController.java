package com.example.ejemplo.api;
import com.example.ejemplo.model.Persona;
import com.example.ejemplo.service.PersonaService;
import javafx.css.CssParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RequestMapping("api/v1/persona")
@RestController
public class PersonaController {
    private final PersonaService  personaService;
    @Autowired
    public PersonaController(PersonaService personaService){
        this.personaService=personaService;
    }

    @PostMapping
    public void addPersona(@Valid @NonNull @RequestBody Persona persona){
        personaService.addPersona(persona);
    }

    @GetMapping
    public List<Persona> getAllPeople(){
        return personaService.getAllPeople();
    }
    @GetMapping(path="{id}")
    public Persona getPersonaById(@PathVariable("id") UUID id){

        return personaService.getPersonaById(id).orElse(null);
    }

    @DeleteMapping(path = {"id"})
    public void deletePersonaById(@PathVariable("id") UUID id){
        personaService.deletePersona(id);
    }

    @PutMapping(path = {"id"})
    public  void updatePersona(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Persona personaAModificar){
        personaService.updatePersona(id,personaAModificar);
    }
}
