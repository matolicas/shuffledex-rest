package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Pokemon;
import com.example.demo.repository.PokemonRepository;

@Service
public class PokemonService {
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	public List<Pokemon> getAll(){
		return pokemonRepository.findAll();
	}
	
	public List<Pokemon> getPokemonByName(String name){
		return pokemonRepository.getPokemonByName(name);
	}
	
	public List<Pokemon> getPokemonByType(String type){
		return pokemonRepository.getPokemonByType(type);
	}
	
	public Pokemon getPokemonById(int id){
		return pokemonRepository.findOne(id);
	}
	
	public void createPokemon(Pokemon pokemon){
		pokemonRepository.save(pokemon);
	}
	
	public void updatePokemon(Pokemon pokemon){
		pokemonRepository.save(pokemon);
	}
	
	public void deletePokemon(int id){
		pokemonRepository.delete(id);;
	}
	
}
