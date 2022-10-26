package fr.lernejo.todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/todo") //binde à l'URL /api/todo
public class TodoListController {
    private final List<Todo> todos = new ArrayList<>();

    @PostMapping
    void addTodo(@RequestBody Todo todo) {
        todos.add(todo);
    }

    @GetMapping
    Collection<Todo> getTodoList() {
        return todos;
    }
}
