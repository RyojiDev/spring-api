package br.com.gestor_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestor_api.models.Escola;

public interface EscolaRepository extends JpaRepository<Escola, Long>{

	Escola findById(long id);
	
}
