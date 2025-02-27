package com.example.crud.Controller;

import com.example.crud.Entity.TodosEntity;
import com.example.crud.Service.TodoService;
import com.example.crud.Service.TodoServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/todos")
public class todosController {
    @Autowired
    TodoService todoService;
    private static final Logger logger1 = LoggerFactory.getLogger(todosController.class);


    //post
    @PostMapping("/create")
    public TodosEntity createTodo(@RequestBody TodosEntity todosEntity){
        logger1.info("request of saveTodosEntity [{}]", todosEntity.toString());
        TodosEntity todosEntity1 = todoService.saveTodosEntity(todosEntity);
        logger1.info("response of saveTodosEntity [{}]", todosEntity1.toString());
        return todosEntity1;
    }
    //allget
    @GetMapping("/getAllTodos")
    public List<TodosEntity> getAllTodo(){
        return todoService.fetchTodosEntity();
    }
    //update
    @PutMapping("/update")
    public TodosEntity updateTodos(@RequestBody TodosEntity todosEntity){
       return todoService.updateTodosEntity(todosEntity);
    }
    //delete
    @DeleteMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") Long id ){
        todoService.deleteTodosEntity(id);
        return "Success";

    }
}
