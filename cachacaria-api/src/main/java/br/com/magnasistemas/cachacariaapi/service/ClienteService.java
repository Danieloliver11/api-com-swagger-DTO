package br.com.magnasistemas.cachacariaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.cachacariaapi.DTO.ClienteDTO;
import br.com.magnasistemas.cachacariaapi.DTO.ProdutoDTO;
import br.com.magnasistemas.cachacariaapi.configuracao.MapperConfgCliente;
import br.com.magnasistemas.cachacariaapi.entity.Cliente;
import br.com.magnasistemas.cachacariaapi.entity.Produto;
import br.com.magnasistemas.cachacariaapi.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private MapperConfgCliente mapperCliente;
	
	public ClienteDTO salvarCliente (ClienteDTO clienteDTO) {
		
		repository.save(mapperCliente.paraEntidade(clienteDTO));
		
		return clienteDTO;
	}
	
	public Iterable<ClienteDTO> acharTodos() {
		
		return mapperCliente.paraListaModel((List<Cliente>) repository.findAll());
	}
	
	public ClienteDTO acharPorIdCliente(long id) {
		
		ClienteDTO clienteDTO = null ;
		
	        Optional<Cliente> idCliente = repository.findById(id);   
            Cliente cliente = idCliente.get() ;
            clienteDTO =  mapperCliente.paraModel(cliente);
        
        return clienteDTO ;
	}
	

	public List<ClienteDTO> encontrarPorNomeCliente(String nome) {

		return mapperCliente.paraListaModel(repository.findAllBynomeContainingIgnoreCase(nome));
		
		
	}
	

	public void deletarCliente(long id) {
		
		repository.deleteById(id);
		
		
	}
	

}
