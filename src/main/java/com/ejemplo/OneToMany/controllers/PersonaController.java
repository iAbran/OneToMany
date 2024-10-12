package com.ejemplo.OneToMany.controllers;

import com.ejemplo.OneToMany.models.Persona;
import com.ejemplo.OneToMany.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inicio")
public class PersonaController {

    private final PersonaService service;

    @Autowired
    public PersonaController(PersonaService service) {
        this.service = service;
    }

    //GET
    @GetMapping("/personas")
    public List<Persona> getAllPersona() {
        return service.getAllPersona();
    }

    //POST
    @PostMapping("/personas/api")
    public void addNewPersona(@RequestBody Persona prs) {
        service.addNewPersona(prs);
    }

    //DELETE
    @DeleteMapping("/personas/{id}")
    public void deletePersona(@PathVariable("id") Long id) {
        service.deletePersona(id);
    }

    //PUT
    @PutMapping("/personas/{id}")
    public void updatePersona(@PathVariable("id") Long id,
                              @RequestParam(required = false) String name) {
        service.updatePersona(id,name);
    }
}
