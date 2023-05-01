package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.CharactersEntity;

@Repository
public interface CharactersRepository extends JpaRepository<CharactersEntity, Long> {

}