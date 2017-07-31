package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.domain.Pokemon;
import com.example.demo.service.PokemonService;

@RestController
@RequestMapping("api/pokemon")
@CrossOrigin(origins = { "http://localhost:4200" })
public class PokemonRest {
	
	@Autowired
	private PokemonService pokemonRestService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Pokemon>> getAll(){
		List<Pokemon> pokemons = pokemonRestService.getAll();
		return new ResponseEntity<List<Pokemon>>(pokemons, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/namehas/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<Pokemon>> getPokemonByName(@PathVariable("name") String name){
		List<Pokemon> pokemons = pokemonRestService.getPokemonByName(name);
		return new ResponseEntity<List<Pokemon>>(pokemons, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/typeis/{type}", method = RequestMethod.GET)
	public ResponseEntity<List<Pokemon>> getPokemonByType(@PathVariable("type") String type){
		List<Pokemon> pokemons = pokemonRestService.getPokemonByType(type);
		return new ResponseEntity<List<Pokemon>>(pokemons, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/idis/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pokemon> getPokemonById(@PathVariable("id") int id){
		Pokemon pokemon = pokemonRestService.getPokemonById(id);
		return new ResponseEntity<Pokemon>(pokemon, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> addPokemon(@RequestBody Pokemon pokemon, UriComponentsBuilder builder){
		try {
			pokemonRestService.createPokemon(pokemon);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Pokemon> updatePokemon(@RequestBody Pokemon pokemon){
		pokemonRestService.updatePokemon(pokemon);
		return new ResponseEntity<Pokemon>(pokemon, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePokemon(@PathVariable("id") int id){
		pokemonRestService.deletePokemon(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}
