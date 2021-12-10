package br.org.generation.dandara.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.dandara.model.Produto;
import br.org.generation.dandara.repository.ProdutoRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto>getById(@PathVariable long id){
		return produtoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>>getByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
	}
		
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Produto>>getByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(produtoRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	

}
