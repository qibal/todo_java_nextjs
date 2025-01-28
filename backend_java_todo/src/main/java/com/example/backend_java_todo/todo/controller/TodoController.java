package com.example.backend_java_todo.todo.controller;

import com.example.backend_java_todo.todo.entity.Todo;
import com.example.backend_java_todo.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }
    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo)
    {
        return todoService.createTodo(todo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Todo> toggleTodoDone(@PathVariable String id){
        Todo updatedTodo = todoService.toggleTodoDone(id);
        return ResponseEntity.ok(updatedTodo);
    }
}


