package com.evento.participar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evento.participar.entities.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

}
