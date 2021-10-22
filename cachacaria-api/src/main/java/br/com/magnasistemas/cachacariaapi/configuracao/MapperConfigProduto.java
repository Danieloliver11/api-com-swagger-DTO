package br.com.magnasistemas.cachacariaapi.configuracao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import br.com.magnasistemas.cachacariaapi.DTO.ProdutoDTO;
import br.com.magnasistemas.cachacariaapi.entity.Produto;

@Configuration
public class MapperConfigProduto {
	

	 @Bean
	 public ModelMapper modelMapper() {
	      ModelMapper modelMapper = new ModelMapper();
	      return modelMapper;
	   }
	
	public ProdutoDTO paraModel(Produto produto) {
		ModelMapper modelMapper = modelMapper();
		return modelMapper.map(produto, ProdutoDTO.class);
	}

	public Produto paraEntidade(ProdutoDTO produtoDTO) {
		ModelMapper modelMapper = modelMapper();
		return modelMapper.map(produtoDTO, Produto.class);
		
	}
	
	public List<ProdutoDTO> paraListaModel(List<Produto> produtos){
		
		return produtos.stream().map(prods -> paraModel(prods)).collect(Collectors.toList());
	}
	
	
	public List<ProdutoDTO> paraListaPageModel(Page<Produto> page){
		
		return page.stream().map(prods -> paraModel(prods)).collect(Collectors.toList());
	}

	
	
}
