package br.com.magnasistemas.cachacariaapi.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.magnasistemas.cachacariaapi.entity.Cliente;

@Repository
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long>{

		public List<Cliente> findAllBynomeContainingIgnoreCase(String nome);


}
