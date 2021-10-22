package br.com.magnasistemas.cachacariaapi.configuracao;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.magnasistemas.cachacariaapi.DTO.ClienteDTO;
import br.com.magnasistemas.cachacariaapi.DTO.ProdutoDTO;
import br.com.magnasistemas.cachacariaapi.entity.Cliente;
import br.com.magnasistemas.cachacariaapi.entity.Produto;

@Configuration
public class MapperConfgCliente {
	
	@Bean
	 public ModelMapper modelMapperClient() {
	      ModelMapper modelMapper = new ModelMapper();
	      return modelMapper;
	   }
	
	public ClienteDTO paraModel(Cliente cliente) {
		ModelMapper modelMapper = modelMapperClient();
		return modelMapper.map(cliente, ClienteDTO.class);
	}
	
	public Cliente paraEntidade(ClienteDTO clienteDTO) {
		ModelMapper modelMapper = modelMapperClient();
		return modelMapper.map(clienteDTO, Cliente.class);
	}
	
	public List<ClienteDTO> paraListaModel(List<Cliente> clientes){
				
		return clientes.stream().map(clients -> paraModel(clients)).collect(Collectors.toList());
	}
	

}
