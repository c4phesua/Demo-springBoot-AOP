package com.example.demoaop.services;

import com.example.demoaop.api.model.TodoResponseObject;

public interface TodosService {
    TodoResponseObject getTodoById(Integer id);

    TodoResponseObject createTodo(Integer userId, String value, String status);
}
