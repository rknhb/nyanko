package com.example.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.CharacterEntity;


@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
	
	List<CharacterEntity> findByRareOrderByTypeAsc(String rare);
	List<CharacterEntity> findByType(int type);
	
	
	
	
}