package org.example.java6nfa25sd20203.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.java6nfa25sd20203.entity.Todo;
import org.example.java6nfa25sd20203.exception.CustomResourceNotFoundException;
import org.example.java6nfa25sd20203.repository.TodoRepository;
import org.example.java6nfa25sd20203.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public List<Todo> findAll() {

        return todoRepository.findAll();
    }

    @Override
    public Todo findById(long id) {
        return todoRepository
                .findById(id)
                .orElseThrow(() -> new CustomResourceNotFoundException("Todo not found for this id: " + id));
    }

    @Override
    public Todo add(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo update(Todo todo, long id) {
        return todoRepository.findById(id)
                .map(existing -> {
                    if (todo.getTitle() != null) existing.setTitle(todo.getTitle());
                    if (todo.getDescription() != null) existing.setDescription(todo.getDescription());
                    existing.setCompleted(todo.isCompleted());

                    return todoRepository.save(existing);
                })
                .orElseThrow(() -> new CustomResourceNotFoundException("Todo not found for this id: " + id));

    }

    @Override
    public Todo delete(long id) {

        Todo deletedTodo = findById(id);

        todoRepository.deleteById(id);

        return deletedTodo;

        //return todoRepository.findById(id)
        //        .map(todo -> {
        //            todoRepository.deleteById(id);
        //            return todo;
        //        })
        //        .orElseThrow(() -> new CustomResourceNotFoundException("Todo not found for this id: " + id));

    }
}
