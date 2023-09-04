package com.example.repository;

import org.springframework.stereotype.Repository;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;

@Repository
public class CharacterDateRepository {
	private EntityManager entityManager;
	
	//private CriteriaBuilder builder;

	//private CriteriaQuery<Character> query;
	
	//private Root<Character> root;
	
	public CharacterDateRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
		//builder = entityManager.getCriteriaBuilder();
		//query = builder.createQuery(Character.class);
		//root = query.from(Character.class);
		
	}
	
	public Date getMaxUpdatedAt(String rare) {
		
		Query query = entityManager
				.createNativeQuery("SELECT MAX(updated_at)FROM characters WHERE rare = :rare")
				.setParameter(rare, 1);
		return (Date) query.getSingleResult();
	}
}
