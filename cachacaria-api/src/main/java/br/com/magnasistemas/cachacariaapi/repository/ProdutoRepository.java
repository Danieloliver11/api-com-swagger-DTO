package br.com.magnasistemas.cachacariaapi.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.magnasistemas.cachacariaapi.entity.Produto;

//PagingAndSortingRepository

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long> {


	public List<Produto> findAllBynomeContainingIgnoreCase(String nome);

}
