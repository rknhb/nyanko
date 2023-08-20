package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.CharaType;

@Repository
public interface CharaTypeRepository extends JpaRepository<CharaType, Long> {
	List<CharaType> findByRare(String rare);
}