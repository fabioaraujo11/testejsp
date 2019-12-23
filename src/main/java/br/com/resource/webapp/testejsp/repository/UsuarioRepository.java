package br.com.resource.webapp.testejsp.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.resource.webapp.testejsp.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {


	Usuario findByusername(String username);
}
