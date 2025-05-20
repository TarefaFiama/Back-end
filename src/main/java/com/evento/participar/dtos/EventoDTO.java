package com.evento.participar.dtos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.evento.participar.entities.Evento;
import com.evento.participar.entities.Participante;

//caio<- vamos criar um DTO para o evento
public class EventoDTO {
	
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate data;
    private String local;
    private int vagas;
    
    private Set<ParticipanteDTO> participantes = new HashSet<>();
    
    public EventoDTO() {
	}
    
    	public Set<ParticipanteDTO> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Set<ParticipanteDTO> participantes) {
		this.participantes = participantes;
	}

		public EventoDTO(Long id, String nome, String descricao, LocalDate data, String local, int vagas) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.local = local;
		this.vagas = vagas;
	}
    
      	public EventoDTO(Evento evento) {
    		id = evento.getId();
    		nome = evento.getNome();
    		descricao = evento.getDescricao();
    		data = evento.getData();
    		local = evento.getLocal();
    		vagas = evento.getVagas();
    		for (Participante batatao : evento.getParticipantes()) {
    			participantes.add(new ParticipanteDTO(batatao));
    		}
    	}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public LocalDate getData() {
			return data;
		}

		public void setData(LocalDate data) {
			this.data = data;
		}

		public String getLocal() {
			return local;
		}

		public void setLocal(String local) {
			this.local = local;
		}

		public int getVagas() {
			return vagas;
		}

		public void setVagas(int vagas) {
			this.vagas = vagas;
		}	
      	
      	
      	
}
