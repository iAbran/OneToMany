package com.ejemplo.OneToMany.service;

import com.ejemplo.OneToMany.models.Cursos;
import com.ejemplo.OneToMany.repositories.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository repository;

    @Autowired
    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<Cursos> getAllCursos() {
        return repository.findAll();
    }

    public void addNewCursos(Cursos c) {
        Optional<Cursos> cursosOptional = repository.findByName(c.getName());
        if (cursosOptional.isPresent()){
            throw new IllegalStateException("Name is already taken");
        }
        repository.save(c);

    }

    public void deleteCursos(Long id) {
        boolean exists = repository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("this id: " + id + "no exists");
        }
        repository.deleteById(id);
    }

    @Transactional
    public void updateCursos(Long id, String name) {
        Cursos c = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("this id do not exists"));

        if (name != null && name.length() > 0 &&
                !Objects.equals(c.getName(), name)) {

            c.setName(name);
        }
    }
}
