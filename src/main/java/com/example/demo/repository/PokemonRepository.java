package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
	@Query("select new Pokemon(poke.id, poke.name, poke.type, poke.baseXP, poke.height, poke.weight) from Pokemon poke order by poke.id")
	public List<Pokemon> findAll();
	
	@Query("select new Pokemon(poke.id, poke.name, poke.type, poke.baseXP, poke.height, poke.weight) from Pokemon poke where poke.name like %?1% order by poke.id")
	public List<Pokemon> getPokemonByName(String name);
	
	@Query("select new Pokemon(poke.id, poke.name, poke.type, poke.baseXP, poke.height, poke.weight) from Pokemon poke where poke.type like %?1% order by poke.id")
	public List<Pokemon> getPokemonByType(String type);
}
