package com.ejemplo.OneToMany.controllers;

import com.ejemplo.OneToMany.models.Cursos;
import com.ejemplo.OneToMany.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inicio")
public class CursoController {

    private final CursoService service;

    @Autowired
    public CursoController(CursoService service) {
        this.service = service;
    }

    //GET
    @GetMapping("/cursos")
    public List<Cursos> getAllCursos() {
        return service.getAllCursos();
    }

    //POST
    @PostMapping("/cursos/api")
    public void addNewCursos(@RequestBody Cursos c) {
        service.addNewCursos(c);
    }

    //DELETE
    @DeleteMapping("/cursos/{id}")
    public void deleteCursos(@PathVariable("{id}") Long id) {
        service.deleteCursos(id);
    }

    //PUT
    @PutMapping("/cursos/{id}")
    public void updateCursos(@PathVariable("{id}") Long id,
                             @RequestParam(required = false) String name) {
        service.updateCursos(id,name);
    }

}
