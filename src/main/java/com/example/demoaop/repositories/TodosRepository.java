package com.example.demoaop.repositories;

import com.example.demoaop.entities.Todos;

public interface TodosRepository extends BaseRepository<Todos> {
    Todos getTodosById(Integer id);
}
