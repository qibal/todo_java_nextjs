package com.example.backend_java_todo.todo.repository;
import com.example.backend_java_todo.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,String>{
    String id(String id);
}
