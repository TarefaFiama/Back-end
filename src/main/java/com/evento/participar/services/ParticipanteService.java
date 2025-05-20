package com.evento.participar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.evento.participar.dtos.ParticipanteDTO;
import com.evento.participar.entities.Evento;
import com.evento.participar.entities.Participante;
import com.evento.participar.repositories.EventoRepository;
import com.evento.participar.repositories.ParticipanteRepository;

@Service
public class ParticipanteService {
	
	@Autowired
	private ParticipanteRepository participanteRepository;
	
	@Autowired
	private EventoRepository eventoRepository;
	

	public ParticipanteDTO cadastrar(ParticipanteDTO participante) {
		
		Participante participanteEntity = new Participante();
		
		participanteEntity.setNome(participante.getNome());
		participanteEntity.setEmail(participante.getEmail());
		participanteEntity.setTelefone(participante.getTelefone());
		Participante responseRegistro = participanteRepository.save(participanteEntity);
		return new ParticipanteDTO(responseRegistro);
		
	}
	
	public String inscrever(Long partId,Long eventId) {
		Participante participante = participanteRepository.findById(partId)
				.orElseThrow(() -> new RuntimeException("Participante não encontrado"));
		
		Evento evento = eventoRepository.findById(eventId)
				.orElseThrow(() -> new RuntimeException("Evento não encontrado"));
		
		if (evento.getVagas() < 45) {
			participante.getEventos().add(evento);
			evento.getParticipantes().add(participante);
			evento.setVagas(evento.getVagas() - 1);
			
			participanteRepository.save(participante);
			eventoRepository.save(evento);
			
			return "Inscrição realizada com sucesso!";
		} else {
			return "Não há vagas disponíveis para este evento.";
		}
	}
		
		
		public String cancelarInscricao(Long partId,Long eventId) {
			Participante participante = participanteRepository.findById(partId)
					.orElseThrow(() -> new RuntimeException("Participante não encontrado"));
			
			Evento evento = eventoRepository.findById(eventId)
					.orElseThrow(() -> new RuntimeException("Evento não encontrado"));
			
			if (evento.getVagas() > 0) {
				participante.getEventos().remove(evento);
				evento.getParticipantes().remove(participante);
				evento.setVagas(evento.getVagas() - 1);
				
				participanteRepository.save(participante);
				eventoRepository.save(evento);
				
				return "você saiu desse evento com sucesso!";
			} else {
				return "deu um erro :/, tente novamente mais tarde.";
			}
		}
			
		//	/{id}/eventos
		
		public ResponseEntity<?> listarEventosInscritos(Long id) {
			Participante participante = participanteRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Participante não encontrado"));
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(participante.getEventos());
		}		
	}
	
	

