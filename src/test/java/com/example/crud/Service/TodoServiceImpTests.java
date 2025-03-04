package com.example.crud.Service;

import com.example.crud.Entity.TodosEntity;
import com.example.crud.Repository.TodosRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TodoServiceImpTests {

    @BeforeAll
    public static void setUp() {
        System.out.println("setUp");
    }
    @Mock
    TodosRepo todosRepo;

    @InjectMocks
    TodoServiceImp todoServiceImp;
    @Test
    void saveTodosEntityShouldAddTodoSuccessfully(){
        // data preparation
        TodosEntity todosEntity = new TodosEntity(11L,"checking","testing checking", "Completed");
        //mocking the calls
        Mockito.when(todosRepo.save(todosEntity)).thenReturn(todosEntity);
        //calling the actual methods
        TodosEntity addedTodo = todoServiceImp.saveTodosEntity(todosEntity);
        System.out.println("My First Test");

//        Assertions portion
//      to check input should not be null
        Assertions.assertNotNull(addedTodo);

//        to check the result is as correct or not by providing input related output
        Assertions.assertEquals(todosEntity.getId(),addedTodo.getId());

    }

    @Test
    void deleteTodoByIdShouldDeleteTodoSuccessfully(){
        doNothing().when(todosRepo).deleteById(1L);
        todoServiceImp.deleteTodosEntity(1L);
        verify(todosRepo, times(1)).deleteById(1L);
        System.out.println("deleting");

    }


}