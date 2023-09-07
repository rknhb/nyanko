package com.example.repository;

import org.springframework.stereotype.Repository;

import java.util.Date;

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
	
}