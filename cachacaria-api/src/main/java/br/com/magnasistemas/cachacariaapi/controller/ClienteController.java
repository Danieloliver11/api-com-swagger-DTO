package br.com.magnasistemas.cachacariaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magnasistemas.cachacariaapi.DTO.ClienteDTO;
import br.com.magnasistemas.cachacariaapi.DTO.ProdutoDTO;
import br.com.magnasistemas.cachacariaapi.configuracao.MapperConfgCliente;
import br.com.magnasistemas.cachacariaapi.entity.Cliente;
import br.com.magnasistemas.cachacariaapi.entity.Produto;
import br.com.magnasistemas.cachacariaapi.repository.ClienteRepository;
import br.com.magnasistemas.cachacariaapi.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ClienteController {
	
	
	@Autowired
	private ClienteService clienteServise;
	@Autowired
	private MapperConfgCliente MapperCLiente;
	
	@PostMapping								
	public ResponseEntity<ClienteDTO> postCliente (@RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteServise.salvarCliente(MapperCLiente.paraModel(cliente)));
		
	}
	
	@GetMapping			
	public ResponseEntity<Iterable<ClienteDTO>> getAllProduto(){
		return ResponseEntity.ok(clienteServise.acharTodos()); 
	}
	
	@GetMapping("/{id}")						
	public ResponseEntity<ClienteDTO> getClienteById(@PathVariable long id){
		
		ClienteDTO clienteDTO =  clienteServise.acharPorIdCliente(id);
	     return new ResponseEntity<ClienteDTO>( clienteDTO, HttpStatus.OK );
	}
	
	
	@GetMapping("/nome/{nome}")  
	public ResponseEntity<List<ClienteDTO>>getProdutoByTitulo(@PathVariable String nome){  
		return ResponseEntity.ok(clienteServise.encontrarPorNomeCliente(nome)); 
	}
	
	@PutMapping
	public ResponseEntity<ClienteDTO> putProduto (@RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.OK).body(clienteServise.salvarCliente(MapperCLiente.paraModel(cliente)));
	}
	
	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable long id) {
		
		clienteServise.deletarCliente(id);
	}
}


