package br.com.magnasistemas.cachacariaapi.configuracao;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import br.com.magnasistemas.cachacariaapi.DTO.ProdutoDTO;
import br.com.magnasistemas.cachacariaapi.DTO.RevendedoraDTO;
import br.com.magnasistemas.cachacariaapi.entity.Revendedora;

@Configuration
public class MapperConfigRevendedora {
	
	@Bean
	 public ModelMapper modelMapperRevendedora() {
	      ModelMapper modelMapper = new ModelMapper();
	      return modelMapper;
	   }
	
	public RevendedoraDTO paraModelRevendedora(Revendedora revendedora) {
		ModelMapper modelMapper = modelMapperRevendedora();
		return modelMapper.map(revendedora, RevendedoraDTO.class);
	}
	
	public Revendedora paraEntidadeRevendedora(RevendedoraDTO revendedoraDTO) {
		ModelMapper modelMapper = modelMapperRevendedora();
		return modelMapper.map(revendedoraDTO, Revendedora.class);
	}
	
	public List<RevendedoraDTO> paraListaModelPageRevendedora(Page<Revendedora> page){
				
		return page.stream().map(revends -> paraModelRevendedora(revends)).collect(Collectors.toList());
	}
	
	public List<RevendedoraDTO> paraListaModelRevendedora(List<Revendedora> revendedoras){
		
		return revendedoras.stream().map(revends -> paraModelRevendedora(revends)).collect(Collectors.toList());
	}

	
}
