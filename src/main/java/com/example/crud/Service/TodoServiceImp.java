package com.example.crud.Service;

import com.example.crud.Entity.TodosEntity;
import com.example.crud.Repository.TodosRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImp implements TodoService {
    @Autowired
    TodosRepo todosRepo;

    private static final Logger logger = LoggerFactory.getLogger(TodoServiceImp.class);


    @Override
    public TodosEntity saveTodosEntity(TodosEntity todosEntity) {
        try{
            TodosEntity todosEntity1 = todosRepo.save(todosEntity);
            logger.info("response of saveTodosEntity [{}]", todosEntity1.toString());


            return  todosEntity1;
        }
        catch(Exception e){
            logger.error("error");
//            throw new RuntimeException();
            return null;

        }


    }

    @Override
    public List<TodosEntity> fetchTodosEntity() {
        return (List<TodosEntity>) todosRepo.findAll();
    }

    @Override
    public TodosEntity updateTodosEntity(TodosEntity todosEntity) {
        //find existing data
        TodosEntity todo = todosRepo.findById(todosEntity.getId()).get();
//        if present then
        if(todo!=null){
//            delete the previous data
            todosRepo.deleteById(todo.getId());
//
        }
//        update with new data
//        todosRepo.save(todosEntity);
        return todosRepo.save(todosEntity);
    }

    @Override
    public void deleteTodosEntity(Long id) {
        todosRepo.deleteById(id);

    }
}
