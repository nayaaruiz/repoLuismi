package com.salesianostriana.dam.tarea2301.repository;

import com.salesianostriana.dam.tarea2301.model.Vivienda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ViviendaRepository
        extends JpaRepository<Vivienda, Long>,
        JpaSpecificationExecutor<Vivienda>{

    Page<Vivienda> findAll(Pageable pageable);

}