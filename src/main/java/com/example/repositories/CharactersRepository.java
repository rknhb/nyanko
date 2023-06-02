package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.CharacterEntity;

@Repository
public interface CharactersRepository extends JpaRepository<CharacterEntity, Long> {

}