package br.com.magnasistemas.cachacariaapi.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.magnasistemas.cachacariaapi.entity.Revendedora;

public interface RevendedoraRepository extends PagingAndSortingRepository<Revendedora, Long>{
	
	public List<Revendedora> findAllBynomeContainingIgnoreCase(String nome);

}
