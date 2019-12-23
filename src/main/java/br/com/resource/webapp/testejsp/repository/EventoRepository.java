package br.com.resource.webapp.testejsp.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.resource.webapp.testejsp.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String> {
	Evento findByidEvento(int idEvento);
}
