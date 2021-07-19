package com.example.demoaop.services;

import com.example.demoaop.api.model.TodoResponseObject;
import com.example.demoaop.entities.Todos;
import com.example.demoaop.mappers.TodoMapper;
import com.example.demoaop.repositories.TodosRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TodosServiceImpl implements TodosService {
    private final TodosRepository todosRepository;

    private final TodoMapper todoMapper;

    public TodosServiceImpl(TodosRepository todosRepository, TodoMapper todoMapper) {
        this.todosRepository = todosRepository;
        this.todoMapper = todoMapper;
    }

    @Override
    public TodoResponseObject getTodoById(Integer id) {
        Todos todos = todosRepository.getTodosById(id);
        return todoMapper.todoToResponseObject(todos);
    }

    @Override
    public TodoResponseObject createTodo(Integer userId, String value, String status) {
        Todos todo = Todos.builder().userId(userId)
                .status(status).value(value)
                .createAt(Instant.now()).updateAt(Instant.now())
                .build();
        Todos response = todosRepository.save(todo);
        return todoMapper.todoToResponseObject(response);
    }
}
