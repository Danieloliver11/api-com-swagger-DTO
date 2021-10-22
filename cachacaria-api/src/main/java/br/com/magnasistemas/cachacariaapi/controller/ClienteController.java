package br.com.magnasistemas.cachacariaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ClienteController {
	
	
	@Autowired
	private ClienteService clienteServise;
	@Autowired
	private MapperConfgCliente MapperCLiente;
	
	@PostMapping
	@ApiOperation(value = "Cadastra um Cliente")
	public ResponseEntity<ClienteDTO> postCliente (@RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteServise.salvarCliente(MapperCLiente.paraModel(cliente)));
		
	}
	
	@GetMapping
	@ApiOperation(value = "Retorna todos os produto com paginação")
	public ResponseEntity<Iterable<ClienteDTO>> getAllProduto(Pageable pageable){
		return ResponseEntity.ok(clienteServise.acharTodos(pageable)); 
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Pega um Cliente pelo ID ")
	public ResponseEntity<ClienteDTO> getClienteById(@PathVariable long id){
		
		ClienteDTO clienteDTO =  clienteServise.acharPorIdCliente(id);
	     return new ResponseEntity<ClienteDTO>( clienteDTO, HttpStatus.OK );
	}
	
	
	@GetMapping("/nome/{nome}")
	@ApiOperation(value = " Acha Clientes por nome")
	public ResponseEntity<List<ClienteDTO>>getProdutoByTitulo(@PathVariable String nome){  
		return ResponseEntity.ok(clienteServise.encontrarPorNomeCliente(nome)); 
	}
	
	@PutMapping
	@ApiOperation(value = "Atualiza um Cliente ")
	public ResponseEntity<ClienteDTO> putProduto (@RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.OK).body(clienteServise.salvarCliente(MapperCLiente.paraModel(cliente)));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = " Deleta um Cliente polo Id")
	public void deleteCliente(@PathVariable long id) {
		
		clienteServise.deletarCliente(id);
	}
}


