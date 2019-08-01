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

import br.com.gestor_api.models.Pessoa;
import br.com.gestor_api.repository.PessoaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/")
@Api(value="API REST Gestor")
public class PessoaResource {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping("/pessoas")
	@ApiOperation(value="Retorna uma lista de pessoas")
	public List<Pessoa> listPessoas(){
		
		List<Pessoa> listaPessoas = pessoaRepository.findAll();
		for(int i = 0 ; i < listaPessoas.size() ; i++) {
	//		System.out.println(listaPessoas.get(i).getNome());			
		}

		return pessoaRepository.findAll();
	}
	
	@GetMapping("/teste")
	@ApiOperation(value="Retorna algo")
	public List<Pessoa> teste(){
		return pessoaRepository.teste();
	}
	
	@GetMapping("/pessoas/{id}")
	@ApiOperation(value="Retorna uma pessoa específica")
	public Pessoa listPessoaById(@PathVariable(value="id") long id){
		return pessoaRepository.findById(id);
	}
	
	@PostMapping("/pessoa")
	@ApiOperation(value="Salva uma nova pessoa")
	public Pessoa salvaPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@DeleteMapping("/pessoa")
	@ApiOperation(value="Deleta uma pessoa específica")
	public void deletaPessoa(@RequestBody Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
	}
	
	@PutMapping("/pessoa")
	@ApiOperation(value="Retorna uma pessoa específica")
	public Pessoa atualizaPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
}
