package com.evento.participar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteService service;

    @PostMapping
    public Participante cadastrar(@RequestBody Participante participante) {
        return service.cadastrar(participante);
    }

    @PostMapping("/{id}/inscricoes/{eventoId}")
    public ResponseEntity<String> inscrever(@PathVariable Long id, @PathVariable Long eventoId) {
        try {
            service.inscrever(id, eventoId);
            return ResponseEntity.ok("Inscrição realizada com sucesso");
        } catch (IllegalStateException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}/inscricoes/{eventoId}")
    public ResponseEntity<String> cancelar(@PathVariable Long id, @PathVariable Long eventoId) {
        try {
            service.cancelarInscricao(id, eventoId);
            return ResponseEntity.ok("Inscrição cancelada com sucesso");
        } catch (IllegalStateException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    // Trata exceções de regra de negócio (como falta de vagas ou inscrição repetida)
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> handleErroNegocio(IllegalStateException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

