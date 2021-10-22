package br.com.magnasistemas.cachacariaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.cachacariaapi.DTO.ProdutoDTO;
import br.com.magnasistemas.cachacariaapi.DTO.RevendedoraDTO;
import br.com.magnasistemas.cachacariaapi.configuracao.MapperConfigProduto;
import br.com.magnasistemas.cachacariaapi.configuracao.MapperConfigRevendedora;
import br.com.magnasistemas.cachacariaapi.entity.Produto;
import br.com.magnasistemas.cachacariaapi.entity.Revendedora;
import br.com.magnasistemas.cachacariaapi.repository.ProdutoRepository;
import br.com.magnasistemas.cachacariaapi.repository.RevendedoraRepository;

@Service
public class RevendedoraService {
	
	@Autowired
	private RevendedoraRepository repository;
	
	@Autowired
	private MapperConfigRevendedora mapperRevendedora;

	public RevendedoraDTO salvarRevendedora(RevendedoraDTO revendedoraDTO) {
		
		repository.save(mapperRevendedora.paraEntidadeRevendedora(revendedoraDTO));
	
		return revendedoraDTO ;
	}
	
	public Iterable<RevendedoraDTO> acharTodasRevendedoras(Pageable pageable) {
		
		return mapperRevendedora.paraListaModelPageRevendedora(repository.findAll(pageable));
	}

	public RevendedoraDTO acharRevendedoraPorId(long id) {
		//Optional<Produto> produtoId = repository.findById(id);	
		//return mapperProduto.paraModelOptional(repository.findById(id)) ;
		RevendedoraDTO revendedoraDTO = null ;
		
	        Optional<Revendedora> idRevendedora = repository.findById(id);   
	        Revendedora revendedora = idRevendedora.get() ;
            revendedoraDTO =  mapperRevendedora.paraModelRevendedora(revendedora);
        
        return revendedoraDTO ;
	}
	
	public List<RevendedoraDTO> encontrarPorNomeRevendedora(String nome) {

		return mapperRevendedora.paraListaModelRevendedora(repository.findAllBynomeContainingIgnoreCase(nome));
	}
	
public void deletarRevendedora(long id) {
		
		repository.deleteById(id);
		
		
	}
	

}
