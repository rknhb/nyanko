package com.example.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "characterclassification")
@Data
public class CharacterClassificationEntity {
	
	@Id
	@SequenceGenerator(name = "characterclassification_id_seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = true)
	private String claasification;
	
	@OneToMany(mappedBy = "classification")
	private List<CharacterEntity> characters;
}
