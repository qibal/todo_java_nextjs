package com.example.backend_java_todo.todo.service;



import com.example.backend_java_todo.todo.entity.Todo;
import com.example.backend_java_todo.todo.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }
    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }
    public Todo createTodo(Todo todo) {
        if (todo.getTodo() == null || todo.getTodo().trim().isEmpty()) {
            throw new IllegalArgumentException("Todo description cannot be null or empty");
        }
        return todoRepository.save(todo);
    }
    public void deleteTodo(String id){
        if (!todoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Todo not found");
        }
        todoRepository.deleteById(id);
    }
    public  Todo toggleTodoDone(String id){
        Todo todo = todoRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Todo not Found"));
        todo.setDone(!todo.isDone());
        return todoRepository.save(todo);
    }
}
