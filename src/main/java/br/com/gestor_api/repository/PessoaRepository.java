package br.com.gestor_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import br.com.gestor_api.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, JpaSpecificationExecutor{

	Pessoa findById(long id);
	
	@Query(value="SELECT * FROM academico.pessoa", nativeQuery = true)
	List<Pessoa> teste();
}
