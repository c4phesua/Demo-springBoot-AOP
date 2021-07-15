package com.example.demoaop.repository;

import com.example.demoaop.entity.Todos;

import java.util.Optional;

public interface TodosRepository extends BaseRepository<Todos> {
    Todos getTodosById(Integer id);
}
