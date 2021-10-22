package br.com.magnasistemas.cachacariaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.magnasistemas.cachacariaapi.DTO.RevendedoraDTO;
import br.com.magnasistemas.cachacariaapi.configuracao.MapperConfigRevendedora;
import br.com.magnasistemas.cachacariaapi.entity.Revendedora;
import br.com.magnasistemas.cachacariaapi.service.RevendedoraService;

@RestController 
@RequestMapping("/revendedora") 
@CrossOrigin(origins = "*", allowedHeaders ="*")
public class RevendedoraController {

	@Autowired
	private RevendedoraService revendedoraService;
	@Autowired
	private MapperConfigRevendedora mapperRevendedora;
	
	@PostMapping								
	public ResponseEntity<RevendedoraDTO> postRevendedora (@RequestBody Revendedora revendedora){
		return ResponseEntity.status(HttpStatus.CREATED).body(revendedoraService
				.salvarRevendedora(mapperRevendedora.paraModelRevendedora(revendedora)));
	}
	
	@GetMapping			
	public ResponseEntity<Iterable<RevendedoraDTO>> getAllRevendedora(){
		return ResponseEntity.ok(revendedoraService.acharTodasRevendedoras()); 
	}
	
	@GetMapping("/{id}")						
	public ResponseEntity<RevendedoraDTO> getRevendedoraById(@PathVariable long id){
		
		RevendedoraDTO revendedoraDTO =  revendedoraService.acharRevendedoraPorId(id);
	     return new ResponseEntity<RevendedoraDTO>( revendedoraDTO, HttpStatus.OK );
	}
	
	@GetMapping("/nome/{nome}")  
	public ResponseEntity<List<RevendedoraDTO>>getRevendedoraByTitulo(@PathVariable String nome){  
		return ResponseEntity.ok(revendedoraService.encontrarPorNomeRevendedora(nome)); 
	}
	
	@PutMapping
	public ResponseEntity<RevendedoraDTO> putRevendedora (@RequestBody Revendedora revendedora){
		return ResponseEntity.status(HttpStatus.OK).body(revendedoraService.salvarRevendedora(mapperRevendedora.paraModelRevendedora(revendedora)));
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable long id) {
		revendedoraService.deletarRevendedora(id);
		
	}
}
