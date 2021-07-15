package com.example.demoaop.controller;

import com.example.demoaop.api.TodoApi;
import com.example.demoaop.api.model.TodoResponseObject;
import com.example.demoaop.service.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodosController implements TodoApi {
    private final TodosService todosService;

    public TodosController(TodosService todosService) {
        this.todosService = todosService;
    }

    @Override
    public ResponseEntity<TodoResponseObject> getTodo(Integer id) {
        return new ResponseEntity<>(todosService.getTodoById(id), HttpStatus.OK);
    }
}
