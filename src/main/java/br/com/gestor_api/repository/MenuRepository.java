package br.com.gestor_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gestor_api.models.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
	Menu findById(long id);

	@Query(value="SELECT * FROM academico.menu as M WHERE M.parent_id = ?1", nativeQuery = true)
	List<Menu> getMenuChildren(long parent_id);
}
