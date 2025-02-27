package com.example.crud.Repository;

import com.example.crud.Entity.TodosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosRepo  extends CrudRepository<TodosEntity, Long> {


}
