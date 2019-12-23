package br.com.resource.webapp.testejsp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Convidado {

	@Id
	@NotNull
	private String rg;

	@NotNull
	@Size(min = 5, max = 100)
	private String nomeConvidado;

	private String pathImgPerfil;
	private String nameImgPerfil;

	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNomeConvidado() {
		return nomeConvidado;
	}

	public void setNomeConvidado(String nomeConvidado) {
		this.nomeConvidado = nomeConvidado;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getPathImgPerfil() {
		return pathImgPerfil;
	}

	public void setPathImgPerfil(String pathImgPerfil) {
		this.pathImgPerfil = pathImgPerfil;
	}

	public String getNameImgPerfil() {
		return nameImgPerfil;
	}

	public void setNameImgPerfil(String nameImgPerfil) {
		this.nameImgPerfil = nameImgPerfil;
	}

}
