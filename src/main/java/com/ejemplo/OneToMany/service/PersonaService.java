package com.ejemplo.OneToMany.service;

import com.ejemplo.OneToMany.models.Persona;
import com.ejemplo.OneToMany.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonaService {

    private PersonaRepository repository;

    @Autowired
    public PersonaService(PersonaRepository repository) {
        this.repository = repository;
    }

    //GET
    public List<Persona> getAllPersona() {
        return this.repository.findAll();
    }

    //POST
    public void addNewPersona(Persona p) {
        Optional<Persona> personaOptional = repository.findByName(p.getName());
        if (personaOptional.isPresent()) {
            throw new IllegalStateException("This " + p.getName() + "is already in use");
        }
        repository.save(p);
    }

    //DELETE
    public void deletePersona(Long id) {
        boolean exists = this.repository.existsById(id);
       if (!exists) {
           throw new IllegalStateException("this id person: " + id + "no exists");
       }
       this.repository.deleteById(id);
    }

    //PUT
    @Transactional
    public void updatePersona(Long id, String name) {

        Persona p = repository.findById(id).orElseThrow(() -> new IllegalStateException(
                "this id person: " + id + "already exists"
        ));
        if (name != null && name.length() > 0 &&
                !Objects.equals(p.getName(), name)) {
            p.setName(name);
        }
    }
}
