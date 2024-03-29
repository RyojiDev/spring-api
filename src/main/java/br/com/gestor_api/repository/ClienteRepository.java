package br.com.gestor_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestor_api.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findById(long id);
	
}
