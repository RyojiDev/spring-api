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
import br.com.gestor_api.models.Menu;
import br.com.gestor_api.repository.ClienteRepository;
import br.com.gestor_api.repository.MenuRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/")
@Api(value="API REST Gestor")
public class ClienteResource {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	MenuRepository menuRepository;
	
	@GetMapping("/clientes")
	@ApiOperation(value="Retorna uma lista de Clientes")
	public List<Cliente> listClientes(){

		return clienteRepository.findAll();
	}
		
	
	@GetMapping("/clientes/{id}")
	@ApiOperation(value="Retorna uma Cliente específica")
	public Cliente listClienteById(@PathVariable(value="id") long id){
		return clienteRepository.findById(id);
	}
	
	@PostMapping("/cliente")
	@ApiOperation(value="Salva uma nova cliente")
	public Cliente salvaCliente(@RequestBody Cliente cliente) {
		 System.out.println("testando salvar cliente");
		 System.out.println(cliente);
		return clienteRepository.save(cliente);
		
	}	
	
	public List<Menu> recursiveGetMenuChildren(List<Menu> menusToAdd, List<Menu> children, int index){
		
		//Chegou ao último elemento filho
		if((index + 1) == children.size()) {
						
			System.out.println("Adicionou: " + children.get(index).getTitle());
			menusToAdd.add(children.get(index));
			
			List<Menu> maybeChildren = menuRepository.getMenuChildren(children.get(index).getId());			
			if(maybeChildren.size() > 0) {
				recursiveGetMenuChildren(menusToAdd, maybeChildren, 0);	
			}
			
			return menusToAdd;
			
		}else {
			
			System.out.println("Adicionou: " + children.get(index).getTitle());
			menusToAdd.add(children.get(index));
			
			List<Menu> maybeChildren = menuRepository.getMenuChildren(children.get(index).getId());			
			if(maybeChildren.size() > 0) {
				recursiveGetMenuChildren(menusToAdd, maybeChildren, 0);	
			}
			
			recursiveGetMenuChildren(menusToAdd, children, index+1);
			
		}
		
		return menusToAdd;
	}
	
	@GetMapping("/menu_children/{id_menu}")
	@ApiOperation(value="Retorna uma lista de Clientes")
	public List<Menu> menuChildren(@PathVariable(value="id_menu") long id_menu){

		List<Menu> menusToAdd = new ArrayList<Menu>();
		//menusToAdd.add(menuRepository.findById(id_menu));
		List<Menu> maybeChildren = menuRepository.getMenuChildren(id_menu); 
		if(maybeChildren.size() > 0) {
			recursiveGetMenuChildren(menusToAdd, maybeChildren, 0);
		}	
		
		System.out.println(menusToAdd);
		
		return menusToAdd;
		
	}
	
	@PostMapping("/add_menu_cliente/{id_cliente}/menu/{id_menu}")
	@ApiOperation(value="Relaciona um menu ao cliente")
	public List<Menu> adicionarMenuCliente(@PathVariable(value="id_cliente") long id_cliente, @PathVariable(value="id_menu") long id_menu) {				
		
		Cliente cliente = clienteRepository.findById(id_cliente);		
		if(cliente.getMenus() == null) {
			cliente.setMenus(new HashSet<Menu>());
		}
		
		List<Menu> menusToAdd = new ArrayList<Menu>();	
		//Adicionando o menu clicado as adições
		menusToAdd.add(menuRepository.findById(id_menu));
		
		//Lista que agrupará os menus a serem atualizados, pode ser mais de um pois
		//pode ter sido adicionado um menu que contém filhos		
		List<Menu> maybeChildren = menuRepository.getMenuChildren(id_menu); 
		if(maybeChildren.size() > 0) {
			cliente.getMenus().addAll(recursiveGetMenuChildren(menusToAdd, maybeChildren, 0));
		}				
		
		clienteRepository.save(cliente);
		
		return menusToAdd;
	}
	
	@PostMapping("/remover_menu_cliente/{id_cliente}/menu/{id_menu}")
	@ApiOperation(value="Desrelaciona um menu ao cliente")
	public List<Menu> removerMenuCliente(@PathVariable(value="id_cliente") long id_cliente, @PathVariable(value="id_menu") long id_menu) {				
		
		Cliente cliente = clienteRepository.findById(id_cliente);		
		if(cliente.getMenus() == null) {
			cliente.setMenus(new HashSet<Menu>());
		}
		
		//Remove o menu clicado
		List<Menu> menusToRemove = new ArrayList<Menu>();
		menusToRemove.add(menuRepository.findById(id_menu));		
				
		//Testa-se se ele possui filhos e então aplica-se a recursividade de remoção		
		List<Menu> maybeChildren = menuRepository.getMenuChildren(id_menu);
		if(maybeChildren.size() > 0) {
			cliente.getMenus().removeAll(recursiveGetMenuChildren(menusToRemove, maybeChildren, 0));
		}
		
		clienteRepository.save(cliente);
		
		return menusToRemove;
	}
	
	
	@DeleteMapping("/cliente")
	@ApiOperation(value="Deleta uma cliente específica")
	public void deletaCliente(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	@PutMapping("/cliente")
	@ApiOperation(value="Retorna uma cliente específica")
	public Cliente atualizaCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
