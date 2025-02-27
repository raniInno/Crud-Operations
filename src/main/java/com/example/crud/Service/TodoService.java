package com.example.crud.Service;

import com.example.crud.Entity.TodosEntity;

import java.util.List;

public interface TodoService {

    //save the todo
    TodosEntity saveTodosEntity(TodosEntity todosEntity);
    // read All
    List<TodosEntity> fetchTodosEntity();
    //update
    TodosEntity updateTodosEntity(TodosEntity todosEntity);
    //delete
    void deleteTodosEntity(Long id );
}
