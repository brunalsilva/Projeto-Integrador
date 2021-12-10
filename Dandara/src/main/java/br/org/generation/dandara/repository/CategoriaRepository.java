package br.org.generation.dandara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.dandara.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	public List<Categoria> findAllByNomeContainingIgnoreCase(String nome);
	public List<Categoria> findAllByPalavraChaveContainingIgnoreCase(String palavraChave);
	public List<Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);

}
