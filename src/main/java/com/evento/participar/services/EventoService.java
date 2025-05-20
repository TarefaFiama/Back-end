package com.evento.participar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.evento.participar.dtos.EventoDTO;
import com.evento.participar.entities.Evento;
import com.evento.participar.repositories.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	public EventoDTO criar(EventoDTO evento) {
		Evento eventoGeral = new Evento();
		eventoGeral.setNome(evento.getNome());
		eventoGeral.setDescricao(evento.getDescricao());
		eventoGeral.setData(evento.getData());
		eventoGeral.setLocal(evento.getLocal());
		eventoGeral.setVagas(evento.getVagas());
		Evento responseRegistro = eventoRepository.save(eventoGeral);
		return new EventoDTO(responseRegistro);
	}
	
	public EventoDTO atualizar(Long id, EventoDTO evento) {
		Evento eventoGeral = new Evento();
		eventoGeral.setId(id);
		eventoGeral.setNome(evento.getNome());
		eventoGeral.setDescricao(evento.getDescricao());
		eventoGeral.setData(evento.getData());
		eventoGeral.setLocal(evento.getLocal());
		eventoGeral.setVagas(evento.getVagas());
		
		return new EventoDTO(eventoGeral);
	}
	
	public ResponseEntity<?> excluir(Long id) {
		
		eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado"));
		if(eventoRepository.findById(id).isPresent()) {
			eventoRepository.deleteById(id);
			return ResponseEntity.ok().body("Evento deletado com sucesso!");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(eventoRepository.findAll());
	}
	public ResponseEntity<?> listarParticipantes(Long id) {
		Evento evento = eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado"));
		return ResponseEntity.ok(evento.getParticipantes());
	}
	
	
	
}
