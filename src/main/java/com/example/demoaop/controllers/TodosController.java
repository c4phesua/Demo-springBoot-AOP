package com.example.demoaop.controllers;

import com.example.demoaop.api.TodoApi;
import com.example.demoaop.api.model.TodoRequestObject;
import com.example.demoaop.api.model.TodoResponseObject;
import com.example.demoaop.services.TodosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TodosController implements TodoApi {
    private final TodosService todosService;

    public TodosController(TodosService todosService) {
        this.todosService = todosService;
    }

    @Override
    public ResponseEntity<TodoResponseObject> createTodo(@Valid TodoRequestObject todoRequestObject) {
        return new ResponseEntity<>(todosService.createTodo(
                todoRequestObject.getUserId(),
                todoRequestObject.getValue(),
                todoRequestObject.getStatus()
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TodoResponseObject> getTodo(Integer id) {
        return new ResponseEntity<>(todosService.getTodoById(id), HttpStatus.OK);
    }
}
