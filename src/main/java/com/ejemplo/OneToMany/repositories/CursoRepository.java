package com.ejemplo.OneToMany.repositories;

import com.ejemplo.OneToMany.models.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Cursos, Long>
{
    Optional<Cursos> findByName(String name);
}
