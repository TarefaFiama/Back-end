package com.evento.participar.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evento.participar.dtos.EventoDTO;
import com.evento.participar.entities.Evento;
import com.evento.participar.entities.Participante;
import com.evento.participar.services.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @PostMapping
    public ResponseEntity criar(@RequestBody EventoDTO evento) {
    	return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(evento));
    }
       
    

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.listar());
    }

    @PutMapping("/{id}")
    public EventoDTO atualizar(@PathVariable Long id, @RequestBody EventoDTO evento) {
    	EventoDTO eventoDTO = service.atualizar(id, evento);
    
        return eventoDTO;
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    @GetMapping("/{id}/participantes")
    public ResponseEntity<?> participantes(@PathVariable Long id) {
        return service.listarParticipantes(id);
    }
}
