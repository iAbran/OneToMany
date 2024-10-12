package com.ejemplo.OneToMany.repositories;

import com.ejemplo.OneToMany.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>
{
    Optional<Persona> findByName(String name);
}
