package com.example.demoaop.service;

import com.example.demoaop.api.model.TodoResponseObject;

public interface TodosService {
    TodoResponseObject getTodoById(Integer id);
}
