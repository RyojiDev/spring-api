package br.com.gestor_api.resources;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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

import br.com.gestor_api.models.Cliente;
import br.com.gestor_api.models.Escola;
import br.com.gestor_api.models.Menu;
import br.com.gestor_api.repository.ClienteRepository;
import br.com.gestor_api.repository.EscolaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/")
@Api(value="API REST Gestor")
public class EscolaResource {

	@Autowired
	EscolaRepository escolaRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/escolas")
	@ApiOperation(value="Retorna uma lista de Escolas")
	public List<Escola> listEscolas(){

		return escolaRepository.findAll();
	}
		
	@GetMapping("/escolas/{id}")
	@ApiOperation(value="Retorna uma Cliente específica")
	public Escola listClienteById(@PathVariable(value="id") long id){
		return escolaRepository.findById(id);
	}
	
	@PostMapping("/escola/{cliente_id}")
	@ApiOperation(value="Salva uma nova escola")
	public Escola salvaEscola(@RequestBody Escola escola, @PathVariable(value="cliente_id") long cliente_id) {
		
		
		//Instaciando cliente que a qual será atribuída a escola
		Cliente cliente = clienteRepository.findById(cliente_id);
		//Atribuindo o cliente como dono da escola enviada
		escola.setCliente(cliente);					
		
		return escolaRepository.save(escola);
	}	
	
	@DeleteMapping("/escola")
	@ApiOperation(value="Deleta uma escola específica")
	public void deletaCliente(@RequestBody Escola escola) {
		escolaRepository.delete(escola);
	}
	
	@PutMapping("/escola")
	@ApiOperation(value="Retorna uma escola específica")
	public Escola atualizaEscola(@RequestBody Escola escola) {
		return escolaRepository.save(escola);
	}
}
