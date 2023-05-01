package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "characters")
public class CharactersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int cost;
	
	@Column(nullable = false)
	private String rare;
	
	@Column(nullable = false)
	private String commentary1;
	
	@Column(nullable = false)
	private String commentary2;
	
	@Column(nullable = false)
	private float attack_frequency;
	
	@Column(nullable = false)
	private float reproduction;
	
	@Column(nullable = false)
	private int knockback;
	
	@Column(nullable = false)
	private String image;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getRare() {
		return rare;
	}

	public void setRare(String rare) {
		this.rare = rare;
	}

	public String getCommentary1() {
		return commentary1;
	}

	public void setCommentary1(String commentary1) {
		this.commentary1 = commentary1;
	}

	public String getCommentary2() {
		return commentary2;
	}

	public void setCommentary2(String commentary2) {
		this.commentary2 = commentary2;
	}

	public float getAttack_frequency() {
		return attack_frequency;
	}

	public void setAttack_frequency(float attack_frequency) {
		this.attack_frequency = attack_frequency;
	}

	public float getReproduction() {
		return reproduction;
	}

	public void setReproduction(float reproduction) {
		this.reproduction = reproduction;
	}

	public int getKnockback() {
		return knockback;
	}

	public void setKnockback(int knockback) {
		this.knockback = knockback;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}