package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.IdolEntity;

/**
 * アイドル情報　Repository
 */
@Repository
public interface IdolRepository extends JpaRepository<IdolEntity, Integer> {
	List<IdolEntity> findAllByOrderByIdAsc();
}
