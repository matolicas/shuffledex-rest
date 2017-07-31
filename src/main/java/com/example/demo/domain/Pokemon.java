package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pokemons")
public class Pokemon implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;
	@Column(name = "base_xp")
	private int baseXP;
	@Column(name = "height")
	private int height;
	@Column(name = "weight")
	private int weight;
	
	public Pokemon() {
		super();
	}
	public Pokemon(int id, String name, String type, int baseXP, int height, int weight) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.baseXP = baseXP;
		this.height = height;
		this.weight = weight;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getBaseXP() {
		return baseXP;
	}
	public void setBaseXP(int baseXP) {
		this.baseXP = baseXP;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
