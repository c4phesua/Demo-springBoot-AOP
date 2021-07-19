package com.example.demoaop.repositories;

import com.example.demoaop.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Integer>, JpaSpecificationExecutor<T> {

}
