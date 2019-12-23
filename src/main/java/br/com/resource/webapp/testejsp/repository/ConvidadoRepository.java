package br.com.resource.webapp.testejsp.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.resource.webapp.testejsp.models.Convidado;
import br.com.resource.webapp.testejsp.models.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String> {
	Iterable<Convidado> findByEvento(Evento evento);
	Convidado findByRg(String rg);
}
