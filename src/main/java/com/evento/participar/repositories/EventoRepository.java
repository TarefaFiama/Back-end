package com.evento.participar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evento.participar.entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {


}
