package br.com.gestor_api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestor_api.models.Menu;
import br.com.gestor_api.repository.MenuRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
@Api(value = "API REST Gestor")
public class MenuResource {
	@Autowired
	MenuRepository menuRepository;

	@GetMapping("/menu")
	@ApiOperation(value = "Retorna uma lista de Menus de Cliente")
	public List<Menu> listaMenus() {
		return menuRepository.findAll();
	}

	@GetMapping("/menu/{id}")
	@ApiOperation(value = "Retorna um Menu do Cliente")
	public Menu listaMenuUnico(@PathVariable(value = "id") long id) {
		return menuRepository.findById(id);
	}

	@PostMapping("/menu")
	@ApiOperation(value = "Salva um Menu do Cliente")
	public Menu salvarMenu(@RequestBody Menu menu) {
		return menuRepository.save(menu);
	}

	@DeleteMapping("/menu")
	@ApiOperation(value = "Deleta um Menu do Cliente")
	public void deletaMenu(@RequestBody Menu menu) {
		menuRepository.delete(menu);
	}

	@PutMapping("/menu")
	@ApiOperation(value = "Atualiza um Menu do Cliente")
	public Menu atualizaMenu(@RequestBody Menu menu) {
		return menuRepository.save(menu);
	}

}
