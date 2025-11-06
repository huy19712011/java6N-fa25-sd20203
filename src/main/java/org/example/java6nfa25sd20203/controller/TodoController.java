package org.example.java6nfa25sd20203.controller;

import lombok.RequiredArgsConstructor;
import org.example.java6nfa25sd20203.entity.Todo;
import org.example.java6nfa25sd20203.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos() {

        return todoService.findAll();
    }

    @GetMapping("{id}")
    public Todo getTodo(@PathVariable("id") long id) {

        return todoService.findById(id);
    }

    @PostMapping("{id}")
    public Todo addTodo(@RequestBody Todo todo) {

        return todoService.add(todo);
    }

    @PutMapping("{id}")
    public Todo updateTodo(@RequestBody Todo todo, @PathVariable("id") long id) {

        return todoService.update(todo, id);
    }

    @DeleteMapping("{id}")
    public Todo deleteTodo(@PathVariable("id") long id) {

        return todoService.delete(id);
    }
}
