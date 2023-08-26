package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "characterclassification")
@Data
public class CharaType extends AbstractEntity {
	
	@Id
	@SequenceGenerator(name = "characterclassification_id_seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "classification", nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String rare;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "classification", referencedColumnName = "id")
	@OrderBy ("number ASC")
	private List<CharacterEntity> characters;
}
