package com.evento.participar.dtos;

import java.util.ArrayList;
import java.util.List;

import com.evento.participar.entities.Evento;
import com.evento.participar.entities.Participante;

public class ParticipanteDTO {

	private long id;

	private String nome;
	private String email;
	private String telefone;

	private List<EventoDTO> eventos = new ArrayList<>();

	public ParticipanteDTO() {
	}

	public ParticipanteDTO(long id, String nome, String email, String telefone) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public ParticipanteDTO(Participante entity) {
		id = entity.getId();
		nome = entity.getNome();
		email = entity.getEmail();
		telefone = entity.getTelefone();
		for (Evento cat : entity.getEventos()) {
			eventos.add(new EventoDTO(cat));
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<EventoDTO> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventoDTO> eventos) {
		this.eventos = eventos;
	}
	
	

}
