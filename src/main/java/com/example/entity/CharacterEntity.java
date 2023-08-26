package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "characters")
public class CharacterEntity extends AbstractEntity {
	
	@Id
	@SequenceGenerator(name = "characters_id_seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Column(nullable = true)
	private String image;
	
	@Column(name = "classification", nullable = false)
	private int type;
	
	@Column(nullable = false)
	private int number;
}