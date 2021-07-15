package com.example.demoaop.service;

import com.example.demoaop.api.model.TodoResponseObject;
import com.example.demoaop.entity.Todos;
import com.example.demoaop.mapper.TodoMapper;
import com.example.demoaop.repository.TodosRepository;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
