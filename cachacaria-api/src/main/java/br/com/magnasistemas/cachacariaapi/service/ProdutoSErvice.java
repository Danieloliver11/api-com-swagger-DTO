package br.com.magnasistemas.cachacariaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.cachacariaapi.DTO.ProdutoDTO;
import br.com.magnasistemas.cachacariaapi.configuracao.MapperConfigProduto;
import br.com.magnasistemas.cachacariaapi.entity.Produto;
import br.com.magnasistemas.cachacariaapi.repository.ProdutoRepository;

@Service
public class ProdutoSErvice {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private MapperConfigProduto mapperProduto;

	
	public ProdutoDTO salvar(ProdutoDTO produtoDTO) {
		
		repository.save(mapperProduto.paraEntidade(produtoDTO));
	
		return produtoDTO ;
	}

	public Iterable<ProdutoDTO> acharTodos(Pageable pageable) {
		
		return mapperProduto.paraListaPageModel( repository.findAll(pageable));
	}
	
	public ProdutoDTO acharPorId(long id) {
		//Optional<Produto> produtoId = repository.findById(id);	
		//return mapperProduto.paraModelOptional(repository.findById(id)) ;
		ProdutoDTO produtoDTO = null ;
		
	        Optional<Produto> idProduto = repository.findById(id);   
            Produto produto = idProduto.get() ;
            produtoDTO =  mapperProduto.paraModel(produto);
        
        return produtoDTO ;
	}
	
	public List<ProdutoDTO> encontrarPorNome(String nome) {

		return mapperProduto.paraListaModel(repository.findAllBynomeContainingIgnoreCase(nome));
	}
	
	public void deletar(long id) {
		
		
		repository.deleteById(id);
		
		
	}
	
	/*
	 * 
	 * public Iterable<Produto> acharTodos() {
		
		return repository.findAll();
	}

	public Optional<Produto> acharPorId(long id) {

		return repository.findById(id);
	}

	public List<Produto> encontrarPorNome(String nome) {

		return repository.findAllBynomeContainingIgnoreCase(nome);
	}

	public void deletar(long id) {
		
		repository.deleteById(id);
		
	}*/

}
