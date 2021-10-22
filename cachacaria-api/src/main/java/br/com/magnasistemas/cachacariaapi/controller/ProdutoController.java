package br.com.magnasistemas.cachacariaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

import br.com.magnasistemas.cachacariaapi.DTO.ProdutoDTO;
import br.com.magnasistemas.cachacariaapi.configuracao.MapperConfigProduto;
import br.com.magnasistemas.cachacariaapi.entity.Cliente;
import br.com.magnasistemas.cachacariaapi.entity.Produto;
import br.com.magnasistemas.cachacariaapi.repository.ProdutoRepository;
import br.com.magnasistemas.cachacariaapi.service.ProdutoSErvice;
import io.swagger.annotations.ApiOperation;

@RestController 
@RequestMapping("/produto") 
@CrossOrigin(origins = "*", allowedHeaders ="*")
public class ProdutoController {
	
	@Autowired
	private ProdutoSErvice produtoServer;
	@Autowired
	private MapperConfigProduto mapperProduto;
	
	@PostMapping
	@ApiOperation(value = "Posta um produto")
	public ResponseEntity<ProdutoDTO> postProduto (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoServer.salvar(mapperProduto.paraModel(produto)));
		
	}
	
	@ApiOperation(value = "Retorna todos os produto")
	@GetMapping			
	public ResponseEntity<Iterable<ProdutoDTO>> getAllProduto(){
		return ResponseEntity.ok(produtoServer.acharTodos()); 
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um produto pelo Id")
	public ResponseEntity<ProdutoDTO> getProdutoById(@PathVariable long id){
		
		ProdutoDTO produtoDTO =  produtoServer.acharPorId(id);
	     return new ResponseEntity<ProdutoDTO>( produtoDTO, HttpStatus.OK );
	}
	
	@GetMapping("/nome/{nome}") 
	@ApiOperation(value = "Retorna um produto pelo nome")
	public ResponseEntity<List<ProdutoDTO>>getProdutoByTitulo(@PathVariable String nome){  
		return ResponseEntity.ok(produtoServer.encontrarPorNome(nome)); 
	}
	
	@PutMapping
	@ApiOperation(value = "Atualiza um produto")
	public ResponseEntity<ProdutoDTO> putProduto (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK).body(produtoServer.salvar(mapperProduto.paraModel(produto)));
	}
	@ApiOperation(value = "Deleta um produto pelo Id")
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable long id) {
		//EmptyResultDataAccessException Throwable

		try {
			produtoServer.deletar(id);

		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
		}
		
	}
	
	
	
	
	
	
	/**
	@Autowired
	private ProdutoRepository repository;
	
	@PostMapping								
	public ResponseEntity<Produto> postProduto (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
		
	}
	
	@GetMapping			
	public ResponseEntity<Iterable<Produto>> getAllProduto(){
		return ResponseEntity.ok(repository.findAll()); 
	}
	
	@GetMapping("/{id}")						
	public ResponseEntity<Produto> getProdutoById(@PathVariable long id){
		return repository.findById(id) 
				.map(resp -> ResponseEntity.ok(resp)) 
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")  
	public ResponseEntity<List<Produto>>getProdutoByTitulo(@PathVariable String nome){  
		return ResponseEntity.ok(repository.findAllBynomeContainingIgnoreCase(nome)); 
	}
	
	@PutMapping
	public ResponseEntity<Produto> putProduto (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	*/
}
