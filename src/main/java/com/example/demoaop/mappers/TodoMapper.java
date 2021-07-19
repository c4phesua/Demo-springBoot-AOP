package com.example.demoaop.mappers;

import com.example.demoaop.api.model.TodoResponseObject;
import com.example.demoaop.entities.Todos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class TodoMapper {
    @Mappings({
            @Mapping(target = "todoId", source = "todos.id"),
            @Mapping(target = "createAt", source = "todos.createAt"),
            @Mapping(target = "updateAt", source = "todos.updateAt"),
            @Mapping(target = "userId", source = "todos.userId"),
            @Mapping(target = "value", source = "todos.value"),
            @Mapping(target = "status", source = "todos.status")
    })
    public abstract TodoResponseObject todoToResponseObject(Todos todos);
}
