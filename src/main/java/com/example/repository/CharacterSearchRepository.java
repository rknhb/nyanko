package com.example.repository;

import org.springframework.stereotype.Repository;

import com.example.entity.CharacterEntity;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class CharacterSearchRepository {
	
	private EntityManager entityManager;
	
	public CharacterSearchRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Date getMaxUpdatedAt(String rare) {
		Query query = entityManager
				.createNativeQuery("SELECT MAX(updated_at)FROM characters WHERE rare = ?1")
				.setParameter(1, rare);
		return (Date) query.getSingleResult();
	}
	
	public List<CharacterEntity> search(String word) {
		return entityManager
				.createNativeQuery("SELECT * FROM characters WHERE name like :word OR commentary1 like :word OR commentary2 like :word ORDER BY id ASC", CharacterEntity.class)
				.setParameter("word", "%" + word + "%")
				.getResultList();
	}
	
}