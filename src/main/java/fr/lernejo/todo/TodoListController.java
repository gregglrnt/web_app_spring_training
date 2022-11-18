package fr.lernejo.todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;


@RestController
@RequestMapping("api/todo")
public class TodoListController {

    private TodoRepository todos;

    public TodoListController(TodoRepository tr) {
        todos = tr;
    }
    @PostMapping
    void addTodo(@RequestBody TodoEntity todo) {
        todos.save(todo);
    }
    @GetMapping
    Collection<TodoEntity> getTodoList() {
        ArrayList<TodoEntity> tc = new ArrayList<TodoEntity>();
        todos.findAll().forEach((todo) -> {
            tc.add(todo);
        });
        return tc;
    }
}
